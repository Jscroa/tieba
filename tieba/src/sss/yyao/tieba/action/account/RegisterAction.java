package sss.yyao.tieba.action.account;

import sss.yyao.tieba.action.BaseAction;
import sss.yyao.tieba.dao.DAOFactory;
import sss.yyao.tieba.dao.account.IAccountDAO;
import sss.yyao.tieba.entity.Account;
import sss.yyao.tieba.exception.DAOException;

public class RegisterAction extends BaseAction {
	private Account account;
	private String msg;

	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String execute(){
		IAccountDAO dao = DAOFactory.getAccountDAO();
		try {
			dao.addAcocunt(account);
			msg = "注册成功！";
			account = dao.findAccountByLoginNameAndPassword(account.getLoginName(), account.getPassword());
			session.put("acc", account);
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
}
