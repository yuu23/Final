<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
</head>
<body>
	<form action="/Final/FinalServlet" method="post">
		ユーザー名:<input type="text" name="userId" /><br />
		パスワード:<input type="password" name="pw" /><br />
		<input type="hidden" name="action" value="login" />
		<input type="submit" value="ログイン" />
	</form>

	<hr />

</body>
</html>