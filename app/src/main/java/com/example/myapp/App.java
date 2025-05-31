package com.example.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@RestController
public class App implements WebMvcConfigurer {

    @GetMapping("/")
    public String home() {
        return "hello-api 백엔드 서버입니다!";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 URL에 대해
            .allowedOrigins(
                "https://hello.eomcs.com",
                "http://localhost",           // Ingress를 통한 프론트엔드
                "http://localhost:3000",      // 개발 서버
                "http://hello-ui.local"       // 도메인을 통한 접속
            ) // 허용할 Origin
            .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS") // 허용할 HTTP 메서드
            .allowCredentials(true); // 자격 증명 허용 (JWT 쿠키 등)
    }

}