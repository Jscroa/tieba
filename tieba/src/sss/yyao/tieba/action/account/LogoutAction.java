package sss.yyao.tieba.action.account;

import sss.yyao.tieba.action.BaseAction;

public class LogoutAction extends BaseAction {

	public String execute(){
		session.remove("acc");
		return "success";
	}

}
