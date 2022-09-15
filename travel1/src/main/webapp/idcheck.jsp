<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <% String id = (String)session.getAttribute("id"); 
   String checkid = (String)session.getAttribute("checkid");
%>  

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
div{
background-image: url("images/hicoding_2.jpg");
background-repeat: no-repeat;
background-size: 100% 100%;
position:absolute;
top:0px; left:0px;
width:400px; height:400px;
}
h1{color: green;}
</style>
<meta charset="UTF-8">
<title>아이디중복체크</title>
</head>
<body onLoad="WinClose();">
<div>
<%
   /*String idcheck=request.getParameter("check");
   if(id.equals(checkid)){
      out.print("<h1>아이디가중복되었습니다.</h1>");
   }else {
      out.print("<h1>아이디가사용가능합니다.</h1>");
   }*/
   
%>
<script type="text/javascript">

function WinClose()
{
    top.window.open('about:blank','_self').close(); 
    top.window.opener=self;
    opener.location.reload();
    top.self.close(); 
   
}
function close1() {
    opener.location.reload();
    window.close();
}
</script>
</div>

</body >
</html>

