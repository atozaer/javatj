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
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="assets/css/main.css" />
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link rel="shortcut icon" href="/images/종이비행기.png" type="image/x-icon">
	<link rel="icon" href="images/종이비행기.png" type="image/x-icon">
	<link href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap" rel="stylesheet">      
	<script
	  src="https://code.jquery.com/jquery-3.6.0.min.js"
	  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	  crossorigin="anonymous">
	</script>
	   <script>
        // 유효성 검사 (사용자가 입력한 값들이 유효한 값의 형태인지)
        function validate(){
            // 유효성 검사 : 아이디, 비밀번호, 비밀번호 일치, 이름
    
            // input요소 객체들 가져다놓기 (작성된 값 아님!!)
            var userId = document.getElementById("id_lbl");
            var userPwd1 = document.getElementById("pwd_lbl");
            var userPwd2 = document.getElementById("pwd2_lbl");
            var userName = document.getElementById("name_lbl");
    
            // 1) 아이디 검사 
            //    영소문자, 숫자로만 총 4~12글자로 이뤄져야됨
            //    단, 첫 글자는 반드시 영소문자 여야됨
            var regExp = /^[a-z][a-z\d]{3,11}$/;
            if(!regExp.test(id_lbl.value)){
                alert("유효한 아이디를 입력해주세요");
                userId.select();
                return false;
            }
    
            // 2) 비밀번호 검사
            //    영문자(대소문자),숫자,특수문자(!@#$%^&*)로 총 8~15자 사이로 입력
            regExp = /^[a-z\d!@#$%^&*]{8,15}$/i;
            if(!regExp.test(pwd_lbl.value)){
                alert("유효한 비밀번호를 입력해주세요");
                pwd_lbl.value = "";
                pwd_lbl.focus();
                return false;
            }
    
            // 3) 비밀번호 일치
            if(pwd_lbl.value != pwd2_lbl.value){
                alert("동일한 비밀번호를 입력해주세요");
                pwd2_lbl.value = "";
                pwd2_lbl.focus();
                return false;
            }
    
            // 4) 이름
            //    한글(결합)로만 2글자 이상
            regExp = /^[가-힣]{2,}$/;
            if(!regExp.test(name_lbl.value)){
                alert("유효한 이름을 입력해주세요");
                name_lbl.select();
                return false;
            }
        }
    </script>
	
	
   </head>
   <body class="is-preload" >

      <!-- Wrapper -->
         <div id="wrapper">

            <!-- Main -->
               <div id="main">
                  <div class="inner">

                     <!-- Header -->
                        
                        <header id="header" >
                           <a href="index.jsp" class="logo"><strong>Trip</strong>review</a>   
                           
                                                   
                           <hc:login></hc:login>
                        </header>
                        
                     <!-- Content -->
                        <section>
                           <div class="location_area member">
                              <div class="box_inner">
                                 <h2 class="tit_page" style="text-align: center;">회원가입 <span class="in"></span></h2>
                              </div>
                           </div>               
                           <form name="member" action="signup.do" class="appForm" method="post">
                              <fieldset>
                                 <p class="info_pilsoo pilsoo_item" style="text-align: center;">* 표시는 필수 입력 해주세요.</p>
                                 <hr color="#25b9e6">            
                                    <table>
                                       <tr>
                                          <td>* 이름 : </td>
                                          <td><input type="text" name="mname" class="w100p" id="name_lbl" placeholder="이름을 입력해주세요"  required/></td>
                                          <td><label>한글로만 이루어져야되며 2글자 이상으로 입력하시오.</label></td>
                                       </tr>
                                        <tr>
                                          <td>* 아이디 : <font id = "checkId" size = "2" style="float: right;"></font></td>
                                          <td><input type="text" name="mid" class = "input_id" id="id_lbl" placeholder="아이디을 입력해주세요" value="" required /></td>
                                          
                                          <td><label>첫글자는 반드시 영문자로, 그리고 영문자, 숫자 포함하여 총 4~12자로 입력하시오.</label></td>
										</tr>
										<tr>
                                          <td>* 비밀번호 : </td>
                                          <td><input type="password" name="mpw" class="pw" id="pwd_lbl" placeholder="비밀번호를 입력해주세요" required/></td>
                                          <td><label>영문자, 숫자, 특수문자로 총 8자~15자로 입력하시오.</label></td>
                                       </tr>
                                       <tr>
                                          <td>* 비밀번호 확인 : <font id = "checkPw" size = "2" style="float: right;"></font></td>
                                          <td><input type="password" name="mpw2" class="pw" id="pwd2_lbl" placeholder="비밀번호를 다시 한번 입력해주세요" required/></td>
                                          <td><label>위의 비밀번호와 일치하게 입력하시오.</label></td>
                                       </tr>
                                       <tr>
                                          <td>생년월일</td>
                                          <td><input type="text" name="mbirth" class="w100p" id="mbrith_lbl" placeholder="생년월일를 입력해주세요" /></td>
                                       </tr>
                                       <tr>
                                          <td>* 성별</td>
                                          <td>
                                             <input type="radio" class="css-radio" id="mmm_lbl" name="mgender" value="남자" checked="checked"><label for="mmm_lbl" >남</label>
                                             <input type="radio" class="css-radio" id="www_lbl" name="mgender" value="여자"><label for="www_lbl">여</label>
                                          </td>
                                       </tr>
                                       <tr>
                                          <td>* 연락처</td>
                                          <td><input type="tel" name="mphone" class="w100p" id="phone_lbl" placeholder=" ' - '  없이 숫자만 입력하세요" required/></td>
                                          <td><label>전화번호작성해주세요</label></td>
                                       </tr>
                                       <tr>
                                          <td rowspan="1"> * 이메일 : </td>
                                          <td>
                                             <input type="email" name="mmail" id="email_lbl" title="이메일아이디만입력하세요" placeholder="E-mail@naver.com" required /></td>
                                          <td>
                                              <label>이메일 형식에 맞춰서 입력하시오.</label>
                                              <!-- <a href="#" class="button">인증번호 받기</a> -->
                                          </td>
                                          
                                       </tr>
                                       <!-- <tr>
                                          <td>
                                         	<input type="text" name="" placeholder="인증번호를 입력해주세요">
                                          </td>
                                       </tr> -->
                                       
                                       <tr>
                                          <td ><a href="https://policy.naver.com/policy/service.html">홈페이지 이용 약관(필수)</a></td>
                                          <td colspan="2">
                                             <input type="checkbox" id="demo-copy" name="demo-copy" required>
                                             <label for="demo-copy">동의함</label>
                                          </td>
                                       </tr>
                                       <tr>
                                          <td><a href="https://policy.naver.com/policy/service.html">개인정보 수집 및 이용 동의(필수)</a></td>
                                          <td colspan="2">
                                             <input type="checkbox" id="demo-human" name="demo-human" required>
                                             <label for="demo-human">동의함</label>
                                          </td>
                                       </tr>
                                    
                                    </table>
                                 
                                 
                                 <input type="submit" value="회원가입" onclick="return validate();">   
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
         <script>
			$('.input_id').focusout(function(){
				let userId = $('.input_id').val(); // input_id에 입력되는 값
				
				console.log(userId);
				
				$.ajax({
					url : "idCheck.do", //던질 URL
					type : "post", // 방식
					data : {userId: userId}, //던지는 파라미터
					dataType : 'json',
					success : function(result){ // 성공시 result에 값이 들어옵니다.
						if(result == 0){
							$("#checkId").html('사용할 수 없는 아이디입니다.');
							$("#checkId").attr('color','red');
						} else{
							$("#checkId").html('사용할 수 있는 아이디입니다.');
							$("#checkId").attr('color','green');
						} 
					},
					error : function(){
						alert("서버요청실패");
					}
				});
			});
		</script>
         <script>
			$('.pw').keyup(function(){
				
				let pass1 = $("#pwd_lbl").val(); // input_id에 입력되는 값
				let pass2 = $("#pwd2_lbl").val(); // input_id에 입력되는 값
			
				if(pass1 != "" || pass2 != ""){
					if(pass1==pass2){
						$("#checkPw").html('비밀번호가 일치합니다.');
						$("#checkPw").attr('color','green');
					}else{
						$("#checkPw").html('비밀번호가 일치하지 않습니다.');
						$("#checkPw").attr('color','red');
					}
				}
					
			})
		</script>

   </body>
</html>