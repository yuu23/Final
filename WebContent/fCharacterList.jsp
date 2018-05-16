<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fCharacterList</title>
</head>
<body>

<h1>キャラクター一覧</h1>


	<table border="3" bordercolor="skyblue">
	<tr><td><b>No</b></td>
	<td><b>名前</b></td>
	<td><b>職業</b></td>
	<td><b>能力</b></td>
	<td><b>画像</b></td>
	<td>

		<form action="/Final/FinalServlet" method="post">
			No<input type="text" name="no" /><input type="submit" value="キャラクター削除">
			<input type="hidden" name="action" value="delete" />
		</form>

	</td></tr>
<form action="fCreation.jsp">
<input type="submit" value="キャラクター作成">
</form>

	<c:forEach items="${characterList}" var="character">
		<tr><td>${character.no}</td>
		<td>${character.name}</td>
		<td>${character.job}</td>
		<td>${character.ability}</td>
		<td><img src="${character.image}"></td>
		</tr>
	</c:forEach>


	</table>
</body>
</html>