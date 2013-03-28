<html>
<body>
	<h2>Registration</h2>
	<form action="/stats/teacher/register" method="POST">
	<input type="text" value="Teacher ID" name="teacherId"/><br>
	<input type="text" value="First Name" name="firstName"/><br>
	<input type="text" value="Last Name" name="lastName"/><br>
	<input type="text" value="Login" name="login"/><br>
	<input type="text" value="Password" name="password"/><br>
	<input type="text" value="Email" name="email"/><br>
	<input type="text" value="Clever ID" name="cleverId"/><br>
	<input type="submit" value="REGISTER"/><br>
	</form>
	
	<h2>Login</h2>
	<form action="/stats/teacher/login" method="GET">
	<input type="text" value="Login" name="login"/><br>
	<input type="text" value="Password" name="password"/><br>
	<input type="submit" value="LOGIN"/><br>
	</form>	
</body>
</html>
