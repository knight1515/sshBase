package com.sshbase1.web.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sshbase1.domain.User;
import com.sshbase1.service.UserService;

/**
 * 用户的控制器
 * @author Administrator
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private static final long serialVersionUID = -3413092622818913571L;
	
	private User user = new User();
	
	public User getModel() {
		return user;
	}
	
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * 注册功能
	 * @return
	 */
	public String regist(){
		// 接收请求参数
		userService.save(user);
		return LOGIN;
	}
	
	/**
	 * 通过登录名，判断，登录名是否已经存在
	 * @return
	 */
	public String checkCode(){
		// 调用业务层，查询
		User u = userService.checkCode(user.getUser_code());
		// 获取response对象
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		try {
			// 获取输出流
			PrintWriter writer = response.getWriter();
			// 进行判断
			if(u != null){
				// 说明：登录名查询到用户了，说明登录已经存在了，不能注册
				writer.print("no");
			}else{
				// 说明，不存在登录名，可以注册
				writer.print("yes");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return NONE;
	}
	
	/**
	 * 登录功能
	 * @return
	 */
	public String login(){
		User existUser = userService.login(user);
		// 判断，登录名或者密码错误了
		if(existUser == null){
			return LOGIN;
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			// 登录成功
			return "loginOK";
		}
	}
	
	/**
	 * 退出功能
	 * @return
	 */
	public String exit(){
		ServletActionContext.getRequest().getSession().removeAttribute("existUser");
		return LOGIN;
	}
}









