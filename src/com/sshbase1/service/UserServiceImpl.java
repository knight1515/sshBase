package com.sshbase1.service;

import org.springframework.transaction.annotation.Transactional;

import com.sshbase1.dao.UserDao;
import com.sshbase1.domain.User;
import com.sshbase1.utils.MD5Utils;


/**
 * 用户的业务层
 * @author Administrator
 */
@Transactional
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * 通过登录名进行验证
	 */
	public User checkCode(String user_code) {
		return userDao.checkCode(user_code);
	}

	/**
	 * 保存用户，密码需要加密
	 */
	public void save(User user) {
		String pwd = user.getUser_password();
		// 给密码加密
		user.setUser_password(MD5Utils.md5(pwd));
		// 用户的状态默认是1状态
		user.setUser_state("1");
		// 调用持久层
		userDao.save(user);
	}

	/**
	 * 登录通过登录名和密码做校验
	 * 先给密码加密，再查询
	 */
	public User login(User user) {
		String pwd = user.getUser_password();
		// 给密码加密
		user.setUser_password(MD5Utils.md5(pwd));
		// 查询
		return userDao.login(user);
	}
}










