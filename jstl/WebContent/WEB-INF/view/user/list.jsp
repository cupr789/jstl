<%@page import="com.jstl.test.vo.UserClass"%>
<%@page import="java.util.ArrayList"%>
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
하이 난 리스트
<br>



${userList[0].uiName }


<form method="get" action="<%=root%>/view/user/search" onsubmit="return searchUser()"><input type="text" name="param" id="input1" placeholder="검색"><button type="submit" onclick="searchUser()">검색</button><br></form>
<table id="table1" border="1">
<c:forEach items="${userList}" var="user" >
<tr >
<td>유저번호 : ${user.uiNo }, 유저이름 : ${user.uiName}, 유저나이 : ${user.uiAge}, 유저ID : ${user.uiId}, 유저가입날짜 : ${user.uiRegdate}</td>
</tr>
</c:forEach>
</table>
</body>
<script>
function searchUser(){
	   document.getElementById("table").innerHTML = "";
	   for(var u of "${userList}"){
	   document.getElementById("table").innerHTML += "<tr><td>유저번호 :  ${user.uiNo} </th><th>유저 아이디 :  ${user.uiId} </th><th>유저 이름 : ${user.uiName} </th><th>유저 나이 :  ${user.uiAge} </th></tr>"
	   }
	}	
</script>
</html>
