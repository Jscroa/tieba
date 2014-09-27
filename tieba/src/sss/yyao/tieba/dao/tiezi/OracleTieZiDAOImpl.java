package sss.yyao.tieba.dao.tiezi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sss.yyao.tieba.entity.TieZi;
import sss.yyao.tieba.exception.DAOException;
import sss.yyao.tieba.util.EntityUtil;
import sss.yyao.tieba.util.OracleUtil;

public class OracleTieZiDAOImpl implements ITieZiDAO {

	@Override
	public List<TieZi> findTieZiList(int tieBaId, int page, int pageSize)
			throws DAOException {
		Connection conn = OracleUtil.getConnection();
		try {
			String sql = "select * from (select t.*,rownum r from (select * from bysj_tiezi_"+tieBaId+" order by finaltime desc) t) where r>? and r<?";
			PreparedStatement stat = conn.prepareStatement(sql);
			int lastMax = (page-1)*pageSize;
			int nextMin = page*pageSize+1;
			stat.setInt(1, lastMax);
			stat.setInt(2, nextMin);
			ResultSet rs = stat.executeQuery();
			List<TieZi> tieZis = new ArrayList<TieZi>();
			while(rs.next()){
				tieZis.add(EntityUtil.createTieZi(rs));
			}
			return tieZis;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("数据库查询异常", e);
		} finally {
			OracleUtil.close();
		}
	}

	@Override
	public int findCountByTieBaId(int tieBaId) throws DAOException {
		Connection conn = OracleUtil.getConnection();
		try {
			String sql = "select count(*) from bysj_tiezi_"+tieBaId;
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
	public void addTieZi(int tieBaId, TieZi tieZi) throws DAOException {
		Connection conn = OracleUtil.getConnection();
		try {
			conn.setAutoCommit(false);
			String sql = "select bysj_tiezi_"+tieBaId+"_seq.nextval from dual";
			PreparedStatement stat = conn.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
			if(rs.next()){
				tieZi.setId(rs.getInt(1));
				sql = "insert into bysj_tiezi_"+tieBaId+"(id,userid,title,theme,createtime,finaltime) values ("+tieZi.getId()+",?,?,?,?,?)";
				stat = conn.prepareStatement(sql);
				stat.setObject(1, tieZi.getUserId());
				stat.setObject(2, tieZi.getTitle());
				stat.setObject(3, tieZi.getTheme());
				stat.setObject(4, tieZi.getCreateTime());
				stat.setObject(5, tieZi.getFinalTime());
				stat.executeUpdate();
				sql = "create sequence bysj_huitie_"+tieBaId+"_"+tieZi.getId()+"_seq start with 1";
				stat = conn.prepareStatement(sql);
				stat.executeUpdate();
				sql = "create table bysj_huitie_"+tieBaId+"_"+tieZi.getId()+" (id number(10) primary key,userid number(10) not null,content varchar2(1000) not null,time TIMESTAMP not null,touserid number(10),finftieid number(10))";
				stat = conn.prepareStatement(sql);
				stat.executeUpdate();
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new DAOException("发帖异常", e);
		} finally {
			OracleUtil.close();
		}
	}

	@Override
	public TieZi findTieZiById(int tieBaId, int tieZiId) throws DAOException {
		Connection conn = OracleUtil.getConnection();
		try {
			String sql = "select * from bysj_tiezi_"+tieBaId+" where id=?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, tieZiId);
			ResultSet rs = stat.executeQuery();
			if(rs.next()){
				return EntityUtil.createTieZi(rs);
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
