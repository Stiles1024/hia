package cn.ssh.dao;

import java.util.List;

import cn.ssh.base.BaseDao;
import cn.ssh.domain.TUPrivilege;

public interface UPrivilegeDao extends BaseDao<TUPrivilege> {

	List<TUPrivilege> findTopList();

	List<String> findAllPrivilege();

}
