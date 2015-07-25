package cn.ssh.action;

import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;



import cn.ssh.base.BaseAction;
import cn.ssh.domain.TUPrivilege;
import cn.ssh.domain.TURole;
import cn.ssh.domain.TUUser;
@Controller("uRoleAction")
@Scope("prototype")
public class URoleAction extends BaseAction<TURole> {
	private Integer[] privilegeIds;
	public String list() {
		// TODO Auto-generated method stub
		List<TURole>roleList=uroleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}
	


	public String addUI() {
		// TODO Auto-generated method stub
		
		return "saveUI";
	}
	public String add() {
		// TODO Auto-generated method stub
		/*Role role=new Role();
		role.setName(model.getName());
		role.setDescription(model.getDescription());*/
		uroleService.save(model);
		usyslogService.addSyslog("添加岗位：" + model.getName());
		return "tolist";
	}
	
	public String delete() {
		// TODO Auto-generated method stub
		TURole role = uroleService.findById(model.getRoleId());
		String roleName = role.getName();
		uroleService.delete(role.getRoleId());
		usyslogService.addSyslog("删除岗位：" + roleName);
		return "tolist";
	}
	
	public String editUI() {
		// TODO Auto-generated method stub
		/**
		 * 这里不能push model，model下次请求时为空
		 */
		TURole role = uroleService.findById(model.getRoleId());
		ActionContext.getContext().getValueStack().push(role);
		return "saveUI";
	}
	
	public String edit() {
		// TODO Auto-generated method stub
		
		/*Role role=roleService.findById(model.getId());
		role.setName(model.getName());
		role.setDescription(model.getDescription());*/
		
		uroleService.update(model);
		usyslogService.addSyslog("修改岗位：" + model.getName());
		return "tolist";
	}
	
	public String setPrivilegeUI() {
		// TODO Auto-generated method stub
		//1 需要全部的权限列表
		List<TUPrivilege>privilegeList=uprivilegeService.findAll();
		ActionContext.getContext().put("privilegeList", privilegeList);
		//2获得已有的权限
		TURole role=uroleService.findById(model.getRoleId());
		ActionContext.getContext().put("role", role);
		if(role.getPrivilegs()!=null){
			
			privilegeIds=new Integer[role.getPrivilegs().size()];
			int index=0;
			for(TUPrivilege privilege : role.getPrivilegs()){
				privilegeIds[index++]=privilege.getPrivilegeId();
				System.out.println("123"+privilege.getName());
			}
		}
		
		return "setPrivilegeUI";
	}
	
	public String setPrivilege() {
		// TODO Auto-generated method stub
		//收到表单发回的privilegeIds和id
		List<TUPrivilege> privileges=uprivilegeService.findByIds(privilegeIds);
		model=uroleService.findById(model.getRoleId());
		
		//更新role，并存到数据库
		model.setPrivilegs(new HashSet<TUPrivilege>( privileges));
		uroleService.update(model);
		//为保证当前登入用户在session中保存的是最新的权限信息
		TUUser user=(TUUser) ActionContext.getContext().getSession().get("user");
		user=uuserService.findById(user.getUserId());
		ActionContext.getContext().getSession().remove("user");
		ActionContext.getContext().getSession().put("user", user);
		usyslogService.addSyslog("设置岗位“" + model.getName() + "”的权限");
		return "tolist";
	}

//=======================================
	public Integer[] getPrivilegeIds() {
		return privilegeIds;
	}



	public void setPrivilegeIds(Integer[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

}
