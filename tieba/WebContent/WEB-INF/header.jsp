<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<div id="header_div">
	<s:if test="#session.acc==null">
		您还未登陆！&nbsp;&nbsp;<a href="../account/toLogin">登录</a>|<a
			href="../account/toRegister">注册</a>
	</s:if>
	<s:else>
		<a href="#"><s:property value="#session.acc.userName" /></a>&nbsp;&nbsp;<a
			href="../account/logout">注销</a>
	</s:else>

</div>