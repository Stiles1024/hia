package cn.ssh.service.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.URoleDao;
import cn.ssh.domain.TURole;
import cn.ssh.service.URoleService;
@Service
@Transactional
public class URoleServiceImpl implements URoleService {
	@Resource
	URoleDao uroleDao;

	public List<TURole> findAll() {
		// TODO Auto-generated method stub
		return uroleDao.findAll();
	}

	public void save(TURole model) {
		// TODO Auto-generated method stub
		uroleDao.save(model);
	}

	public void delete(Integer roleId) {
		// TODO Auto-generated method stub
		uroleDao.delete(roleId);
	}

	public TURole findById(Integer roleId) {
		// TODO Auto-generated method stub
		return uroleDao.findById(roleId);
	}

	public void update(TURole model) {
		// TODO Auto-generated method stub
		uroleDao.udate(model);
	}

	public Collection<? extends TURole> findByIds(Integer[] roleIds) {
		// TODO Auto-generated method stub
		return uroleDao.findByIds(roleIds);
	}
}
