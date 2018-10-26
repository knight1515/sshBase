package com.sshbase1.service;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.sshbase1.dao.LinkmanDao;
import com.sshbase1.domain.Linkman;
import com.sshbase1.domain.PageBean;

@Transactional
public class LinkmanServiceImpl implements LinkmanService {
	
	private LinkmanDao linkmanDao;
	public void setLinkmanDao(LinkmanDao linkmanDao) {
		this.linkmanDao = linkmanDao;
	}
	
	/**
	 * 分页的方法
	 */
	public PageBean<Linkman> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
		return linkmanDao.findByPage(pageCode, pageSize, criteria);
	}

}
