package com.company.web.controller;

import com.company.web.service.ComputeClient;
import com.company.web.util.ApplicationSupport;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Ribbon 客户端 消费add 服务（使用2种方式）
 *
 */
@RestController
public class FeignConsumerController {

    private static final Logger logger = LoggerFactory.getLogger(FeignConsumerController.class);

    @Autowired
    ComputeClient computeClient;

    /**
     *
     * @return
     */
    @RequestMapping(value = "/feign_consumer", method = RequestMethod.GET)
    public String add() {
        logger.info("{}", "Spring-feign-service-add2 method");
        String result = computeClient.add(10, 30);
        return result;
    }

}