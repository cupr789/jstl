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
<c:forEach items="${classList}" var="classObj">
클래스번호 : ${classObj.cino}, 클래스이름 : ${classObj.ciname}, 클래스설명 : ${classObj.cidesc }<br>
</c:forEach>
</body>
</html>