<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="hc" tagdir="/WEB-INF/tags"%>

  <% 
   String id="";
   id = (String)session.getAttribute("id"); 
   String checkid="";
   checkid = (String)session.getAttribute("checkid");   
%> 
<%
    if(id==null){
       
    }
%>
<!DOCTYPE HTML>
<!--
   Editorial by HTML5 UP
   html5up.net | @ajlkn
   Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
   <head>
   <script src="assets/js/jquery-1.10.2.js"></script>
      <style type="text/css">
   .idcheck1{color: red;}
   .idcheck2{color:green;}
   </style>
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
    <script type="text/javascript">

   function openId(idform){ 
   
   var idCheck = idform.mid.value;
   
   if(idCheck.length==0||idCheck==""){
   
   alert("아이디를 입력해주세요");
   
   idform.mid.focus();
   
   } 
   
   if(idCheck){
   
   var url = "idCheck.do?id="+idCheck; 
   
   open(url,"win01","width=400,height=400");   
   
   }
  reLoad(); 
}
</script>
  <SCRIPT type="text/javascript"> 
function reLoad(){
      setTimeout("location.reload()",1000);   
}
</SCRIPT>
<script>
   $(function(){
      
      $("#w100p").val("sdfsdfdsf");
   });
</script>
      <title>하이코딩 - TripReview</title>
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
      <link rel="stylesheet" href="assets/css/main.css" />
      <link rel="preconnect" href="https://fonts.googleapis.com">
      <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
      <link href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap" rel="stylesheet">      
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
                                 <p class="info_pilsoo pilsoo_item" style="text-align: center;">전부 다 필수 입력 해주세요.</p>
                                 <hr color="#25b9e6">            
                                    <table>
                                       <tr>
                                          <td>* 이름 : </td>
                                          <td><input type="text" name="mname" class="w100p" id="name_lbl" placeholder="이름을 입력해주세요"  required/></td>
                                          <td><label>한글로만 이루어져야되며 2글자 이상으로 입력하시오.</label></td>
                                       </tr>
                                        <tr>
                                        <%
                                           if(checkid==null){
                                              checkid=" ";      
                                           }
                                         %>
                                          <td>* 아이디 : </td>
                                          <td><input type="text" name="mid" class="w100p" id="id_id1" placeholder="아이디을 입력해주세요" value="<%=checkid %>" required /></td>
                                          <td><input type="button" value="아이디중복검사" onclick="openId(this.form)"><td>
                                          <td><label>첫글자는 반드시 영문자로, 그리고 영문자, 숫자 포함하여 총 4~12자로 입력하시오.</label></td>
                                          <tr>
                                          <td>
                                          <%   
                                                checkid=(String)session.getAttribute("checkid");
                                                if(id==null){
                                                   out.println("<td class=idcheck1>아이디를입력해주세요</td>");
                                                }
                                                else if(id.equals(checkid)){
                                                   out.print("<td class=idcheck1>아이디가중복되었습니다.</td>");
                                                }else {
                                                   out.print("<td class=idcheck2>아이디가사용가능합니다.</td>");
                                                } 
                                          %>    
                                          </td>
                                          </tr>

                                       <tr>
                                       <td>
                                       
                                       
                                       </tr>
                                       <tr>
                                          <td>* 비밀번호 : </td>
                                          <td><input type="password" name="mpw" class="w100p" id="pwd_lbl" placeholder="비밀번호를 입력해주세요" required/></td>
                                          <td><label>영문자, 숫자, 특수문자로 총 8자~15자로 입력하시오.</label></td>
                                       </tr>
                                       <tr>
                                          <td>* 비밀번호 확인 : </td>
                                          <td><input type="password" name="mpw2" class="w100p" id="pwd2_lbl" placeholder="비밀번호를 다시 한번 입력해주세요" required/></td>
                                          <td><label>위의 비밀번호와 일치하게 입력하시오.</label></td>
                                       </tr>
                                       <tr>
                                          <td>생년월일</td>
                                          <td><input type="text" name="mbrith" class="w100p" id="mbrith_lbl" placeholder="생년월일를 입력해주세요" required/></td>
                                       </tr>
                                       <tr>
                                          <td>* 남여 :성별</td>
                                          <td>
                                             <input type="radio" class="css-radio" id="mmm_lbl" name="mgender" value="남자"><label for="mmm_lbl">남</label>
                                             <input type="radio" class="css-radio" id="www_lbl" name="mgender" value="여자"><label for="www_lbl">여</label>
                                          </td>
                                       </tr>
                                       <tr>
                                          <td>* 전화번호 : 연락처</td>
                                          <td><input type="tel" name="mphone" class="w100p" id="phone_lbl" placeholder=" ' - '  없이 숫자만 입력하세요" required/></td>
                                          <td><label>전화번호작성해주세요</label></td>
                                       </tr>
                                       <tr>
                                          <td rowspan="2"> * 이메일 : </td>
                                          <td>
                                             <input type="email" name="mmail" id="email_lbl" title="이메일아이디만입력하세요" placeholder="aaa@naver.com" required /></td>
                                          <td>
                                              <label>이메일 형식에 맞춰서 입력하시오.</label>
                                              <a href="#" class="button">인증번호 받기</a>
                                          </td>
                                          
                                       </tr>
                                       <tr>
                                          <td>
                                                   <input type="text" name="" placeholder="인증번호를 입력해주세요">
                                          </td>
                                       </tr>
                                       
                                       <tr>
                                          <td >홈페이지 이용 약관(필수)</td>
                                          <td colspan="2">
                                             <input type="checkbox" id="demo-copy" name="demo-copy" required>
                                             <label for="demo-copy">동의함</label>
                                          </td>
                                       </tr>
                                       <tr>
                                          <td>개인정보 수집 및 이용 동의(필수)</td>
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
                        <section id="search" class="alt">
                           <form method="post" action="#">
                              <input type="text" name="query" id="query" placeholder="Search" />
                           </form>
                        </section>

                     <!-- Menu -->
                        <nav id="menu">
                           <header class="major">
                              <h2>메뉴</h2>
                           </header>
                           <ul>
                              <li><a href="index.jsp">메인</a></li>
                              <li><a href="generic.jsp">Generic 나중에 지우기</a></li>
                              <li><a href="elements.jsp">Elements 나중에 지우기</a></li>
                              <li><a href="newsBoard.jsp">공지사항</a></li>
                              <li><a href="reviewBoard.jsp">리뷰 게시판</a></li>
                              <li><a href="askBoard.jsp">문의 게시판</a></li>
                           </ul>
                        </nav>

                     <!-- Section -->
                        <section>
                           <header class="major">
                              <h2>Get in touch</h2>
                           </header>
                           <p>Sed varius enim lorem ullamcorper dolore aliquam aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin sed aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
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