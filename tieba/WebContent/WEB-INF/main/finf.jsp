<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<div id="finf">
<div id="itera">
	<s:iterator value="finfTies" id="finfTie">
			<div>
				<a href="#"> <s:action name="findName" executeResult="true"
						namespace="/account">
						<s:param name="accountId">
							<s:property value="#finfTie.userId" />
						</s:param>
					</s:action>
				</a>
				<s:if test="toUserId!=0">回复 <a href="#"> <s:action
							name="findName" executeResult="true" namespace="/account">
							<s:param name="accountId">
								<s:property value="#finfTie.toUserId" />
							</s:param>
						</s:action>
					</a>
				</s:if>
				:&nbsp;
				<s:property value="#finfTie.content" />
			<p id="finf_msg">
				<s:date name="time" />
				&nbsp;|&nbsp;<a onclick="huifutouser(this,<s:property value="#finfTie.id" />);">回复</a>
			</p>
			</div>
	</s:iterator>
	</div>
	<div id="finfform">
		<form action="../huitie/huiTie" method="post">
			<textarea name="huiTie.content"></textarea>
			<input type="hidden" name="huiTie.finfTieId"
				value="<s:property value="id" />" /> <input id="idinput" type="hidden"
				name="huiTie.toUserId" value="id" />
			<input type="submit" value="发表">
		</form>
	</div>
</div>