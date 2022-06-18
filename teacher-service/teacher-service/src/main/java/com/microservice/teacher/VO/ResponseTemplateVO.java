package com.microservice.teacher.VO;

import com.microservice.teacher.entity.Teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
	
	private User user;
	private Department department;
	private Teacher teacher;

}
