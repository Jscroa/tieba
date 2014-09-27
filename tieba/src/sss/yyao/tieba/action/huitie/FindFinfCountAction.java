package sss.yyao.tieba.action.huitie;

import sss.yyao.tieba.action.BaseAction;
import sss.yyao.tieba.dao.DAOFactory;
import sss.yyao.tieba.dao.huitie.IHuiTieDAO;
import sss.yyao.tieba.entity.TieBa;
import sss.yyao.tieba.entity.TieZi;
import sss.yyao.tieba.exception.DAOException;

public class FindFinfCountAction extends BaseAction {
	private int huiTieId;
	private int count;
	
	public int getHuiTieId() {
		return huiTieId;
	}
	public void setHuiTieId(int huiTieId) {
		this.huiTieId = huiTieId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public String execute(){
		int tieBaId = ((TieBa)session.get("tieba")).getId();
		int tieZiId = ((TieZi)session.get("tiezi")).getId();
		IHuiTieDAO dao = DAOFactory.getHuiTieDAO();
		try {
			count = dao.findFinfCount(tieBaId, tieZiId, huiTieId);
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
}
