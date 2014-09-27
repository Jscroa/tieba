<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>

<html>
<head>
<title>注册账号</title>
<link type="text/css" rel="stylesheet" media="all" href="../style/common.css" />
<link type="text/css" rel="stylesheet" media="all" href="../style/register.css" /> 
</head>
<body>
	<div id="body">
	<form action="register" method="post">
		<table>
			<tr>
				<td colspan="2"><h1>注册</h1></td>
			</tr>
			<tr>
				<td>登录名</td>
				<td><input type="text" name="account.loginName" placeholder="请输入登录名" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="account.password" placeholder="请输入密码" /></td>
			</tr>
			<tr>
				<td>确认密码</td>
				<td><input type="password" name="repassword" placeholder="请再次输入密码" /></td>
			</tr>
			<tr>
				<td>昵称</td>
				<td><input type="text" name="account.userName" placeholder="请输入姓名" /></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="account.email" placeholder="请输入邮箱" /></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="radio" name="account.gender" value="1"
					checked="checked" />男 <input type="radio" name="account.gender"
					value="0" />女</td>
			</tr>
			<tr>
				<td colspan="2"><input class="sub" type="submit"
					value="提&nbsp;&nbsp;&nbsp;&nbsp;交" /></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>
