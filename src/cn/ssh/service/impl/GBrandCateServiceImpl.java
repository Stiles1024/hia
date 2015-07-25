package cn.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.GBrandCateDao;

import cn.ssh.domain.TGBrand;
import cn.ssh.domain.TGBrandCate;
import cn.ssh.service.GBrandCateService;
@Service
@Transactional
public class GBrandCateServiceImpl implements GBrandCateService{
	@Resource
	GBrandCateDao gbrandcateDao;

	public void save(TGBrandCate gbcate) {
		// TODO Auto-generated method stub
		gbrandcateDao.save(gbcate);
	}

	public List findcateListBybrand(TGBrand gbrand) {
		// TODO Auto-generated method stub
		
		return gbrandcateDao.findcateListBybrand(gbrand);
	}
}
