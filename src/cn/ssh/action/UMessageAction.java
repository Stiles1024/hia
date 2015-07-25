package cn.ssh.action;

import java.sql.Timestamp;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.ssh.base.BaseAction;
import cn.ssh.domain.PageBean;
import cn.ssh.domain.TUMessage;
import cn.ssh.util.QueryHelper;

@Controller("uMessageAction")
@Scope("prototype")
public class UMessageAction extends BaseAction<TUMessage> {
	
	public String list() {
		QueryHelper qp=new QueryHelper(TUMessage.class, "com")
			.addCondition("com.isSys=?", true);
		PageBean pageBean = ggoodsService.getPageBean( getPageNum(),  getPageSize(), qp);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "list";
	}
	
	public String del() {
		umessageService.delete(model.getMessageId());
		return "tolist";
	}
	
	public String addUI() {
		return "saveUI";
	}
	
	public String editUI() {
		TUMessage me = umessageService.findById(model.getMessageId());
		ActionContext.getContext().getValueStack().push(me);
		return "editUI";
	}
	
	public String add() {
		//System.out.println("content == " + model.getContent());
		model.setMessageTime(new Timestamp(System.currentTimeMillis()));
		model.setIsSys(true);
		model.setTUUserByReceId(uuserService.findById(1));
		model.setTUUserBySendId(uuserService.findById(1));
		model.setIsRead(0);
		umessageService.save(model);
		return "tolist";
	}
	
	public String edit() {
		TUMessage me = umessageService.findById(model.getMessageId());
		me.setContent(model.getContent());
		umessageService.save(me);
		return "tolist";
	}
}
