package sss.yyao.tieba.action.account;

import sss.yyao.tieba.dao.DAOFactory;
import sss.yyao.tieba.dao.account.IAccountDAO;
import sss.yyao.tieba.exception.DAOException;

public class FindNameByIdAction {

	private Integer accountId;
	private String accountName;
	
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String execute(){
		IAccountDAO dao = DAOFactory.getAccountDAO();
		try {
			accountName = dao.findNameById(accountId);
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}

}
