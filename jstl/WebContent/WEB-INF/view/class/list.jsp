<%@page import="java.util.ArrayList"%>
<%@page import="com.jstl.test.vo.UserClass"%>
<%@page import="java.util.List"%>
<%@page import="com.jstl.test.vo.ClassInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/view/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
난클래스 리스트
<br>
	<%
		String str = (String) request.getAttribute("keyword");
		out.println(str);
		List<ClassInfo> classList = (List<ClassInfo>) session.getAttribute("classList");

		List<ClassInfo> getClass = new ArrayList<ClassInfo>();
		if (str != null) {
			out.println(str);
			for (ClassInfo ci : classList) {
				if (ci.getCiname().indexOf(str) != -1) {
					getClass.add(ci);
				}
			}

			request.setAttribute("classList", getClass);
		}
	%>

	<form method="get" action="<%=root%>/view/class/search">
		<input type="text" name="param" id="input1" placeholder="클래스명검색">
		<button type="submit">검색</button>
		<br>
	</form>
<c:forEach items="${classList}" var="classObj">
클래스번호 : ${classObj.cino}, 클래스이름 : ${classObj.ciname}, 클래스설명 : ${classObj.cidesc }<br>
</c:forEach>
</body>
</html>