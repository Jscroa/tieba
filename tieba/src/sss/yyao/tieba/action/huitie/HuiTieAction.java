package sss.yyao.tieba.action.huitie;

import java.sql.Timestamp;

import sss.yyao.tieba.action.BaseAction;
import sss.yyao.tieba.dao.DAOFactory;
import sss.yyao.tieba.dao.huitie.IHuiTieDAO;
import sss.yyao.tieba.entity.Account;
import sss.yyao.tieba.entity.HuiTie;
import sss.yyao.tieba.entity.TieBa;
import sss.yyao.tieba.entity.TieZi;
import sss.yyao.tieba.exception.DAOException;
import sss.yyao.tieba.util.TimeUtil;

public class HuiTieAction extends BaseAction{
	private HuiTie huiTie;

	public HuiTie getHuiTie() {
		return huiTie;
	}
	public void setHuiTie(HuiTie huiTie) {
		this.huiTie = huiTie;
	}
	
	public String execute(){
		int tieBaId = ((TieBa)session.get("tieba")).getId();
		int tieZiId =((TieZi) session.get("tiezi")).getId();
		int userId = ((Account)session.get("acc")).getId();
		Timestamp time = TimeUtil.getCurrentTime();
		huiTie.setUserId(userId);
		huiTie.setTime(time);
		IHuiTieDAO dao = DAOFactory.getHuiTieDAO();
		try {
			dao.addHuiTie(tieBaId, tieZiId, huiTie);
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
}
