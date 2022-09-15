<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="hc" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<!--
	Editorial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->

<!-- memberInfo페이지 개선해야 할 사항 -->
<!-- 별점관리가 회원 -> 리뷰로 넘어가고나서 관리자가 어떤 정보를 변경할 수 있을지?  -> 회원정보 변경말고 회원이 쓴 문의보기, 리뷰보기로 넘어갈 수 있도록함.-->

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

							<!-- Content -->
								<section>
									<header class="main" style="text-align: center;">
										<h1>Member Info</h1>
									</header>
									<c:set var="m" value="${memberInfo}"></c:set>


									<div class="row">
										<div class="col-4 col-12-medium off-2" style="border-right: #25b9e6 2px solid;">
											<ul class="actions stacked">
												<li style="text-align: center; ">
													<hc:mphoto_big></hc:mphoto_big>
												</li>
												
												<li style="padding-left: 40px;">
													<a href="myReviewBoard.do?a=${m.mid}" class="button primary  small">회원이 쓴 리뷰 보기</a>
												</li>
												<li style="padding-left: 40px;">
													<a href="askBoard.do?a=${m.mid}" class="button primary  small">전체문의보기</a>
												</li>
												
											</ul>										
											
										</div>
										
																				
										
										<div class="col-4 col-12-medium">
										<c:set var="m" value="${memberInfo}"></c:set>
											
											아이디<input type="text" value="${m.mid}" readonly="readonly">											
											이름<input type="text" placeholder="${m.mname}" readonly="readonly">											
											생년월일<input type="text" placeholder="${m.mbirth}" readonly="readonly">
											전화번호<input type="tel" placeholder="${m.mphone}" readonly="readonly">
											성별<input type="text" placeholder="${m.mgender}" readonly="readonly">
											이메일<input type="email" placeholder="${m.mmail}" readonly="readonly">
											
										
											
										</div>
										
										<div class="col-4 off-4" style="margin-top: 30px">											
											<a href="memberList.do?mid=${m.mid}" class="button fit">목록으로</a>
										</div>
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