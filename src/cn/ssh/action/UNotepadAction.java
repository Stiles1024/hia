package cn.ssh.action;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.ssh.base.BaseAction;
import cn.ssh.domain.PageBean;

import cn.ssh.domain.TUMessage;
import cn.ssh.domain.TUNotepad;
import cn.ssh.util.QueryHelper;
@Controller("uEventAction")
@Scope("prototype")
public class UNotepadAction extends BaseAction<TUNotepad> {
	
	private List<TUNotepad> eventlist;
	
	public String list() {
		QueryHelper qp=new QueryHelper(TUNotepad.class, "com")
		.addCondition("com.type=?", 1);
//		PageBean pageBean = gcommentlongService.getPageBean( getPageNum(),  getPageSize(), qp);
//		ActionContext.getContext().getValueStack().push(pageBean);
		return "list";
	}
	
	public String del() {
		ueventService.delete(model.getEventId());
		return "tolist";
	}
	
	public String add() {
		System.out.println("content = " + model.getContext());
		model.setTUUser(uuserService.findById(1));
		model.setOccurTime(new Timestamp(System.currentTimeMillis()));
		model.setType(1);
		ueventService.save(model);
		return "tolist";
	}
	
	public String editUI() {
		TUNotepad ev = ueventService.findById(model.getEventId());
		ActionContext.getContext().getValueStack().push(ev);
		return "saveUI";
	}
	
	public String addUI() {
		return "saveUI";
	}
	
	public String edit() {
		TUNotepad ev = ueventService.findById(model.getEventId());
		ev.setContext(model.getContext());
		ueventService.save(ev);
		return "tolist";
	}
}
