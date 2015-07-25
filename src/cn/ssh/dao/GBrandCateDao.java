package cn.ssh.dao;


import java.util.List;

import cn.ssh.base.BaseDao;
import cn.ssh.domain.TGBrand;
import cn.ssh.domain.TGBrandCate;

public interface GBrandCateDao extends BaseDao<TGBrandCate>  {

	List findcateListBybrand(TGBrand gbrand);

}
