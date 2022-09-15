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

<!-- reviewBoard페이지 개선해야 할 사항 -->
<!-- 해당 게시글의 별점 평균을 출력해주는 sql문 필요: avg참고-->
<!-- 해당 게시글의 댓글 개수를 출력해주는 sql문 필요 -->
<!-- ...누르면 삭제, 신고하기 버튼 나오게 -->

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
										<h1>리뷰 게시판</h1>
									</header>
									<hc:reviewWrite></hc:reviewWrite>
									<hr>

									<div class="row gtr-uniform">
									<!-- c태그로 div생성 및 내용물 넣기 -->
									
									
									<c:forEach var="bs" items="${reviewList}">
									
										
										<c:set var="rvo" value="${bs.reviewboardVO}"/>
									
																				
										<div class="col-4" style="justify-content:center;">
									
											
											<table>
												<tr style="background: transparent; border: none; padding-bottom: 0px;">
													
													<td style=" width:55%; text-align: left">
														<div id="review_mname" style="display:inline-block;">
															<a href="myReviewBoard.do?a=${rvo.mid}" style="font-size: 20px;">${rvo.mid}</a>
									
														</div>
													</td>
													<td colspan="2" style="width:30%; text-align: right; padding-bottom: 0px;"> <ul id="rmenu${rvo.rnum}" class="actions"> <hc:reviewDelete mid="${rvo.mid}" rnum="${rvo.rnum}"></hc:reviewDelete></ul> </td>
																																					
												</tr>
												
												
												<tr style="background: transparent; border: none;">
													<td colspan="3">
														<span class="image fit">
															<a href="review.do?rnum=${rvo.rnum}"><img alt="리뷰이미지" src="./images/${rvo.rfile}" style="border: 2px solid gray; width:100%; height:100%;"> </a>
														</span>
													</td>
												</tr>
												<tr>
													<td colspan="3">
														${rvo.rtitle}
													</td>
												</tr>
												
												<tr style="background: transparent; border: none;">
													<td>
														${rvo.rdate}
													</td>
													
													<td style="text-align: right">													
														
														<a href="review.do?rnum=${rvo.rnum}" class="icon"><span>★<hc:fmt rthumbsup="${rvo.rthumbsup}"></hc:fmt></span></a>
																											
									
														
													</td>	
													<td style="text-align: right">										
														
														<a href="review.do?rnum=${rvo.rnum}" class="icon">💬<span>${rvo.rcnt}</span></a>													
														
													</td>									
												</tr>
											</table>										
									
										</div>
									</c:forEach>
									
									</div>
								</section>
								<section style="text-align: center;">
									<div class="row">
										<div id="bottom" class="col-12">
											<!-- <ul class="pagination">
												<li><span class="button disabled">Prev</span></li>
												<li><a href="#" class="page active">1</a></li>
												<li><a href="#" class="page">2</a></li>
												<li><a href="#" class="page">3</a></li>
												<li><span>&hellip;</span></li>
												<li><a href="#" class="page">8</a></li>
												<li><a href="#" class="page">9</a></li>
												<li><a href="#" class="page">10</a></li>
												<li><a href="#" class="button">Next</a></li>
											</ul> -->
														
												
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