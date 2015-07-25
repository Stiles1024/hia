package cn.ssh.dao.impl;

import org.springframework.stereotype.Repository;

import cn.ssh.base.BaseDaoImpl;
import cn.ssh.dao.GBrandFocusDao;
import cn.ssh.domain.TGBrand;
import cn.ssh.domain.TGBrandFocus;
import cn.ssh.domain.TUUser;
@Repository
public class GBrandFocusDaoImpl extends BaseDaoImpl<TGBrandFocus> implements GBrandFocusDao {

	public TGBrandFocus findByUserBrand(TUUser user, TGBrand gb) {
		// TODO Auto-generated method stub
		return (TGBrandFocus)getSession().createQuery(//
				"FROM TGBrandFocus bf WHERE bf.TUUser=? and bf.TGBrand=?")//
				.setParameter(0, user)//
				.setParameter(1, gb)//
				.uniqueResult();
	}

	public void delete(TGBrandFocus bf) {
		// TODO Auto-generated method stub
		getSession().delete(bf);
	}

}
