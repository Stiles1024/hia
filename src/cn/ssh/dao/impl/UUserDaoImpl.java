package cn.ssh.dao.impl;

import org.springframework.stereotype.Repository;

import cn.ssh.base.BaseDaoImpl;
import cn.ssh.dao.UUserDao;
import cn.ssh.domain.TUUser;

@Repository
public class UUserDaoImpl extends BaseDaoImpl<TUUser> implements UUserDao {

	public TUUser findByNameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return (TUUser)getSession().createQuery(//
				"FROM TUUser uu WHERE uu.username=? and uu.password=?")//
				.setParameter(0, username)//
				.setParameter(1, password)//
				.uniqueResult();
	}

	public TUUser findByName(String username) {
		// TODO Auto-generated method stub
		return (TUUser)getSession().createQuery(//
				"FROM TUUser uu WHERE uu.username=?")//
				.setParameter(0, username)//
				.uniqueResult();
	}

	public TUUser findByNum(String phonenum) {
		// TODO Auto-generated method stub
		return (TUUser)getSession().createQuery(//
				"FROM TUUser uu WHERE uu.phonenum=?")//
				.setParameter(0, phonenum)//
				.uniqueResult();
	}

	public TUUser findByphoneAndPassword(String phonenum, String password) {
		// TODO Auto-generated method stub
		return (TUUser)getSession().createQuery(//
				"FROM TUUser uu WHERE uu.phonenum=? and uu.password=?")//
				.setParameter(0, phonenum)//
				.setParameter(1, password)//
				.uniqueResult();
	}

	public TUUser findByEmailAndPassword(String phonenum, String password) {
		// TODO Auto-generated method stub
		return (TUUser)getSession().createQuery(//
				"FROM TUUser uu WHERE uu.email=? and uu.password=?")//
				.setParameter(0, phonenum)//
				.setParameter(1, password)//
				.uniqueResult();
	}

	public TUUser findByPhone(String phonenum) {
		// TODO Auto-generated method stub
		return (TUUser)getSession().createQuery(//
				"FROM TUUser uu WHERE uu.phonenum=?")//
				.setParameter(0, phonenum)//
				.uniqueResult();
	}

	public TUUser findByEmaild(String phonenum) {
		// TODO Auto-generated method stub
		return (TUUser)getSession().createQuery(//
				"FROM TUUser uu WHERE uu.email=?")//
				.setParameter(0, phonenum)//
				.uniqueResult();
	}

}
