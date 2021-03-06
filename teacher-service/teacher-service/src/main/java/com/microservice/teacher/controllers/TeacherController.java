package com.microservice.teacher.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.teacher.VO.ResponseTemplateVO;
import com.microservice.teacher.entity.Teacher;
import com.microservice.teacher.service.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	
	@PostMapping("/")
	public Teacher save(@RequestBody Teacher teacher) {
		return  teacherService.save(teacher);
		
	}
	
	@GetMapping("/{id}")
	public ResponseTemplateVO findByTeacher(@PathVariable("id")Long teacherId) {
		System.out.println("Teacher id: " + teacherId);

		return teacherService.findByTeacherId(teacherId);
	}
	
	@PostMapping("/userDep")
	public Teacher saveD(@RequestBody Teacher teacher) {
		return  teacherService.saveD(teacher);
		
	}
	
	@GetMapping("/userDep/{id}")
	public ResponseTemplateVO findByTeacherD(@PathVariable("id")Long teacherId) {
		System.out.println("Teachers id: " + teacherId);

		return teacherService.findByTeacherIdD(teacherId);
	}

}
