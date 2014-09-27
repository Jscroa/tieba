package sss.yyao.tieba.action.tieba;

import java.sql.Timestamp;

import sss.yyao.tieba.action.BaseAction;
import sss.yyao.tieba.dao.DAOFactory;
import sss.yyao.tieba.dao.tieba.ITieBaDAO;
import sss.yyao.tieba.entity.Account;
import sss.yyao.tieba.entity.TieBa;
import sss.yyao.tieba.exception.DAOException;
import sss.yyao.tieba.util.TimeUtil;

public class CreateTieBaAction extends BaseAction {
	private TieBa tieBa;
	private String msg;

	public TieBa getTieBa() {
		return tieBa;
	}
	public void setTieBa(TieBa tieBa) {
		this.tieBa = tieBa;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String execute(){
		int creatorId = ((Account)session.get("acc")).getId();
		Timestamp createTime = TimeUtil.getCurrentTime();
		ITieBaDAO dao = DAOFactory.getTieBaDAO();
		try {
			tieBa.setCreatorId(creatorId);
			tieBa.setCreateTime(createTime);
			dao.addTieBa(tieBa);
			msg = "创建成功!";
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}

}
