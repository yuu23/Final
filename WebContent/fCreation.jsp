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
</head>
<body>

<h1>キャラクターを作成します</h1>

<form action="/Final/FinalServlet" method="post">

追加:No<input type="text" name="no" /><br/>
	名前<input type="text" name="name" /><br/>
	職業<input type="text" name="job" /><br/>
	能力<input type="text" name="ability" /><br/>
	画像
	<select name="image">
		<option value="img/warrior.png">img/warrior.png</option>
		<option value="img/monk.png">img/monk.png</option>
		<option value="img/BlackMage.png">img/BlackMage.png</option>
		<option value="img/WhiteMage.png">img/WhiteMage.png</option>
		<option value="img/mon_285.bmp">img/mon_285.bmp</option>
		<option value="img/mon_275.bmp">img/mon_275.bmp</option>
		<option value="img/mon_245.bmp">img/mon_245.bmp</option>
		<option value="img/mon_241.bmp">img/mon_241.bmp</option>
		<option value="img/mon_208.bmp">img/mon_208.bmp</option>
		<option value="img/mon_204.bmp">img/mon_204.bmp</option>
	</select>

	<input type="submit"value="作成">
<input type="hidden" name="action" value="add" />

</form>


<script type="text/javascript">
$(document).ready(function(){
 $('select[name=image]').ImageSelect({dropdownWidth:425});
 });
</script>
</body>
</html>