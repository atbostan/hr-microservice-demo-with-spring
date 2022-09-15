package com.bossware.hr.application.adapters;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.bossware.hr.core.entity.EmployeeEntity;
import com.bossware.hr.domain.Employee;
import com.bossware.hr.domain.annotations.Adapter;
import com.bossware.hr.domain.valueObjects.TcKimlikNo;
import com.bossware.hr.persistance.EmployeeEntityRepository;
import com.bossware.hr.persistance.repositories.EmployeeRepository;

@Repository
@Adapter(port = EmployeeRepository.class)
public class EmployeeRepositoryJpaAdapter implements EmployeeRepository {
	private final EmployeeEntityRepository empRepo;
	private final ModelMapper modelMapper;

	public EmployeeRepositoryJpaAdapter(EmployeeEntityRepository empRepo, ModelMapper modelMapper) {
		this.empRepo = empRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public boolean exists(TcKimlikNo identity) {
		return empRepo.existsById(identity.getValue());
	}

	@Override
	public Employee persist(Employee employee) {
		return modelMapper.map(empRepo.save(modelMapper.map(employee, EmployeeEntity.class)), Employee.class);
	}

	@Override
	public Optional<Employee> findByIdentity(TcKimlikNo identity) {
		return empRepo.findById(identity.getValue()).map(entity -> modelMapper.map(entity, Employee.class));
	}

	@Override
	public void remove(Employee employee) {
		empRepo.deleteById(employee.getIdentity().getValue());
	}

}
