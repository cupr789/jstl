package com.jstl.test.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.jstl.test.vo.ClassInfo;

public interface ClassService {
	public void getClassList(HttpServletRequest req);
}
