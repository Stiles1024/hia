package cn.ssh.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;



import cn.ssh.domain.TGGoods;
import cn.ssh.service.GAttrRangeService;
import cn.ssh.service.GAttributeService;
import cn.ssh.service.GBrandCateService;
import cn.ssh.service.GBrandFocusService;
import cn.ssh.service.GBrandService;
import cn.ssh.service.GCategoryService;
import cn.ssh.service.GGoodsEvaluateService;
import cn.ssh.service.UCollectionContentService;
import cn.ssh.service.UCollectionService;
import cn.ssh.service.UDreamContentService;
import cn.ssh.service.UDreamService;
import cn.ssh.service.UpocketService;

import cn.ssh.service.GGoodsAttrService;
import cn.ssh.service.GGoodsImgService;
import cn.ssh.service.GGoodsService;




import cn.ssh.service.UNotepadService;

import cn.ssh.service.UMessageService;

import cn.ssh.service.UPrivilegeService;
import cn.ssh.service.URoleService;
import cn.ssh.service.USyslogService;
import cn.ssh.service.UUserService;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Repository
public  abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

//	@Resource
//	protected DepartmentService departmentService;
	@Resource
	protected GCategoryService gcategoryService;
	@Resource
	protected GAttributeService gattributeService;
	@Resource
	protected GAttrRangeService gattrrangeService;
	@Resource
	protected GGoodsService ggoodsService;
	@Resource
	protected GBrandService gbrandService;

	@Resource
	protected GGoodsAttrService ggoodsattrService;
	

	
	@Resource
	protected UUserService uuserService;

	
	@Resource
	protected GGoodsImgService ggoodsimgService;
	
	@Resource
	protected GGoodsEvaluateService gGoodsEvaluateService;

    @Resource
    protected UMessageService umessageService;

    @Resource
   	protected UPrivilegeService uprivilegeService;
    @Resource
   	protected URoleService uroleService;
	@Resource
   	protected USyslogService usyslogService;
	
	
	@Resource
	protected UNotepadService ueventService;
	@Resource
	protected GBrandCateService gbrandcateService;
	@Resource
	protected GBrandFocusService gbrandfocusService;

	@Resource
	protected UCollectionService ucollectionService;
	
	@Resource
	protected UCollectionContentService ucollectioncontentService;
	@Resource
	protected UpocketService upocketService;
	@Resource
	protected UDreamService udreamService;
	@Resource
	protected UDreamContentService udreamcontentService;
	

	protected String route = "D://tomcat";
	protected T model=null;
	private Class<T> clazz=null;
	
	private int pageNum=1;
	private int pageSize=10;
	public BaseAction()  {
		// 使用反射技术得到T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass(); // 获取当前new的对象的 泛型的父类 类型
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0]; // 获取第一个类型参数的真实类型
		try {
			model=clazz.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public T getModel() {
		// TODO Auto-generated method stub
		return model ;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	

}
