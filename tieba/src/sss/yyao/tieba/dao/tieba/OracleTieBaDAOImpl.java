package sss.yyao.tieba.dao.tieba;

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

public class OracleTieBaDAOImpl implements ITieBaDAO {

	@Override
	public List<TieBa> findTieBaByName(String name, int page, int pageSize) throws DAOException {
		Connection conn = OracleUtil.getConnection();
		try {
			String sql = "select * from (select t.*,rownum r from (select * from bysj_tieba where name like ?) t) where r>? and r<?";
			PreparedStatement stat = conn.prepareStatement(sql);
			int lastMax = (page-1)*pageSize;
			int nextMin = page*pageSize+1;
			stat.setString(1, "%"+name+"%");
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
			throw new DAOException("数据库查询异常!", e);
		} finally {
			OracleUtil.close();
		}
	}

	@Override
	public int findCountByName(String name)
			throws DAOException {
		Connection conn = OracleUtil.getConnection();
		try {
			String sql = "select count(*) from bysj_tieba where name like ?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, "%"+name+"%");
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
	public void addTieBa(TieBa tieBa) throws DAOException {
		Connection conn = OracleUtil.getConnection();
		try {
			conn.setAutoCommit(false);
			String sql = "select bysj_tieba_seq.nextval from dual";
			PreparedStatement stat = conn.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
			if(rs.next()){
				tieBa.setId(rs.getInt(1));
				sql = "insert into bysj_tieba (id,name,creatorid,classify,descr,createtime) values ("+tieBa.getId()+",?,?,?,?,?)";
				stat = conn.prepareStatement(sql);
				stat.setString(1, tieBa.getName());
				stat.setInt(2, tieBa.getCreatorId());
				stat.setString(3, tieBa.getClassify());
				stat.setString(4, tieBa.getDescr());
				stat.setTimestamp(5, tieBa.getCreateTime());
				stat.executeUpdate();
				sql = "create sequence bysj_tiezi_"+tieBa.getId()+"_seq start with 1";
				stat = conn.prepareStatement(sql);
				stat.executeUpdate();
				sql = "create table bysj_tiezi_"+tieBa.getId()+" (id number(10) primary key,userid number(10) not null,title varchar2(60) not null,theme varchar2(1000) not null,createtime TIMESTAMP not null,finaltime TIMESTAMP not null,essence varchar2(1),top varchar2(1))";
				stat = conn.prepareStatement(sql);
				stat.executeUpdate();
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new DAOException("数据库创建贴吧异常", e);
		} finally {
			OracleUtil.close();
		}
	}

	@Override
	public TieBa findTieBaById(int id) throws DAOException {
		Connection conn = OracleUtil.getConnection();
		try {
			String sql = "select * from bysj_tieba where id=?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, id);
			ResultSet rs = stat.executeQuery();
			if(rs.next()){
				return EntityUtil.createTieBa(rs);
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
