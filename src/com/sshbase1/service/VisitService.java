package com.sshbase1.service;

import org.hibernate.criterion.DetachedCriteria;

import com.sshbase1.domain.PageBean;
import com.sshbase1.domain.Visit;


public interface VisitService {

	PageBean<Visit> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);

	void save(Visit visit);

}
