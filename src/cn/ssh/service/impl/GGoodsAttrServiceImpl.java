package cn.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.GGoodsAttrDao;
import cn.ssh.domain.TGGoodsAttr;
import cn.ssh.service.GGoodsAttrService;

@Service
@Transactional
public class GGoodsAttrServiceImpl implements GGoodsAttrService {

	@Resource
	GGoodsAttrDao ggoodsattrDao;
	
	public void save(TGGoodsAttr model) {
		ggoodsattrDao.save(model);
	}

	public void deleteByGoodId(Integer goodsId) {
		// TODO Auto-generated method stub
		ggoodsattrDao.deleteByGoodId(goodsId);
	}

	public List<TGGoodsAttr> findListByGoodsId(Integer goodsId) {
		// TODO Auto-generated method stub
		return ggoodsattrDao.findListByGoodsId(goodsId);
	}
}
