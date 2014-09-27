<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>跳转到创建页面</title>
<link type="text/css" rel="stylesheet" media="all" href="../style/common.css" />
</head>
<body>
	<%@include file="/WEB-INF/header.jsp"%>
	“
	<s:property value="name" />
	”吧尚未建立。
	<br /> 欢迎创建此吧，与今后来到这里的朋友交流讨论。
	<input type="button" onclick="location.href='toCreateTieBa';"
		value="我来创建" />
</body>
</html>