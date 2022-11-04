package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Department;

public interface DepartmentService {

	public Department savedept(Department department);

	public List<Department> fetchall();

	public Department getbyid(Long departmentid);

	public void del(Long departmentid);

	public Department up(Long departmentid, Department dept);

	public Department fetchbyname(String deptname);

}
