<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String name = request.getParameter("name");
	String price = request.getParameter("price");
	
	/* request객체 통해 값 넘어감 */
	/* 이 부분에서 중요한 점은 getParameter을 이용해 가져온 값을 String 에 저장 후 
	그 값을 또 다시 변수에 집어 넣는다는 것이다. */

%>
<%=name%> : <%=price%>
<%-- {
name :<%=name%>,
price : <%=price%>
} --%>
