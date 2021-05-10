package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.VO.Department;
import com.user.VO.ResponseTemplateVO;
import com.user.entity.User;
import com.user.repo.UserRepo;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		return this.userRepo.save(user);
	}

	@GetMapping("/allusers")
	public List<User> getAllUsers() {
		return this.userRepo.findAll();
	}

//	@GetMapping("/{id}")
//	public User getUserById(@PathVariable("id") Long userId) {
//		return this.userRepo.findById(userId).get();
//	}

	@GetMapping("/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = this.userRepo.findById(userId).get();
		Department department = this.restTemplate
				.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}

}
