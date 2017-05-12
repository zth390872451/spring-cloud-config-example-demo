package com.company;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 认证服务器
 */
@RestController
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableAuthorizationServer
//@EnableDiscoveryClient
@SpringBootApplication
public class OAuthServer {
    private static Logger log = LoggerFactory.getLogger(OAuthServer.class);

    @RequestMapping("/home")
    public String home() {
        log.info("Handling home");
        return "Hello World";
    }

    public static void main(String[] args) {
        SpringApplication.run(OAuthServer.class, args);
    }
}
