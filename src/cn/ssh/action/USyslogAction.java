package cn.ssh.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import com.opensymphony.xwork2.ActionContext;

import cn.ssh.base.BaseAction;
import cn.ssh.domain.PageBean;

import cn.ssh.domain.TUSyslog;
import cn.ssh.domain.TUUser;
import cn.ssh.util.QueryHelper;

@Controller("uSyslogAction")
@Scope("prototype")
public class USyslogAction extends BaseAction<TUSyslog>{

	public String list() {
		//List<TUUser> userList = uuserService.findAll();
		//ActionContext.getContext().put("userList",userList);
		/*TUSyslog syslog =usyslogService.findById(model.getSyslogId());
		ActionContext.getContext().put("syslog", syslog);*/
		
		QueryHelper qp=new QueryHelper(TUSyslog.class, "syslog");
		PageBean pageBean = usyslogService.getPageBean( getPageNum(),  getPageSize(), qp);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "list";
	}
	
	public String delete(){
		usyslogService.delete(model.getSyslogId());
		 return "tolist";
	 }
	
}
