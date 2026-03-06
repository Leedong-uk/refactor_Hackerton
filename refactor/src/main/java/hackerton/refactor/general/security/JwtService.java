package hackerton.refactor.general.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtService {
    private final Key key = Keys.hmacShaKeyFor("엄청길고안전한FULLY ENOUGH LONG LENGTH STRING".getBytes(StandardCharsets.UTF_8));

    private static final long ACCESS_EXPIRE = 1000L * 60 * 60 * 24;
    private static final long REFRESH_EXPIRE = 1000L * 60 * 60 * 24 * 7;


    private String createToken(String subject,long expire) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis() + expire))
                .signWith(key)
                .compact();
    }


    public String createAccessToken(String email) {
        return createToken(email, ACCESS_EXPIRE);
    }

    public String createRefreshToken(String email) {
        return createToken(email, REFRESH_EXPIRE);
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

}

