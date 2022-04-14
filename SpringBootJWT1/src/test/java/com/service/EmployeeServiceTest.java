package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.model.Employee;
import com.repository.EmployeeRepository;

@SpringBootTest
class EmployeeServiceTest {
	
	@Autowired
	EmployeeService empservice;
	
	@MockBean
	EmployeeRepository emprepo;

	@Test
	void testGetEmps() {
		Employee e1=new Employee();
		e1.setEid(1);
		e1.setEname("Madhu");
		e1.setTech("JavaFS");
		
		Employee e2=new Employee();
		e2.setEid(2);
		e2.setEname("Madhuri");
		e2.setTech("Java");
		
		List<Employee> empList = new ArrayList<>();
		empList.add(e1);
		empList.add(e2);
		
		Mockito.when(emprepo.findAll()).thenReturn(empList);
		
		assertThat(empservice.getEmps()).isEqualTo(empList);
		
	}

	@Test
	void testGetEmpById() {
		Employee e1=new Employee();
		e1.setEid(1);
		e1.setEname("Madhu");
		e1.setTech("JavaFS");
		Optional<Employee> e2=Optional.of(e1);
   Mockito.when(emprepo.findById(1)).thenReturn(e2);
   assertThat(empservice.getEmpById(1)).isEqualTo(e2);
	}

	@Test
	void testCreateEmp() {
		Employee e1=new Employee();
		e1.setEid(1);
		e1.setEname("Madhu");
		e1.setTech("JavaFS");
   Mockito.when(emprepo.save(e1)).thenReturn(e1);
   assertThat(empservice.createEmp(e1)).isEqualTo(e1);
	}

	@Test
	void testAddEmps() {
		Employee e1=new Employee();
		e1.setEid(1);
		e1.setEname("Madhu");
		e1.setTech("JavaFS");
		
		Employee e2=new Employee();
		e2.setEid(2);
		e2.setEname("Madhuri");
		e2.setTech("Java");
		
		List<Employee> empList = new ArrayList<>();
		empList.add(e1);
		empList.add(e2);
		
		Mockito.when(emprepo.saveAll(empList)).thenReturn(empList);
		
		assertThat(empservice.addEmps(empList)).isEqualTo(empList);
	}

	@Test
	void testUpdateEmp() throws Exception {
		Employee e1=new Employee();
		e1.setEid(1);
		e1.setEname("Madhu");
		e1.setTech("JavaFS");
		
		Optional<Employee> e2=Optional.of(e1);
		Mockito.when(emprepo.findById(1)).thenReturn(e2);
		e1.setEname("Madhulika");
   Mockito.when(emprepo.save(e1)).thenReturn(e1);
   assertThat(empservice.updateEmp(e1)).isEqualTo(e1);
	}

	@Test
	void testDeleteEmp() {
		Employee e1=new Employee();
		e1.setEid(1);
		e1.setEname("Madhu");
		e1.setTech("JavaFS");
		
		Optional<Employee> e2=Optional.of(e1);
		Mockito.when(emprepo.findById(1)).thenReturn(e2);
		 Mockito.when(emprepo.existsById(e1.getEid())).thenReturn(false);
		   assertFalse(emprepo.existsById(e1.getEid()));
	}

	/*
	 * @Test void testDeleteEmpById() {
	 * 
	 * }
	 */

}
