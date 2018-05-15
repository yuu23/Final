<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fCharacterList</title>
</head>
<body>

<h1>キャラクター一覧</h1>

	<table border="3" bordercolor="skyblue">
	<tr><td><b>No</b>
	<tr><td><b>名前</b>
	<tr><td><b>職業</b>
	</td><td><b>能力</b>
	</td><td><b>画像</b></td></tr>

	<c:forEach items="${characterList}" var="characters">
		<tr><td>${characters.no}</td><td>${characters.name}</td><td>${characters.job}</td>
		<td>${characters.ability}</td></tr>
	</c:forEach>

	</table>
</body>
</html>