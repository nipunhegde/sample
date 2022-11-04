package com.example.demo.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository deptrepo;

	@Override
	public Department savedept(Department department) {
		// TODO Auto-generated method stub
		return deptrepo.save(department);
	}

	@Override
	public List<Department> fetchall() {
		// TODO Auto-generated method stub
		return deptrepo.findAll();
	}

	@Override
	public Department getbyid(Long departmentid) {
		// TODO Auto-generated method stub
		return deptrepo.findById(departmentid).get();
	}

	@Override
	public void del(Long departmentid) {
		// TODO Auto-generated method stub
		deptrepo.deleteById(departmentid);
	}

	@Override
	public Department up(Long departmentid, Department dept) {
		// TODO Auto-generated method stub
		Department dep=deptrepo.findById(departmentid).get();
		if(Objects.nonNull(dept.getDepartmentName())&&
				!"".equalsIgnoreCase(dept.getDepartmentName())) {
			dep.setDepartmentName(dept.getDepartmentName());
		}
		if(Objects.nonNull(dept.getDepartmentAddress())&&
				!"".equalsIgnoreCase(dept.getDepartmentAddress())) {
			dep.setDepartmentAddress(dept.getDepartmentAddress());
		}
		if(Objects.nonNull(dept.getDepartmentCode())&&
				!"".equalsIgnoreCase(dept.getDepartmentCode())) {
			dep.setDepartmentCode(dept.getDepartmentCode());
		}
		return deptrepo.save(dep);
	}

	@Override
	public Department fetchbyname(String deptname) {
		// TODO Auto-generated method stub
		return deptrepo.findBydepartmentName(deptname);
	}

}
