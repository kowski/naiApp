package pl.lodz.uni.math.naiApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import pl.lodz.uni.math.naiApp.interceptor.LogInterceptor;

/**
 * Created by HP on 2018-05-24.
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/supplier/**").allowedOrigins("http://localhost:3000").allowedMethods("DELETE","GET","POST");
        registry.addMapping("/").allowedOrigins("http://localhost:3000").allowedMethods("DELETE","GET","POST");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor());
    }
}
