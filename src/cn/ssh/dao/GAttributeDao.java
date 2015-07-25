package cn.ssh.dao;

import java.util.List;

import cn.ssh.base.BaseDao;
import cn.ssh.domain.TGAttribute;
import cn.ssh.domain.TGCategory;

public interface GAttributeDao extends BaseDao<TGAttribute> {

	

	List<TGAttribute> findByCat(TGCategory gc);

}
