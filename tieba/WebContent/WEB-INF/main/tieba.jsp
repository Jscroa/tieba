<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
<title>主页</title>
<link type="text/css" rel="stylesheet" media="all"
	href="../style/common.css" />
<link type="text/css" rel="stylesheet" media="all"
	href="../style/tieba.css" />
<script type="text/javascript">
	function search() {
		var name = document.getElementById("search").value;
		location.href = '../tieba/searchTieBa?name='
				+ encodeURI(encodeURI(name));
	}
	function att(obj) {
		location.href = '../attentionTieBas/addAttention?tieBaId=' + obj;
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
	<div id="tieba">
		<h1>
			<a href="../tiezi/findTieZi?tieBaId=<s:property value="tieBa.id"/>"><s:property
					value="tieBa.name" />吧</a>
		<s:action name="checkAttention" executeResult="true" namespace="/attentionTieBas">
			<s:param name="tieBaId">
				<s:property value="tieBa.id"/>
			</s:param>
		</s:action>
		</h1>
		<p id="tieba_descr">
			<s:property value="tieBa.descr" />
		</p>
		<p id="tieba_msg">
			<s:property value="tieBa.classify" />
			&nbsp;|&nbsp;
			<s:action name="findName" executeResult="true" namespace="/account">
				<s:param name="accountId">
					<s:property value="tieBa.creatorId" />
				</s:param>
			</s:action>
			&nbsp;|&nbsp;
			<s:date name="tieBa.createTime" />
		</p>
	</div>

	<div id="tiezi_list">
		<s:iterator value="tieZis" var="tieZi">
			<div id="each_tiezi">
				<div id="count">
					<s:action name="findCount" executeResult="true" namespace="/huitie">
						<s:param name="tieZiId">
							<s:property value="id" />
						</s:param>
					</s:action>
				</div>
				<div id="body">
					<h3>
						<a href="../huitie/findHuiTie?tieZiId=<s:property value="id"/>"><s:property
								value="title" /></a>
					</h3>
					<p>
						<s:property value="theme" />
					</p>
					<p id="tiezi_msg">
						<s:action name="findName" executeResult="true"
							namespace="/account">
							<s:param name="accountId">
								<s:property value="userId" />
							</s:param>
						</s:action>
						&nbsp;|&nbsp;
						<s:date name="finalTime" />
					</p>
				</div>

				<div style="clear: both;"></div>
			</div>
		</s:iterator>
	</div>

	<div id="pages">
		<s:if test="page > 1">
			<a href="findTieZi?page=<s:property value="1"/>">首页</a>
			<a href="findTieZi?page=<s:property value="page-1"/>">上一页</a>
		</s:if>
		<s:else>
			<a href="findTieZi?page=<s:property value="1"/>">首页</a>
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
					<a href="findTieZi?page=<s:property value="#p"/>"><s:property
							value="#p" /></a>
				</s:else>
			</s:if>
		</s:iterator>
		<s:if test="page<=totalPage-4">
				...
			</s:if>
		<s:if test="page < totalPage">
			<a href="findTieZi?page=<s:property value="page+1"/>">下一页</a>
			<a href="findTieZi?page=<s:property value="totalPage"/>">末页</a>
		</s:if>
		<s:else>
			下一页
			<a href="findTieZi?page=<s:property value="totalPage"/>">末页</a>
		</s:else>
	</div>

	<div id="fatie">
		<p>发表新帖</p>
		<form action="../tiezi/faTie" method="post">
			<div id="title">
				<input type="text" name="tieZi.title" />
			</div>
			<div id="theme">
				<textarea name="tieZi.theme"></textarea>
			</div>
			<div id="submit">
				<input type="submit" value="发表" />
			</div>
		</form>
	</div>

</body>
</html>