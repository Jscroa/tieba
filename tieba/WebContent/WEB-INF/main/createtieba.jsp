<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>创建贴吧</title>
<link type="text/css" rel="stylesheet" media="all"
	href="../style/common.css" />
<link type="text/css" rel="stylesheet" media="all"
	href="../style/createtieba.css" />
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<div id="body">
	<form action="createTieBa" method="post">
		<table>
			<tr>
				<td class="head" colspan="5"><h2>创建贴吧</h2></td>
			</tr>
			<tr>
				<td>贴吧名:</td>
				<td colspan="4"><input type="text" name="tieBa.name" /></td>
			</tr>
			<tr>
				<td rowspan="4">贴吧分类:</td>
				<td><input type="radio" checked="checked" name="tieBa.classify" value="娱乐明星">娱乐明星</td>
				<td><input type="radio" name="tieBa.classify" value="爱综艺">爱综艺</td>
				<td><input type="radio" name="tieBa.classify" value="追剧狂">追剧狂</td>
				<td><input type="radio" name="tieBa.classify" value="看电影">看电影</td>
			</tr>
			<tr>
				<td><input type="radio" name="tieBa.classify" value="小说">小说</td>
				<td><input type="radio" name="tieBa.classify" value="生活家">生活家</td>
				<td><input type="radio" name="tieBa.classify" value="闲趣">闲趣</td>
				<td><input type="radio" name="tieBa.classify" value="游戏">游戏</td>
			</tr>
			<tr>
				<td><input type="radio" name="tieBa.classify" value="动漫宅">动漫宅</td>
				<td><input type="radio" name="tieBa.classify" value="体育">体育</td>
				<td><input type="radio" name="tieBa.classify" value="高校">高校</td>
				<td><input type="radio" name="tieBa.classify" value="地区">地区</td>
			</tr>
			<tr>
				<td><input type="radio" name="tieBa.classify" value="人文自然">人文自然</td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>简介:</td>
				<td colspan="4"><textarea id="textarea" name="tieBa.descr"></textarea></td>
			</tr>
			<tr>
				<td colspan="5"><input type="submit" class="sub" value="创建" /></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>