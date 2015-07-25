package cn.ssh.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.UPocketDao;
import cn.ssh.domain.TUPocket;
import cn.ssh.domain.TUUser;
import cn.ssh.service.UpocketService;

@Service
@Transactional
public class UpocketServiceImpl implements UpocketService {
	@Resource
	UPocketDao upocketDao;

	public TUPocket findByUserAndName(TUUser user, String string) {
		// TODO Auto-generated method stub
		return upocketDao.findByUserAndName(user,string);
	}

	public void save(TUPocket p1) {
		// TODO Auto-generated method stub
		upocketDao.save(p1);
	}
}
