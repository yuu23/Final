<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Character creation</title>
		<script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>
		<script type="text/javascript" src="js/imageselect.js"></script>
		<link href="css/imageselect.css" media="screen" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="/Final/css/background2.css">
		<link rel="stylesheet" type="text/css" href="/Final/css/button.css">
		<link rel="stylesheet" href="/Final/css/fontFamily.css" type="text/css">
	</head>
	<body>

		<h1><p class="fontFamily">Character Creation</p></h1>

		<form action="/Final/fMyPageServlet" class="f1">
			<input id="cp_btn" type="submit" value="My page">
		</form>

		<form action="/Final/fLoginServlet" class="f2" method="post">
			<input type="hidden" name="action" value="logout" />
			<input id="cp_btn" type="submit" value="Logout" />
		</form>

		<form action="/Final/FinalServlet" method="post">

			<p style="display:inline;" class="fontFamily">No:</p><input type="text" name="no" /><br/><br/>
			<p style="display:inline;" class="fontFamily">Name:</p><input type="text" name="name" /><br/><br/>
			<p style="display:inline;" class="fontFamily">Job:</p><input type="text" name="job" /><br/><br/>
			<p style="display:inline;" class="fontFamily">Ability:</p><input type="text" name="ability" /><br/><br/>
			<p style="display:inline;" class="fontFamily">Image:</p>
				<select name="image">
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
				</select>

		<br/><br/>

			<input id="cp_btn" type="submit" value="Create">
			<input type="hidden" name="action" value="add" />
		</form>


		<script type="text/javascript">
			$(document).ready(function(){
 			$('select[name=image]').ImageSelect({dropdownWidth:425});
 			});
		</script>
	</body>
</html>