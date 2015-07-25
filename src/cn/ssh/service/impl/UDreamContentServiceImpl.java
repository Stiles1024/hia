package cn.ssh.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.UDreamContentDao;
import cn.ssh.domain.TGGoods;
import cn.ssh.domain.TUDream;
import cn.ssh.domain.TUDreamContent;
import cn.ssh.service.UDreamContentService;
@Service
@Transactional
public class UDreamContentServiceImpl implements UDreamContentService {

	@ Resource
	UDreamContentDao udreamcontentDao;

	public TUDreamContent findByDreamAndGoods(TUDream dreamBig, TGGoods model) {
		// TODO Auto-generated method stub
		return udreamcontentDao.findByDreamAndGoods(dreamBig,model);
	}

	public void save(TUDreamContent dc) {
		// TODO Auto-generated method stub
		udreamcontentDao.save(dc);
	}

	public void delete(TUDreamContent dc) {
		// TODO Auto-generated method stub
		udreamcontentDao.delete(dc);
	}
}
