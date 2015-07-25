package cn.ssh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.ssh.base.BaseDaoImpl;
import cn.ssh.dao.GGoodsImgDao;
import cn.ssh.domain.PageBean;
import cn.ssh.domain.TGGoodsImg;
import cn.ssh.util.QueryHelper;

@Repository
public class GGoodsImgDaoImpl extends BaseDaoImpl<TGGoodsImg> implements
		GGoodsImgDao {

	public List<TGGoodsImg> findListByGoodId(Integer goodsId) {
		// TODO Auto-generated method stub
		return getSession().createQuery(//
				"FROM TGGoodsImg img WHERE img.TGGoods.goodsId=?")//
				.setParameter(0, goodsId)//
				.list();
	}



}
