<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.more { margin: 0 auto; display:flex; flex-direction: column; }
.more ul { display: flex; }
.more ul li:not(:first-child) { margin-left: 5px }

</style>
</head>
<body>
<h3>질문과 답변 목록</h3>
<form method='post' action='list.qna'>
<div class='w-px1200 more'>
	<ul><li class='w-px100 left'>공개여부</li>
		<li>
			<label><input type='radio' name='open' value='-1'>전체</label>
			<label><input type='radio' name='open' value='0'>공개</label>
			<label><input type='radio' name='open' value='1'>비공개</label>
		</li>
	</ul>
</div>
<div class='w-px1200 more'>
	<ul><li class='w-px100 left'>구분</li>
		<li>
			<select class='w-px600' name='field'>
			<option value='0'>질문분야</option>
			<c:forEach items="${fields}" var='f'>
			<option value='${f.id}'>${f.title}</option>
			</c:forEach>
			</select>
		</li>
	</ul>
</div>
<div id='list-top' class='w-px1200'>
	<ul>
		<li><select class='w-px100' name='search'>
			<option value='all'  ${page.search eq 'all' ? 'selected' : ''} >전체</option>
			<option value='title'  ${page.search eq 'title' ? 'selected' : ''}>제목</option>
			<option value='writer'  ${page.search eq 'writer' ? 'selected' : ''}>작성자</option>
			</select>
		</li>
		<li><input type='text' name='keyword' value='${page.keyword}' class='w-px300'></li>
		<li><a class='btn-fill search'>검색</a></li>
	</ul>
	<ul>
		<li>
			<select name='pageList' class='w-px100'>
			<c:forEach var='i' begin="1" end='5' >
			<option value='${10*i}'>${10*i}개씩</option>
			</c:forEach>
			</select>
		</li>
		<li><a class='btn-fill new' >글쓰기</a></li>
	</ul>
</div>
<input type='hidden' name='id'>
<input type='hidden' name='curPage' value='1'>
<input type='hidden' name='read' value='0'>
</form>

<table class='tb-list w-px1200'>
<colgroup>
	<col width='100px'>
	<col>
	<col width='80px'>
	<col width='120px'>
	<col width='120px'>
	<col width='80px'>
</colgroup>
<tr><th>번호</th>
	<th>제목</th>
	<th>처리상태</th>
	<th>작성자</th>
	<th>작성일자</th>
	<th>조회수</th>
</tr>
<c:if test="${empty page.qnaList}">
<tr><td colspan='6'>질문과 답변 자료가 없습니다</td>
</c:if>

<c:forEach items="${page.qnaList}" var='vo'>
<tr><td>${vo.no}</td>
	<td class='left'>
		<c:if test='${vo.open eq 1}'><i class="fa-solid fa-lock"></i></c:if>
		<c:choose>
			<c:when test='${loginInfo.userid eq vo.writer or loginInfo.admin eq "Y"}'>
				<a onclick='detail(${vo.id})'>${vo.title}</a>
			</c:when>
			<c:otherwise>
				<c:if test='${vo.open eq 0}'>
					<a onclick='detail(${vo.id})'>${vo.title}</a>
				</c:if>
				<c:if test='${vo.open eq 1}'>${vo.title}</c:if>
			</c:otherwise>
		</c:choose>
	</td>
	<td>${vo.status}</td>
	<td>${vo.name}</td>
	<td>${vo.writedate}</td>
	<td>${vo.readcnt}</td>
</tr>
</c:forEach>
</table>

<div class='btnSet'>
	<jsp:include page="/WEB-INF/views/include/page.jsp"/>
</div>
<script>
$('[name=field]').val( ${field} ).prop( 'selected', true );
$('[name=open][value=${open}]').prop( 'checked', true );

$('.new').click(function(){
	if( ${empty loginInfo} ){
		alert('로그인 후 이용가능합니다');
	}else{
		location.href='new.qna'
	}
});
$('[name=pageList]').val( ${page.pageList} ).prop( 'selected', true );

$('[name=pageList], [name=open], [name=field]').change(function(){
	$('form').submit();
});

$('.search').click(function(){
	$('form').submit();
});

function detail( id ){
	$('[name=id]').val( id );
	$('[name=read]').val( 1 );
	$('form').attr('action', 'detail.qna');
	$("form").submit();
}
</script>
</body>
</html>







