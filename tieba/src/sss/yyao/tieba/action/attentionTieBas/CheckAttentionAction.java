package sss.yyao.tieba.action.attentionTieBas;

import com.sun.org.apache.regexp.internal.recompile;

import sss.yyao.tieba.action.BaseAction;
import sss.yyao.tieba.dao.DAOFactory;
import sss.yyao.tieba.dao.attentionTieBas.IAttentionTieBasDAO;
import sss.yyao.tieba.entity.Account;
import sss.yyao.tieba.exception.DAOException;

public class CheckAttentionAction extends BaseAction {
	private Integer tieBaId;
	private boolean attention;
	
	public Integer getTieBaId() {
		return tieBaId;
	}
	public void setTieBaId(Integer tieBaId) {
		this.tieBaId = tieBaId;
	}
	public boolean isAttention() {
		return attention;
	}
	public void setAttention(boolean attention) {
		this.attention = attention;
	}

	public String execute(){
		Account account = (Account) session.get("acc");
		if(account==null){
			attention = false;
			return "success";
		}
		IAttentionTieBasDAO dao = DAOFactory.getAttentionTieBasDAO();
		try {
			attention = dao.checkAttention(account.getId(), tieBaId);
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
}
