package com.microservice.department.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.department.entity.Department;
import com.microservice.department.repositorty.DepartmentRepository;
import com.microservice.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {
		log.info("");
		return departmentRepository.save(department);
	}

	@Override
	public Department findDepartmentById(Long departmentId) {
		log.info("");
		return departmentRepository.findByDepartmentId(departmentId);
	}

}
