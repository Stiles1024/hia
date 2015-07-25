package cn.ssh.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.ssh.base.BaseAction;
import cn.ssh.domain.TGAttrRange;
import cn.ssh.domain.TGAttribute;
import cn.ssh.domain.TGCategory;
@Controller("gAttrRangeAction")
@Scope("prototype")
public class GAttrRangeAction extends BaseAction<TGAttrRange> {
	private  Integer catId;
	private Integer attrId;
	public String list(){
		TGAttribute ga=gattributeService.findById(attrId);
		TGCategory gc=gattributeService.findById(attrId).getTGCategory();
		List<TGAttrRange> gattrrangeList=gattrrangeService.findByAttr(ga);
		
		ActionContext.getContext().put("gattrrangeList", gattrrangeList);
		ActionContext.getContext().put("gattribute", ga);
		ActionContext.getContext().getValueStack().push(gc);
		
		
		ArrayList<TGCategory> contentList=new ArrayList<TGCategory>();
		 contentList.add(gc);
		 TGCategory temp=gc;
		 while(temp.getParent()!=null){
			 contentList.add(temp.getParent());
			 temp=temp.getParent();
		 }
		 Collections.reverse(contentList);
		 ActionContext.getContext().put("contentList", contentList);
		
		return "list";
	}
	
	 public String delete(){
		 //TGCategory gc=gcategoryService.findById(catId);
		 TGAttribute ga=gattributeService.findById(attrId);
		 TGAttrRange gt=gattrrangeService.findById(model.getCatRangeId());
		 String Value=gt.getRangeValue();
		 gattrrangeService.delete(gt.getCatRangeId());
		 usyslogService.addSyslog("删除产品分类“" + ga.getTGCategory().getCatName() + "”下属性“" + ga.getAttrName() + "”的值：" + Value);
		 return "tolist";
	 }
	 
	 public String addUI(){
			TGAttribute ga=gattributeService.findById(attrId);
			ActionContext.getContext().getValueStack().push(ga);
			 return "saveUI";
		 }
		 
		 public String add(){
			 //TGCategory gc=gcategoryService.findById(catId);
			 TGAttribute ga=gattributeService.findById(attrId);
			 model.setTGAttribute(gattributeService.findById(attrId));
			 gattrrangeService.save(model);
			 usyslogService.addSyslog("添加产品分类“" + ga.getTGCategory().getCatName() + "”下属性“" + ga.getAttrName() + "”的值：" + model.getRangeValue());
			 return "tolist";
		 }
		 public String editUI(){
			 TGAttribute ga=gattributeService.findById(attrId);
			ActionContext.getContext().getValueStack().push(ga);
			
			TGAttrRange gattrrange=gattrrangeService.findById(model.getCatRangeId());
			ActionContext.getContext().getValueStack().push(gattrrange);
			 return "saveUI";
		 }
		 
		 public String edit(){
			 //TGCategory gc=gcategoryService.findById(catId);
			 TGAttribute ga=gattributeService.findById(attrId);
			 model.setTGAttribute(gattributeService.findById(attrId));
			 gattrrangeService.update(model);
			 usyslogService.addSyslog("修改产品分类“" + ga.getTGCategory().getCatName() + "”下属性“" + ga.getAttrName() + "”的值：" + model.getRangeValue());
			 return "tolist";
		 }
	//==============================
	public Integer getAttrId() {
		return attrId;
	}
	public void setAttrId(Integer attrId) {
		this.attrId = attrId;
	}

	public Integer getCatId() {
		return catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	
}
