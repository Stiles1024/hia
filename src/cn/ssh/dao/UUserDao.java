package cn.ssh.dao;

import cn.ssh.base.BaseDao;
import cn.ssh.domain.TUUser;

public interface UUserDao extends BaseDao<TUUser> {

	TUUser findByNameAndPassword(String username, String password);

	TUUser findByName(String username);

	TUUser findByNum(String phonenum);

	TUUser findByphoneAndPassword(String phonenum, String password);

	TUUser findByEmailAndPassword(String phonenum, String password);

	TUUser findByPhone(String phonenum);

	TUUser findByEmaild(String phonenum);

}
