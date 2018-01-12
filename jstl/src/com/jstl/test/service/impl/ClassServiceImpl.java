package com.jstl.test.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jstl.test.dao.ClassDao;
import com.jstl.test.dao.impl.ClassDaoImpl;
import com.jstl.test.service.ClassService;
import com.jstl.test.vo.ClassInfo;

public class ClassServiceImpl implements ClassService{
	ClassDao cd = new ClassDaoImpl();
	@Override
	public void getClassList(HttpServletRequest req) {
		List<ClassInfo> classList = cd.getClassList();
		System.out.println(classList);
		HttpSession ss = req.getSession();
		ss.setAttribute("classList", classList);
	}

}
