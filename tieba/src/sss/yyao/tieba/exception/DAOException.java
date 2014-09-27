package sss.yyao.tieba.exception;

/**
 * 自定义异常类
 * @author Administrator
 *
 */
public class DAOException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

}
