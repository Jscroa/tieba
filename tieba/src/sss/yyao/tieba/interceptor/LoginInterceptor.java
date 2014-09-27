package sss.yyao.tieba.interceptor;

import java.util.Map;

import sss.yyao.tieba.entity.Account;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		Map<String, Object> session = ai.getInvocationContext().getSession();
		Account account = (Account) session.get("acc");
		if(account==null){
			return "login";
		}else {
			return ai.invoke();
		}
	}

}
