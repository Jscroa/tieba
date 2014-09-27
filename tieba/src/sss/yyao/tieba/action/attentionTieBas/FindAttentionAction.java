package sss.yyao.tieba.action.attentionTieBas;

import java.util.ArrayList;
import java.util.List;

import sss.yyao.tieba.action.BaseAction;
import sss.yyao.tieba.dao.DAOFactory;
import sss.yyao.tieba.dao.attentionTieBas.IAttentionTieBasDAO;
import sss.yyao.tieba.entity.Account;
import sss.yyao.tieba.entity.TieBa;
import sss.yyao.tieba.exception.DAOException;

public class FindAttentionAction extends BaseAction {
	
	private Integer page=1;
	private Integer pageSize = 10;
	private Integer count;
	private Integer totalPage;
	private List<TieBa> list = new ArrayList<TieBa>();
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<TieBa> getList() {
		return list;
	}
	public void setList(List<TieBa> list) {
		this.list = list;
	}
	
	public String execute(){
		Account account = (Account) session.get("acc");
		IAttentionTieBasDAO dao = DAOFactory.getAttentionTieBasDAO();
		try {
			list = dao.findAttentionTieBas(account.getId(), page, pageSize);
			count = dao.findCountOfAttentionTieBas(account.getId());
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
