<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="/Final/css/background.css">
		<link rel="stylesheet" type="text/css" href="/Final/css/button.css">
		<link rel="stylesheet" href="/Final/css/fontFamily.css" type="text/css">
		<link rel="stylesheet" type="text/css" href="/Final/css/alphabetColor.css">
		<STYLE type="text/css"></STYLE>
		<title>fCharacterList</title>
	</head>
	<body>
		<div>
			<h1><p style="display:inline;" class="fontFamily">Character List</p></h1>

			<form action="/Final/fMyPageServlet" class="f1" >
				<input class="mypage" id="cp_btn" type="submit" value="My page">
			</form>

			<form action="/Final/fLoginServlet" class="f2" method="post">
				<input type="hidden" name="action" value="logout" />
				<input id="cp_btn" type="submit" value="Logout" />
			</form>
		</div>

		<p style="display:inline;" class="fontFamily">[No]Sort:</p>
		<a href="/Final/FinalServlet?action=sort&key=no_asc">↑</a>
		<a href="/Final/FinalServlet?action=sort&key=no_desc">↓</a><br/>

		<table style="background:rgba(255,255,255,0.2);" border="5">
			<tr><td><b><p class="fontFamily">No</p></b></td>
			<td><b><p class="fontFamily">Name</p></b></td>
			<td><b><p class="fontFamily">Job</p></b></td>
			<td><b><p class="fontFamily">Ability</p></b></td>
			<td><b><p class="fontFamily">Image</p></b></td>
			<td>

			<form action="/Final/FinalServlet" method="post">
				No:<input type="text" name="no" size="1" />
				<input id="cp_btn" type="submit" value="Character Delete">
				<input type="hidden" name="action" value="delete" />
			</form>

			<form action="/Final/FinalServlet" method="post">
				No:<input type="text" name="editNo" size="1" />
				<input id="cp_btn" type="submit" value="Select Edit Character">
				<input type="hidden" name="action" value="editSearch" />
			</form>

			</td></tr>

			<form action="/Final/fCreationServlet">
				<input id="cp_btn" type="submit" value="Character Creation">
			</form>


			<c:forEach items="${characterList}" var="character">
				<tr><td>${character.no}</td>
				<td>${character.name}</td>
				<td>${character.job}</td>
				<td>${character.ability}</td>
				<td><img src="${character.image}"></td>
				</tr>
			</c:forEach>

			<form action="/Final/FinalServlet" method="post">
				<p style="display:inline;" class="fontFamily">Search No:</p><input type="text" name="no" size="5" />
				<input id="cp_btn" type="submit" value="Search">
				<input type="hidden" name="action" value="search" />
			</form>

			<form action="/Final/fListServlet" method="post">
				<input type="hidden" name="action" value="characterList" />
				<input id="cp_btn" type="submit" value="Show All Character" />
			</form>
		</table>
	</body>
</html>