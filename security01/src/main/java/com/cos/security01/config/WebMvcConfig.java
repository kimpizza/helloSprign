package com.cos.security01.config;

import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 이 자바 파일을 IoC로 등록하기위해 어노테이션을 붙여준다.
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        MustacheViewResolver resolver = new MustacheViewResolver(); //기존 설정 재설정
        resolver.setCharset("UTF-8"); //내가 만드는 뷰의 인코딩
        resolver.setContentType("text/html; charset=UTF-8"); //내가 너한테 던지는 데이터는 html 파일이야
        resolver.setPrefix("classpath:/templates/");
        resolver.setSuffix(".html");

        registry.viewResolver(resolver);
    }
}
