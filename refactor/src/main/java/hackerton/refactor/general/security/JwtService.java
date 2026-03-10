package hackerton.refactor.general.security;

import hackerton.refactor.domain.entity.auth.AuthStatus;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtService {
    private final Key key = Keys.hmacShaKeyFor("엄청길고안전한FULLY ENOUGH LONG LENGTH STRING".getBytes(StandardCharsets.UTF_8));

    private static final long ACCESS_EXPIRE = 1000L * 60 * 60 * 24;
    private static final long REFRESH_EXPIRE = 1000L * 60 * 60 * 24 * 7;


    private String createToken(String subject,long expire, List<AuthStatus> roles) {
        return Jwts.builder()
                .setSubject(subject)
                .claim("roles",roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .signWith(key)
                .compact();
    }


    public String createAccessToken(String email , List<AuthStatus> roles) {
        return createToken(email, ACCESS_EXPIRE,roles);
    }

    public String createRefreshToken(String email , List<AuthStatus> roles) {
        return createToken(email, REFRESH_EXPIRE,roles);
    }

    public String extractSubject(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validate(String token) {
        Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
        return true;
    }

    public Claims extractBody(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}

