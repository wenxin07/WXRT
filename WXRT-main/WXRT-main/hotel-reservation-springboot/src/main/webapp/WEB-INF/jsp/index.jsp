<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html style="font-size: 16px" lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta charset="utf-8" />
<meta name="keywords"
	content="​Best Camping in the National Park, Our Services, Our Campimg, ​Family Camp, ​Sport activities, Contact Us, INTUITIVE" />
<meta name="description" content="" />
<title>Home</title>

<link rel="stylesheet" href="<c:url value="/css/nicepage.css" />"
	media="screen" type="text/css" />
<link rel="stylesheet" href="<c:url value="/css/Home.css" />"
	media="screen" type="text/css" />

<script class="u-script" type="text/javascript" src="/js/jquery.js"
	defer=""></script>
<script class="u-script" type="text/javascript" src="/js/nicepage.js"
	defer=""></script>
<meta name="generator" content="Nicepage 4.18.4, nicepage.com" />
<link id="u-theme-google-font" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i" />
<link id="u-page-google-font" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700,700i|Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" />

<script type="application/ld+json">
      {
        "@context": "http://schema.org",
        "@type": "Organization",
        "name": "",
        "logo": "images/49B454D8-1351-4462-B220-A14275B5D570.png"
      }
    </script>
<meta name="theme-color" content="#478ac9" />
<meta property="og:title" content="Home" />
<meta property="og:type" content="website" />
</head>
<body data-home-page="Home.html" data-home-page-title="Home"
	class="u-body u-xl-mode" data-lang="en">
	<header class="u-clearfix u-header u-header" id="sec-ca98">
		<div class="u-clearfix u-sheet u-sheet-1">
			<a href="/index" class="u-image u-logo u-image-1"
				data-image-width="3603" data-image-height="2136"> <img
				src="/images/49B454D8-1351-4462-B220-A14275B5D570.png"
				class="u-logo-image u-logo-image-1" />
			</a>
			<nav class="u-menu u-menu-dropdown u-offcanvas u-menu-1">
				<div class="menu-collapse"
					style="font-size: 1rem; letter-spacing: 0px; font-weight: 700">
					<a
						class="u-button-style u-custom-border u-custom-border-color u-custom-borders u-custom-left-right-menu-spacing u-custom-padding-bottom u-custom-text-color u-custom-top-bottom-menu-spacing u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base"
						href="#"> <svg class="u-svg-link" viewBox="0 0 24 24">
                <use xmlns:xlink="http://www.w3.org/1999/xlink"
								xlink:href="#menu-hamburger"></use>
              </svg> <svg class="u-svg-content" version="1.1"
							id="menu-hamburger" viewBox="0 0 16 16" x="0px" y="0px"
							xmlns:xlink="http://www.w3.org/1999/xlink"
							xmlns="http://www.w3.org/2000/svg">
                <g>
                  <rect y="1" width="16" height="2"></rect>
                  <rect y="7" width="16" height="2"></rect>
                  <rect y="13" width="16" height="2"></rect>
                </g>
              </svg>
					</a>
				</div>
				<div class="u-nav-container">
					<ul class="u-nav u-spacing-20 u-unstyled u-nav-1">
						<li class="u-nav-item"><a
							class="u-border-no-bottom u-border-no-left u-border-no-right u-border-no-top u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-palette-2-base"
							href="/index" style="padding: 10px">首頁</a></li>
						<li class="u-nav-item"><a
							class="u-border-no-bottom u-border-no-left u-border-no-right u-border-no-top u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-palette-2-base"
							href="/about" style="padding: 10px">關於我們</a></li>
						<li class="u-nav-item"><a
							class="u-border-no-bottom u-border-no-left u-border-no-right u-border-no-top u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-palette-2-base"
							href="/contact" style="padding: 10px">聯繫我們</a></li>
						<li class="u-nav-item"><a
							class="u-border-no-bottom u-border-no-left u-border-no-right u-border-no-top u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-palette-2-base"
							href="/reservation/index" style="padding: 10px">立即訂房</a></li>
						<li class="u-nav-item"><a
							class="u-border-no-bottom u-border-no-left u-border-no-right u-border-no-top u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-palette-2-base"
							href="${contextRoot}/member/memberprofile" style="padding: 10px">會員資料</a>
						</li>
						<li class="u-nav-item"><a
							class="u-border-no-bottom u-border-no-left u-border-no-right u-border-no-top u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-palette-2-base"
							href="${contextRoot}/member/logout" style="padding: 10px">登出</a>

						</li>
					</ul>
				</div>
				<div class="u-nav-container-collapse">
					<div
						class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
						<div class="u-inner-container-layout u-sidenav-overflow">
							<div class="u-menu-close"></div>
							<ul
								class="u-align-center u-nav u-popupmenu-items u-unstyled u-nav-2">
								<li class="u-nav-item"><a class="u-button-style u-nav-link"
									href="/index">首頁</a></li>
								<li class="u-nav-item"><a class="u-button-style u-nav-link"
									href="/about">關於我們</a></li>
								<li class="u-nav-item"><a class="u-button-style u-nav-link"
									href="/contact">聯繫我們</a></li>
								<li class="u-nav-item"><a class="u-button-style u-nav-link"
									href="/reservation/index">立即訂房</a></li>
								<li class="u-nav-item"><a class="u-button-style u-nav-link"
									href="${contextRoot}/member/memberprofile">會員資料</a></li>
							</ul>
						</div>
					</div>
					<div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
				</div>
			</nav>
		</div>
	</header>
	<section
		class="skrollable skrollable-between u-align-center u-clearfix u-image u-shading u-section-1"
		src="" id="carousel_dcac" data-image-width="1280"
		data-image-height="853">
		<div class="u-clearfix u-sheet u-sheet-1">
			<h2 class="u-align-center u-text u-text-1">Make a life , not
				just a reservation !</h2>
			<div class="u-clearfix u-layout-wrap u-layout-wrap-1">
				<div class="u-layout">
					<div class="u-layout-row">
						<div
							class="u-align-right u-container-style u-layout-cell u-left-cell u-size-30 u-layout-cell-1">
							<div class="u-container-layout u-valign-top u-container-layout-1">
								<a href="/member/login"
									class="u-active-palette-4-base u-border-none u-btn u-btn-round u-button-style u-custom-color-1 u-hover-palette-2-base u-radius-50 u-btn-1">會員登入</a>
							</div>
						</div>
						<div
							class="u-align-left u-container-style u-layout-cell u-right-cell u-size-30 u-layout-cell-2">
							<div class="u-container-layout u-valign-top u-container-layout-2">
								<a href="/member/signup"
									class="u-active-white u-border-2 u-border-active-white u-border-hover-white u-border-white u-btn u-btn-round u-button-style u-hover-white u-none u-radius-50 u-text-active-black u-text-hover-black u-btn-2">成為會員</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="u-expanded-width u-list u-list-1">
				<div class="u-repeater u-repeater-1">
					<div
						class="u-align-center u-container-style u-list-item u-repeater-item u-shape-rectangle">
						<div
							class="u-container-layout u-similar-container u-container-layout-3">
							<span class="u-file-icon u-icon u-text-white u-icon-1"><img
								src="/images/2325148-28c38e53.png" alt="" /></span>
							<h4
								class="u-align-center u-custom-font u-text u-text-font u-text-2">
								Travel</h4>
						</div>
					</div>
					<div
						class="u-align-center u-container-style u-list-item u-repeater-item u-shape-rectangle">
						<div
							class="u-container-layout u-similar-container u-container-layout-4">
							<span class="u-file-icon u-icon u-text-white u-icon-2"><img
								src="/images/7401471-4294aa1a.png" alt="" /></span>
							<h4
								class="u-align-center u-custom-font u-text u-text-font u-text-3">
								Business</h4>
						</div>
					</div>
					<div
						class="u-align-center u-container-style u-list-item u-repeater-item u-shape-rectangle">
						<div
							class="u-container-layout u-similar-container u-container-layout-5">
							<span class="u-file-icon u-icon u-text-white u-icon-3"><img
								src="/images/931077-6ca510ad.png" alt="" /></span>
							<h4
								class="u-align-center u-custom-font u-text u-text-font u-text-4">
								Booking</h4>
						</div>
					</div>
					<div
						class="u-align-center u-container-style u-list-item u-repeater-item u-shape-rectangle">
						<div
							class="u-container-layout u-similar-container u-container-layout-6">
							<span class="u-file-icon u-icon u-text-white u-icon-4"><img
								src="/images/2560416-11b1db70.png" alt="" /></span>
							<h4
								class="u-align-center u-custom-font u-text u-text-font u-text-5">
								Rest<br /> <br />
							</h4>
						</div>
					</div>
				</div>
			</div>
			<%
			String contextPath = request.getContextPath();
			%>
			<h6 class="u-align-center u-text u-text-6">Copyright © 2022
				WXRT.&nbsp;All rights reserved.</h6>
		</div>
	</section>
</body>
</html>
