<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>News</title>
</head>
<body>
	<ul class="page">
		<li class="active">
			<a href="${pageContext.request.contextPath}/news">news</a></li>
		<li><a href="${pageContext.request.contextPath}/sport">sport</a></li>
		<li><a href=" ${pageContext.request.contextPath}/technology">technology</a></li>
	</ul>
	<h1>НОВИНИ</h1>
	<br />
	<div>${news}</div>
	<ul class="page">
		<li class="active">
		<a href="${pageContext.request.contextPath}/news">news</a></li>
		<li><a href="${pageContext.request.contextPath}/sport">sport</a></li>
		<li><a href="${pageContext.request.contextPath}/technology">technology</a></li>
	</ul>
</body>
</html>