package com.user.VO;

import com.user.entity.User;

public class ResponseTemplateVO {

	private User user;
	private Department department;

	public ResponseTemplateVO() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
