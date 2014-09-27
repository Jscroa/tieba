package sss.yyao.tieba.action.tieba;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import sss.yyao.tieba.action.BaseAction;
import sss.yyao.tieba.dao.DAOFactory;
import sss.yyao.tieba.dao.tieba.ITieBaDAO;
import sss.yyao.tieba.entity.TieBa;

public class SearchTieBaAction extends BaseAction {
	
	private String name;
	private int page = 1;
	private int pageSize = 10;
	private int count;
	private int totalPage;
	private List<TieBa> tieBas = new ArrayList<TieBa>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public List<TieBa> getTieBas() {
		return tieBas;
	}
	public void setTieBas(List<TieBa> tieBas) {
		this.tieBas = tieBas;
	}
	
	public String execute(){
		ITieBaDAO dao = DAOFactory.getTieBaDAO();
		try {
			if(name!=null){
				name = URLDecoder.decode(name,"UTF-8");
				session.put("selname", name);
			}
			name = (String) session.get("selname");
			tieBas = dao.findTieBaByName(name,page,pageSize);
			count = dao.findCountByName(name);
			if(count==0){
				return "none";
			}
			if(count%pageSize==0){
				totalPage = count/pageSize;
			}else {
				totalPage = count/pageSize+1;
			}
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
}
