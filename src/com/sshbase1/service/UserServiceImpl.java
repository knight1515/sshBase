package com.sshbase1.service;

import org.springframework.transaction.annotation.Transactional;

import com.sshbase1.dao.UserDao;
import com.sshbase1.domain.User;
import com.sshbase1.utils.MD5Utils;

@Transactional
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User checkCode(String user_code) {
		return userDao.checkCode(user_code);
	}

	@Override
	public void save(User user) {
		String pwd=user.getUser_password();
		user.setUser_password(MD5Utils.md5(pwd));
		//用户的状态默认是1
		user.setUser_state("1");
		//调用持久层
		userDao.save(user);
	}

}
