package com.jstl.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jstl.test.service.ClassService;
import com.jstl.test.service.UserService;
import com.jstl.test.service.impl.ClassServiceImpl;
import com.jstl.test.service.impl.UserServiceImpl;

public class JspServlet extends HttpServlet {
	public String getCommand(String uri) {
		int idx = uri.lastIndexOf(".");
		if (idx != -1) {
			return uri.substring(0,idx);
		}
		return "";
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doProcess(req, res);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doProcess(req, res);
	}

	public void doProcess(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		String uri = req.getRequestURI();
		uri = uri.replace("jstl/", "");
		uri = "/WEB-INF" + uri + ".jsp";
		
		if(uri.indexOf("user/list")!=-1) {
			UserService us = new UserServiceImpl();
			us.getUserList(req);
		}
		
		if(uri.indexOf("user/search")!=-1) {
			String keyword= req.getParameter("param");
			System.out.println(keyword);
			req.setAttribute("keyword", keyword);
			uri ="/WEB-INF/view/user/list.jsp";
		}
		
		
		if(uri.indexOf("class/search")!=-1) {
			String keyword= req.getParameter("param");
			System.out.println(keyword);
			req.setAttribute("keyword", keyword);
			uri ="/WEB-INF/view/class/list.jsp";
		}
		
		
		
		if(uri.indexOf("class/list")!=-1) {
			ClassService cs = new ClassServiceImpl();
			cs.getClassList(req);
		}
		
		System.out.println("JspServlet ���� uri : "+uri);
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
	}
}
