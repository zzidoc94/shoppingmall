<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="insertproduct" method="post"enctype="multipart/form-data">
	<table border="1">
		<tr>
			<td colspan="2" align="center"><h3>상품 업로드</h3></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="radio" name="p_kind" value="new" checked>신상품
			<input type="radio" name="p_kind" value="best" >인기상품
			</td>
		</tr>
		<tr>
			<td>상품명</td>
			<td><input type="text"name="p_name"></td>
		</tr>
		<tr>
			<td>가격</td>
			<td><input type="text"name="p_price"></td>
		</tr>
		<tr>
			<td>재고수량</td>
			<td><input type="text"name="p_qty"></td>
		</tr>
		<tr>
			<td>상품설명</td>
			<td><textarea rows="5" cols="50" name="contents"></textarea>
			</td>
		</tr>
		<tr>
			<td>이미지</td>
			<td><input type="file"name="p_file"></td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<button>상품등록</button>
				<input type="reset" value="등록취소">
			</td>
		</tr>
	</table>
</form>
</body>
</html>