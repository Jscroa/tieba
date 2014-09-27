package sss.yyao.tieba.dao.attentionTieBas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sss.yyao.tieba.entity.TieBa;
import sss.yyao.tieba.exception.DAOException;
import sss.yyao.tieba.util.EntityUtil;
import sss.yyao.tieba.util.OracleUtil;

public class OracleAttentionTieBasDAOImpl implements IAttentionTieBasDAO {

	@Override
	public void addAttentionTieBas(Integer selfID, Integer tieBaID)
			throws DAOException {
		Connection conn = OracleUtil.getConnection();
		try {
			String sql = "insert into bysj_attentiontiebas values(?,?)";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, selfID);
			stat.setInt(2, tieBaID);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("数据库插入异常", e);
		} finally {
			OracleUtil.close();
		}
		
	}

	@Override
	public List<TieBa> findAttentionTieBas(Integer selfID,
			Integer page, Integer pageSize) throws DAOException {
		Connection conn = OracleUtil.getConnection();
		try {
			String sql = "select * from (select t.*,rownum r from (select * from bysj_tieba aaa inner join bysj_attentiontiebas fff on aaa.id=fff.tiebaid where fff.selfid=?) t) where r>? and r<?";
			PreparedStatement stat = conn.prepareStatement(sql);
			int lastMax = (page-1)*pageSize;
			int nextMin = page*pageSize+1;
			stat.setInt(1, selfID);
			stat.setInt(2, lastMax);
			stat.setInt(3, nextMin);
			ResultSet rs = stat.executeQuery();
			List<TieBa> list = new ArrayList<TieBa>();
			while(rs.next()){
				list.add(EntityUtil.createTieBa(rs));
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
	public Integer findCountOfAttentionTieBas(Integer selfID)
			throws DAOException {
		Connection conn = OracleUtil.getConnection();
		try {
			String sql = "select count(*) from bysj_tieba aaa inner join bysj_attentiontiebas fff on aaa.id=fff.tiebaid where fff.selfid=?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, selfID);
			ResultSet rs = stat.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("数据库查询异常", e);
		}
		return null;
	}

	@Override
	public boolean checkAttention(Integer selfID, Integer tieBaID)
			throws DAOException {
		Connection conn = OracleUtil.getConnection();
		try {
			String sql = "select * from bysj_attentiontiebas where selfid=? and tiebaid=?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, selfID);
			stat.setInt(2, tieBaID);
			ResultSet rs = stat.executeQuery();
			if(rs.next()){
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("数据库查询异常", e);
		}
	}

}
