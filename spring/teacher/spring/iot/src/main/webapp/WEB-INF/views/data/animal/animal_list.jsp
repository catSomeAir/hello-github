<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>

<c:if test='${empty list.item}'>
<table class='tb-list animal'>
<thead><tr><td>해당 유기동물이 없습니다</td></tr></thead>
</table>
</c:if>

<c:forEach items='${list.item}' var='vo'>
<table class='tb-list animal'>
<colgroup>
	<col width='100px'>
	<col width='100px'><col width='80px'>
	<col width='60px'><col width='120px'>
	<col width='60px'><col width='100px'>
	<col width='60px'><col>
	<col width='100px'><col width='120px'>
</colgroup>
<tr>
	<td rowspan='3'><img src='${vo.popfile}'></td>
	<th>성별</th>
	<td>${vo.sexCd}</td>
	<th>나이</th>
	<td>${vo.age}</td>
	<th>체중</th>
	<td>${vo.weight}</td>
	<th>색상</th>
	<td>${vo.colorCd}</td>
	<th>접수일자</th>
	<td>${vo.happenDt}</td>
</tr>
<tr><th>특징</th>
	<td colspan='9' class='left'>${vo.specialMark}</td>
</tr>
<tr><th>발견장소</th>
	<td colspan='8' class='left'>${vo.happenPlace}</td>
	<td>${vo.processState}</td>
</tr>
<tr><td colspan='2'>${vo.careNm}</td>
	<td colspan='7' class='left'>${vo.careAddr}</td>
	<td colspan='2'>${vo.careTel}</td>
</tr>
</table>
</c:forEach>
<script>
makePage(${list.count}, ${pageNo});
</script>