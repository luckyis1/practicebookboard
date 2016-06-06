<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
</head>

<body>
	<div>
		<li><a href="/book/">조회</a></li>
		<li><a href="/book/join">가입</a></li>
	</div>
	
	<h2>Book 수정페이지 !</h2>
	<form  action='/book/update' method="post">
		<input type=hidden name="bno" value="${vo.bno}"> 
		<input type="text" placeholder="bookname" name="book_name"  value= "${vo.book_name}"/> 
		<input type="text" placeholder="name" name="name"  value="${vo.name}"/> 
		<input type="text" placeholder="author" name="author"  value="${vo.author}"/>
		<input type="text"placeholder="price" name="price" value="${vo.price}"/> <br>
		<button type="submit" class="btn">수정완료</button>

	</form>
</body>




</html>