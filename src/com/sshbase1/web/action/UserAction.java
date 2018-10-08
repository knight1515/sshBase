package com.sshbase1.web.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sshbase1.domain.User;
import com.sshbase1.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = -534290718537139474L;
	
	private User user = new User();
	
	public User getModel() {
		return user;
	}
	
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService=userService;
	}
	
	/**
	 * 注册功能
	 * @return
	 */
	public String regist() {
		//接收请求参数
		userService.save(user);
		return LOGIN;
	}
	
	/**
	 * 通过登录名，判断，登录名是否已经存在
	 * @return
	 */
	public String checkCode() {
		User u=userService.checkCode(user.getUser_code());
		//获取response对象
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		try {
			PrintWriter writer = response.getWriter();
			//进行判断
			if(u!=null) {
				writer.print("no");
			}else {
				writer.print("yes");
			}
			
		} catch (IOException e) {
			e.printStackTrace();			
		}
		return NONE;
	}
	
}
