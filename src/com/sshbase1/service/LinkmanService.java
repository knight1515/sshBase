package com.sshbase1.service;

import org.hibernate.criterion.DetachedCriteria;

import com.sshbase1.domain.Linkman;
import com.sshbase1.domain.PageBean;


public interface LinkmanService {

	PageBean<Linkman> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);

}
