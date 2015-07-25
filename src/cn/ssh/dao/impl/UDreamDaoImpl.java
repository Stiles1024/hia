package cn.ssh.dao.impl;

import org.springframework.stereotype.Repository;

import cn.ssh.base.BaseDaoImpl;
import cn.ssh.dao.UDreamDao;
import cn.ssh.domain.TUDream;
import cn.ssh.domain.TUUser;
@ Repository
public class UDreamDaoImpl extends BaseDaoImpl<TUDream> implements UDreamDao {

	public TUDream findBDreamByUser(TUUser user, Integer bigdream) {
		// TODO Auto-generated method stub
		return (TUDream)getSession().createQuery(//
				"FROM TUDream d WHERE d.TUUser=? and d.type=?")//
				.setParameter(0, user)//
				.setParameter(1, bigdream)//
				.uniqueResult();
	}

}
