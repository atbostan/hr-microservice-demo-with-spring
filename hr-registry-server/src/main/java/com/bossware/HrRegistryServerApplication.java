package com.bossware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HrRegistryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrRegistryServerApplication.class, args);
	}

}
