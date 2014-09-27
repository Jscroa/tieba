package sss.yyao.tieba.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import sss.yyao.tieba.entity.Account;
import sss.yyao.tieba.entity.HuiTie;
import sss.yyao.tieba.entity.TieBa;
import sss.yyao.tieba.entity.TieZi;

public class EntityUtil {
	
	public static Account createAccount(ResultSet rs) throws SQLException{
		Account account = new Account();
		account.setId(rs.getInt("id"));
		account.setLoginName(rs.getString("loginname"));
		account.setPassword(rs.getString("password"));
		account.setUserName(rs.getString("username"));
		account.setEmail(rs.getString("email"));
		account.setGender(rs.getString("gender"));
		return account;
	}
	
	public static TieBa createTieBa(ResultSet rs) throws SQLException{
		TieBa tieBa = new TieBa();
		tieBa.setId(rs.getInt("id"));
		tieBa.setName(rs.getString("name"));
		tieBa.setCreatorId(rs.getInt("creatorid"));
		tieBa.setClassify(rs.getString("classify"));
		tieBa.setDescr(rs.getString("descr"));
		tieBa.setCreateTime(rs.getTimestamp("createtime"));
		return tieBa;
	}
	
	public static TieZi createTieZi(ResultSet rs) throws SQLException{
		TieZi tieZi = new TieZi();
		tieZi.setId(rs.getInt("id"));
		tieZi.setUserId(rs.getInt("userId"));
		tieZi.setTitle(rs.getString("title"));
		tieZi.setTheme(rs.getString("theme"));
		tieZi.setCreateTime(rs.getTimestamp("createTime"));
		tieZi.setFinalTime(rs.getTimestamp("finalTime"));
		tieZi.setEssence(rs.getString("finalTime"));
		tieZi.setTop(rs.getString("top"));
		return tieZi;
	}
	
	public static HuiTie createHuiTie(ResultSet rs) throws SQLException{
		HuiTie huiTie = new HuiTie();
		huiTie.setId(rs.getInt("id"));
		huiTie.setUserId(rs.getInt("userId"));
		huiTie.setContent(rs.getString("content"));
		huiTie.setTime(rs.getTimestamp("time"));
		huiTie.setToUserId(rs.getInt("toUserId"));
		huiTie.setFinfTieId(rs.getInt("finfTieId"));
		return huiTie;
	}
	
}
