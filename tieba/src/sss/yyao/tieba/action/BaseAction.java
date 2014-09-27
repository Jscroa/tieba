package sss.yyao.tieba.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

/**
 * 用于保存session的类
 * @author Administrator
 *
 */
public class BaseAction implements SessionAware {

	protected Map<String,Object> session;

	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}
	
}
