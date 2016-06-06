<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>조회</title>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

</head>
<body>

	<div>
		<li><a href="/book/">조회</a></li>
		<li><a href="/book/join">가입</a></li>
	</div>

	<table border="1">
		<thead>
			<tr class="filters">
				<th>NUM</th>
				<th>책제목</th>
				<th>이름</th>
				<th>작가</th>
				<th>가격</th>
				<th>수정일</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="book" items="${bookList}" varStatus="status">
				<tr>
					<td>${book.bno}</td>
					<td class="book_name" ><a href="/book/info/${book.bno}">${book.book_name}</a></td>
					<td>${book.name}</td>
					<td>${book.author}</td>
					<td>${book.price}</td>
					<td>${book.regdate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div>
		<ul>
			<c:if test="${pageMaker.prev}">
				<oi><a href="/book/listCri?page=${pageMaker.startPage-1}">prev</a></oi>
			</c:if>		
			
			<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
				<oi>
					<a href="listCri?page=${idx}">${idx}</a>
				</oi>
			</c:forEach>
			
			<c:if test="${pageMaker.next && pageMaker.endPage >0}">
				<oi><a href="/book/listCri?page=${pageMaker.endPage+1}">next</a></oi>
			</c:if>
		</ul>
	</div>
</body>









</html>
