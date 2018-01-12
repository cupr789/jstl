package com.jstl.test.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.jstl.test.vo.UserClass;

public interface UserService {
	public void getUserList(HttpServletRequest req);
}
