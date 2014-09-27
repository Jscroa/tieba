package sss.yyao.tieba.action.tiezi;

import java.sql.Timestamp;

import sss.yyao.tieba.action.BaseAction;
import sss.yyao.tieba.dao.DAOFactory;
import sss.yyao.tieba.dao.tiezi.ITieZiDAO;
import sss.yyao.tieba.entity.Account;
import sss.yyao.tieba.entity.TieBa;
import sss.yyao.tieba.entity.TieZi;
import sss.yyao.tieba.exception.DAOException;
import sss.yyao.tieba.util.TimeUtil;

public class FaTieAction extends BaseAction {
	private TieZi tieZi;

	public TieZi getTieZi() {
		return tieZi;
	}
	public void setTieZi(TieZi tieZi) {
		this.tieZi = tieZi;
	}
	
	public String execute(){
		int userId = ((Account)session.get("acc")).getId();
		int tieBaId = ((TieBa)session.get("tieba")).getId();
		Timestamp now = TimeUtil.getCurrentTime();
		tieZi.setUserId(userId);
		tieZi.setCreateTime(now);
		tieZi.setFinalTime(now);
		ITieZiDAO dao = DAOFactory.getTieZiDAO();
		try {
			dao.addTieZi(tieBaId, tieZi);
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
}
