package cn.ssh.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.GBrandFocusDao;
import cn.ssh.domain.TGBrand;
import cn.ssh.domain.TGBrandFocus;
import cn.ssh.domain.TUUser;
import cn.ssh.service.GBrandFocusService;

@Service
@Transactional
public class GBrandFocusServiceImpl implements GBrandFocusService {
	@Resource 
	GBrandFocusDao gbrandfocusDao;
	public void save(TGBrandFocus bf) {
		// TODO Auto-generated method stub
	 gbrandfocusDao.save(bf);
	}
	public TGBrandFocus findByUserBrand(TUUser user, TGBrand gb) {
		// TODO Auto-generated method stub
		return gbrandfocusDao.findByUserBrand(user,gb);
	}
	public void delete(TGBrandFocus bf) {
		// TODO Auto-generated method stub
		gbrandfocusDao.delete(bf);
	}

}
