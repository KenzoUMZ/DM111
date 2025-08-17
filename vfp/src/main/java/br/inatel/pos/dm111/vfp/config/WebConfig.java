package br.inatel.pos.dm111.vfp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.inatel.pos.dm111.vfp.promotion.RestaurantJwtAuthInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private RestaurantJwtAuthInterceptor restaurantJwtAuthInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(restaurantJwtAuthInterceptor)
        .addPathPatterns("/promotions/**");
    }
}
