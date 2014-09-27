<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
<title>主页</title>
<link type="text/css" rel="stylesheet" media="all"
	href="../style/common.css" />
<link type="text/css" rel="stylesheet" media="all"
	href="../style/tiezi.css" />
<script type="text/javascript">
	function search() {
		var name = document.getElementById("search").value;
		location.href = '../tieba/searchTieBa?name='
				+ encodeURI(encodeURI(name));
	}
	function fohuifu() {
		document.getElementById("huitie_content").focus();
	}
	function showdiv(obj) {
		var finf = obj.parentNode.nextElementSibling;
		if(finf.style.display=="block"){
			finf.style.display = "none";
		}else{
			finf.style.display = "block";
		}
	}
	function huifutouser(obj,userid) {
		document.getElementById("idinput").value = userid;
		var textarea = obj.parentNode.parentNode.parentNode.lastChild.firstChild.firstChild;
		textarea.focus();
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

	<div id="huitie_list">
		<div id="title">
			<s:property value="tieZi.title" />
		</div>
		<div id="theme">
			<p>
				<s:property value="tieZi.theme" />
			</p>
			<p id="tiezi_msg">
				<s:action name="findName" executeResult="true" namespace="/account">
					<s:param name="accountId">
						<s:property value="tieZi.userId" />
					</s:param>
				</s:action>
				&nbsp;|&nbsp;
				<s:date name="tieZi.finalTime" />
				&nbsp;|&nbsp; <a href="javascript:fohuifu();">回复</a>
			</p>
		</div>
		<s:iterator value="huiTies" var="huiTie">
			<div id="each_huitie">
				<div id="name">
					<p>
						<s:action name="findName" executeResult="true"
							namespace="/account">
							<s:param name="accountId">
								<s:property value="userId" />
							</s:param>
						</s:action>
					</p>
				</div>
				<div id="body">
					<p>
						<s:property value="content" />
					</p>
					<p id="huitie_msg">
						<s:date name="time" />
						&nbsp;|&nbsp;<a onclick="showdiv(this);"><s:action name="findFinfCount"
								executeResult="true" namespace="/huitie">
								<s:param name="huiTieId">
									<s:property value="id" />
								</s:param>
							</s:action></a>
					</p>
					<s:action name="findFinf" executeResult="true" namespace="/huitie">
						<s:param name="finfTieId">
							<s:property value="id" />
						</s:param>
					</s:action>
				</div>
				<div style="clear: both;"></div>
			</div>
		</s:iterator>
	</div>

	<div id="pages">
		<s:if test="page > 1">
			<a href="findHuiTie?page=<s:property value="1"/>">首页</a>
			<a href="findHuiTie?page=<s:property value="page-1"/>">上一页</a>
		</s:if>
		<s:else>
			<a href="findHuiTie?page=<s:property value="1"/>">首页</a>
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
					<a href="findHuiTie?page=<s:property value="#p"/>"><s:property
							value="#p" /></a>
				</s:else>
			</s:if>
		</s:iterator>
		<s:if test="page<=totalPage-4">
				...
			</s:if>
		<s:if test="page < totalPage">
			<a href="findHuiTie?page=<s:property value="page+1"/>">下一页</a>
			<a href="findHuiTie?page=<s:property value="totalPage"/>">末页</a>
		</s:if>
		<s:else>
			下一页
			<a href="findHuiTie?page=<s:property value="totalPage"/>">末页</a>
		</s:else>
	</div>

	<div id="huitie">
		<p>回复</p>
		<form action="../huitie/huiTie" method="post">
			<div id="content">
				<textarea id="huitie_content" name="huiTie.content"></textarea>
			</div>
			<div id="submit">
				<input type="submit" value="发表" />
			</div>
		</form>
	</div>

</body>
</html>