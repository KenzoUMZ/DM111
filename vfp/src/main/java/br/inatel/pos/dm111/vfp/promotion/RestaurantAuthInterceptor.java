package br.inatel.pos.dm111.vfp.promotion;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RestaurantAuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userType = request.getHeader("User-Type");
        if (request.getMethod().equals("GET")) {
            // GET pode ser público, mas personalize conforme sua regra
            return true;
        }
        if (userType == null || !userType.equalsIgnoreCase("RESTAURANT")) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("Apenas usuários do tipo RESTAURANT podem acessar este recurso.");
            return false;
        }
        return true;
    }
}
