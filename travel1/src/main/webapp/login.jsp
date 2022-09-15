<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="hc" tagdir="/WEB-INF/tags"%>
<!DOCTYPE HTML>
<!--
	Editorial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>하이코딩 - TripReview</title>
		
		<!-- jquery -->
		<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
		<!-- 소셜 버튼 -->
		<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
		
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link rel="shortcut icon" href="/images/종이비행기.png" type="image/x-icon">
		<link rel="icon" href="images/종이비행기.png" type="image/x-icon">
		<link href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap" rel="stylesheet">
		<style>
			.btn-social-login {
			   transition: all .2s;
			   outline: 0;
			   border: 1px solid transparent;
			   padding: .5rem !important;
			   border-radius: 50%;
			   color: #fff;
			}
			
			.btn-social-login:focus {
			   box-shadow: 0 0 0 .2rem rgba(0, 123, 255, .25);
			}
			
			.text-dark {
			   color: #343a40 !important;
			}
			
			.name {
			   text-align: center;
			}
		</style>
	</head>
	<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">

							<!-- Header -->
								
								<header id="header" >
									<a href="main.do" class="logo"><strong>Trip</strong>review</a>	
									
									
									
																	
									<ul class="icons">
										<li><a href="idSearch.jsp" class="button small" style="float: right;">아이디 찾기</a></li>
										<li><a href="pwSearch.jsp" class="button small" style="float: right;">비밀번호 찾기</a></li>
										<li><a href="signup.jsp" class="button small" style="float: right;">회원가입</a></li>
									</ul>
								</header>

							<!-- Content -->
							
							<script async defer crossorigin="anonymous"
							     src="https://connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v13.0&appId=4872709812825483&autoLogAppEvents=1"
							     nonce="FEkAkaD8"></script>
							<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
																

								<section>
								<div class="location_area member">
										<div class="box_inner">
											<h2 class="tit_page" style="text-align: center;">로그인<span class="in"></span></h2>
										</div>
									</div>	
								
								
								<form action="login.do" class="appForm" method="post">
										<fieldset>	
											<table>
												<tr>
													<td>아이디</td>
													<td colspan="2"><input type="text" name="mid" placeholder="아이디를 입력해주세요"/></td>
												</tr>
												<tr>
													<td>비밀번호</td>
													<td colspan="2"><input type="password" name="mpw" placeholder="비밀번호를 입력해주세요"/></td>
												</tr>
												<tr>
													<td colspan="3"><input type="submit" value="로그인" style="float: right;"></td>
												</tr>
											</table>
										</fieldset>
									</form>
								
								</section>

						</div>
					</div>

				<!-- Sidebar -->
					<div id="sidebar">
						<div class="inner">

							<!-- Search -->
								<section  class="alt">
								
									<form id="searchForm" method="post" action="searchPage.do">
										
								
									<table>
										<tr>
											<td>								
												<select name="keyword" style="float: left; vertical-align: text-top; font-size: 12pt; text-align-last: center; width: 100px; height: 40px; background-color: #D4F4FA; color: black; border: 1px solid gray;">
													<option value="rtitle">제목</option>
													<option value="mid">작성자</option>
												</select>
											</td>
											<td>										
												<input type="submit" value="검색하기" name="searchres" class="" style="float: right;">
											</td>		
										</tr>
										<tr>
											<td colspan="2">
												<input type="text" name="query" id="query" placeholder="Search" />
											</td>
										</tr>	
									</table>

								
										<!-- <input type="text" name="query" id="query" placeholder="Search" /> -->
									</form>
								</section>

							<!-- Menu -->
								<nav id="menu">
									<header class="major">
										<h2>메뉴</h2>
									</header>
									<ul>
										<li><a href="main.do">메인</a></li>
										<li><a href="newsBoard.do">공지사항</a></li>
										<li><a href="reviewBoard.do">리뷰 게시판</a></li>
										<li><a href="askBoard.do">문의 게시판</a></li>
									</ul>
								</nav>

							<!-- Section -->
								<section>
									<header class="major">
										<h2>꿈을 담은 특별한 여행<br>하이코딩 TripReview!</h2>
									</header>
									<p>
										꿈을 담은 특별한 여행, 하이코딩 TripReview!<br>
										그 들의 후기가 궁금하다면?<br>
										하이코딩 Original 지금바로 리뷰페이지에서 만나보세요.<br>
										특별한 키워드를 담은 여행 후기들을 소개합니다.<br>
										#친환경 여행  #꿈의 숙박</p>
									<ul class="contact">
										<li class="icon solid fa-envelope"><a href="#">j38317_study@naver.com</a></li>
										<li class="icon solid fa-phone">010-4920-xxxx</li>
										<li class="icon solid fa-home">7, Bongcheon-ro 8-gil</li>
									</ul>
								</section>

							<!-- Footer -->
								<footer id="footer">
									<p class="copyright">&copy; Untitled. All rights reserved. Demo Images: <a href="https://unsplash.com">Unsplash</a>. Design: <a href="https://html5up.net">HTML5 UP</a>.</p>
								</footer>

						</div>
					</div>

			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
			
			
			

	</body>
</html>