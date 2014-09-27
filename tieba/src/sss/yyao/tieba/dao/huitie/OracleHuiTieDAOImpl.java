package sss.yyao.tieba.dao.huitie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sss.yyao.tieba.entity.HuiTie;
import sss.yyao.tieba.exception.DAOException;
import sss.yyao.tieba.util.EntityUtil;
import sss.yyao.tieba.util.OracleUtil;

public class OracleHuiTieDAOImpl implements IHuiTieDAO {

	@Override
	public List<HuiTie> findHuiTies(int tieBaId, int tieZiId, int page,
			int pageSize) throws DAOException {
		Connection conn = OracleUtil.getConnection();
		try {
			String sql = "select * from (select t.*,rownum r from (select * from bysj_huitie_"+tieBaId+"_"+tieZiId+" where finftieid=0 order by time) t) where r>? and r<?";
			PreparedStatement stat = conn.prepareStatement(sql);
			int lastMax = (page-1)*pageSize;
			int nextMin = page*pageSize+1;
			stat.setInt(1, lastMax);
			stat.setInt(2, nextMin);
			ResultSet rs = stat.executeQuery();
			List<HuiTie> list = new ArrayList<HuiTie>();
			while(rs.next()){
				list.add(EntityUtil.createHuiTie(rs));
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
	public int findCount(int tieBaId, int tieZiId) throws DAOException {
		Connection conn = OracleUtil.getConnection();
		try {
			String sql = "select count(*) from bysj_huitie_"+tieBaId+"_"+tieZiId;
			PreparedStatement stat = conn.prepareStatement(sql);
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
		return 0;
	}

	@Override
	public void addHuiTie(int tieBaId, int tieZiId, HuiTie huiTie) throws DAOException {
		Connection conn = OracleUtil.getConnection();
		try {
			conn.setAutoCommit(false);
			String sql = "insert into bysj_huitie_"+tieBaId+"_"+tieZiId+" values (bysj_huitie_"+tieBaId+"_"+tieZiId+"_seq.nextval,?,?,?,?,?)";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, huiTie.getUserId());
			stat.setString(2, huiTie.getContent());
			stat.setTimestamp(3, huiTie.getTime());
			stat.setInt(4, huiTie.getToUserId());
			stat.setInt(5, huiTie.getFinfTieId());
			stat.executeUpdate();
			sql = "update bysj_tiezi_"+tieBaId+" set finaltime=? where id=?";
			stat = conn.prepareStatement(sql);
			stat.setTimestamp(1, huiTie.getTime());
			stat.setInt(1, tieZiId);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new DAOException("回帖异常", e);
		} finally {
			OracleUtil.close();
		}
	}

	@Override
	public int findCountNotfinf(int tieBaId, int tieZiId) throws DAOException {
		Connection conn = OracleUtil.getConnection();
		try {
			String sql = "select count(*) from bysj_huitie_"+tieBaId+"_"+tieZiId+" where finftieid=0";
			PreparedStatement stat = conn.prepareStatement(sql);
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
		return 0;
	}

	@Override
	public List<HuiTie> findFinf(int tieBaId, int tieZiId, int finfTieId) throws DAOException {
		Connection conn = OracleUtil.getConnection();
		try {
			String sql = "select * from bysj_huitie_"+tieBaId+"_"+tieZiId+" where finftieid=?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, finfTieId);
			ResultSet rs = stat.executeQuery();
			List<HuiTie> list = new ArrayList<HuiTie>();
			while(rs.next()){
				list.add(EntityUtil.createHuiTie(rs));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("", e);
		} finally {
			OracleUtil.close();
		}
	}

	@Override
	public int findFinfCount(int tieBaId, int tieZiId, int finfTieId) throws DAOException {
		Connection conn = OracleUtil.getConnection();
		try {
			String sql = "select count(*) from bysj_huitie_"+tieBaId+"_"+tieZiId+" where finftieid=?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, finfTieId);
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
		return 0;
	}


}
