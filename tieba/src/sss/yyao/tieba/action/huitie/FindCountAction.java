package sss.yyao.tieba.action.huitie;

import sss.yyao.tieba.action.BaseAction;
import sss.yyao.tieba.dao.DAOFactory;
import sss.yyao.tieba.dao.huitie.IHuiTieDAO;
import sss.yyao.tieba.entity.TieBa;
import sss.yyao.tieba.exception.DAOException;

public class FindCountAction extends BaseAction {

	private int tieZiId;
	private int count;

	public int getTieZiId() {
		return tieZiId;
	}
	public void setTieZiId(int tieZiId) {
		this.tieZiId = tieZiId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	public String execute(){
		TieBa tieBa = (TieBa) session.get("tieba");
		if(tieBa!=null){
			IHuiTieDAO dao = DAOFactory.getHuiTieDAO();
			try {
				count = dao.findCount(tieBa.getId(), tieZiId);
				return "success";
			} catch (DAOException e) {
				e.printStackTrace();
			}
		}
		return "error";
	}

}
