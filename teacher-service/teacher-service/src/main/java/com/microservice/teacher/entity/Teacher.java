package com.microservice.teacher.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long teacherId;
	private String education;
	private Long userId;
	private Long departmentId;

}
