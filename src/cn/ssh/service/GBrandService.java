package cn.ssh.service;

import java.util.List;
import java.util.Map;

import cn.ssh.domain.PageBean;
import cn.ssh.domain.TGBrand;
import cn.ssh.domain.TGCategory;
import cn.ssh.domain.TGGoods;
import cn.ssh.util.QueryHelper;

public interface GBrandService {

	TGBrand findById(Integer brandId);
	
	void delete(Integer brandId);

	void save(TGBrand model);

	void update(TGBrand model);

	List<TGBrand> findRootList();

	List<TGBrand> findAll();

	List<TGGoods> findListByBrand(Integer brandId);
	
	List<TGGoods> findListByCat(Integer catId,Integer brandId);//待定
	
	List<TGGoods> findListByAttr(String s,Integer brandId);
	
	List<TGGoods> findListByCatlist(List<TGCategory> soncatlist,Integer brandId);
	
	public PageBean getPageBean(int pageNum, int pageSize, String attrnow, Integer brandId);

	public PageBean getPageBean(int pageNum, int pageSize, QueryHelper qp);

	List<TGCategory> findCates(TGBrand gbrand);

	void findList(List<TGBrand> fList, List<TGBrand> fListNum,
			List<TGBrand> fListCH, List<TGBrand> fListEN);

	void findMap(List<TGBrand> fListEN, Map<String, List<TGBrand>> mapF);

	PageBean getPageBean2(int pageNum, int pageSize, String attrnow,
			Integer brandId);

	PageBean getPageBean2(int pageNum, int pageSize, String attrnow,
			Integer brandId, Integer cateId);

	List<TGBrand> findListByUser(Integer authorId);



	

	
}
