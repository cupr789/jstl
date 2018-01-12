<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
Map<String,String> menuMap = new HashMap<String,String>();
String root =request.getContextPath();
menuMap.put("userList", root+"/view/user/list");
menuMap.put("classList", root+"/view/class/list");
menuMap.put("Home",root);
%>
<c:set var="menuMap" value="<%=menuMap %>" scope="page"/>
<c:set var="title" value="JSTL 테스트" scope="page"/>
<c:forEach items="${menuMap}" var="menu">
	<a href="${menu.value }">${menu.key}</a><br>
</c:forEach>