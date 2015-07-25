package cn.ssh.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.ssh.base.BaseAction;
import cn.ssh.domain.TGAttribute;
import cn.ssh.domain.TGCategory;
import cn.ssh.util.GCategoryUtil;

@Controller("gAttributeAction")
@Scope("prototype")
public class GAttributeAction extends BaseAction<TGAttribute>{
	private  Integer catId;
	public String list(){
		TGCategory gc=gcategoryService.findById(catId);
	
		List<TGAttribute> gattributeList=gattributeService.findByCat(gc);
		
		ActionContext.getContext().put("gattributeList", gattributeList);
		ActionContext.getContext().put("gc", gc);
		
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
		 TGCategory gc=gcategoryService.findById(catId);
		 TGAttribute ga = gattributeService.findById(model.getAttrId());
		 String attrName = ga.getAttrName();
		 gattributeService.delete(ga.getAttrId());
		 usyslogService.addSyslog("删除产品分类“" + gc.getCatName() + "”下的属性：" + attrName);
		 return "tolist";
	 }
	 public String addUI(){
		TGCategory gc=gcategoryService.findById(catId);
		 ActionContext.getContext().put("gcategory", gc);
		 return "saveUI";
	 }
	 
	 public String add(){
		 TGCategory gc=gcategoryService.findById(catId);		
		 model.setTGCategory(gc);		
		 gattributeService.save(model);
		 usyslogService.addSyslog("添加产品分类“" + gc.getCatName() + "”下的属性：" + model.getAttrName());
		 return "tolist";
	 }
	 
	 public String editUI(){
		 TGCategory gc=gcategoryService.findById(catId);
		 ActionContext.getContext().put("gcategory", gc);
		 TGAttribute ga=gattributeService.findById(model.getAttrId());
		 ActionContext.getContext().getValueStack().push(ga);
		 
		 return "saveUI";
	 }
	 
	 public String edit(){
		 TGCategory gc=gcategoryService.findById(catId);			
		 model.setTGCategory(gc);
		 gattributeService.update(model);
		 usyslogService.addSyslog("修改产品分类“" + gc.getCatName() + "”下的属性：" + model.getAttrName());
		 return "tolist";
	 }
	
	//=========================================
	public Integer getCatId() {
		return catId;
	}
	public void setCatId(Integer catId) {
		this.catId = catId;
	}

}
