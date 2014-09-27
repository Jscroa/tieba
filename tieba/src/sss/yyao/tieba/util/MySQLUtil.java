package sss.yyao.tieba.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class MySQLUtil {
	private static DataSource ds;
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	//加载MySQL数据库资源文件
	static{
		Properties prop = new Properties();
		try {
			prop.load(MySQLUtil.class.getClassLoader().getResourceAsStream("mysql.properties"));
			ds = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("读取MySQL数据库资源文件失败!",e);
		}
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static synchronized Connection getConnection(){
		Connection conn = tl.get();
		try {
			if(conn == null){
				conn = ds.getConnection();
				tl.set(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("获取数据库连接失败！",e);
		}
		return tl.get();
	}
	
	/**
	 * 关闭数据库连接
	 */
	public static void close(){
		Connection conn = tl.get();
		if(conn != null){
			try {
				conn.close();
				tl.set(null);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭数据库连接失败！",e);
			}
		}
	}
	
}
