package com.microservice.teacher.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.teacher.VO.Department;
import com.microservice.teacher.VO.ResponseTemplateVO;
import com.microservice.teacher.VO.User;
import com.microservice.teacher.entity.Teacher;
import com.microservice.teacher.repositorty.TeacherRepository;
import com.microservice.teacher.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	private TeacherRepository teacherRepositorty;
	@Autowired
	RestTemplate restTemplate;

	@Override
	public Teacher save(Teacher teacher) {
		
		return teacherRepositorty.save(teacher);
	}

	@Override
	public ResponseTemplateVO findByTeacherId(Long teacherId) {
		ResponseTemplateVO vo = new ResponseTemplateVO();
		
		Teacher teacher = teacherRepositorty.findByTeacherId(teacherId);
		User user = restTemplate.getForObject("http://USER-SERVICE/users/" 
				+ teacher.getUserId(), User.class);
		System.out.println("User id: " + user.getUserId());
		/*
		 * Department d =
		 * restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" +
		 * teacher.getDepartmentId(), Department.class);
		 * System.out.println("Department id: " + d.getDepartmentId());
		 */
		
		vo.setTeacher(teacher);
		vo.setUser(user);
//		vo.setDepartment(d);

		return vo;
	}

	@Override
	public Teacher saveD(Teacher teacher) {
		return teacherRepositorty.save(teacher);
	}

	@Override
	public ResponseTemplateVO findByTeacherIdD(Long teacherId) {
		System.out.println("Teachers id: " + teacherId);

		ResponseTemplateVO vo = new ResponseTemplateVO();
  		Teacher teacher = teacherRepositorty.findByTeacherId(teacherId);
		System.out.println("TeachersT id: " + teacher.getEducation());

		Department d = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" 
				+ teacher.getDepartmentId(), Department.class);
		System.out.println("Department id: " + d.getDepartmentId());

		vo.setTeacher(teacher);
		vo.setDepartment(d);

		return vo;
	}


}
