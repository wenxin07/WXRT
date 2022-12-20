<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>會員資料</title>
<link rel="stylesheet" href="${contextRoot}/css/member.css">
<script src="${contextRoot}/js/birthday.js"></script>
</head>

<body background="">


	<form:form action="${contextRoot}/member/memberprofile/${member.id}"
		method="post" modelAttribute="member">
		<div class="w-container contact-continer">
			<div class="c1">
				<h1>會員資料</h1>
			</div>

			<table class="tb1">
				<tr>
					<th>真實姓名</th>
					<td>
						<div class="c2">
							<span id="idfnamesp"></span> <label for="w-FNAME">姓氏</label>
							<form:input path="firstname" type="text"
								value="${member.firstname}" name="firstName" class="tab"
								id="w-FNAME" placeholder="" />

							<span id="idlnamesp"></span> <label for="w-LNAME">名字</label>
							<form:input path="lastname" type="text"
								value="${member.lastname}" name="lastName" class="tab"
								id="w-LNAME" placeholder="" />

						</div>
					</td>
				</tr>
				<!--             <tr> -->
				<!--                 <th>性別</th> -->
				<!--                 <td> -->
				<!--                     <div class="c3"> -->
				<%--                         <form:input path="sex"  type="radio" name="sex" value="Male" class="c31" />男性 --%>
				<%--                         <form:input path="sex" type="radio" name="sex" value="Female" class="c31" />女性 --%>
				<!--                     </div> -->
				<!--                 </td> -->
				<!--             </tr> -->
				<tr>
					<th>生日</th>
					<td>
						<div class="c3">

							<form:input path="birth" type="date" id="start" name="birth"
								value="${member.birth}" min="1970-01-01" max="2022-12-31" />
							<%--                         <form name="reg_testdate"> --%>
							<!--                             <select name="YYYY" onchange="YYYYDD(this.value)"> -->
							<!--                                 <option value="西元年(yyyy)"></option> -->
							<!--                             </select> -->

							<!--                             <select name="MM" onchange="MMDD(this.value)"> -->
							<!--                                 <option value="月(MM)"></option> -->
							<!--                             </select> -->

							<!--                             <select name="DD" onchange="MMDD(this.value)"> -->
							<!--                                 <option value="日(dd)"></option> -->
							<!--                             </select> -->
							<%--                         </form> --%>
						</div>
					</td>
				</tr>
				<tr>
					<th>電話</th>
					<td>
						<div class="c2">
							<span id="idtelsp"></span>
							<form:input path="phone" type="text" name="" class="tab"
								value="${member.phone}" id="w-TEL" />
						</div>
					</td>
				</tr>
				<tr>
					<th>帳號(電子郵件)</th>
					<td>
						<div class="c2">
							<span id="idemailsp"></span>
							<form:input path="email" type="email" value="${member.email}"
								name="email" class="tab" id="w-EMAIL" placeholder="" />
						</div>
					</td>
				</tr>
				<tr>
					<th>密碼</th>
					<td>
						<div class="c2">
							<span id="idpasswordsp"></span>
							<form:input path="password" type="password" value=""
								name="password" class="tab" id="w-PASSWORD" placeholder="" />
						</div>
					</td>
				</tr>
			</table>
			<div class="c4">
				<input type="submit" class="update" value="修改"
					onclick="location.href='${contextRoot}/jsp/member/editsuccess'">
			</div>
	</form:form>



	<script>
		var lname = document.getElementById("w-LNAME");
		var fname = document.getElementById("w-FNAME");
		var tel = document.getElementById("w-TEL");
		var email = document.getElementById("w-EMAIL");
		var password = document.getElementById("w-PASSWORD");

		lname.addEventListener("blur", checklname);
		function checklname() {
			let re = /[^a-zA-Z]/;
			let sp1 = document.getElementById("idlnamesp")
			if (lname.value == "") {
				sp1.innerHTML = "*";
				sp1.style.color = "red";
			} else if (lname.value.length > 20) {
				sp1.innerHTML = "*";
				sp1.style.color = "red";
			} else if (re.test(lname.value)) {
				sp1.innerHTML = "*";
				sp1.style.color = "red";
			} else {
				sp1.innerHTML = ""
			}
		}
		fname.addEventListener("blur", checkfname);
		function checkfname() {
			let re = /[^a-zA-Z-]/;
			let sp2 = document.getElementById("idfnamesp")
			if (fname.value == "") {
				sp2.innerHTML = "*";
				sp2.style.color = "red";
			} else if (fname.value.length > 20) {
				sp2.innerHTML = "*";
				sp2.style.color = "red";
			} else if (re.test(fname.value)) {
				sp2.innerHTML = "*";
				sp2.style.color = "red";
			} else {
				sp2.innerHTML = ""
			}
		}
		tel.addEventListener("blur", checktel);
		function checktel() {
			let sp3 = document.getElementById("idtelsp")
			if (tel.value == "") {
				sp3.innerHTML = "*";
				sp3.style.color = "red";
			} else if (tel.value.length != 10) {
				sp3.innerHTML = "*";
				sp3.style.color = "red";
			} else {
				sp3.innerHTML = ""
			}
		}
		email.addEventListener("blur", checkemail);
		function checkemail() {
			let sp4 = document.getElementById("idemailsp")
			if (email.value == "") {
				sp4.innerHTML = "*";
				sp4.style.color = "red";
			} else {
				sp4.innerHTML = ""
			}
		}
		password.addEventListener("blur", checkpassword);
		function checkpassword() {
			let re = /[^a-zA-Z0-9]/;
			let sp5 = document.getElementById("idpasswordsp")
			if (password.value == "") {
				sp5.innerHTML = "*";
				sp5.style.color = "red";
			} else if (password.value.length > 20 || password.value.length < 6) {
				sp5.innerHTML = "*";
				sp5.style.color = "red";
			} else if (re.test(password.value)) {
				sp5.innerHTML = "*";
				sp5.style.color = "red";
			} else {
				sp5.innerHTML = ""
			}
		}
	</script>
	</div>
</body>

</html>