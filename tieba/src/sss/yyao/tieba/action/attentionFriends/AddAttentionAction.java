package sss.yyao.tieba.action.attentionFriends;

import sss.yyao.tieba.action.BaseAction;
import sss.yyao.tieba.dao.DAOFactory;
import sss.yyao.tieba.dao.attentionFriends.IAttentionFriendsDAO;
import sss.yyao.tieba.entity.Account;
import sss.yyao.tieba.exception.DAOException;

public class AddAttentionAction extends BaseAction {
	
	private Integer friendId;
	
	public Integer getFriendId() {
		return friendId;
	}
	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}

	public String execute(){
		Account account = (Account) session.get("acc");
		IAttentionFriendsDAO dao = DAOFactory.getAttentionFriendsDAO();
		try {
			dao.addAttention(account.getId(), friendId);
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
}
