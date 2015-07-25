package cn.ssh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.ssh.base.BaseDaoImpl;
import cn.ssh.dao.UPrivilegeDao;
import cn.ssh.domain.TUPrivilege;
@Repository
public class UPrivilegeDaoImpl  extends BaseDaoImpl<TUPrivilege> implements UPrivilegeDao{

	public List<TUPrivilege> findTopList() {
		// TODO Auto-generated method stub
		return	getSession().createQuery("from TUPrivilege p  where p.parent is null").list();
	}

	public List<String> findAllPrivilege() {
		// TODO Auto-generated method stub
		return getSession().createQuery("SELECT DISTINCT p.url FROM TUPrivilege p WHERE p.url IS NOT NULL").list();
	}

}
