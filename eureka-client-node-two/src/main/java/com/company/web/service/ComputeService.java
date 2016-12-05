package com.company.web.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ComputeService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String computeService() {
        String body = restTemplate.getForEntity("http://eureka-client-node/add?a=1&b=2", String.class).getBody();
        // int a =1/0; //断路器调试验证
        return body;
    }

    /**
     * 熔断机制：调用失败返回结果
     * @return
     */
    public String addServiceFallback() {
        return "eureka-client-node invoke failed,maybe you should make sure you can connect the admin!";
    }
}