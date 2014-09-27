package sss.yyao.tieba.dao.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sss.yyao.tieba.entity.Account;
import sss.yyao.tieba.exception.DAOException;
import sss.yyao.tieba.util.EntityUtil;
import sss.yyao.tieba.util.OracleUtil;

public class OracleAccountDAOImpl implements IAccountDAO {

	@Override
	public Account findAccountByLoginNameAndPassword(String loginName,
			String password) throws DAOException {
		String sql = "select * from bysj_account where loginname=? and password=?";
		Connection conn = OracleUtil.getConnection();
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, loginName);
			stat.setString(2, password);
			ResultSet rs = stat.executeQuery();
			if(rs.next()){
				return EntityUtil.createAccount(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("数据库查询异常", e);
		} finally {
			OracleUtil.close();
		}
		return null;
	}

	@Override
	public void addAcocunt(Account account) throws DAOException {
		String sql = "insert into bysj_account values(bysj_account_seq.nextval,?,?,?,?,?)";
		Connection conn = OracleUtil.getConnection();
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setObject(1, account.getLoginName());
			stat.setObject(2, account.getPassword());
			stat.setObject(3, account.getUserName());
			stat.setObject(4, account.getEmail());
			stat.setObject(5, account.getGender());
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("数据库插入异常", e);
		} finally {
			OracleUtil.close();
		}
	}

	@Override
	public String findNameById(Integer id) throws DAOException {
		Connection conn = OracleUtil.getConnection();
		try {
			String sql = "select username from bysj_account where id=?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, id);
			ResultSet rs = stat.executeQuery();
			if(rs.next()){
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("数据库查询异常", e);
		} finally {
			OracleUtil.close();
		}
		return null;
	}

}
