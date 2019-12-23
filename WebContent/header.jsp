<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><!-- 로그인이 안된 경우 -->
	<c:if test="${id==null}">
		<form action="access" name="loginfrm" method="post">
        	
			아이디:<input type="text" name="id">
			비번:<input type="password" name="pw">
			<span>${msgAccess}</span>
			<button>로그인</button>
			<a href="joinfrm">회원가입</a><br>
			 
		</form>
	</c:if>
	
	 <c:if test="${id!=null&&id!='admin'}">
	 	<span><%= request.getSession().getAttribute("id") %>님 반갑습니다.</span>
	 	<a href="orderPrint">주문내역</a>
		<a href="cart">장바구니</a>
		<a href="#">즐겨찾기</a>
		<a href="logout">로그아웃</a>	
	</c:if>
	
	<c:if test="${id=='admin'}">
		<span><%= request.getSession().getAttribute("id") %>님 반갑습니다.</span>>
		<a href="orderPrint">주문내역</a>
		<a href="cart">장바구니</a>
		<a href="#">즐겨찾기</a>
		<a href="logout">로그아웃</a>	
		<a href="proupfrm">상품등록</a>
	</c:if>
</body>
</html>