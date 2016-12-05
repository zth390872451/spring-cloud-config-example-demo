package com.company;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2016/12/1.
 */
@RestController
@SpringBootApplication
public class SpringCloudSleuth {
    private static Logger log = LoggerFactory.getLogger(SpringCloudSleuth.class);

    @RequestMapping("/")
    public String home() {
        log.info("Handling home");
        return "Hello World";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudSleuth.class, args);
    }
}
