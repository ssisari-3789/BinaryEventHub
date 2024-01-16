<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login or Register</title>
	<style type="text/css">
		body {
			font-family: Arial, sans-serif;
			background-color: #007BFF;
			margin: 0;
			padding: 0;
		}
		.container {
			display: flex;
			justify-content: center;
			align-items: center;
			height: 100vh;
		}
		.form-box {
			background: #ffffff;
			border-radius: 8px;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
			padding: 20px;
			width: 620px;
		}
		h1 {
			text-align: center;
		}
		.form {
			margin-top: 20px;
		}
		.form h2 {
			margin: 0;
		}
		.form input[type="text"],
		.form input[type="password"] {
			width: 95%;
			padding: 10px;
			margin: 10px 0;
			border: 1px solid #ccc;
			border-radius: 4px;
		}
		.form input[type="submit"] {
			background-color: #007BFF;
			color: #fff;
			padding: 10px 20px;
			border: none;
			border-radius: 4px;
			cursor: pointer;
		}
		.form input[type="submit"]:hover {
			background-color: #0056b3;
		}
		.toggle-link {
			text-align: center;
			margin-top: 20px;
		}
	</style>
</head>
<body>
	<div class="container">
		<div class="form-box">
			<h1>Login or Register</h1>
			<div class="form">
				<div id="login-form">
					<!-- Login Form -->
					<form action="login" method="post">
						<h2>Login</h2>
						User Name <input type="text" name="username" placeholder="Enter your username"><br>
						Password <input type="password" name="password" placeholder="Enter your password"><br>
						<input type="submit" name="login" value="Login">
					</form>
					<p class="toggle-link">Don't have an account? <a href="#" id="register-link">Register</a></p>
				</div>
				<div id="register-form" style="display: none;">
					<!-- Registration Form -->
					<form action="insert" method="post">
						<h2>Register</h2>
						Name <input type="text" name="name" placeholder="Enter your name"><br>
						Email <input type="text" name="email" placeholder="Enter your email"><br>
						Phone <input type="text" name="phone" placeholder="Enter your phone"><br>
						Username <input type="text" name="uid" placeholder="Enter your username"><br>
						Password <input type="password" name="psw" placeholder="Enter your password"><br>
						<input type="submit" name="register" value="Register">
					</form>
					<p class="toggle-link">Already have an account? <a href="#" id="login-link">Login</a></p>
				</div>
			</div>
		</div>
	</div>

	<script>
		// JavaScript to toggle between login and registration forms
		const loginForm = document.getElementById("login-form");
		const registerForm = document.getElementById("register-form");
		const loginLink = document.getElementById("login-link");
		const registerLink = document.getElementById("register-link");

		loginLink.addEventListener("click", (e) => {
			e.preventDefault();
			loginForm.style.display = "block";
			registerForm.style.display = "none";
		});

		registerLink.addEventListener("click", (e) => {
			e.preventDefault();
			loginForm.style.display = "none";
			registerForm.style.display = "block";
		});
	</script>
</body>
</html>
