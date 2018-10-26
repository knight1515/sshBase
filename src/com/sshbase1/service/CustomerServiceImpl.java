package com.sshbase1.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.sshbase1.dao.CustomerDao;
import com.sshbase1.domain.Customer;
import com.sshbase1.domain.PageBean;


/**
 * 客户的业务层
 * @author Administrator
 */
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	/**
	 * 保存客户
	 */
	public void save(Customer customer) {
		customerDao.save(customer);
	}

	/**
	 * 分页查询
	 */
	public PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
		return customerDao.findByPage(pageCode,pageSize,criteria);
	}

	/**
	 * 通过主键，查询客户
	 */
	public Customer findById(Long cust_id) {
		return customerDao.findById(cust_id);
	}

	public void delete(Customer customer) {
		customerDao.delete(customer);
	}

	public void update(Customer customer) {
		customerDao.update(customer);
	}
	
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	public List<Object[]> findBySource() {
		return customerDao.findBySource();
	}

}











