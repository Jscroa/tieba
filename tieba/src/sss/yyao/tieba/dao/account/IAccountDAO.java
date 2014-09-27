package sss.yyao.tieba.dao.account;

import sss.yyao.tieba.entity.Account;
import sss.yyao.tieba.exception.DAOException;

public interface IAccountDAO {

	Account findAccountByLoginNameAndPassword(String loginName, String password) throws DAOException;
	
	void addAcocunt(Account account) throws DAOException;
	
	String findNameById(Integer id) throws DAOException;

}
