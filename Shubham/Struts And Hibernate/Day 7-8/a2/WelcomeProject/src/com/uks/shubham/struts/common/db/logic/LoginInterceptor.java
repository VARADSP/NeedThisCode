/**
 *
 */
package com.uks.shubham.struts.common.db.logic;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.uks.shubham.struts.common.util.Constants;

/**
 * @author Shubham
 *
 */
public class LoginInterceptor implements Interceptor {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		System.out.println(Constants.stratInceptor);
	}

	@Override
	public void init() {
		System.out.println(Constants.endInceptor);
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {

		String result = actionInvocation.invoke();
		return result;
	}

}
