package cn.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.UPrivilegeDao;
import cn.ssh.domain.TUPrivilege;
import cn.ssh.service.UPrivilegeService;
@Service("uprivilegeServiceImpl")
@Transactional
public class UPrivilegeServiceImpl implements UPrivilegeService{
@Resource
UPrivilegeDao uprivilegeDao;
	public List<TUPrivilege> findAll() {
		// TODO Auto-generated method stub
		return uprivilegeDao.findAll();
	}

	public List<TUPrivilege> findByIds(Integer[] privilegeIds) {
		// TODO Auto-generated method stub
		return uprivilegeDao.findByIds(privilegeIds);
	}

	public List<TUPrivilege> findTopList() {
		// TODO Auto-generated method stub
		return uprivilegeDao.findTopList();
	}

	public List<String> findAllPrivilege() {
		// TODO Auto-generated method stub
		return uprivilegeDao.findAllPrivilege();
	}

}
