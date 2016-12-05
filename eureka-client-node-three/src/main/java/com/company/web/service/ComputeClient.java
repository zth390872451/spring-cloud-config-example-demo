package com.company.web.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client-node", fallback = ComputeClientHystrix.class)
public interface ComputeClient {
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    String add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}