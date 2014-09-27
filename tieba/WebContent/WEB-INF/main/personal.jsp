<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
<title>主页</title>
<link type="text/css" rel="stylesheet" media="all" href="../style/common.css" />
<link type="text/css" rel="stylesheet" media="all" href="../style/personal.css" />
<script type="text/javascript">
	function search() {
		var name = document.getElementById("search").value;
		location.href = '../tieba/searchTieBa?name='
				+ encodeURI(encodeURI(name));
	}
</script>
</head>
<body>
	<%@include file="/WEB-INF/header.jsp"%>
	<div id="small_search">
		<img alt="贴吧" src="../img/logo_white.png" /><input type="text"
			name="name" id="search" class="index_search_input" /><input
			type="button" value="搜&nbsp;&nbsp;索" onclick="search()" id="button" />
	</div>
	<h1 id="personal_title">共为您找到<s:property value="count"/>个贴吧</h1>
	<div id="result_body">
		<s:iterator value="tieBas" var="tieBa">
			<div id="result_each">
				<h2><a href="#"><s:property value="name"/></a></h2>
				<p><s:property value="descr"/></p>
			</div>
		</s:iterator>
	</div>
</body>
</html>