package hackerton.refactor.domain.service;

import hackerton.refactor.domain.dto.email.MailRequest;
import hackerton.refactor.general.enums.BadStatusCode;
import hackerton.refactor.general.exception.CustomException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;
    private final Semaphore emailSemaphore = new Semaphore(20);
    private final StringRedisTemplate stringRedisTemplate;

    @Async("emailAsyncExecutor")
    public void sendEmail(MailRequest request) {
        String email = request.getEmail();
        boolean acquired = false;

        try {
            acquired = emailSemaphore.tryAcquire(3, TimeUnit.SECONDS);

            if (!acquired) {
                throw new CustomException(
                        BadStatusCode.MAIL_QUEUE_FULL_EXCEPTION
                );
            }

            String verificationCode = generateCode();

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper =
                    new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom(new InternetAddress(
                    "zibi_official@naver.com", "경상났네 운영팀"));
            helper.setTo(email);
            helper.setSubject("[경상났네] 이메일 인증번호 안내");

            Context context = new Context();
            context.setVariable("code", verificationCode);

            String htmlContent =
                    templateEngine.process("verification", context);

            helper.setText(htmlContent, true);
            String emailKey = "email:verification:"+email;
            stringRedisTemplate.opsForValue().set(emailKey,verificationCode, Duration.ofMinutes(5));
            javaMailSender.send(message);


        } catch (Exception e) {
            throw new CustomException(
                    BadStatusCode.FAIL_TO_SEND_MAIL_EXCEPTION
            );

        } finally {
            if (acquired) {
                emailSemaphore.release();
            }
        }
    }

    public String generateCode() {
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        return uuid.substring(0, 6);
    }
}
