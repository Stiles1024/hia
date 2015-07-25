package cn.ssh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.ssh.base.BaseDaoImpl;
import cn.ssh.dao.GAttributeDao;
import cn.ssh.domain.TGAttribute;
import cn.ssh.domain.TGCategory;
@Repository
public class GAttributeDaoImpl extends BaseDaoImpl<TGAttribute> implements GAttributeDao{

	
	public List<TGAttribute> findByCat(TGCategory gc) {
		// TODO Auto-generated method stub
		return getSession().createQuery(//
				"FROM TGAttribute ga WHERE ga.TGCategory=?")//
				.setParameter(0, gc)//
				.list();
	}

}
