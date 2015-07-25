package cn.ssh.service;

import java.util.List;

import cn.ssh.domain.TUPrivilege;



public interface UPrivilegeService {

	List<TUPrivilege> findAll();

	List<TUPrivilege> findByIds(Integer[] privilegeIds);

	List<TUPrivilege> findTopList();

	List<String> findAllPrivilege();
}
