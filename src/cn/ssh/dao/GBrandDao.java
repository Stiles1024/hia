package cn.ssh.dao;

import java.util.List;

import cn.ssh.base.BaseDao;
import cn.ssh.domain.PageBean;
import cn.ssh.domain.TGBrand;
import cn.ssh.domain.TGCategory;
import cn.ssh.domain.TGGoods;
import cn.ssh.util.QueryHelper;

public interface GBrandDao extends BaseDao<TGBrand>{

	List<TGBrand> findRootList();

	public List<TGGoods> findListByBrand(Integer brandId);
	
	public List<TGGoods> findListByCat(Integer catId,Integer brandId);
	
	public List<TGGoods> findListByAttr(String s,Integer brandId);
	
	public List<TGGoods> findListByCatList(List<TGCategory> soncatlist,Integer brandId);
	
	public PageBean getPageBean2(int pageNum, int pageSize,String attrnow,Integer brandId);

	PageBean getPageBean22(int pageNum, int pageSize, String attrnow,
			Integer brandId);

	PageBean getPageBean22(int pageNum, int pageSize, String attrnow,
			Integer brandId, Integer cateId);

	List<TGBrand> findListByuser(Integer authorId);
}
