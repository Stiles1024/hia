package cn.ssh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.ssh.base.BaseDaoImpl;
import cn.ssh.dao.GGoodsAttrDao;
import cn.ssh.domain.TGGoodsAttr;

@Repository
public class GGoodsAttrDaoImpl extends BaseDaoImpl<TGGoodsAttr> implements
		GGoodsAttrDao {

	public void deleteByGoodId(Integer goodsId) {
		// TODO Auto-generated method stub
		System.out.println("delete" + goodsId);
		getSession().createQuery("DELETE FROM TGGoodsAttr tga WHERE tga.TGGoods.goodsId = ?").setParameter(0, goodsId).executeUpdate();
	}

	public List<TGGoodsAttr> findListByGoodsId(Integer goodsId) {
		// TODO Auto-generated method stub
		return getSession().createQuery(//
				"FROM TGGoodsAttr tga WHERE tga.TGGoods.goodsId=?")//
				.setParameter(0, goodsId)//
				.list();
	}
	
	

}
