package cl.praxis.inmobiliaria.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class JwtUtils {

    @Value("${security.jwt.key.private}")
    private String privateKey;

    @Value("${security.jwt.user.generator}")
    private String userGenerator;

    public String generateToken(Authentication authentication) {
        final int MILISECOND = 1000;
        final int SECONDS = 60;
        final int MINUTES = 60;
        final int HOURS = 1;
        Algorithm algorithm = Algorithm.HMAC256(privateKey);
        String username = authentication.getPrincipal().toString();
        String authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));

        return JWT.create()
                .withIssuer(userGenerator)
                .withSubject(username)
                .withClaim("authorities", authorities)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + MILISECOND * SECONDS * MINUTES * HOURS))
                .withJWTId(UUID.randomUUID().toString())
                .withNotBefore(new Date(System.currentTimeMillis()))
                .sign(algorithm);
    }

    public DecodedJWT verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(privateKey);
            JWTVerifier verifier = JWT
                    .require(algorithm)
                    .withIssuer(userGenerator)
                    .build();

            return verifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new JWTVerificationException("Invalid Token", e);
        }
    }

    public String extractUsername(DecodedJWT decodedToken) {
        return decodedToken.getSubject();
    }

    public Claim getSpecificClaim(DecodedJWT decodedToken, String claimName) {
        return decodedToken.getClaim(claimName);
    }

    public Map<String, Claim> retrieveAllClaims(DecodedJWT decodedToken) {
        return decodedToken.getClaims();
    }
}
