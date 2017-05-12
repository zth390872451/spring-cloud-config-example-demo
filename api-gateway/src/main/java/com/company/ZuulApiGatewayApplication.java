package com.company;

//import com.company.web.fileter.AccessFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * 使用@EnableZuulProxy注解激活zuul。
 * 跟进该注解可以看到该注解整合了@EnableCircuitBreaker、@EnableDiscoveryClient，是个组合注解，目的是简化配置。
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
//@EnableZuulProxy
@RestController
public class ZuulApiGatewayApplication {

    @RequestMapping("home")
    public String home(){
        return "home";
    }
    /*@Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }*/
    @Autowired
    DataSource dataSource;
    /*@Bean
    public DefaultTokenServices defaultTokenServices(){
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(new JdbcTokenStore(dataSource));
        return defaultTokenServices;
    }*/
    public static void main(String[] args) {
        SpringApplication.run(ZuulApiGatewayApplication.class, args);
    }
}
