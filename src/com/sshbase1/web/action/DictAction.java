package com.sshbase1.web.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sshbase1.domain.Dict;
import com.sshbase1.service.DictService;
import com.sshbase1.utils.FastJsonUtil;

/**
 * 字典控制器
 * @author Administrator
 */
public class DictAction extends ActionSupport implements ModelDriven<Dict>{

	private static final long serialVersionUID = -82264029685635742L;
	
	private Dict dict = new Dict();

	public Dict getModel() {
		return dict;
	}
	
	private DictService dictService;
	public void setDictService(DictService dictService) {
		this.dictService = dictService;
	}
	
	/**
	 * 通过字段的type_code值，查询客户级别或者客户的来源
	 * @return
	 */
	public String findByCode(){
		// 调用业务层
		List<Dict> list = dictService.findByCode(dict.getDict_type_code());
		// List<Dict> list = dictService.findByCode("006");
		
		// 使用fastjson，把list转换成json字符串
		String jsonString = FastJsonUtil.toJSONString(list);
		// 把json字符串写到浏览器
		HttpServletResponse response = ServletActionContext.getResponse();
		// 输出
		FastJsonUtil.write_json(response, jsonString);
		
		return NONE;
	}

}

















