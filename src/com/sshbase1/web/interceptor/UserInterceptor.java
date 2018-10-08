package com.sshbase1.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.sshbase1.domain.User;

public class UserInterceptor extends MethodFilterInterceptor {

	/**
	 *  反序列化
	 */
	private static final long serialVersionUID = 7374687356507317072L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//获取session
		User user = (User)ServletActionContext.getRequest().getSession().getAttribute("existUser");
		
		if (user == null) {
			return "login";
		}
		
		return invocation.invoke();
	}

}
