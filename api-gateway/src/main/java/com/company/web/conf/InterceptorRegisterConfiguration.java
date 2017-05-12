package com.company.web.conf;

import com.company.web.fileter.Oauth2Interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@EnableWebSecurity
public class InterceptorRegisterConfiguration extends WebMvcConfigurerAdapter{
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        //match .json api version
		registry.addInterceptor(new Oauth2Interceptor())
    	.excludePathPatterns("/api/oauth2/**");

    }

	
	//静态资源路径配置
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/resources/**")
                    .addResourceLocations("/resources/");
    }


}
