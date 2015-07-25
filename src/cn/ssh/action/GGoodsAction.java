package cn.ssh.action;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
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
import cn.ssh.domain.TGBrandCate;
import cn.ssh.domain.TGCategory;
import cn.ssh.domain.TGGoodsEvaluate;
import cn.ssh.domain.TUCollection;
import cn.ssh.domain.TUCollectionContent;
import cn.ssh.domain.TUDream;
import cn.ssh.domain.TUDreamContent;
import cn.ssh.domain.TUPocket;
import cn.ssh.domain.TUUser;

import cn.ssh.domain.TGGoods;
import cn.ssh.domain.TGGoodsAttr;
import cn.ssh.domain.TGGoodsImg;

import cn.ssh.service.GBrandCateService;
import cn.ssh.util.GAttributeUtil;
import cn.ssh.util.GCategoryUtil;
import cn.ssh.util.QueryHelper;
import cn.ssh.util.UploadUtil;

@Controller("gGoodsAction")
@Scope("prototype")
public class GGoodsAction extends BaseAction<TGGoods> {
	private String selectRange;//顶替al_gattrrangeList;
	private Integer collectionId;
	private  boolean is_dreamed;
	
	public String  show(){

		TUUser user=(TUUser) ActionContext.getContext().getSession().get("user");
		TUDream dreamBig=udreamService.findBDreamByUser(user,TUDream.BIGDREAM);
		
		model=ggoodsService.findGoodsById(model.getGoodsId());
		
		TUDreamContent dc=udreamcontentService.findByDreamAndGoods(dreamBig,model);
		if(dc!=null){
			is_dreamed=true;//已经添加到心愿单
		}
		else{
			is_dreamed=false;
		}
		Collection< TGGoodsImg>imgs=model.getTGGoodsImgs();
		
		Collection<TUCollection>collectionList=ucollectionService.findByUser(user);
		ActionContext.getContext().put("collectionList", collectionList);
		List<String> urls=new ArrayList<String>();
		for(TGGoodsImg img:imgs)
		{
			urls.add(img.getValue());
			
		}
		ActionContext.getContext().put("urls", urls);
			return "show";
	}
	public String collection(){
		TUCollectionContent cc=new TUCollectionContent();
		TGGoods g=ggoodsService.findGoodsById(model.getGoodsId());
		TUCollection c =ucollectionService.findById(collectionId);
		cc.setTGGoods(g);
		cc.setTUCollection(c);
		System.out.println(g.getGoodsName());
		System.out.println(c.getName());
		ucollectioncontentService.save(cc);
		return "collection";
	}
	public String dream(){
		TUUser user=(TUUser) ActionContext.getContext().getSession().get("user");
		TUDream dreamBig=udreamService.findBDreamByUser(user,TUDream.BIGDREAM);
		if(dreamBig==null){
			dreamBig=new TUDream();
			dreamBig.setTUUser(user);
			dreamBig.setType(TUDream.BIGDREAM);
			udreamService.save(dreamBig);
		}
		TUDreamContent dc=new TUDreamContent();
		TGGoods goods=ggoodsService.findGoodsById(model.getGoodsId());
		dc.setTGGoods(goods);
		dc.setTUDream(dreamBig);
		udreamcontentService.save(dc);
		is_dreamed=true;
		
		return "dream";
	}
	public String Nodream(){
		TUUser user=(TUUser) ActionContext.getContext().getSession().get("user");
		TUDream dreamBig=udreamService.findBDreamByUser(user,TUDream.BIGDREAM);
		
		TGGoods goods=ggoodsService.findGoodsById(model.getGoodsId());
		TUDreamContent dc=udreamcontentService.findByDreamAndGoods(dreamBig, goods);
		
		udreamcontentService.delete(dc);
		is_dreamed=false;
		
		return "Nodream";
	}
	
	public String evaluate(){
		TUUser user=(TUUser) ActionContext.getContext().getSession().get("user");
		
		TGGoods goods = ggoodsService.findGoodsById(0);
	
		
		File[] files = (File[]) ActionContext.getContext().getParameters().get("file");
		String surl=ServletActionContext.getServletContext().getRealPath("/test");
		String[] text=(String[])ActionContext.getContext().getParameters().get("comment");
		System.out.println(text[0]);
		System.out.println(surl);
		File dir = new File(surl);
		if(!dir.exists()) dir.mkdirs();
		if(files != null) {
			for(File f: files) {
				System.out.println(f.getName());
				System.out.println(f.length());
				try {
					
					BufferedImage image = ImageIO.read(f);
					Date date = new Date();
					long time = date.getTime();
					
					TGGoodsEvaluate evaluate = new TGGoodsEvaluate(user, goods, date);
					evaluate.setContent(text[0]);
					
					ImageIO.write(image, "jpg", new File(surl+"/"+String.valueOf(time)+".jpg"));
					System.out.println(image);
					gGoodsEvaluateService.save(evaluate);
					
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		return "evaluate";
	}
	
	public String ajaxCollection() throws IOException{

		HttpServletRequest request = ServletActionContext.getRequest();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		String nameColl="";
		try {
			nameColl = IOUtils.toString(request.getInputStream());
			System.out.println("nameColl"+nameColl);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
		}
		nameColl = URLDecoder.decode(nameColl,"UTF-8");  //传递中文解码
	
		String [] nameId=nameColl.split("_");
		TUUser user=(TUUser) ActionContext.getContext().getSession().get("user");
		String name=nameId[0];
		
		TUCollection uc=ucollectionService.findByUserAndName(user, name);
		if(uc!=null){
			response.setCharacterEncoding("utf-8");
			response.getWriter().print("");
			System.out.println("weikong ");
		}
		else{
			Integer id=Integer.parseInt(nameId[1]);
			System.out.println("name="+name);
			TUCollection c=new TUCollection();
			
			TGGoods goods=ggoodsService.findGoodsById(id);
			TGCategory cate=goods.getTGCategory();
			System.out.println(cate.getCatName()+"前");
			while(cate.getParent()!=null){
				cate=cate.getParent();
			}
			System.out.println(cate.getCatName()+"后");
			TUPocket pocket=new TUPocket();
			if(cate.getCatName().equals("时尚")){
				pocket=upocketService.findByUserAndName(user,"时尚");
				System.out.println(pocket.getPocketId()+"id");
			}
			if(cate.getCatName().equals("美妆")){
				pocket=upocketService.findByUserAndName(user,"美妆");
			}
			if(cate.getCatName().equals("家居")){
				pocket=upocketService.findByUserAndName(user,"家居");
			}
			
			c.setCollTime(new Date());
			c.setName(name);
			c.setTUPocket(pocket);
			c.setTUUser(user);
			c.setUpdateTime(new Date());
			System.out.println("zhe");
			
			ucollectionService.save(c);
			TUCollection cc=ucollectionService.findByUserAndName(user,name);
			
			System.out.println("na ");
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(name+"_"+cc.getCollId());
		}
		
		
	
		return null;
	}

	//----------------------------------------------------
	private Integer brandId;

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getSelectRange() {
		return selectRange;
	}

	public void setSelectRange(String selectRange) {
		this.selectRange = selectRange;
	}
	public Integer getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(Integer collectionId) {
		this.collectionId = collectionId;
	}
	public boolean isIs_dreamed() {
		return is_dreamed;
	}
	public void setIs_dreamed(boolean is_dreamed) {
		this.is_dreamed = is_dreamed;
	}



	
	
	
	
}
