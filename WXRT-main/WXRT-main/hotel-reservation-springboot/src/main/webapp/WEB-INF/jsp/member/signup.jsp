<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" scope="session"/>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>註冊</title>
<link rel="stylesheet" href="${contextRoot}/css/signup.css">
<!--   <script src="js/login.js"></script> -->
</head>

<body background="../images/-min.jpg">
	<!--   <div class="system_name"> -->
	<!--     <h2>Member Area</h2> -->
	<!--   </div> -->

	<div class="signup_page">
		<div id="container2">

			<div class="signup">

				<h3>註冊</h3>

				<form:form action="${contextRoot}/member/signup" method="post" modelAttribute="signup_member">
					<form:input path="email" type="text" id="username2" name="username"
						placeholder="帳號 (email)" required="required"/>
					<div class="tab"></div>
					<form:input path="password" type="password" id="password2" name="password"
						placeholder="密碼 (password)" required="required"/>
					<div class="tab"></div>
					<form:input path="checkpassword" type="password" id="comfirm_password" name="comfirm_password"
						placeholder="確認密碼 (comfirm password)" />
					<div class="tab"></div>
					<br> 
					<input type="submit" name="submit" value="註冊" class="submit" >
				</form:form>

				<h5 onclick="show_hide()">登入</h5>

			</div>
			<!-- signup end-->
		</div>
		<!-- container2 end-->
	</div>
	<!-- signup_page end-->

	<div class="login_page">
		<div id="container1">

			<div class="login">

				<h3>登入</h3>


        		<form:form action="${contextRoot}/member/login"  method="post" modelAttribute="login_member">
         		 	<form:input path='email' type="text" id="username" name="username" placeholder="帳號 (email)" />
          			<div class="tab"></div>
         			 <form:input path='password' type="password" id="password" name="password" placeholder="密碼 (password)"  />
         			 <div class="tab"></div>
          
          			<br>
          			<input type="submit" value="登入" class="submit" >
<!--         	 onclick="location.href='(登入之後的連結)'" -->
        
       			</form:form>
				<h5 onclick="show_hide()">註冊</h5>
				

			</div>
			<!-- login end-->
		</div>
		<!-- container1 end-->
	</div>
	<!-- login_page end-->
	



	<div id="since">
		<h4>WXRT since 2022</h4>
	</div>

	<script>
		function show_hide() {
			var login = document.getElementById("container1");
			var signup = document.getElementById("container2");
			var copyright = document.getElementById("copyright");

			if (signup.style.display === "none") {
				signup.style.display = "block"; //signup出現
				document.getElementById("username2").value = "";
				document.getElementById("password2").value = "";
				login.style.display = "none"; //login消失
				copyright.style.margin = "200px 0px 0px 0px";

			} else {

				signup.style.display = "none"; //signup消失
				login.style.display = "block"; //login出現
				login.style.visibility = "visible";
				copyright.style.margin = "200px 0px 0px 0px";

				document.getElementById("username").value = "";
				document.getElementById("password").value = "";
			}
		}
	</script>

</body>
</html>