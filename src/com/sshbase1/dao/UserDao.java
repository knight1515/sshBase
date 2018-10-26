package com.sshbase1.dao;

import com.sshbase1.domain.User;

public interface UserDao {

	User checkCode(String user_code);

	void save(User user);

	User login(User user);

}
