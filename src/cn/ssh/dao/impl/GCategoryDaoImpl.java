package cn.ssh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.ssh.base.BaseDaoImpl;
import cn.ssh.dao.GCategoryDao;
import cn.ssh.domain.TGCategory;
import cn.ssh.domain.TGGoods;
@Repository
public class GCategoryDaoImpl extends BaseDaoImpl<TGCategory> implements GCategoryDao {

	public List<TGCategory> findTopList() {
		// TODO Auto-generated method stub
		return getSession().createQuery(//
				"FROM TGCategory gc WHERE gc.parent is null")//
				.list();
	}

	public List<TGCategory> findChildList(Integer parentId) {
		// TODO Auto-generated method stub
		
		return getSession().createQuery(//
				"FROM TGCategory gc WHERE gc.parent.catId=?")//
				.setParameter(0, parentId)//
				.list();
		
	}

	public List<TGCategory> findRootList() {
		// TODO Auto-generated method stub
		return getSession().createQuery(//
				"FROM TGCategory gc  ")//
				.list();
	}
	
	public TGCategory findByName(String string) {
		// TODO Auto-generated method stub
		return (TGCategory) getSession().createQuery(//
				"FROM TGCategory gc WHERE gc.catName=?")//
				.setParameter(0, string).uniqueResult();//
				
	}

}
