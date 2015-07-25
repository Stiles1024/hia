package cn.ssh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.ssh.base.BaseDaoImpl;
import cn.ssh.dao.GBrandCateDao;
import cn.ssh.domain.TGBrand;
import cn.ssh.domain.TGBrandCate;
@Repository
public class GBrandCateDaoImpl   extends BaseDaoImpl<TGBrandCate> implements GBrandCateDao  {

	public List findcateListBybrand(TGBrand gbrand) {
		// TODO Auto-generated method stub
		return getSession().createQuery(//
				"FROM TGBrandCate bc WHERE bc.TGBrand=?")//
				.setParameter(0, gbrand)//
				.list();
	}

}
