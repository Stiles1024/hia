package cn.ssh.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.GGoodsEvaluateDao;
import cn.ssh.domain.TGGoodsEvaluate;
import cn.ssh.service.GGoodsEvaluateService;

@Service
@Transactional
public class GGoodsEvaluateServiceImpl implements GGoodsEvaluateService {
	
	@Resource
	GGoodsEvaluateDao gGoodsEvaluateDao;
	public void save(TGGoodsEvaluate model) {
		gGoodsEvaluateDao.save(model);
	}
}
