package cn.ssh.dao;

import cn.ssh.base.BaseDao;
import cn.ssh.domain.TUPocket;
import cn.ssh.domain.TUUser;

public interface UPocketDao extends BaseDao<TUPocket> {

	TUPocket findByUserAndName(TUUser user, String string);

}
