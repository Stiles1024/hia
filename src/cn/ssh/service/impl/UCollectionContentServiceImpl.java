package cn.ssh.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.UCollectionContentDao;
import cn.ssh.domain.TUCollectionContent;
import cn.ssh.service.UCollectionContentService;

@Service
@Transactional
public class UCollectionContentServiceImpl  implements UCollectionContentService{

	@Resource
	UCollectionContentDao ucollectioncontentDao;

	public void save(TUCollectionContent cc) {
		// TODO Auto-generated method stub
		ucollectioncontentDao.save(cc);
	}
}
