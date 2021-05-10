package com.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.department.entity.Department;
import com.department.repo.DepartmentRepo;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentRepo departmentRepo;

	@PostMapping("/")
	public Department saveUser(@RequestBody Department department) {
		return this.departmentRepo.save(department);
	}

	@GetMapping("/allDepartments")
	public List<Department> getAllDepartments() {
		return this.departmentRepo.findAll();
	}

	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable("id") Long departmentId) {
		return this.departmentRepo.findById(departmentId).get();
	}

	@DeleteMapping("/{id}")
	public void deleteDepartmentById(@PathVariable("id") Long departmentId) {
		this.departmentRepo.deleteById(departmentId);
	}

}
