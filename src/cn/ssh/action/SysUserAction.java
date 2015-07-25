package cn.ssh.action;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import net.sf.json.JSONObject;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import cn.ssh.base.BaseAction;
import cn.ssh.domain.PageBean;
import cn.ssh.domain.TURole;
import cn.ssh.domain.TUUser;
import cn.ssh.util.QueryHelper;
@Controller("sysUserAction")
@Scope("prototype")
public class SysUserAction extends BaseAction<TUUser> {
	private Integer [] roleIds;
	private String md5;
	
	public String ajax(){
		//System.out.println("=============================");
		//HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String username="";
		try {
			 username = IOUtils.toString(request.getInputStream());
			//Object obj=JSONValue.parse(json);
			System.out.println("shoudao"+username);
//			JSONObject obj=JSONObject.fromObject(json);
//			JSONArray paths= obj .getJSONArray("paths");
			
//			
//			System.out.println("json == " + obj);
//			System.out.println("jsonobj="+paths);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JSONObject jsonObject = new JSONObject();
		TUUser user;
//		jsonObject.put("name", "fly");
//		jsonObject.put("type", "虫子");
//		response.setCharacterEncoding("gbk");//这儿是为了返回中文格式的response。如果都是英文就不用了。
		try {
			//System.out.println(username+"===================");
			 user=uuserService.findByName(username);
		
			
			response.setCharacterEncoding("utf-8");
			//response.getWriter().print("{\"demoData\":\"用户名可以使用\"}");   
			if(user==null){
				response.getWriter().print("<font color='green'><b>用户名可以使用</b></font>"); 
			}
			else{
				response.getWriter().print("<font color='red'><b>用户名已存在</b></font>"); 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //{"name":"fly","type":"虫子"}
		return null;

	}

	public String list(){
//		List<User> userList=userService.findAll();
//		ActionContext.getContext().put("userList", userList);
		
		 QueryHelper qp=new QueryHelper(TUUser.class, "u") .addCondition("u.type=?", TUUser.ADMIN);
		 PageBean pageBean = uuserService.getPageBean( getPageNum(),  getPageSize(), qp);
				
		ActionContext.getContext().getValueStack().push(pageBean);
		return "list";
	}
	
	public String delete(){
		TUUser user=uuserService.findById(model.getUserId());
		String userName=user.getUsername();
		uuserService.delete(user.getUserId());
		usyslogService.addSyslog("删除岗位用户：" + userName);
		return "tolist";
	}
	
	public String addUI(){
		
   	 
		List<TURole> roleList=uroleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
  
		return "saveUI";
	}
	
	public String add(){
		model.setRoles(new HashSet<TURole>(uroleService.findByIds(roleIds)));		
		md5=DigestUtils.md5Hex(model.getPassword());
		model.setPassword(md5);
		
		model.setType(TUUser.ADMIN);
		uuserService.save(model);
		usyslogService.addSyslog("添加岗位用户：" + model.getUsername());
		return "tolist";
	}
	
	public String editUI(){
		
   	 TUUser user=uuserService.findById(model.getUserId());
   	 System.out.println(user.getUsername()+"=================");
   	 if(user.getRoles()!=null){
   		 roleIds=new Integer[user.getRoles().size()];
   		 int index=0;
      	  for(TURole role :user.getRoles()){
      		  roleIds[index++]=role.getRoleId();
      	  }
   	 }

   	 ActionContext.getContext().getValueStack().push(user);
   	 List<TURole> roleList=uroleService.findAll();
   	 ActionContext.getContext().put("roleList", roleList);
		return "saveUI";
	}
	
	public String edit(){		
		System.out.println(model.getUsername());
		
		TUUser user=uuserService.findById(model.getUserId());
		user.setEmail(model.getEmail());
		user.setPhonenum(model.getPhonenum());
		
		user.setUsername(model.getUsername());
		
		user.setRoles(new HashSet<TURole>(uroleService.findByIds(roleIds)));
		md5=DigestUtils.md5Hex(model.getPassword());
		System.out.println(model.getPassword());
		user.setPassword(md5);
		user.setType(TUUser.ADMIN);
		uuserService.update(user);
		usyslogService.addSyslog("修改岗位用户：" + model.getUsername());
		return "tolist";
	}
	//=======================================
	public Integer [] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Integer [] roleIds) {
		this.roleIds = roleIds;
	}
}
