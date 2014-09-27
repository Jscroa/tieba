<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<s:if test="attention==true">
	<button class="attentionButton">
		已关注
	</button>
</s:if>
<s:else>
	<button class="attentionButton" onclick="att(<s:property value="tieBa.id" />);">
		关&nbsp;注
	</button>
</s:else>