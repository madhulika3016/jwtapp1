package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

	List<Employee> findByTech(String tech);
	
	@Query("Select e from Employee e order by e.ename")
	List<Employee> findByTechSorted(String tech);
}
