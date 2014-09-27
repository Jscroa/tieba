<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
<title>主页</title>
<link type="text/css" rel="stylesheet" media="all" href="../style/common.css" />
<link type="text/css" rel="stylesheet" media="all" href="../style/searchresult.css" />
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
	<p id="result_count">共为您找到<span><s:property value="count"/></span>个贴吧</p>
	<div id="result_body">
		<s:iterator value="tieBas" var="tieBa">
			<div id="result_each">
				<h2><a href="../tiezi/findTieZi?tieBaId=<s:property value="id"/>"><s:property value="name"/>吧</a></h2>
				<p id="tieba_descr"><s:property value="descr"/></p>
				<p id="tieba_msg">
					<s:property value="classify"/>
					&nbsp;|&nbsp;
					<s:action name="findName" executeResult="true"
						namespace="/account">
						<s:param name="accountId">
							<s:property value="creatorId" />
						</s:param>
					</s:action>
					&nbsp;|&nbsp;
					<s:date name="createTime" />
				</p>
			</div>
		</s:iterator>
	</div>
	<div id="pages">
		<s:if test="page > 1">
			<a href="searchTieBa?page=<s:property value="1"/>">首页</a>
			<a href="searchTieBa?page=<s:property value="page-1"/>">上一页</a>
		</s:if>
		<s:else>
			<a href="searchTieBa?page=<s:property value="1"/>">首页</a>
			上一页
		</s:else>
		<s:if test="page>=5">
			...
		</s:if>
		<s:iterator begin="1" end="totalPage" var="p">
			<s:if test="(page>=#p-3)&&(page<=#p+3)">
				<s:if test="page==#p">
					<s:property value="#p" />
				</s:if>
				<s:else>
					<a href="searchTieBa?page=<s:property value="#p"/>"><s:property
							value="#p" /></a>
				</s:else>
			</s:if>
		</s:iterator>
		<s:if test="page<=totalPage-4">
				...
			</s:if>
		<s:if test="page < totalPage">
			<a href="searchTieBa?page=<s:property value="page+1"/>">下一页</a>
			<a href="searchTieBa?page=<s:property value="totalPage"/>">末页</a>
		</s:if>
		<s:else>
			下一页
			<a href="searchTieBa?page=<s:property value="totalPage"/>">末页</a>
		</s:else>
	</div>
</body>
</html>