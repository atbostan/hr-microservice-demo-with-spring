package com.bossware.hr.presentation.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.bossware.hr.application.services.HrService;
import com.bossware.hr.application.validation.TcKimlikNo;
import com.bossware.hr.core.dto.request.EmployeeRequest;
import com.bossware.hr.core.dto.response.EmployeeResponse;

@RestController
@RequestScope
@RequestMapping("/employees")
@Validated
@CrossOrigin
public class HrController {
	private final HrService hrService;
	
	public HrController(HrService hrService) {
		this.hrService = hrService;
	}

	@GetMapping("{identity}")
	public EmployeeResponse getEmployee(@PathVariable @TcKimlikNo String identity){
		return hrService.findEmployeeByIdentity(identity);
	}
	
	@PostMapping
	public EmployeeResponse hireEmployee(@RequestBody @Validated EmployeeRequest request) {
		return hrService.hireEmployee(request);
	}
	
	@DeleteMapping("{identity}")
	public EmployeeResponse fireEmployee(@PathVariable @TcKimlikNo String identity) {
		return hrService.fireEmployee(identity);
	}
}
