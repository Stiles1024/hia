package cn.ssh.dao;

import cn.ssh.base.BaseDao;
import cn.ssh.domain.TUDream;
import cn.ssh.domain.TUUser;

public interface UDreamDao extends BaseDao<TUDream> {

	TUDream findBDreamByUser(TUUser user, Integer bigdream);

}
