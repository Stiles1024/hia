package cn.ssh.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;


import cn.ssh.base.BaseAction;
import cn.ssh.domain.TGCategory;
import cn.ssh.domain.TGGoods;
import cn.ssh.util.GCategoryUtil;
@Controller("gCategoryAction")
@Scope("prototype")
public class GCategoryAction extends BaseAction<TGCategory>{
	
	private Integer parentId;
	private boolean judge;
	//judge=true为可创建分类 即is_Leaf为0不作为叶子节点
	 public  String list(){
    	 if(parentId==null){
    		 List<TGCategory> gcategoryList=gcategoryService.findTopList();
    		 ActionContext.getContext().put("gcategoryList", gcategoryList);
    		 judge=true;
    		 ActionContext.getContext().put("judge", judge);
    		 return "list"; 
    	 }
    	 else{   		
    		TGCategory parent =gcategoryService.findById(parentId);
    		 List<TGCategory> gcategoryList=gcategoryService.findChildList(parentId);
    		
    		 ActionContext.getContext().put("parent", parent);
    		 ActionContext.getContext().put("gcategoryList", gcategoryList);
    		 ArrayList<TGCategory> contentList=new ArrayList<TGCategory>();
    		 contentList.add(parent);
    		 TGCategory temp=parent;
    		 while(temp.getParent()!=null){
    			 contentList.add(temp.getParent());
    			 temp=temp.getParent();
    		 }
    		 Collections.reverse(contentList);
    		 ActionContext.getContext().put("contentList", contentList);
    		 if(parent.getIsLeaf()==1){
    			 judge=false;
    			 
    			 return "listAttribute"; 
    		 }
    		 else 
    			 judge=true;
    		 ActionContext.getContext().put("judge", judge);
    		 return "list"; 
    	 }
	 		
     }
	 
	 public String delete(){
		 TGCategory gc=gcategoryService.findById(model.getCatId());
		 String catName=gc.getCatName();
		 gcategoryService.delete(gc.getCatId());
		 usyslogService.addSyslog("删除产品分类：" + catName); 
		 return "tolist";
	 }
	 
	 public String addUI(){
		 List<TGCategory> topList=gcategoryService.findTopList();
		 List<TGCategory>gcategoryList=GCategoryUtil.findAll(topList);
		 ActionContext.getContext().put("gcategoryList", gcategoryList);
		 return "saveUI";
	 }
	 
	 public String add(){
		 TGCategory gc=gcategoryService.findById(parentId);
		 if(gc.getIsLeaf()==1){
			 addActionError("不能选择叶子分类作为上级分类，请选择其他分类！");
			 List<TGCategory> topList=gcategoryService.findTopList();
			 List<TGCategory>gcategoryList=GCategoryUtil.findAll(topList);
			 ActionContext.getContext().put("gcategoryList", gcategoryList);
				return "saveUI";
		 }
		 model.setParent(gc);
		 gcategoryService.save(model);
		 usyslogService.addSyslog("添加产品分类：" + model.getCatName());
		 return "tolist";
	 }
	 
	 public String editUI(){
		 List<TGCategory> topList=gcategoryService.findTopList();
		 List<TGCategory>gcategoryList=GCategoryUtil.findAll(topList);
		 ActionContext.getContext().put("gcategoryList", gcategoryList);
		 
		 TGCategory gcategory =gcategoryService.findById(model.getCatId());
		 ActionContext.getContext().getValueStack().push(gcategory);
		 
		 return "saveUI";
	 }
	 
	 public String edit(){
		 TGCategory gc=gcategoryService.findById(parentId);
		 model.setParent(gc);
		 gcategoryService.update(model);
		 usyslogService.addSyslog("修改产品分类：" + model.getCatName());
		 return "tolist";
	 }

	 
//--------------------------------------------------------------------------------------------
	 public Integer getParentId() {
			return parentId;
		}

		public void setParentId(Integer parentId) {
			this.parentId = parentId;
		}

}
