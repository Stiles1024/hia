package cn.ssh.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;




import cn.ssh.base.BaseAction;
import cn.ssh.domain.PageBean;
import cn.ssh.domain.TGAttrRange;
import cn.ssh.domain.TGAttribute;
import cn.ssh.domain.TGBrand;
import cn.ssh.domain.TGBrandFocus;
import cn.ssh.domain.TGCategory;
import cn.ssh.domain.TGGoods;
import cn.ssh.domain.TGGoodsAttr;
import cn.ssh.domain.TUUser;
import cn.ssh.util.GCategoryUtil;
import cn.ssh.util.QueryHelper;
import cn.ssh.util.UploadUtil;
@Controller("gBrandAction")
@Scope("prototype")
public class GBrandAction extends BaseAction<TGBrand>{

	private Integer brandId;
	private boolean judge;
	private String loadFileFileName;
	private File loadFile;
	private Integer userId;
	private boolean is_focused;
	 Integer cateId;
	
	private List<List<TGAttrRange> >gattrrangeList;
	
	private String attrnow;
	
	private String attradd;
	
	private String attrdel;
	
	private List<TGAttrRange> al_gattrrangeList;
	private List<String> selectRangeList;//顶替al_gattrrangeList;
	
	private List<TGGoodsAttr> goodsattrList;
	private String focusPreUrl;
	List<TGCategory> soncatlist = new ArrayList<TGCategory>();
	
	
	
	public String show(){
		
		TGBrand gb=gbrandService.findById(model.getBrandId());		
		TUUser user=(TUUser) ActionContext.getContext().getSession().get("user");
		TGBrandFocus bf=gbrandfocusService.findByUserBrand(user,gb);
		if(bf!=null){
			is_focused=true;
		}
		else{
			is_focused=false;
		}
		//分类 无论什么情况都展示
		 List<TGCategory> allList=gbrandService.findCates(gb);
		 List<TGCategory>seListF=new ArrayList<TGCategory>();
		 List<TGCategory>seListB=new ArrayList<TGCategory>();
		 List<TGCategory>seListH=new ArrayList<TGCategory>();
		 TGCategory gcF=gcategoryService.findByName("时尚");
		 TGCategory gcB=gcategoryService.findByName("美妆");
		 TGCategory gcH=gcategoryService.findByName("家居");
		 gcategoryService.findSelListByNmae(seListF,allList,gcF);
		 gcategoryService.findSelListByNmae(seListB,allList,gcB);
		 gcategoryService.findSelListByNmae(seListH,allList,gcH); 
		 Map<TGCategory, List<TGCategory>> mapF=new LinkedHashMap<TGCategory, List<TGCategory>>();
		 Map<TGCategory, List<TGCategory>> mapB=new LinkedHashMap<TGCategory, List<TGCategory>>();
		 Map<TGCategory, List<TGCategory>> mapH=new LinkedHashMap<TGCategory, List<TGCategory>>();
		 if(seListF.size()!=0){
		 gcategoryService.findMapBySel(seListF,allList,mapF);}
		 if(seListB.size()!=0){
			 gcategoryService.findMapBySel(seListB,allList,mapB);}
		 if(seListH.size()!=0){
			 gcategoryService.findMapBySel(seListH,allList,mapH);}
		
		ActionContext.getContext().put("mapF", mapF);
		ActionContext.getContext().put("mapB", mapB);
		ActionContext.getContext().put("mapH", mapH);
		
		//先处理扩展分类
		if(attradd != null && !attradd.equals("")) {
	
			if(attrnow.equals("")){			
				attrnow=attrnow+attradd;
			}
			else{
					List<String> attrrangeValueList = gattrrangeService.stringToRangeList(attrnow);
					List<String>attrNameList=new ArrayList<String>();//获得已选择扩展分类名List
					for(String value:attrrangeValueList){
						TGAttribute attrSel=gattrrangeService.findAttrByValue(value);
						attrNameList.add(attrSel.getAttrName());
					}
					
					String addnow=gattrrangeService.findAttrByValue(attradd).getAttrName();//当前选择属性的 扩展分类名
					System.out.println("addnow"+addnow);
					if(!(attrNameList.contains(addnow))){//如果选择的属性所属扩展分类之前没选择过
						attrnow=attrnow+"_"+attradd;
						System.out.println("没有选择过");
					}
					else{
						System.out.println("选择过");
						for(int i=0;i<attrNameList.size();i++){
							if(attrNameList.get(i).equals(addnow)){
								//防止显示已选择属性 乱序
								attrrangeValueList.set(i, attradd);
								
							}
						}
						String s="";
						for(String temp:attrrangeValueList)
						{
							s=s+"_"+temp;
						}
						attrnow=s.substring(1);
					}
			}
			attradd = null;
		} else if(attrdel != null && !attrdel.equals("")) {
			
			List<String> attrrangeValueList = gattrrangeService.stringToRangeList(attrnow);
			attrrangeValueList.remove(attrdel);
			String s="";
			for(String temp:attrrangeValueList)
			{
				s=s+"_"+temp;
			}
			if(s.equals("")){
				attrnow="";
			}
			else{
				attrnow=s.substring(1);
			}
			attrdel = null;
		}
		selectRangeList=gattrrangeService.stringToRangeList(attrnow);
		ActionContext.getContext().put("selectRangeList", selectRangeList);
		
		
	  //准备扩展分类
		Map<TGAttribute,List<String>> mapAttr=new LinkedHashMap<TGAttribute, List<String>>();//
		PageBean pageBean=new PageBean();
		//1 罗列所有扩展分类 map<扩展分类，扩展分类属性的名称集合>
		if(cateId==null){
				List<TGCategory> leafList=new ArrayList<TGCategory>();
			
				for(TGCategory gct:allList){
					if(gct.getChildren().size()==0l){
						leafList.add(gct);
					}
				}
				List<TGAttribute> attrList=new ArrayList<TGAttribute>();
				
				for(TGCategory gct:leafList){
					
					Collection<TGAttribute> temp=gct.getTGAttributes();
				 	if(temp.size()!=0){
						 for(TGAttribute ga:temp){
							 attrList.add(ga);
						 }
				 	}
				}
				
				for(TGAttribute ga :attrList)
				{
					if(mapAttr.containsKey(ga.getAttrName())){
						Collection<TGAttrRange> tempR=ga.getTGAttrRanges();
						for(TGAttrRange  range:tempR ){
							if(mapAttr.get(ga.getAttrName()).contains(range.getRangeValue())){	
							}
							else{
								mapAttr.get(ga.getAttrName()).add(range.getRangeValue());
							}
						}
					}
					else{
						Collection<TGAttrRange> tempR=ga.getTGAttrRanges();//有扩展属性必须保证有扩展分类值
						List<String> listR=new ArrayList<String>();
						for(TGAttrRange  range:tempR ){
							listR.add(range.getRangeValue());
						}
						mapAttr.put(ga, listR);
					}
				}
				if(attrnow==null||attrnow.equals("")){
					QueryHelper qp=new QueryHelper(TGGoods.class, "good").addCondition("good.TGBrand.brandId=?",model.getBrandId());//---
					pageBean = gbrandService.getPageBean( getPageNum(),  getPageSize(), qp);
					System.out.println("无分类   无扩展分类。。。。。。");
				}
				else{
					pageBean = gbrandService.getPageBean2( getPageNum(),  getPageSize(), attrnow, model.getBrandId());
					System.out.println("无分类   有扩展分类。。。。。。");
				}
				ActionContext.getContext().getValueStack().push(pageBean);
		}
		
		else{//2 罗列属于已选择分类的扩展分类 map<扩展分类名，扩展分类属性的名称集合>
			TGCategory selectedCate=gcategoryService.findById(cateId);
			ActionContext.getContext().getValueStack().push(selectedCate);
			
			
			Collection<TGAttribute> attrs=selectedCate.getTGAttributes();
			
			for(TGAttribute ga:attrs){
				List<String> rangeNames=new ArrayList<String>();
				Collection<TGAttrRange> tempRanges=ga.getTGAttrRanges();
				for(TGAttrRange range :tempRanges){
					rangeNames.add(range.getRangeValue());
				}
			mapAttr.put(ga, rangeNames);
			}
			if(attrnow==null||attrnow.equals("")){
				QueryHelper qp=new QueryHelper(TGGoods.class, "good").addCondition("good.TGBrand.brandId=?",model.getBrandId())
						.addCondition("good.TGCategory.catId=?", cateId);//---
				pageBean = gbrandService.getPageBean( getPageNum(),  getPageSize(), qp);
				System.out.println("有分类   无扩展分类。。。。。。");
			}
			else{
				pageBean = gbrandService.getPageBean2( getPageNum(),  getPageSize(), attrnow, model.getBrandId(),cateId);
				System.out.println("有分类   有扩展分类。。。。。。");
			}
			ActionContext.getContext().getValueStack().push(pageBean);
		}
		ActionContext.getContext().put("mapAttr", mapAttr);
	   Collection<TGGoods> goo=pageBean.getRecordList();
	   for(TGGoods go:goo){
		   System.out.println("==============="+go.getGoodsName());
	   }
	   TGCategory selectedCate=gcategoryService.findById(cateId);
	   if(selectedCate!=null){
		ActionContext.getContext().put("selectedCate", selectedCate);
	   }
		
		
		return "showtest";
	}
	
	public String brandIndex(){
		
		TGCategory gctf=gcategoryService.findByName("时尚");
		TGCategory gcth=gcategoryService.findByName("家居");
		TGCategory gctb=gcategoryService.findByName("美妆");
		List<TGBrand> fList=gcategoryService.findbListBycate(gctf);
		List<TGBrand> hList=gcategoryService.findbListBycate(gcth);
		List<TGBrand> bList=gcategoryService.findbListBycate(gctb);
//时尚
		List<TGBrand>FListNum=new ArrayList<TGBrand>();
		List<TGBrand>FListCH=new ArrayList<TGBrand>();
		List<TGBrand>FListEN=new ArrayList<TGBrand>();
		Map< String, List<TGBrand>> mapF=new LinkedHashMap<String, List<TGBrand>>();
		gbrandService.findList(fList,FListNum,FListCH,FListEN);
		gbrandService.findMap(FListEN,mapF);
		ActionContext.getContext().put("FListNum", FListNum);
		ActionContext.getContext().put("FListCH", FListCH);
		ActionContext.getContext().put("mapF", mapF);
//家居		
		List<TGBrand>HListNum=new ArrayList<TGBrand>();
		List<TGBrand>HListCH=new ArrayList<TGBrand>();
		List<TGBrand>HListEN=new ArrayList<TGBrand>();
		Map< String, List<TGBrand>> mapH=new LinkedHashMap<String, List<TGBrand>>();
		gbrandService.findList(hList,HListNum,HListCH,HListEN);
		gbrandService.findMap(HListEN,mapH);
		ActionContext.getContext().put("HListNum", HListNum);
		ActionContext.getContext().put("HListCH", HListCH);
		ActionContext.getContext().put("mapH", mapH);
		
//美妆	
		List<TGBrand>BListNum=new ArrayList<TGBrand>();
		List<TGBrand>BListCH=new ArrayList<TGBrand>();
		List<TGBrand>BListEN=new ArrayList<TGBrand>();
		Map< String, List<TGBrand>> mapB=new LinkedHashMap<String, List<TGBrand>>();
		gbrandService.findList(bList,BListNum,BListCH,BListEN);
		gbrandService.findMap(BListEN,mapB);
		ActionContext.getContext().put("BListNum", BListNum);
		ActionContext.getContext().put("BListCH", BListCH);
		ActionContext.getContext().put("mapB", mapB);
		
		
			return "brandIndex";
	}
	
	public String focusBrand(){
		
		if(focusPreUrl!=null&&!focusPreUrl.equals(""))
		{
			String [] array=focusPreUrl.split("-");
			String s="";
			for(String temp:array){
				s=s+"&"+temp;
			}
			focusPreUrl=s.substring(1);
		
		}
		TGBrand brand=gbrandService.findById(model.getBrandId());
		
		TUUser user=(TUUser) ActionContext.getContext().getSession().get("user");
		TGBrandFocus bf=new TGBrandFocus();
		bf.setTGBrand(brand);
		bf.setTUUser(user);
		System.out.println(brand.getBrandName());
		System.out.println(user.getUsername());
		gbrandfocusService.save(bf);
		is_focused=true;
		return "focusBrand";
	}
	public String NofocusBrand(){
		if(focusPreUrl!=null&&!focusPreUrl.equals(""))
		{
			String [] array=focusPreUrl.split("-");
			String s="";
			for(String temp:array){
				s=s+"&"+temp;
			}
			focusPreUrl=s.substring(1);
		System.out.println(focusPreUrl);
		}
		TGBrand gb=gbrandService.findById(model.getBrandId());
		TUUser user=(TUUser) ActionContext.getContext().getSession().get("user");
		TGBrandFocus bf=gbrandfocusService.findByUserBrand(user, gb);
		gbrandfocusService.delete(bf);
		is_focused=false;
		return "NofocusBrand";
	}
	public String introduce(){
		
		TGBrand gb=gbrandService.findById(model.getBrandId());		
		TUUser user=(TUUser) ActionContext.getContext().getSession().get("user");
		TGBrandFocus bf=gbrandfocusService.findByUserBrand(user,gb);
		if(bf!=null){
			is_focused=true;
		}
		else{
			is_focused=false;
		}
		model=gbrandService.findById(model.getBrandId());
		return "introduce";
	}
//-------------------------------------------------------------------------------	

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getLoadFileFileName() {
		return loadFileFileName;
	}
	
	public void setLoadFileFileName(String loadFileFileName) {
		this.loadFileFileName = loadFileFileName;
	}

	public File getLoadFile() {
		return loadFile;
	}

	public void setLoadFile(File loadFile) {
		this.loadFile = loadFile;
	}

	public Integer getCateId() {
		return cateId;
	}

	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}

	public List<List<TGAttrRange>> getGattrrangeList() {
		return gattrrangeList;
	}

	public void setGattrrangeList(List<List<TGAttrRange>> gattrrangeList) {
		this.gattrrangeList = gattrrangeList;
	}

	public String getAttrnow() {
		return attrnow;
	}

	public void setAttrnow(String attrnow) {
		this.attrnow = attrnow;
	}

	public String getAttradd() {
		return attradd;
	}

	public void setAttradd(String attradd) {
		this.attradd = attradd;
	}

	public String getAttrdel() {
		return attrdel;
	}

	public void setAttrdel(String attrdel) {
		this.attrdel = attrdel;
	}

	public List<TGAttrRange> getAl_gattrrangeList() {
		return al_gattrrangeList;
	}

	public void setAl_gattrrangeList(List<TGAttrRange> al_gattrrangeList) {
		this.al_gattrrangeList = al_gattrrangeList;
	}

	public List<TGGoodsAttr> getGoodsattrList() {
		return goodsattrList;
	}

	public void setGoodsattrList(List<TGGoodsAttr> goodsattrList) {
		this.goodsattrList = goodsattrList;
	}

	public List<TGCategory> getSoncatlist() {
		return soncatlist;
	}

	public void setSoncatlist(List<TGCategory> soncatlist) {
		this.soncatlist = soncatlist;
	}











	public Integer getUserId() {
		return userId;
	}











	public void setUserId(Integer userId) {
		this.userId = userId;
	}











	public List<String> getSelectRangeList() {
		return selectRangeList;
	}











	public void setSelectRangeList(List<String> selectRangeList) {
		this.selectRangeList = selectRangeList;
	}











	public boolean isIs_focused() {
		return is_focused;
	}











	public void setIs_focused(boolean is_focused) {
		this.is_focused = is_focused;
	}

	public String getFocusPreUrl() {
		return focusPreUrl;
	}

	public void setFocusPreUrl(String focusPreUrl) {
		this.focusPreUrl = focusPreUrl;
	}
	
	
}
