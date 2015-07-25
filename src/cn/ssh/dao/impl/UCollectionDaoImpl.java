package cn.ssh.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import cn.ssh.base.BaseDaoImpl;
import cn.ssh.dao.UCollectionDao;
import cn.ssh.domain.TUCollection;
import cn.ssh.domain.TUUser;
@Repository
public class UCollectionDaoImpl extends BaseDaoImpl<TUCollection> implements UCollectionDao {

	public Collection<TUCollection> findByUser(TUUser user) {
		// TODO Auto-generated method stub
		return getSession().createQuery(//
				"FROM TUCollection c WHERE c.TUUser=?")//
				.setParameter(0, user)//
				.list();
	}

	public TUCollection findByUserAndName(TUUser user, String name) {
		// TODO Auto-generated method stub
		return (TUCollection)getSession().createQuery(//
				"FROM TUCollection c WHERE c.TUUser=? and c.name=?")//
				.setParameter(0, user)//
				.setParameter(1, name)//
				.uniqueResult();
	}



}
