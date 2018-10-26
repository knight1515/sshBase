package com.sshbase1.service;

import com.sshbase1.domain.User;

public interface UserService {

	User checkCode(String user_code);

	void save(User user);

	User login(User user);

}
