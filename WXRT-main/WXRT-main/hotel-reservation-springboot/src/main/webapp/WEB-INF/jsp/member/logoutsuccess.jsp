<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" scope="session"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>您已登出成功</title>
    <link rel="stylesheet" href="${contextRoot}/css/success.css">
    <meta http-equiv="refresh" content="5" url="Home.html">
</head>
<body>
    <div class="c1">
        <div class="c2">登出成功!</div>
    </div>
    <div class="c3">
        <br>點擊下方圖示回首頁
        <br>5秒後自動跳轉首頁
    </div>

    <div class="c5"><a href="${contextRoot}/index"><img src="${contextRoot}/images/sslogo.png"></a>
    </div>
    <div id="since">
        <h4>WXRT since 2022</h4>
      </div>
</body>
</html>