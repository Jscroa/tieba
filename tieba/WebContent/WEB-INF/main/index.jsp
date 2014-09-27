<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>

<html>
<head>
<title>主页</title>
<link type="text/css" rel="stylesheet" media="all"
	href="../style/common.css" />
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
	<div id="big_logo">
		<img alt="贴吧" src="../img/logo_white.png" />
	</div>
	<div id="big_search">
		<input type="text" name="name" id="search" class="index_search_input" /><input
			type="button" value="搜&nbsp;&nbsp;索" onclick="search()" id="button" />
	</div>
</body>
</html>