<%--
  Created by IntelliJ IDEA.
  User: TJ
  Date: 2022-09-15
  Time: 오전 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<section id="form"><!--form-->
    <div class="container">
        <div class="row">
            <div class="signup-form" style="width:33%; margin:0 auto;text-align:center;"><!--sign up form-->
                <h2>로그인</h2>
                <form id="loginform" name="loginform"
                      action="/market/account/login" method="post"><!-- 상대경로표시 -->
                    <table id="signup-table">
                        <colgroup>
                            <col style="width: 100px;"/>
                            <col style="width: 300px;"/>
                        </colgroup>
                        <tr>
                            <th>아이디(ID)</th>
                            <td>
                                <input type="text" id="memberId" name="memberId" data-value-type="id"
                                       data-not-null="true" data-value-title="아이디"/>
                                <div class="blank-area"></div>
                            </td>
                        </tr>
                        <tr>
                            <th>비밀번호</th>
                            <td>
                                <input type="password" id="passwd" name="passwd" data-value-type="pwd"
                                       data-not-null="true" data-value-title="비밀번호"/>
                                <div class="blank-area"></div>
                            </td>
                        </tr>
                    </table>
                    <div style="padding-top: 30px;">
                        <button type="submit" class="btn btn-default" style="margin:0 auto;">로그인</button>
                    </div>
                </form>
            </div><!--/sign up form-->
        </div>
    </div>
</section><!--/form-->
</body>
</html>
