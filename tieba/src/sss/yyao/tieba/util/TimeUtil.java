package sss.yyao.tieba.util;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 时间工具
 * @author Administrator
 *
 */
public class TimeUtil {

	/**
	 * @return 当前系统时间
	 */
	public static Timestamp getCurrentTime(){
		Date time = new Date();
		return new Timestamp(time.getTime());
	}

}
