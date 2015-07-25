package cn.ssh.dao.impl;

import org.springframework.stereotype.Repository;

import cn.ssh.base.BaseDaoImpl;
import cn.ssh.dao.UPocketDao;
import cn.ssh.domain.TUPocket;
import cn.ssh.domain.TUUser;
@Repository
public class UPocketDaoImpl extends BaseDaoImpl<TUPocket>implements UPocketDao{

	public TUPocket findByUserAndName(TUUser user, String string) {
		// TODO Auto-generated method stub
		return (TUPocket)getSession().createQuery(//
				"FROM TUPocket p WHERE p.TUUser=? and p.pocketName=?")//
				.setParameter(0, user)//
				.setParameter(1, string)//
				.uniqueResult();
	}

}
