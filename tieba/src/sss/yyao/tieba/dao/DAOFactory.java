package sss.yyao.tieba.dao;

import java.io.IOException;
import java.util.Properties;

import sss.yyao.tieba.dao.account.IAccountDAO;
import sss.yyao.tieba.dao.account.MySQLAccountDAOImpl;
import sss.yyao.tieba.dao.account.OracleAccountDAOImpl;
import sss.yyao.tieba.dao.attentionFriends.IAttentionFriendsDAO;
import sss.yyao.tieba.dao.attentionFriends.MySQLAttentionFriendsDAOImpl;
import sss.yyao.tieba.dao.attentionFriends.OracleAttentionFriendsDAOImpl;
import sss.yyao.tieba.dao.attentionTieBas.IAttentionTieBasDAO;
import sss.yyao.tieba.dao.attentionTieBas.MySQLAttentionTieBasDAOImpl;
import sss.yyao.tieba.dao.attentionTieBas.OracleAttentionTieBasDAOImpl;
import sss.yyao.tieba.dao.huitie.IHuiTieDAO;
import sss.yyao.tieba.dao.huitie.MySQLHuiTieDAOImpl;
import sss.yyao.tieba.dao.huitie.OracleHuiTieDAOImpl;
import sss.yyao.tieba.dao.tieba.ITieBaDAO;
import sss.yyao.tieba.dao.tieba.MySQLTieBaDAOImpl;
import sss.yyao.tieba.dao.tieba.OracleTieBaDAOImpl;
import sss.yyao.tieba.dao.tiezi.ITieZiDAO;
import sss.yyao.tieba.dao.tiezi.MySQLTieZiDAOImpl;
import sss.yyao.tieba.dao.tiezi.OracleTieZiDAOImpl;

/**
 * DAO工厂类，用于生成DAO实例
 * @author Administrator
 *
 */
public class DAOFactory {
	private static String dbName;

	//加载配置文件
	static{
		Properties prop = new Properties();
		try {
			prop.load(DAOFactory.class.getClassLoader().getResourceAsStream("db.properties"));
			dbName = prop.getProperty("dbname");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static IAccountDAO getAccountDAO(){
		if(dbName.equals("Oracle")){
			return new OracleAccountDAOImpl();
		}else if (dbName.equals("MySQL")) {
			return new MySQLAccountDAOImpl();
		}else {
			return null;
		}
	}
	
	public static IHuiTieDAO getHuiTieDAO(){
		if(dbName.equals("Oracle")){
			return new OracleHuiTieDAOImpl();
		}else if (dbName.equals("MySQL")) {
			return new MySQLHuiTieDAOImpl();
		}else {
			return null;
		}
	}
	
	public static ITieBaDAO getTieBaDAO() {
		if(dbName.equals("Oracle")){
			return new OracleTieBaDAOImpl();
		}else if (dbName.equals("MySQL")) {
			return new MySQLTieBaDAOImpl();
		}else {
			return null;
		}
	}
	
	public static ITieZiDAO getTieZiDAO(){
		if(dbName.equals("Oracle")){
			return new OracleTieZiDAOImpl();
		}else if (dbName.equals("MySQL")) {
			return new MySQLTieZiDAOImpl();
		}else {
			return null;
		}
	}
	
	public static IAttentionFriendsDAO getAttentionFriendsDAO(){
		if(dbName.equals("Oracle")){
			return new OracleAttentionFriendsDAOImpl();
		}else if (dbName.equals("MySQL")) {
			return new MySQLAttentionFriendsDAOImpl();
		}else {
			return null;
		}
	}
	
	public static IAttentionTieBasDAO getAttentionTieBasDAO(){
		if(dbName.equals("Oracle")){
			return new OracleAttentionTieBasDAOImpl();
		}else if (dbName.equals("MySQL")) {
			return new MySQLAttentionTieBasDAOImpl();
		}else {
			return null;
		}
	}
	
}
