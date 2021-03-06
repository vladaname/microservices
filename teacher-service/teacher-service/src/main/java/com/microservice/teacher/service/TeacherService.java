package com.microservice.teacher.service;

import com.microservice.teacher.VO.ResponseTemplateVO;
import com.microservice.teacher.entity.Teacher;

public interface TeacherService {

	Teacher save(Teacher teacher);

	ResponseTemplateVO findByTeacherId(Long teacherId);

	Teacher saveD(Teacher teacher);

	ResponseTemplateVO findByTeacherIdD(Long teacherId);

}
