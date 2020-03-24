package org.zjy.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.zjy.crud.components.MyLocaleResolver;
import org.zjy.crud.components.MyWebMvcConfigurer;


@Configuration
public class MyConfig {
    @Bean
    public MyWebMvcConfigurer myWebMvcConfigurer(){
        return new MyWebMvcConfigurer();
    }
    @Bean(name = "localeResolver")
    public MyLocaleResolver MylocaleResolver(){
        return new MyLocaleResolver();
    }

}
