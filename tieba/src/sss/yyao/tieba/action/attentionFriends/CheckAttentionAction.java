package sss.yyao.tieba.action.attentionFriends;

import sss.yyao.tieba.action.BaseAction;
import sss.yyao.tieba.dao.DAOFactory;
import sss.yyao.tieba.dao.attentionFriends.IAttentionFriendsDAO;
import sss.yyao.tieba.entity.Account;
import sss.yyao.tieba.exception.DAOException;

public class CheckAttentionAction extends BaseAction {
	
	private Integer friendId;
	private boolean attention;
	
	public Integer getFriendId() {
		return friendId;
	}
	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}
	public boolean isAttention() {
		return attention;
	}
	public void setAttention(boolean attention) {
		this.attention = attention;
	}

	public String execute(){
		Account account = (Account) session.get("acc");
		IAttentionFriendsDAO dao = DAOFactory.getAttentionFriendsDAO();
		try {
			attention = dao.checkAttention(account.getId(), friendId);
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
}
