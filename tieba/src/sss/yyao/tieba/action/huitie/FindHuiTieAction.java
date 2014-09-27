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

public class FindHuiTieAction extends BaseAction {

	private Integer tieZiId;//参数传入
	private TieBa tieBa;//session中获得
	private TieZi tieZi;//根据帖子tieBaId和tieZiIdchacun结果
	private int page = 1;
	private int pageSize = 10;
	private int count;//非楼中楼的回复数
	private int totalPage;
	private List<HuiTie> huiTies = new ArrayList<HuiTie>();

	public Integer getTieZiId() {
		return tieZiId;
	}
	public void setTieZiId(Integer tieZiId) {
		this.tieZiId = tieZiId;
	}
	public TieBa getTieBa() {
		return tieBa;
	}
	public void setTieBa(TieBa tieBa) {
		this.tieBa = tieBa;
	}
	public TieZi getTieZi() {
		return tieZi;
	}
	public void setTieZi(TieZi tieZi) {
		this.tieZi = tieZi;
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
	public List<HuiTie> getHuiTies() {
		return huiTies;
	}
	public void setHuiTies(List<HuiTie> huiTies) {
		this.huiTies = huiTies;
	}

	public String execute(){
		tieBa = (TieBa) session.get("tieba");
		try {
			if (tieBa != null) {
				if(tieZiId != null){
					tieZi = DAOFactory.getTieZiDAO().findTieZiById(tieBa.getId(), tieZiId);
					session.put("tiezi", tieZi);
				}
				tieZi = (TieZi) session.get("tiezi");
				tieZiId = tieZi.getId();
				IHuiTieDAO dao = DAOFactory.getHuiTieDAO();
				huiTies = dao.findHuiTies(tieBa.getId(), tieZiId, page, pageSize);
				count = dao.findCountNotfinf(tieBa.getId(), tieZiId);
				if(count%pageSize==0){
					totalPage = count/pageSize;
				}else {
					totalPage = count/pageSize+1;
				}
				return "success";
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return "error";
	}

}
