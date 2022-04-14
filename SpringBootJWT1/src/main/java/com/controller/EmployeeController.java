package com.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Employee;
import com.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping(path="/api")
public class EmployeeController {
	
	@Autowired
	EmployeeService empservice;
	
	@GetMapping(path="/getEmployees")
	public ResponseEntity<List<Employee>> getEmployees()
	{
		List<Employee> le=empservice.getEmps();
		
		ResponseEntity re=new ResponseEntity<List<Employee>>(le,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getEmployee/{eid}")
	public ResponseEntity<Employee> getEmpById(@PathVariable int eid)
	{
		Optional<Employee> e1=empservice.getEmpById(eid);
		
		ResponseEntity re=new ResponseEntity<Employee>(HttpStatus.OK);
		return re;
	}
	
	@PostMapping(path="/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee e)
	{
		Employee e1=empservice.createEmp(e);
		
		ResponseEntity re=new ResponseEntity<Employee>(e1,HttpStatus.OK);
		return re;
	}
	@PostMapping(path="/addEmployees")
	public ResponseEntity<List<Employee>> addEmployees(@RequestBody List<Employee> ls)
	{
		List<Employee> le=empservice.addEmps(ls);
		
		ResponseEntity re=new ResponseEntity<List<Employee>>(le,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateEmployee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee e) throws Exception
	{
		Employee e1=empservice.updateEmp(e);
		
		ResponseEntity re=new ResponseEntity<Employee>(e1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteEmployee")
	public ResponseEntity<String> deleteEmployee(@RequestBody Employee e)
	{
		empservice.deleteEmp(e);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteEmployee/{eid}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int eid)
	{
		empservice.deleteEmpById(eid);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getEmpTech/{tech}")
	public ResponseEntity<List<Employee>> getEmpbyTech(@PathVariable String tech)
	{
		List<Employee> le=empservice.getempBytechSorted(tech);
		ResponseEntity re=new ResponseEntity<List<Employee>>(le,HttpStatus.OK);
		
		return re;
		
	}
	
	}
