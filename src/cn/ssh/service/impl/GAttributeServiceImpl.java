package cn.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.GAttributeDao;
import cn.ssh.domain.TGAttribute;
import cn.ssh.domain.TGCategory;
import cn.ssh.service.GAttributeService;

@Service
@Transactional
public class GAttributeServiceImpl implements GAttributeService {
@Resource
GAttributeDao gattributeDao;



public List<TGAttribute> findByCat(TGCategory gc) {
	// TODO Auto-generated method stub
	return gattributeDao.findByCat(gc);
}



public void delete(Integer attrId) {
	// TODO Auto-generated method stub
	gattributeDao.delete(attrId);
}



public void save(TGAttribute model) {
	// TODO Auto-generated method stub
	gattributeDao.save(model);
}



public TGAttribute findById(Integer attrId) {
	// TODO Auto-generated method stub
	return gattributeDao.findById(attrId);
}



public void update(TGAttribute model) {
	// TODO Auto-generated method stub
	gattributeDao.udate(model);
}
}
