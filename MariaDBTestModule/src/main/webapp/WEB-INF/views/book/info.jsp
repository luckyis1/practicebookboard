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


	<h2>Book 상세정보</h2>
	
	<table border=1>
	<thead>
	<th>책번호</th>
	<th>책이름</th>
	<th>책제목</th>
	<th>작가</th>
	<th>가격</th>
	<th>날짜</th>
	</thead>
	
	<tbody>
	<td id="bookbno">${vo.bno}</td>
	<td>${vo.book_name}</td>
	<td>${vo.name}</td>
	<td>${vo.author}</td>
	<td>${vo.price}</td>
	<td>${vo.regdate}</td>
	</tbody>
	</table>
	
	<button id="deletebook">삭제</button>
	<button id="updatebook">수정</button>
	
	
</body>


<script>
	$(document).ready(function() {
		
		var bno =$("#bookbno").text();
		 
		 
		$("#deletebook").click(function(){
			
			
			 $.ajax({
					type : 'post',
					url : "/book/delete/" + bno,
					success : function(data) {
						console.log(data);
						if (data == "SUCCESS") {
							alert("책번호"+bno+"의 정보는 삭제완료되었습니다.");
							window.location.href = "/book";
						}
					}
				});		    
			 
		});
		
		$("#updatebook").click(function(){
			location.replace('/book/update/'+bno);
		});
		
	});
</script>




</html>