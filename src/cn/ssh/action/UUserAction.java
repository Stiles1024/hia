package cn.ssh.action;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.StyledEditorKit.BoldAction;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import sun.misc.Request;


import com.opensymphony.xwork2.ActionContext;

import cn.ssh.base.BaseAction;
import cn.ssh.domain.PageBean;
import cn.ssh.domain.TGBrand;
import cn.ssh.domain.TGBrandFocus;
import cn.ssh.domain.TUPocket;


import cn.ssh.domain.TUUser;
import cn.ssh.util.QueryHelper;

@Controller("uUserAction")
@Scope("prototype")
public class UUserAction extends BaseAction<TUUser> {
	
	
	private Integer userid;
	
	private Integer entityid;
	private String md5;
	private String registerPreUrl;
	private Integer loginFlag;//0为账号不存在 1 为密码错误
	private Integer brandId;
	
	public String registerUI(){
		System.out.println(registerPreUrl);
		return "registerUI";
	}
	public String register(){
		TUUser user=model;
		user.setType(TUUser.PERSON);
		user.setAddTime(new Date());
		uuserService.save(user);
		TUPocket p1=new TUPocket();
		TUPocket p2=new TUPocket();
		TUPocket p3=new TUPocket();
		p1.setPocketName("时尚");
		p1.setTUUser(user);
		p2.setPocketName("美妆");
		p2.setTUUser(user);
		p3.setPocketName("家居");
		p3.setTUUser(user);
		upocketService.save(p1);
		upocketService.save(p2);
		upocketService.save(p3);
		TUUser userNow=uuserService.findByNum(model.getPhonenum());
		if(registerPreUrl!=null&&!registerPreUrl.equals(""))
		{
			String [] array=registerPreUrl.split("-");
			String s="";
			for(String temp:array){
				s=s+"&"+temp;
			}
			registerPreUrl=s.substring(1);
			System.out.println(registerPreUrl+"====================");
			ActionContext.getContext().getSession().put("user", user);
		}else{
			registerPreUrl="主页 还没有";
		}
	
		
		return "register";
	}
	public String ajaxRegister(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
	
		String phonenum="";
		try {
			phonenum = IOUtils.toString(request.getInputStream());
			System.out.println("shoudao"+phonenum);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JSONObject jsonObject = new JSONObject();
		TUUser user;
		try {		
			user=uuserService.findByNum(phonenum);	
			response.setCharacterEncoding("utf-8");
			if(user==null){
				response.getWriter().print("<font color='green'><b>手机号可以使用</b></font>"); 
			}
			else{
				response.getWriter().print("<font color='red'><b>手机已注册账户</b></font>"); 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;

	}
public String ajaxLogin(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String phonenum="";
		try {
			phonenum = IOUtils.toString(request.getInputStream());
			System.out.println("shoudao"+phonenum);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		TUUser user;
		try {		
			user=uuserService.findByPhoneOrEmail(phonenum);	
			response.setCharacterEncoding("utf-8");
			if(user==null){
				response.getWriter().print("<font color='red'><b>该账号不存在</b></font>"); 
			}
			else{
				response.getWriter().print("<font color='green'><b>账号可以使用</b></font>"); 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;

	}
	
	
	public String loginUI(){
		
		return "loginUI";
	}
	
	public String login() {
		
		TUUser userP=uuserService.findByPhoneOrEmail(model.getPhonenum());
		
		if(userP==null){
			setLoginFlag(0);//账号不存在
			model.setPhonenum("");
			model.setPassword("");
			return "loginUI";
		}
		else{
				TUUser user=null;
				user = uuserService.findByPhoneOrEmailAndPassword(model.getPhonenum(), model.getPassword());
				 
				if(user==null)
				{
					model.setPassword("");
					setLoginFlag(1);//密码错误
					return "loginUI";
				}
				else{
					ActionContext.getContext().getSession().put("user", user);
				}
				
				if(registerPreUrl!=null&&!registerPreUrl.equals(""))
				{
					String [] array=registerPreUrl.split("-");
					String s="";
					for(String temp:array){
						s=s+"&"+temp;
					}
					registerPreUrl=s.substring(1);
					
				}else{
					registerPreUrl="主页 还没有";
				}
		}
		return "login";
	}
	
	public String logout() {
		ActionContext.getContext().getSession().remove("user");
		System.out.println(registerPreUrl);
		
		return "logoutUI";
	}	
	
	
	
	public String editpre() {
		TUUser user = uuserService.findById(model.getUserId());
		ActionContext.getContext().getValueStack().push(user);
		return "editpre";
	}
	
	public String edit() {
		model.setUserId(model.getUserId());
		uuserService.update(model);
		return "edit";
	}

	//-------------------------------------------------------
	

	public Integer getEntityid() {
		return entityid;
	}

	public void setEntityid(Integer entityid) {
		this.entityid = entityid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getRegisterPreUrl() {
		return registerPreUrl;
	}

	public void setRegisterPreUrl(String registerPreUrl) {
		this.registerPreUrl = registerPreUrl;
	}
	public Integer getLoginFlag() {
		return loginFlag;
	}
	public void setLoginFlag(Integer loginFlag) {
		this.loginFlag = loginFlag;
	}
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}





	
	
}
