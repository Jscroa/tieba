package sss.yyao.tieba.action.attentionTieBas;

import sss.yyao.tieba.action.BaseAction;
import sss.yyao.tieba.dao.DAOFactory;
import sss.yyao.tieba.dao.attentionTieBas.IAttentionTieBasDAO;
import sss.yyao.tieba.entity.Account;
import sss.yyao.tieba.exception.DAOException;

public class AddAttentionAction extends BaseAction{
	
	private Integer tieBaId;

	public Integer getTieBaId() {
		return tieBaId;
	}
	public void setTieBaId(Integer tieBaId) {
		this.tieBaId = tieBaId;
	}
	
	public String execute(){
		Account account = (Account) session.get("acc");
		IAttentionTieBasDAO dao = DAOFactory.getAttentionTieBasDAO();
		try {
			dao.addAttentionTieBas(account.getId(), tieBaId);
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
}
