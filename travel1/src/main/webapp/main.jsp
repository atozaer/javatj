<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		
		<link rel="shortcut icon" href="/images/종이비행기.png" type="image/x-icon">
		<link rel="icon" href="images/종이비행기.png" type="image/x-icon">

		<link href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap" rel="stylesheet">

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
									
									<hc:login></hc:login>							
									
								</header>


							<!-- Banner -->
								<section id="banner">
								
									<div class="content">
										<header>
											<h1>Trip<br />
											Review</h1>
											<p>여행 리뷰 커뮤니티 !</p>
										</header>
										<p>
										여행 정보 공유와 리뷰 별점 시스템으로 신뢰도까지 !<br>
										답답한 일상 속 차기 여행지는?<br>
										모두 건강 조심 하시고 항상 행복하세요!
										</p>
										<ul class="actions">
											<li><a href="reviewBoard.do" class="button big">리뷰 게시판으로</a></li>
										</ul>
									</div>
									<span class="image object">
										<a href="reviewBoard.do"><img src="http://img.etoday.co.kr/pto_db/2021/03/20210312170449_1593071_700_385.jpg" alt="" /></a>
									</span>
								</section>

							<!-- Section -->
								<section>
									<header class="major">
										<h2>리뷰 모아보기</h2>
									</header>
									<div class="posts">
										<c:forEach var="bs" items="${mainreview}">
										<c:set var="rvo" value="${bs.reviewboardVO}" /> 
											<article>
												<a href="review.do?rnum=${rvo.rnum}" class="image"><img alt="리뷰이미지" src="./images/${rvo.rfile}" style="border: 2px solid gray; width:100%; height:100%;"/> </a>
												<a href="review.do?rnum=${rvo.rnum}">
												<h3 style="text-align: center;">${rvo.rtitle}</h3>
												<p style="text-align: center;">${rvo.rcontent}</p>
												</a>
												<ul class="actions">
													<li><a href="review.do?rnum=${rvo.rnum}" class="button">More</a></li>
												</ul>
											</article>
										</c:forEach>
										
									</div>
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