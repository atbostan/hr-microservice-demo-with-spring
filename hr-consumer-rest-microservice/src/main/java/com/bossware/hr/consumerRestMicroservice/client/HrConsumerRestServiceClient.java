package com.bossware.hr.consumerRestMicroservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bossware.hr.consumerRestMicroservice.dto.EmployeeRequest;
import com.bossware.hr.consumerRestMicroservice.dto.EmployeeResponse;

@FeignClient(name="hr")
public interface HrConsumerRestServiceClient {
	
	@GetMapping("/api/v1/employees/{identitiy}")
	public EmployeeResponse	getEmployeeByIdentity(@PathVariable String identity);
	
	@PostMapping("/api/v1/employees")
	public EmployeeResponse hire(@RequestBody EmployeeRequest request);
	
	@DeleteMapping("/api/v1/employees/{identity}")
	public EmployeeResponse fire(@PathVariable String identity);
	
	
	
}
