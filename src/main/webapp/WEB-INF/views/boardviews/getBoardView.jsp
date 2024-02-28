<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 선택된 고양이 보기 (getBoardView.jsp) </h2>
	
	<table border="1">
		<tr height="50" align="center">
			<td width="150"> 번호 </td>
			<td width="250">${board.seq}</td>
		</tr>
		<tr height="50" align="center">
			<td width="150"> 이름 </td>
			<td width="250">${board.name}</td>
		</tr>
		<tr height="50" align="center">
			<td width="150"> 생일(YYMM)</td>
			<td width="250">${board.birth}</td>
		</tr>
		<tr height="50" align="center">
			<td width="150"> 입양여부 </td>
			<td width="250">${board.adopted}</td>
		</tr>
		<tr height="50" align="center">
			<td colspan="2"> 
				<input type="button" value="수정하기"
				       onclick="location.href='modifyBoard.do?seq=${board.seq}'" >
		       	<input type="button" value="삭제하기"
				       onclick="location.href='deleteBoard.do?seq=${board.seq}'" >
		       	<input type="button" value="전체 고양이 보기"
				       onclick="location.href='getBoardList.do'" >
			</td>
			
		</tr>
	</table>

</body>
</html>