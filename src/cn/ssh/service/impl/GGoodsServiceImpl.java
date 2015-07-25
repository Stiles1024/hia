package cn.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.GGoodsDao;
import cn.ssh.domain.PageBean;
import cn.ssh.domain.TGCategory;
import cn.ssh.domain.TGGoods;
import cn.ssh.service.GGoodsService;
import cn.ssh.util.QueryHelper;

@Service
@Transactional
public class GGoodsServiceImpl implements GGoodsService {

	@Resource
	GGoodsDao ggoodsDao;
	
	public List<TGGoods> findAll() {
		// TODO Auto-generated method stub
		return ggoodsDao.findAll();
	}

	public List<TGGoods> findListByCat(Integer catId) {
		// TODO Auto-generated method stub
		return ggoodsDao.findListByCat(catId);
	}

	public List<TGGoods> findListByAttr(String s) {
		// TODO Auto-generated method stub
		return ggoodsDao.findListByAttr(s);
	}
	
	public void save(TGGoods model) {
		ggoodsDao.save(model);
	}
	
	public TGGoods findGoodsById(Integer goodsId) {
		return ggoodsDao.findById(goodsId);
	}
	
	public void update(TGGoods model) {
		ggoodsDao.udate(model);
	}

	public List<TGGoods> findListByCatlist(List<TGCategory> soncatlist) {
		// TODO Auto-generated method stub
		return ggoodsDao.findListByCatList(soncatlist);
	}

	public PageBean getPageBean(int pageNum, int pageSize,
			String attrnow) {
		// TODO Auto-generated method stub
		return ggoodsDao.getPageBean2(pageNum, pageSize, attrnow);
	}

	public PageBean getPageBean(int pageNum, int pageSize, QueryHelper qp) {
		// TODO Auto-generated method stub
		return ggoodsDao.getPageBean(pageNum, pageSize, qp);
	}

	
}
