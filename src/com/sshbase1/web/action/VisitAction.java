package com.sshbase1.web.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.sshbase1.domain.PageBean;
import com.sshbase1.domain.User;
import com.sshbase1.domain.Visit;
import com.sshbase1.service.VisitService;

/**
 * 客户拜访的控制器
 * @author Administrator
 * Controller(value="visitAction") = <bean id="visitAction" class="..." scope="">
 */
@Controller(value="visitAction")
@Scope(value="prototype")
public class VisitAction extends BaseAction implements ModelDriven<Visit>{
	
	private static final long serialVersionUID = -139853886677968072L;
	
	private Visit visit = new Visit();
	
	public Visit getModel() {
		return visit;
	}
	
	@Resource(name="visitService")
	private VisitService visitService;
	
	private String beginDate;
	private String endDate;
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * 分页的查询
	 * 查询客户的拜访记录，根据用户的主键查询
	 * select * from sale_visit where visit_user_id = ?
	 * @return
	 */
	public String findByPage(){
		// 先获取当前登录的用户
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		// 判断
		if(user == null){
			// 配置全局结果跳转
			return LOGIN;
		}
		// 查询该用户下所有的拜访记录
		DetachedCriteria criteria = DetachedCriteria.forClass(Visit.class);
		
		// 拼接查询的条件
		if(beginDate != null && !beginDate.trim().isEmpty()){
			criteria.add(Restrictions.ge("visit_time", beginDate));
		}
		// select * from xxx where visit_time >= ? and visit_time <= ?
		if(endDate != null && !endDate.trim().isEmpty()){
			criteria.add(Restrictions.le("visit_time", endDate));
		}
		
		// 添加查询的条件
		criteria.add(Restrictions.eq("user.user_id",user.getUser_id()));
		// 分页查询
		PageBean<Visit> page = visitService.findByPage(this.getPageCode(),this.getPageSize(),criteria);
		this.setVs("page", page);
		return "page";
	}
	
	/**
	 * 保存拜访记录
	 * @return
	 */
	public String save(){
		// 把用户获取到，设置到当前的拜访记录中，再保存
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		// 判断
		if(user == null){
			// 配置全局结果跳转
			return LOGIN;
		}
		// 设置
		visit.setUser(user);
		// 保存数据
		visitService.save(visit);
		
		return "save";
	}
	
}












