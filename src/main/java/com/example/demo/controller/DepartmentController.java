package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.services.DepartmentService;

@RestController
public class DepartmentController {
    @Autowired
	private DepartmentService deptservice;
	
	@PostMapping("/departments")
	public Department savedept(@RequestBody Department department) {
		return deptservice.savedept(department);
		
	}
	@GetMapping("/departments")
	public List<Department> fetchall(){
		return deptservice.fetchall();
	}
	
	@GetMapping("/departments/{id}")
	public Department getbyid(@PathVariable("id") Long departmentid) {
		return deptservice.getbyid(departmentid);
		
	}
	
	@DeleteMapping("/departments/{id}")
	public String del(@PathVariable("id") Long departmentid) {
		deptservice.del(departmentid);
		return "Deletion done successfully";
		
	}
	@PutMapping("/departments/{id}")
	public Department up(@PathVariable("id")Long departmentid ,
			@RequestBody Department dept ) {
		return deptservice.up(departmentid,dept);
	}
	@GetMapping("/departments/names/{name}")
	public Department fetchbyname(@PathVariable("name")String deptname) {
		return deptservice.fetchbyname(deptname);
	}
}
