<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Edit page</title>
		<script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>
		<script type="text/javascript" src="js/imageselect.js"></script>
		<link href="css/imageselect.css" media="screen" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="/Final/css/background4.css">
		<link rel="stylesheet" type="text/css" href="/Final/css/button.css">
	</head>
	<body>

		<h1><p style="display:inline;" class="fontFamily">Character Edit</p></h1>

		<form action="/Final/FinalServlet" method="post">

			<table style="background:rgba(255,255,255,0.2);" border="5">
				<tr><td><b><p style="display:inline;" class="fontFamily">No</p></b></td>
				<td><b><p style="display:inline;" class="fontFamily">Name</p></b><input type="text" name="name" /><br/></td>
				<td><b><p style="display:inline;" class="fontFamily">Job</p></b><input type="text" name="job" /><br/></td>
				<td><b><p style="display:inline;" class="fontFamily">Ability</p></b><input type="text" name="ability" /><br/></td>
				<td><b><p style="display:inline;" class="fontFamily">Image</p></b><select name="image">
					<option value="img/mon_283.bmp">img/mon_283.bmp</option>
					<option value="img/mon_283r.bmp">img/mon_283r.bmp</option>
					<option value="img/mon_284.bmp">img/mon_284.bmp</option>
					<option value="img/mon_284r.bmp">img/mon_284r.bmp</option>
					<option value="img/mon_284.bmp">img/mon_285.bmp</option>
					<option value="img/mon_285r.bmp">img/mon_285r.bmp</option>
					<option value="img/mon_245.bmp">img/mon_245.bmp</option>
					<option value="img/mon_241.bmp">img/mon_241.bmp</option>
					<option value="img/mon_217r.bmp">img/mon_217r.bmp</option>
					<option value="img/mon_190.bmp">img/mon_190.bmp</option>
					<option value="img/mon_181r.bmp">img/mon_181r.bmp</option>
					<option value="img/mon_184.bmp">img/mon_184.bmp</option>
					<option value="img/mon_275.bmp">img/mon_275.bmp</option>
					<option value="img/mon_204.bmp">img/mon_204.bmp</option>
					</select></td>
				<td></td>
				</tr>

			<c:forEach items="${characterList}" var="character">
				<input type="hidden" name="no" value="${character.no}" />
				<tr><td>${character.no}</td>
				<td>${character.name}</td>
				<td>${character.job}</td>
				<td>${character.ability}</td>
				<td><img src="${character.image}"></td>
				</tr>
			</c:forEach>

			</table>

			<input id="cp_btn" type="submit"value="Edit">
			<input type="hidden" name="action" value="edit" />
		</form>



		<script type="text/javascript">
			$(document).ready(function(){
			 $('select[name=image]').ImageSelect({dropdownWidth:425});
			 });
		</script>
	</body>
</html>