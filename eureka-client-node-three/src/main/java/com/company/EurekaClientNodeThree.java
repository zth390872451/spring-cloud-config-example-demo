package com.company;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientNodeThree {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaClientNodeThree.class).web(true).run(args);
	}

}
