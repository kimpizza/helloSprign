package com.filter.demo;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public FilterRegistrationBean myfirstFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new myFilter());
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean mySecondFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new secondFilter());
        registrationBean.setOrder(2);

        return registrationBean;

    }
}
