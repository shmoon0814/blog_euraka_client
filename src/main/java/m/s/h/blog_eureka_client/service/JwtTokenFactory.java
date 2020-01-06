package m.s.h.blog_eureka_client.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.servlet.http.HttpServletRequest;
import java.util.function.Function;

public class JwtTokenFactory {

    private JwtTokenFactory(){}

    public static JwtDecoder jwtDecoer(String secret, HttpServletRequest request){
        return new JwtDecoder(secret, request);
    }
    public static class JwtDecoder{
        private final String header = "Authorization";
        private final String secret;
        private final HttpServletRequest request;
        private Claims claims;
        private JwtDecoder(String secret, HttpServletRequest request){
            this.secret = secret;
            this.request = request;
        }

        private JwtDecoder decode(){
            String token = this.request.getHeader(header).substring(7);
            claims = Jwts.parser()
                    .setSigningKey(this.secret)
                    .parseClaimsJws(token)
                    .getBody();
            return this;
        }

        public Object getUserId(){
            return getClaimFromToken(Claims::getSubject);
        }

        private  <T> T getClaimFromToken(Function<Claims, T> claimsResolver) {
            decode();
            return claimsResolver.apply(this.claims);
        }




    }

}
