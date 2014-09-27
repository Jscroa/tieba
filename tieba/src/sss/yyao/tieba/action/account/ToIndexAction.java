package sss.yyao.tieba.action.account;

import java.util.ArrayList;
import java.util.List;

import sss.yyao.tieba.action.BaseAction;
import sss.yyao.tieba.entity.Account;
import sss.yyao.tieba.entity.TieBa;

public class ToIndexAction extends BaseAction {
	private Integer selfId;
	
	private Integer pageOfAttentionTieBa = 1;
	private Integer countOfAttentionTieBa;
	private Integer totalPageOfAttentionTieBa;
	private List<TieBa> listOfAttentionTieBa = new ArrayList<TieBa>();
	
	private Integer pageOfAttention = 1;
	private Integer countOfAttention;
	private Integer totalPageOfAttention;
	private List<TieBa> listOfAttention = new ArrayList<TieBa>();
	
	public Integer getSelfId() {
		return selfId;
	}
	public void setSelfId(Integer selfId) {
		this.selfId = selfId;
	}
	public Integer getPageOfAttentionTieBa() {
		return pageOfAttentionTieBa;
	}
	public void setPageOfAttentionTieBa(Integer pageOfAttentionTieBa) {
		this.pageOfAttentionTieBa = pageOfAttentionTieBa;
	}
	public Integer getCountOfAttentionTieBa() {
		return countOfAttentionTieBa;
	}
	public void setCountOfAttentionTieBa(Integer countOfAttentionTieBa) {
		this.countOfAttentionTieBa = countOfAttentionTieBa;
	}
	public Integer getTotalPageOfAttentionTieBa() {
		return totalPageOfAttentionTieBa;
	}
	public void setTotalPageOfAttentionTieBa(Integer totalPageOfAttentionTieBa) {
		this.totalPageOfAttentionTieBa = totalPageOfAttentionTieBa;
	}
	public List<TieBa> getListOfAttentionTieBa() {
		return listOfAttentionTieBa;
	}
	public void setListOfAttentionTieBa(List<TieBa> listOfAttentionTieBa) {
		this.listOfAttentionTieBa = listOfAttentionTieBa;
	}
	public Integer getPageOfAttention() {
		return pageOfAttention;
	}
	public void setPageOfAttention(Integer pageOfAttention) {
		this.pageOfAttention = pageOfAttention;
	}
	public Integer getCountOfAttention() {
		return countOfAttention;
	}
	public void setCountOfAttention(Integer countOfAttention) {
		this.countOfAttention = countOfAttention;
	}
	public Integer getTotalPageOfAttention() {
		return totalPageOfAttention;
	}
	public void setTotalPageOfAttention(Integer totalPageOfAttention) {
		this.totalPageOfAttention = totalPageOfAttention;
	}
	public List<TieBa> getListOfAttention() {
		return listOfAttention;
	}
	public void setListOfAttention(List<TieBa> listOfAttention) {
		this.listOfAttention = listOfAttention;
	}
	
	public String execute(){
		if(session.get("acc")==null){
			return "success";
		}else {
			selfId = ((Account) session.get("acc")).getId();
		}
		return "success";
	}
	
}
