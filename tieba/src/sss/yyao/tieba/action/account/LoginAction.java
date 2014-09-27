package sss.yyao.tieba.action.account;

import sss.yyao.tieba.action.BaseAction;
import sss.yyao.tieba.dao.DAOFactory;
import sss.yyao.tieba.dao.account.IAccountDAO;
import sss.yyao.tieba.entity.Account;
import sss.yyao.tieba.exception.DAOException;

public class LoginAction extends BaseAction {
	private String loginName;
	private String password;
	private String userCode;
	private Account account;
	private String msg;
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
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
		String imageCode = (String) session.get("imageCode");
		if(imageCode==null || userCode==null || !imageCode.equalsIgnoreCase(userCode)){
			msg = "验证码错误";
			return "fail";
		}
		IAccountDAO dao = DAOFactory.getAccountDAO();
		try {
			account = dao.findAccountByLoginNameAndPassword(loginName, password);
			if(account!=null){
				session.put("acc", account);
				return "success";
			}else{
				System.out.println(loginName+"____"+password);
				msg = "账号或密码错误";
				return "fail";
			}
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
}
