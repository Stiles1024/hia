package cn.ssh.service;

import java.util.Collection;
import java.util.List;

import cn.ssh.domain.TURole;

public interface URoleService {

	List<TURole> findAll();

	void save(TURole model);

	void delete(Integer roleId);

	TURole findById(Integer roleId);

	void update(TURole model);

	Collection<? extends TURole> findByIds(Integer[] roleIds);

}
