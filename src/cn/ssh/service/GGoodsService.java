package cn.ssh.service;

import java.util.List;

import cn.ssh.domain.PageBean;
import cn.ssh.domain.TGCategory;
import cn.ssh.domain.TGGoods;
import cn.ssh.util.QueryHelper;

public interface GGoodsService {
	
	public List<TGGoods> findAll();
	
	public List<TGGoods> findListByCat(Integer catId);
	
	public List<TGGoods> findListByAttr(String s);
	
	public void save(TGGoods model);
	
	public TGGoods findGoodsById(Integer goodsId);
	
	public void update(TGGoods model);

	public List<TGGoods> findListByCatlist(List<TGCategory> soncatlist);

	public PageBean getPageBean(int pageNum, int pageSize, String attrnow);

	public PageBean getPageBean(int pageNum, int pageSize, QueryHelper qp);

}
