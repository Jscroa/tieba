package sss.yyao.tieba.action.huitie;

import java.util.ArrayList;
import java.util.List;

import sss.yyao.tieba.action.BaseAction;
import sss.yyao.tieba.dao.DAOFactory;
import sss.yyao.tieba.dao.huitie.IHuiTieDAO;
import sss.yyao.tieba.entity.HuiTie;
import sss.yyao.tieba.entity.TieBa;
import sss.yyao.tieba.entity.TieZi;
import sss.yyao.tieba.exception.DAOException;

public class FindFinfAction extends BaseAction {
	
	private int finfTieId;
	private List<HuiTie> finfTies = new ArrayList<HuiTie>();

	public int getFinfTieId() {
		return finfTieId;
	}
	public void setFinfTieId(int finfTieId) {
		this.finfTieId = finfTieId;
	}
	public List<HuiTie> getFinfTies() {
		return finfTies;
	}
	public void setFinfTies(List<HuiTie> finfTies) {
		this.finfTies = finfTies;
	}

	public String execute(){
		int tieBaId = ((TieBa)session.get("tieba")).getId();
		int tieZiId = ((TieZi)session.get("tiezi")).getId();
		IHuiTieDAO dao = DAOFactory.getHuiTieDAO();
		try {
			finfTies = dao.findFinf(tieBaId, tieZiId, finfTieId);
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}

}
