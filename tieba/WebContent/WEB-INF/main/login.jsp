<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>登陆</title>
<link type="text/css" rel="stylesheet" media="all" href="../style/common.css" />
<link type="text/css" rel="stylesheet" media="all" href="../style/login.css" />
<script type="text/javascript">
	function change(imgObj) {
		imgObj.src = "createImage?date=" + new Date().getTime();
	}
</script>
</head>
<body>
	<div id="body">
	<form action="../account/login" method="post">
		<table>
			<tr>
				<td><h1>登录</h1></td>
			</tr>
			<tr>
				<td>账号</td>
			</tr>
			<tr>
				<td><input class="in" type="text" name="loginName" placeholder="请输入账号" /></td>
			</tr>
			<tr>
				<td>密码</td>
			</tr>
			<tr>
				<td><input class="in" type="password" name="password" placeholder="请输入密码" /></td>
			</tr>
			<tr>
				<td>验证码</td>
			</tr>
			<tr>
				<td><input class="yan" type="text" name="userCode" style="width: 60px" />
					<img alt="验证码" src="createImage" onclick="change(this)" /><span><s:property
							value="message" /></span></td>
			</tr>
			<tr>
				<td colspan="2"><input class="sub" type="submit" value="登&nbsp;&nbsp;&nbsp;&nbsp;陆" /></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>
