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
					<td class="book_name" alt="이동"><a href="#"
						data-book=${book.book_name}>${book.book_name}</a></td>
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
				<li><a href="/book/listCri?page=${pageMaker.startPage-1}">$laquo;</a></li>
			</c:if>
		   
			<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}"
				var="idx">
				<oi>
					<a href="/book/listCri?page=${idx}">${idx}</a>
				</oi>
			</c:forEach>
		</ul>
	</div>

</body>









<script>
	$(document).ready(function() {
		$("tbody").on("click", "a", function(event) {
			event.preventDefault();
			var book_name = event.target.getAttribute("data-book");
			
			$.ajax({
				type : 'post',
				url : "/book/select/" + book_name,
				success : function(data) {
					console.log(data);
					if (data == "SUCCESS") {
						//alert("삭제완료");
						window.location.href = "/book";
					}
				}
			});
		});
	});
</script>



<!-- 
<script>
	$(document).ready(function() {
		$("tbody").on("click", "a", function(event) {
			event.preventDefault();
			var book_name = event.target.getAttribute("data-book");
			
			$.ajax({
				type : 'post',
				url : "/book/delete/" + book_name,
				success : function(data) {
					console.log(data);
					if (data == "SUCCESS") {
						alert("삭제완료");
						window.location.href = "/book";
					}
				}
			});
		});
	});
</script>
-->
</html>
