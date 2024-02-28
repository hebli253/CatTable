<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	max-width: 500px;
	margin-top: 50px;
	padding: 30px;
	background-color: #fff;
	border-radius: 10px;
	box-shadow: 0 8px 20px 0 rgba(0, 0, 255, 0.5);
}
</style>

</head>
<body>
	<!-- <h2> 새로운 게시판 추가 (insertBoardView.jsp)</h2> -->

	<div class="container form-style">

		<p class="fs-2 text-center">새로운 고양이 추가</p>

		<form action="insertBoardProc.do" method="post">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">이름(Name)</label>
				<input type="text" class="form-control" id="exampleInputEmail1"
					name="name">
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">생일(Birth)</label>
				<input type="text" class="form-control" id="exampleInputEmail1"
					name="birth">
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">입양여부(Adopted)</label>
				<input type="text" class="form-control" id="exampleInputEmail1"
					name="adopted">
			</div>

			<div class="mb-3 gap-2 d-md-flex justify-content-md-end">
				<button type="submit" class="btn btn-primary">저장</button>
				<button type="reset" class="btn btn-danger">취소</button>
			</div>
		</form>

	</div>

	<!-- <form action="insertBoardProc.do" method="get">

		<table border="1">
			<tr height="50" align="center">
				<td width="150">글제목</td>
				<td width="250"><input type="text" name="title"></td>
			</tr>
			<tr height="50" align="center">
				<td width="150">글작성자</td>
				<td width="250"><input type="text" name="writer"></td>
			</tr>
			<tr height="50" align="center">
				<td width="150">글내용</td>
				<td width="250"><input type="text" name="content"></td>
			</tr>
			<tr height="50" align="center">
				<td colspan="2"><input type="submit" value="글저장"> <input
					type="reset" value="글취소"></td>
			</tr>

		</table>
	</form> -->


</body>
</html>