package utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import spark.Request;

import java.security.Key;
import java.util.Date;

public class AuthUtils {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String createJWT(String subject, long ttlMillis) {

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder()
                .setIssuedAt(now)
                .setSubject(subject)
                .signWith(key);

        //if it has been specified, let's add the expiration
        if (ttlMillis > 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }

    public static Claims decodeJWT(String jwt) {
        //This line will throw an exception if it is not a signed JWS (as expected)
       return (Claims) Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt);
    }

    public static String getUsernameFromToken(Request r) {
        String auth = r.headers("Authorization");
        System.out.println("Authorization: " + auth);
        if ((auth != null) && (auth.contains("Bearer "))) {
            String jwt = auth.substring(auth.indexOf("Bearer ") + 7);
            try {
                Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt);
                return claims.getBody().getSubject();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

}
