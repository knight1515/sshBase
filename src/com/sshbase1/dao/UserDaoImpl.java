package com.sshbase1.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sshbase1.domain.User;

public class UserDaoImpl extends HibernateDaoSupport  implements UserDao {

	public User checkCode(String user_code) {
		List<User> list = (List<User>)this.getHibernateTemplate().
				find("from User where user_code=?",user_code);
		
		if(list !=null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	//用户注册
	public void save(User user) {
		this.getHibernateTemplate().save(user);
		
	}

}
