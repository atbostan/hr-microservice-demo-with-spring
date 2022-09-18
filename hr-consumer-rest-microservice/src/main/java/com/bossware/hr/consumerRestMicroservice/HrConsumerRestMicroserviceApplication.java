package com.bossware.hr.consumerRestMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients(basePackages = "com.bossware.hr.consumerRestMicroservice.client")
@EnableEurekaClient
@EnableDiscoveryClient
public class HrConsumerRestMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrConsumerRestMicroserviceApplication.class, args);
	}

}
