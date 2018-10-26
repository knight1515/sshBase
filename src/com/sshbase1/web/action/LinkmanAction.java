package com.sshbase1.web.action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ModelDriven;
import com.sshbase1.domain.Customer;
import com.sshbase1.domain.Linkman;
import com.sshbase1.domain.PageBean;
import com.sshbase1.service.LinkmanService;

public class LinkmanAction extends BaseAction implements ModelDriven<Linkman>{
	
	private static final long serialVersionUID = 6607123393570718179L;
	
	private Linkman linkman = new Linkman();

	public Linkman getModel() {
		return linkman;
	}
	
	private LinkmanService linkmanService;
	public void setLinkmanService(LinkmanService linkmanService) {
		this.linkmanService = linkmanService;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	public String findByPage(){
		DetachedCriteria criteria = DetachedCriteria.forClass(Linkman.class);
		// 获取到联系人的名称
		String lkm_name = linkman.getLkm_name();
		if(lkm_name != null && !lkm_name.trim().isEmpty()){
			criteria.add(Restrictions.like("lkm_name", "%"+lkm_name+"%"));
		}
		
		// 获取客户
		Customer c = linkman.getCustomer();
		if(c != null && c.getCust_id() != null){
			// 拼接查询的条件
			criteria.add(Restrictions.eq("customer.cust_id", c.getCust_id()));
		}
		
		// 调用业务层
		PageBean<Linkman> page = linkmanService.findByPage(this.getPageCode(),this.getPageSize(),criteria);
		// 压栈
		this.setVs("page", page);
		return "page";
	}

}






