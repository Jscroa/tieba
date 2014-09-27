package sss.yyao.tieba.dao.attentionFriends;

import java.util.List;

import sss.yyao.tieba.entity.Account;
import sss.yyao.tieba.exception.DAOException;

public interface IAttentionFriendsDAO {
	
	void addAttention(Integer selfID ,Integer friendsID) throws DAOException;
	
	List<Account> findAttention(Integer selfID, Integer page, Integer pageSize) throws DAOException;
	
	Integer findCountOfAttention(Integer selfID) throws DAOException;
	
	List<Account> findFans(Integer friendsID, Integer page, Integer pageSize) throws DAOException;
	
	Integer findCountOfFans(Integer friendsID) throws DAOException;
	
	boolean checkAttention(Integer selfID, Integer friendsID) throws DAOException;
	
}
