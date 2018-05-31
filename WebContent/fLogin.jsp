<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login page</title>
		<link rel="stylesheet" type="text/css" href="/Final/css/button.css">
		<link rel="stylesheet" type="text/css" href="/Final/css/background5.css">
		<link rel="stylesheet" type="text/css" href="/Final/css/fontFamily.css">
	</head>
	<body>

		<h1><p class="fontFamily">Login page</p></h1>

		<form action="/Final/fLoginServlet" method="post">
			<p style="display:inline;" class="fontFamily">User ID:</p>
			<input type="text" name="userId" /><br /><br />

			<p style="display:inline;" class="fontFamily">Password:</p>
			<input type="password" name="pw" /><br /><br/>

			<input type="hidden" name="action" value="login" />
			<input id="cp_btn" type="submit" value="Login" />
		</form>

	</body>
</html>