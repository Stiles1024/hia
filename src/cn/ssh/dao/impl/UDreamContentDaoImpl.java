package cn.ssh.dao.impl;

import org.springframework.stereotype.Repository;

import cn.ssh.base.BaseDaoImpl;
import cn.ssh.dao.UDreamContentDao;
import cn.ssh.domain.TGGoods;
import cn.ssh.domain.TUCollection;
import cn.ssh.domain.TUDream;
import cn.ssh.domain.TUDreamContent;
@ Repository
public class UDreamContentDaoImpl extends BaseDaoImpl<TUDreamContent> implements UDreamContentDao {

	public TUDreamContent findByDreamAndGoods(TUDream dreamBig, TGGoods model) {
		// TODO Auto-generated method stub
		return (TUDreamContent)getSession().createQuery(//
				"FROM TUDreamContent dc WHERE dc.TUDream=? and dc.TGGoods=?")//
				.setParameter(0, dreamBig)//
				.setParameter(1, model)//
				.uniqueResult();
	}

	public void delete(TUDreamContent dc) {
		// TODO Auto-generated method stub
		getSession().delete(dc);
	}

}
