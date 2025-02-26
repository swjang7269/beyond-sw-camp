<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h3>필터의 활용</h3>
    <form action="member/regist" method="post">
        <label>아이다: </label>
        <input type="text" name="userId">
        <br>
<%--        (label+input[name=password]+br)*2--%>
        <label>비밀번호: </label>
        <input type="password" name="password">
        <br>
        <label>이름: </label>
        <input type="text" name="name">
        <br>
        <button>가입하기</button>
    </form>
</body>
</html>