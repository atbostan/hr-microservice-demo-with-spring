package com.bossware.hr.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bossware.hr.core.entity.EmployeeEntity;
import com.bossware.hr.domain.valueObjects.Department;
import com.bossware.hr.domain.valueObjects.JobStyle;

public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, String> {
	List<EmployeeEntity> findAllByBirthYearBetweenAndJobStyleAndDepartment(int fromYear, int toYear, JobStyle style,
			Department department);

	@Query(nativeQuery = true, value = """
				select e from employees e
				where e.birthYear between :fromYear and :toYear
				and e.jobstyle = :style
				and e.department = :dept
			""")
	List<EmployeeEntity> nativGetir(int fromYear, int toYear, JobStyle style, Department dept);
}
