package cn.ssh.dao;

import cn.ssh.base.BaseDao;
import cn.ssh.domain.TGGoods;
import cn.ssh.domain.TUDream;
import cn.ssh.domain.TUDreamContent;

public interface UDreamContentDao extends BaseDao<TUDreamContent> {

	TUDreamContent findByDreamAndGoods(TUDream dreamBig, TGGoods model);

	void delete(TUDreamContent dc);

}
