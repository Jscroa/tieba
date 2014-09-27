package sss.yyao.tieba.action.attentionFriends;

import java.util.ArrayList;
import java.util.List;

import sss.yyao.tieba.action.BaseAction;
import sss.yyao.tieba.dao.DAOFactory;
import sss.yyao.tieba.dao.attentionFriends.IAttentionFriendsDAO;
import sss.yyao.tieba.entity.Account;
import sss.yyao.tieba.exception.DAOException;

public class FindFansAction extends BaseAction {
	
	private Integer page=1;
	private Integer pageSize = 10;
	private Integer count;
	private Integer totalPage;
	private List<Account> list = new ArrayList<Account>();
	
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
	public List<Account> getList() {
		return list;
	}
	public void setList(List<Account> list) {
		this.list = list;
	}
	
	public String execute(){
		Account account = (Account) session.get("acc");
		IAttentionFriendsDAO dao = DAOFactory.getAttentionFriendsDAO();
		try {
			list = dao.findFans(account.getId(), page, pageSize);
			count = dao.findCountOfFans(account.getId());
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
