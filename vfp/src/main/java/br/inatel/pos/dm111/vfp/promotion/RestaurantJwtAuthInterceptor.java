package br.inatel.pos.dm111.vfp.promotion;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.impl.DefaultJws;
import io.jsonwebtoken.lang.Strings;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RestaurantJwtAuthInterceptor implements HandlerInterceptor {
    @Value("${vale-food.jwt.custom.issuer:issuer}")
    private String tokenIssuer;

    private final JwtParser jwtParser;

    public RestaurantJwtAuthInterceptor(JwtParser jwtParser) {
        this.jwtParser = jwtParser;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (request.getMethod().equals("GET")) {
            return true;
        }
        String token = request.getHeader("Token");
        if (!Strings.hasLength(token)) {
            token = request.getHeader("token");
        }
        if (!Strings.hasLength(token)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("JWT token não fornecido.");
            return false;
        }
        try {
            var jwt = (DefaultJws) jwtParser.parse(token);
            var payloadClaims = (Map<String, String>) jwt.getBody();
            var issuer = payloadClaims.get("iss");
            var role = payloadClaims.get("role");
            if (!tokenIssuer.equals(issuer)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Issuer inválido.");
                return false;
            }
            if (!"RESTAURANT".equalsIgnoreCase(role)) {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.getWriter().write("Apenas usuários do tipo RESTAURANT podem acessar este recurso.");
                return false;
            }
            return true;
        } catch (JwtException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("JWT token inválido.");
            return false;
        }
    }
}
