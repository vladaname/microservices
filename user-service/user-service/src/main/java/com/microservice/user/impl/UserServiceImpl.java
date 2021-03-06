package com.microservice.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.user.VO.Department;
import com.microservice.user.VO.ResponseTemplateVO;
import com.microservice.user.entity.User;
import com.microservice.user.repository.UserRepository;
import com.microservice.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public ResponseTemplateVO findUserWithDepartment(Long userId) {
		ResponseTemplateVO vo = new ResponseTemplateVO();
		
		User user = userRepository.findByUserId(userId);
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" 
				+ user.getDepartmentId(), Department.class);
		System.out.println("Dep id is: " + user.getDepartmentId());
		vo.setUser(user);
		vo.setDepartment(department);
		
		return vo;
	}

}
