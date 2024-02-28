<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--  부트 CSS, js 라이브러리 추가 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>

<style>
.form-style {
	max-width: 1000px;
	margin-top: 50px;
	padding: 30px;
	background-color: white;
	border-radius: 10px;
	box-shadow: 0 8px 20px 0 rgba(0, 0, 255, 0.5);
}
</style>

</head>
<body>
	<div class="container form-style">
		<p class="fs-2 text-center">전체 고양이 보기</p>

		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
				<!-- <a class="navbar-brand" href="#">게시판 추가</a> -->
				<button class="btn btn-outline-primary"
				 onclick="location.href='insertBoard.do'"> 고양이 추가 </button>
						
				<form class="d-flex" action="searchBoardList.do" method="post">
					<select name="searchCon" class="form-select" style="margin-right:5px; width:50%;">
						<option value="name" > 이름</option>
						<option value="birth" > 생일</option>
						<option value="adopted" > 입양여부</option> 
					</select>					
					<input name="searchKey" class="form-control me-2" type="search"
						placeholder="Search" aria-label="Search">
						
					<button type="submit" class="btn btn-outline-success" type="submit" style="center:5px; width:25%;">찾기</button>
				</form>				
			</div>
		</nav>

		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th scope="col">
					<form action="sortBoardList.do" method="post">
					    <select name="sortCon">
					        <option value="asc">오름차순</option>
					        <option value="desc">내림차순</option>
					    </select>
					    <input type="submit" value="적용">
					</form>
					<!-- 	<select class="form-select"  aria-label="Default select example" style="center:5px; width:50%;">
						  <option selected>오름차순</option>
						  <option value="1">내림차순</option>
					</select> --></th>
					<th scope="col">이름</th>
					<th scope="col">생일(YYMM)</th>
					<th scope="col">입양여부</th>
					<th scope="col">수정/삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${bList}">
					<tr>
						<td>${board.seq}</td>
						<%-- <td><a href="getBoard.do?seq=${board.seq}">${board.title}</a>
						</td> --%>
						<td>${board.name}</td>
						<td>${board.birth}</td>
						<td>${board.adopted}</td>
						<td>
							<button class="btn btn-primary"
							onclick="location.href='modifyBoard.do?seq=${board.seq}'">수정</button>
							<button class="btn btn-danger"
							onclick="location.href='deleteBoard.do?seq=${board.seq}'">삭제</button>
						
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>


	<%-- 	<h2> 전체 게시판 내용 (getBoardListView.jsp) </h2>
	
	<a href="insertBoard.do"> 새로운 게시판 추가 </a>
	
	<form action="searchBoardList.do" method="post">	
		<table border="1"  style="border-collapse:collapse;" >
			<!-- 검색 기능 추가  -->
			<tr bgcolor="yellow">
				<td align="right" colspan="4"> 
					<select name="searchCon">
						<option value="title" > 글제목 </option>
						<option value="content" > 글내용 </option> 
					</select>
					<input type="text" name="searchKey">
					<input type="submit" value="검색" >
				</td>
			</tr>
			<tr height="50" align="center"> 
				<td width="150"> 번호 </td> 
				<td width="150"> 제목 </td>
				<td width="150"> 글작성자 </td>
				<td width="300"> 내용 </td>
			</tr>
			<c:forEach var="board" items="${bList}">
				<tr height="50" align="center"> 
					<td width="150"> ${board.seq} </td> 
					<td width="150"> 
						<a href="getBoard.do?seq=${board.seq}" >${board.title}</a> 
					</td>
					<td width="150"> ${board.writer} </td>
					<td width="300"> ${board.content} </td>
				</tr>
			</c:forEach>		
		</table>
	</form>
 --%>

</body>
</html>