package com.techthinker.CAWeb.action;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techthinker.CAWeb.iservice.ICollegeService;
import com.techthinker.CAWeb.iservice.IMajorService;
import com.techthinker.CAWeb.iservice.IScenicspotService;
import com.techthinker.CAWeb.iservice.IUserService;
import com.techthinker.CAWeb.iservice.IUsertypeService;
import com.techthinker.CAWeb.model.Profile;
import com.techthinker.CAWeb.model.Register;
import com.techthinker.CAWeb.persistence.College;
import com.techthinker.CAWeb.persistence.Major;
import com.techthinker.CAWeb.persistence.Scenicspot;
import com.techthinker.CAWeb.persistence.User;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<Register> {

	private static final long serialVersionUID = 9129984683671574490L;

	private ICollegeService collegeService;
	private IMajorService majorService;
	private IScenicspotService scenicspotService;
	private IUsertypeService usertypeService;
	private IUserService userService;

	private Register reg;

	private Map<Integer, String> dormitories = new HashMap<Integer, String>();

	private String msg;
	
	private Profile personInfo;
	
	private User user;

	Map<String, Map<Integer, String>> collegeMap = new HashMap<String, Map<Integer, String>>();


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Map<String, Map<Integer, String>> getCollegeMap() {
		return collegeMap;
	}

	public void setCollegeMap(Map<String, Map<Integer, String>> collegeMap) {
		this.collegeMap = collegeMap;
	}

	public Profile getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(Profile personInfo) {
		this.personInfo = personInfo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public IUsertypeService getUsertypeService() {
		return usertypeService;
	}

	@Resource
	public void setUsertypeService(IUsertypeService usertypeService) {
		this.usertypeService = usertypeService;
	}

	public Register getReg() {
		return reg;
	}

	public void setReg(Register reg) {
		this.reg = reg;
	}

	public IMajorService getMajorService() {
		return majorService;
	}

	@Resource
	public void setMajorService(IMajorService majorService) {
		this.majorService = majorService;
	}

	public IScenicspotService getScenicspotService() {
		return scenicspotService;
	}

	@Resource
	public void setScenicspotService(IScenicspotService scenicspotService) {
		this.scenicspotService = scenicspotService;
	}

	public Map<Integer, String> getDormitories() {
		return dormitories;
	}

	public void setDormitories(Map<Integer, String> dormitories) {
		this.dormitories = dormitories;
	}

	public ICollegeService getCollegeService() {
		return collegeService;
	}

	@Resource
	public void setCollegeService(ICollegeService collegeService) {
		this.collegeService = collegeService;
	}

	public IUserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	/**
	 * 退出系统
	 * 
	 * @return
	 */
	public String logout() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session != null && session.size() > 0) {
			ActionContext.setContext(null);
		}
		return SUCCESS;
	}

	/**
	 * 用户注册
	 * 
	 * @return
	 */
	public String registerProcess() {
		if (userService.checkUser(reg.getUsername())) {
			msg = "用户名已经存在！";
			System.out.println("填写信息有错误");
			return "register";
		} else {
			User u = Reg2User (reg);
			try {
				userService.add(u);
				return SUCCESS;
			} catch (Exception e) {
				msg = "填写的信息有误！";
				System.out.println("填写信息有错误");
				return "register";
			}

		}
	}

	/**
	 * 根据Register对象创建一个User对象
	 * 
	 * @param reg
	 * @return
	 */
	public User Reg2User(Register reg) {
		User tempUser = new User();
		tempUser.setUsername(reg.getUsername());
		tempUser.setPassword(reg.getPassword());
		if (reg.getSex().equals("male")) {
			tempUser.setSex("男");
		} else {
			tempUser.setSex("女");
		}
		tempUser.setEmail(reg.getEmail());
		tempUser.setBirthday(Timestamp.valueOf(reg.getBirthday() + " 12:00:00"));
		tempUser.setEntranceYear(reg.getEntrance());
		tempUser.setDescription(reg.getDescription());
		tempUser.setUsertype(usertypeService.loadByUsertypeId(2));
		tempUser.setPhone(reg.getPhone());
		Major m = majorService.load(reg.getMajorname());
		tempUser.setCollege(m.getCollege());
		tempUser.setMajor(m);
		tempUser.setGeoinfo(scenicspotService.load(reg.getDormitory())
				.getGeoinfo());
		return tempUser;
	}	
	/**
	 * 根据Register对象创建一个User对象
	 * 
	 * @param reg
	 * @return
	 */
	public void Reg2User() {
		user.setPassword(reg.getPassword());
		if (reg.getSex().equals("male")) {
			user.setSex("男");
		} else {
			user.setSex("女");
		}
		user.setEmail(reg.getEmail());
		user.setBirthday(Timestamp.valueOf(reg.getBirthday() + " 12:00:00"));
		user.setEntranceYear(reg.getEntrance());
		user.setDescription(reg.getDescription());
		user.setUsertype(usertypeService.loadByUsertypeId(2));
		user.setPhone(reg.getPhone());
		Major m = majorService.load(reg.getMajorname());
		user.setCollege(m.getCollege());
		user.setMajor(m);
		user.setGeoinfo(scenicspotService.load(reg.getDormitory())
				.getGeoinfo());
	}

	/**
	 * 根据User对象创建Register对象
	 * 
	 * @param u
	 * @return
	 */
	public Register User2Reg(User u) {
		Register reg = new Register();
		reg.setUsername(u.getUsername());
		reg.setPassword(u.getPassword());
		reg.setEmail(u.getEmail());
		reg.setBirthday(u.getBirthday().toString().substring(0, 10));
System.out.println(u.getBirthday().toString().substring(0, 10));
		reg.setEntrance(u.getEntranceYear());
		reg.setDescription(u.getDescription());
		reg.setPhone(u.getPhone());
		return reg;
	}

	/**
	 * 根据User对象创建Profile对象
	 * @return
	 */
	public Profile User2Profile(User u){
		Profile p = new Profile();
		p.setUsername(u.getUsername());
		p.setPassword(u.getPassword());
		p.setEmail(u.getEmail());
		p.setSex(u.getSex());
		p.setBirthday(u.getBirthday().toString().substring(0, 10));
		p.setEntrance(u.getEntranceYear());
		p.setCollegename(u.getCollege().getCollegeName());
		p.setMajorname(u.getMajor().getMajorName());
		p.setDescription(u.getDescription());
		p.setPhone(u.getPhone());
		return p;
	}
	/**
	 * 登入注册页面前的预处理
	 * 
	 * @return
	 */
	public String register() {
		selectOption();
		return SUCCESS;
	}

	/**
	 * 处理学院和专业关联的对话框
	 */
	public void selectOption() {
		List<College> lists = collegeService.list();
		for (College c : lists) {
			if (c.getCollegeId() != 1) {
				List<Major> majorList = majorService.listMajorsByCollegeId(c
						.getCollegeId());
				if (majorList != null) {
					Map<Integer, String> majorMap = new HashMap<Integer, String>();
					for (Major m : majorList) {
						majorMap.put(m.getMajorId(), m.getMajorName());
					}
					collegeMap.put(c.getCollegeName(), majorMap);
				}
			}
		}
		List<Scenicspot> listSecnicspot = scenicspotService.listDormitories();
		for (Scenicspot ss : listSecnicspot) {
			dormitories.put(ss.getScenicspotId(), ss.getSpotname());
		}
	}

	/**
	 * 加载个人主页
	 * 
	 * @return
	 */
	public String profile() {
		System.out.println("profile.......");
		System.out.println(ActionContext.getContext().getSession()
				.get("username").toString());
		User u = userService.loadByUsername(ActionContext.getContext()
				.getSession().get("username").toString());
		personInfo = User2Profile(u);
		return SUCCESS;
	}

	/**
	 * 添加个人信息
	 * 
	 * @return
	 */
	public String updateInfo() {
		reg = User2Reg(userService.loadByUsername(ActionContext.getContext()
				.getSession().get("username").toString()));
		selectOption();
		return SUCCESS;
	}

	/**
	 * 更新用户信息
	 * 
	 * @return
	 */
	public String updateProcess() {

		user = userService.loadByUsername(ActionContext.getContext().getSession().get("username").toString());
		Reg2User();
		userService.update(user);
		return SUCCESS;
	}

	@Override
	public Register getModel() {
		if (reg == null)
			reg = new Register();
		return reg;
	}

}
