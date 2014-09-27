package sss.yyao.tieba.dao.attentionFriends;

import java.util.List;

import sss.yyao.tieba.entity.Account;
import sss.yyao.tieba.exception.DAOException;

public class MySQLAttentionFriendsDAOImpl implements IAttentionFriendsDAO {

	@Override
	public void addAttention(Integer selfID, Integer friendsID)
			throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Account> findAttention(Integer selfID,
			Integer page, Integer pageSize) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer findCountOfAttention(Integer selfID) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findFans(Integer friendsID, Integer page,
			Integer pageSize) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer findCountOfFans(Integer friendsID) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkAttention(Integer selfID, Integer friendsID)
			throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

}
