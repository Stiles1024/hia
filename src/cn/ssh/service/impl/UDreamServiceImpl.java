package cn.ssh.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.UDreamDao;
import cn.ssh.domain.TUDream;
import cn.ssh.domain.TUUser;
import cn.ssh.service.UDreamService;
@Service
@Transactional
public class UDreamServiceImpl implements UDreamService {

	@Resource
	UDreamDao udreamDao;

	public TUDream findBDreamByUser(TUUser user, Integer bigdream) {
		// TODO Auto-generated method stub
		return  udreamDao.findBDreamByUser(user,bigdream);
	}

	public void save(TUDream dreamBig) {
		// TODO Auto-generated method stub
		udreamDao.save(dreamBig);
	}
}
