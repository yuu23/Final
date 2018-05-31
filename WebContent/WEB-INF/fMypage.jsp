<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="/Final/css/button.css">
		<link rel="stylesheet" type="text/css" href="/Final/css/background3.css">
		<title>My page</title>
	</head>
	<body>

		<c:forEach items="${loginUser}" var="loginUser1">
			<tr><td>${loginUser1.userId}</td>
			<td>${loginUser1.pw}</td>
			</tr>
		</c:forEach>

		<br/><br/><br/><br/><br/><br/><br/>

		<center>
			<form action="/Final/fCreationServlet">
				<input id="cp_btn" type="submit" value="Character Creation">
			</form>
		</center>

		<br/>

		<center>
			<form action="/Final/fListServlet" method="post">
				<input type="hidden" name="action" value="characterList" />
				<input id="cp_btn" type="submit" value="Character List" />
			</form>
		</center>

		<br/>

		<center>
			<form action="/Final/fEditSearchServlet" method="post">
				<input type="hidden" name="action" value="edit" />
				<input id="cp_btn" type="submit" value="Character Edit" />
			</form>
		</center>

		<br/>

		<center>
			<form action="/Final/fLoginServlet" method="post">
				<input type="hidden" name="action" value="logout" />
				<input id="cp_btn" type="submit" value="Logout" />
			</form>
		</center>
	</body>
</html>