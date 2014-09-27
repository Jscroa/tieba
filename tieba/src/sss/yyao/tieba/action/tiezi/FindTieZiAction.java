package sss.yyao.tieba.action.tiezi;

import java.util.ArrayList;
import java.util.List;

import sss.yyao.tieba.action.BaseAction;
import sss.yyao.tieba.dao.DAOFactory;
import sss.yyao.tieba.dao.tiezi.ITieZiDAO;
import sss.yyao.tieba.entity.TieBa;
import sss.yyao.tieba.entity.TieZi;
import sss.yyao.tieba.exception.DAOException;

public class FindTieZiAction extends BaseAction {
	private Integer tieBaId;
	private TieBa tieBa;
	private int page = 1;
	private int pageSize = 10;
	private int count;
	private int totalPage;
	private List<TieZi> tieZis = new ArrayList<TieZi>();
	
	public Integer getTieBaId() {
		return tieBaId;
	}
	public void setTieBaId(Integer tieBaId) {
		this.tieBaId = tieBaId;
	}
	public TieBa getTieBa() {
		return tieBa;
	}
	public void setTieBa(TieBa tieBa) {
		this.tieBa = tieBa;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<TieZi> getTieZis() {
		return tieZis;
	}
	public void setTieZis(List<TieZi> tieZis) {
		this.tieZis = tieZis;
	}
	
	public String execute(){
		try {
			if(tieBaId!=null){
				tieBa = DAOFactory.getTieBaDAO().findTieBaById(tieBaId);
				session.put("tieba", tieBa);
			}
			tieBa = (TieBa) session.get("tieba");
			tieBaId = tieBa.getId();
			ITieZiDAO dao = DAOFactory.getTieZiDAO();
			tieZis = dao.findTieZiList(tieBaId, page, pageSize);
			count = dao.findCountByTieBaId(tieBaId);
			if(count%pageSize==0){
				totalPage = count/pageSize;
			}else {
				totalPage = count/pageSize+1;
			}
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
}
