package hackerton.refactor.general.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import hackerton.refactor.general.enums.BadStatusCode;
import hackerton.refactor.general.exception.CustomException;
import hackerton.refactor.general.exception.UnAuthorizedException;
import hackerton.refactor.general.response.ApiResponse;
import hackerton.refactor.general.util.StatusCodeHelper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
@Component
@Slf4j
public class ExceptionHandlerFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("필터 진입: {} {}", request.getMethod(), request.getRequestURI());
        try {
            filterChain.doFilter(request, response);

        } catch (ExpiredJwtException e) {
            log.info("🚨 error 발생: ",e);
            log.info("🔎 stackTrace : {}",e.getStackTrace());
            writeErrorResponse(response, BadStatusCode.TOKEN_EXPIRED_EXCEPTION);

        } catch (io.jsonwebtoken.security.SignatureException | SecurityException e) {
            log.info("🚨 error 발생: ",e);
            log.info("🔎 stackTrace : {}",e.getStackTrace());
            writeErrorResponse(response, BadStatusCode.INVALID_TOKEN_SIGNATURE);

        } catch (UnsupportedJwtException | MalformedJwtException | IllegalArgumentException e) {
            log.info("🚨 error 발생: ",e);
            log.info("🔎 stackTrace : {}",e.getStackTrace());
            writeErrorResponse(response, BadStatusCode.TOKEN_NOT_SUPPORT_EXCEPTION);

        }catch (CustomException e){
            log.info("🚨 error 발생: ",e);
            log.info("🔎 stackTrace : {}",e.getStackTrace());
            writeErrorResponse(response,e.getBadStatusCode());
        }catch (ServletException e) {
            log.info("🚨 error 발생: ",e);
            log.info("🔎 stackTrace : {}",e.getStackTrace());
            writeErrorResponse(response, BadStatusCode.INTERNAL_SERVER_EXCEPTION);
        } catch (Exception e) {
            log.info("🚨 error 발생: ",e);
            log.info("🔎 stackTrace : {}",e.getStackTrace());
            writeErrorResponse(response, BadStatusCode.INTERNAL_SERVER_EXCEPTION);
        }
    }


    private void writeErrorResponse(HttpServletResponse response, BadStatusCode code) throws IOException {
        StatusCodeHelper status = StatusCodeHelper.of(code);
        response.setStatus(status.getStatusValue());
        response.setContentType("application/json;charset=UTF-8");

        objectMapper.writeValue(response.getWriter(),
                ApiResponse.fail(status.getStatusValue(), status.getMessage())
        );
    }
}
