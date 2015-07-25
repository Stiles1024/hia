package cn.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.GGoodsImgDao;
import cn.ssh.domain.TGGoodsImg;
import cn.ssh.service.GGoodsImgService;

@Service
@Transactional
public class GGoodsImgServiceImpl implements GGoodsImgService {

	@Resource
	GGoodsImgDao ggoodsimgDao;

	public List<TGGoodsImg> findListByGoodId(Integer goodsId) {
		// TODO Auto-generated method stub
		return ggoodsimgDao.findListByGoodId(goodsId);
	}

	public void save(TGGoodsImg goodimg) {
		// TODO Auto-generated method stub
		ggoodsimgDao.save(goodimg);
	}

	public TGGoodsImg findById(Integer imgid) {
		// TODO Auto-generated method stub
		return ggoodsimgDao.findById(imgid);
	}

	public void delete(Integer imgid) {
		// TODO Auto-generated method stub
		ggoodsimgDao.delete(imgid);
	}


	
	
}
