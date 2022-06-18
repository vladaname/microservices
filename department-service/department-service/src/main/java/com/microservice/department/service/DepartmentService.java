package com.microservice.department.service;

import com.microservice.department.entity.Department;

public interface DepartmentService {

	Department saveDepartment(Department department);

	Department findDepartmentById(Long departmentId);

}
