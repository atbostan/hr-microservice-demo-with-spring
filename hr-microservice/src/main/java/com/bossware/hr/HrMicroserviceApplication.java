package com.bossware.hr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class HrMicroserviceApplication {

	@Value("${spring.datasource.url}")
	public static String configUrlTrace;
	
	public static void main(String[] args) {
		System.out.println("Config trace %s".formatted(configUrlTrace));
		SpringApplication.run(HrMicroserviceApplication.class, args);
	}

}
