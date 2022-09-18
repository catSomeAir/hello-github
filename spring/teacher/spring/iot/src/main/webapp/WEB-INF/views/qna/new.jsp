<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>질문과답변 글쓰기</h3>
<form method='post' action='insert.qna' enctype='multipart/form-data'>
<input type='hidden' name='writer' value='${loginInfo.userid}'>
<table class='w-px1200'>
<tr><th class='w-px140'>제목</th>
	<td><input type='text' class='full chk' name='title' title='제목'></td>
</tr>
<tr><th>분야</th>
	<td><select class='w-pct100' name='field'>
		<option value='0'>질문분야를 선택해주세요</option>
		<c:forEach items="${fields}" var='f'>
		<option value='${f.id}'>${f.title}</option>
		</c:forEach>
		</select>
	</td>
</tr>
<tr><th>공개여부</th>
	<td class='left'>
		<label><input type='radio' name='open' value='0'>공개</label>
		<label><input type='radio' name='open' value='1' checked>비공개</label>
	</td>
</tr>
<tr><th>내용</th>
	<td><textarea class='full chk' name='content' title='내용'></textarea></td>
</tr>
<tr><th>첨부파일</th>
	<td class='left'>
		<div class='items-center'>
			<label>
				<input type='file' name='file' id='attach-file'>
				<a><i class="font fa-solid fa-file-circle-plus"></i></a>
			</label>
			<span id='file-name'></span>
			<a id='delete-file'><i class="font-r fa-regular fa-trash-can"></i></a>
		</div>
</tr>
</table>
</form>

<div class='btnSet'>
	<a class='btn-fill save'>저장</a>
	<a class='btn-empty cancel'>취소</a>
</div>

<script>
$('.save').click(function(){
	if( emptyCheck() ){
		if( $('[name=field] option:selected').val()==0 ){
			alert( $('[name=field] option:selected').text() );
			$('[name=field]').focus();
		}else{
			$('form').submit();
		}
	}
});
$('.cancel').click(function(){
	location="list.qna";
});
</script>

</body>
</html>