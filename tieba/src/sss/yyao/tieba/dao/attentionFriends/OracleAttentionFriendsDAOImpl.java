package sss.yyao.tieba.dao.attentionFriends;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sss.yyao.tieba.entity.Account;
import sss.yyao.tieba.exception.DAOException;
import sss.yyao.tieba.util.EntityUtil;
import sss.yyao.tieba.util.OracleUtil;

public class OracleAttentionFriendsDAOImpl implements IAttentionFriendsDAO {

	@Override
	public void addAttention(Integer selfID, Integer friendsID)
			throws DAOException {
		Connection conn = OracleUtil.getConnection();
		try {
			String sql = "insert into bysj_attentionFriends values(?,?)";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, selfID);
			stat.setInt(2, friendsID);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("添加关注异常", e);
		} finally {
			OracleUtil.close();
		}
	}

	@Override
	public List<Account> findAttention(Integer selfID,
			Integer page, Integer pageSize) throws DAOException {
		Connection conn = OracleUtil.getConnection();
		try {
			String sql = "select * from (select t.*,rownum r from (select * from bysj_account aaa inner join bysj_attentionfriends fff on aaa.id=fff.friendsid where fff.selfid=?) t) where r>? and r<?";
			PreparedStatement stat = conn.prepareStatement(sql);
			int lastMax = (page-1)*pageSize;
			int nextMin = page*pageSize+1;
			stat.setInt(1, selfID);
			stat.setInt(2, lastMax);
			stat.setInt(3, nextMin);
			ResultSet rs = stat.executeQuery();
			List<Account> list = new ArrayList<Account>();
			while(rs.next()){
				list.add(EntityUtil.createAccount(rs));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("数据库查询异常", e);
		} finally {
			OracleUtil.close();
		}
	}

	@Override
	public Integer findCountOfAttention(Integer selfID) throws DAOException {
		Connection conn = OracleUtil.getConnection();
		try {
			String sql = "select count(*) from bysj_account aaa inner join bysj_attentionfriends fff on aaa.id=fff.friendsid where fff.selfid=?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, selfID);
			ResultSet rs = stat.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
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
	public List<Account> findFans(Integer friendsID, Integer page,
			Integer pageSize) throws DAOException {
		Connection conn = OracleUtil.getConnection();
		try {
			String sql = "select * from (select t.*,rownum r from (select * from bysj_attentionfriends fff inner join bysj_account aaa on aaa.id=fff.selfid where fff.friendsid=?) t) where r>? and r<?";
			PreparedStatement stat = conn.prepareStatement(sql);
			int lastMax = (page-1)*pageSize;
			int nextMin = page*pageSize+1;
			stat.setInt(1, friendsID);
			stat.setInt(2, lastMax);
			stat.setInt(3, nextMin);
			ResultSet rs = stat.executeQuery();
			List<Account> list = new ArrayList<Account>();
			while(rs.next()){
				list.add(EntityUtil.createAccount(rs));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("数据库查询异常", e);
		} finally {
			OracleUtil.close();
		}
	}

	@Override
	public Integer findCountOfFans(Integer friendsID) throws DAOException {
		Connection conn = OracleUtil.getConnection();
		try {
			String sql = "select count(*) from bysj_attentionfriends fff inner join bysj_account aaa on aaa.id=fff.selfid where fff.friendsid=?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, friendsID);
			ResultSet rs = stat.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
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
	public boolean checkAttention(Integer selfID, Integer friendsID)
			throws DAOException {
		Connection conn = OracleUtil.getConnection();
		try {
			String sql = "select * from bysj_attentionfriends where selfid=? and friendsid=?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, selfID);
			stat.setInt(2, friendsID);
			ResultSet rs = stat.executeQuery();
			if(rs.next()){
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("数据库查询异常", e);
		} finally {
			OracleUtil.close();
		}
	}

}
