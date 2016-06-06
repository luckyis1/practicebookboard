<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


</head>

<body>
	<div>
		<li><a href="/book/">조회</a></li>
		<li><a href="/book/join">가입</a></li>
	</div>
	
	
	<h2>Book Add</h2>
	<form method="post">
		<input type="text" placeholder="bookname" name="book_name" /> <input
			type="text" placeholder="name" name="name" /> <input type="text"
			placeholder="author" name="author" /> <input type="text"
			placeholder="price" name="price" /> <br>
		<button type="submit" class="btn">Submit</button>

	</form>


</body>
</html>