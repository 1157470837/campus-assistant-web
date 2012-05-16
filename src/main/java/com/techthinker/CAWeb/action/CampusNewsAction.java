package com.techthinker.CAWeb.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techthinker.CAWeb.vo.CampusNews;

@Controller("messageAction")
@Scope("prototype")
public class CampusNewsAction extends ActionSupport implements ModelDriven<CampusNews>{
	private static final long serialVersionUID = -3266057605774486873L;

	@Override
	public CampusNews getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
