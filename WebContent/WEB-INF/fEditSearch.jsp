<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Character edit</title>
		<script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>
		<script type="text/javascript" src="js/imageselect.js"></script>
		<link href="css/imageselect.css" media="screen" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="/Final/css/background4.css">
		<link rel="stylesheet" type="text/css" href="/Final/css/button.css">
	</head>
	<body>

		<h1><p style="display:inline;" class="fontFamily">Character Edit</p></h1>

		<form action="/Final/FinalServlet" method="post">

			<p style="display:inline;" class="fontFamily">No:</p><input type="text" name="editNo" size="5" />
			<input id="cp_btn" type="submit" value="Select Edit Character">
			<input type="hidden" name="action" value="editSearch" />
		</form>
		<hr/>
		<table style="background:rgba(255,255,255,0.2);" border="5">
			<tr><td><b><p style="display:inline;" class="fontFamily">No</p></b></td>
			<td><b><p style="display:inline;" class="fontFamily">Name</p></b></td>
			<td><b><p style="display:inline;" class="fontFamily">Job</p></b></td>
			<td><b><p style="display:inline;" class="fontFamily">Ability</p></b></td>
			<td><b><p style="display:inline;" class="fontFamily">Image</p></b></td>
			<td></td>
			</tr>

			<c:forEach items="${characterList}" var="character">
				<tr><td>${character.no}</td>
				<td>${character.name}</td>
				<td>${character.job}</td>
				<td>${character.ability}</td>
				<td><img src="${character.image}"></td>
				</tr>
			</c:forEach>
		</table>

		<script type="text/javascript">
			$(document).ready(function(){
			 $('select[name=image]').ImageSelect({dropdownWidth:425});
			 });
		</script>
	</body>
</html>