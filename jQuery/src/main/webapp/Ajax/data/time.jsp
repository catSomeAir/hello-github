<%@ page language="java" 
	contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
  
<%
	String timezone = request.getParameter("timezone");
	String format = request.getParameter("format");
%>

<%=timezone%> : <%=format%>