package cn.ssh.dao;

import java.util.List;

import cn.ssh.base.BaseDao;
import cn.ssh.domain.PageBean;
import cn.ssh.domain.TGAttrRange;
import cn.ssh.domain.TGCategory;
import cn.ssh.domain.TGGoods;
import cn.ssh.util.QueryHelper;

public interface GGoodsDao extends BaseDao<TGGoods> {
	
	public List<TGGoods> findListByCat(Integer catId);
	
	public List<TGGoods> findListByAttr(String s);

	public List<TGGoods> findListByCatList(List<TGCategory> soncatlist);

	public PageBean getPageBean2(int pageNum, int pageSize,
			String attrnow);
}
