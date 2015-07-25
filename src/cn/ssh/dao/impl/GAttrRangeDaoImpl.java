package cn.ssh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.ssh.base.BaseDaoImpl;
import cn.ssh.dao.GAttrRangeDao;
import cn.ssh.domain.TGAttrRange;
import cn.ssh.domain.TGAttribute;
@Repository
public class GAttrRangeDaoImpl extends BaseDaoImpl<TGAttrRange> implements GAttrRangeDao{

	public List<TGAttrRange> findByAttr(TGAttribute ga) {
		// TODO Auto-generated method stub
		return getSession().createQuery(//
				"FROM TGAttrRange gar WHERE gar.TGAttribute=?")//
				.setParameter(0, ga)//
				.list();
	}

	public void deleteByGoodId(Integer goodsId) {
		// TODO Auto-generated method stub
		getSession().createQuery("DELETE FROM TGGoodsAttr tga WHERE tga.TGGoods.goodsId = ?").setParameter(0, goodsId).executeUpdate();
	}

	public List<TGAttrRange> findAttrByValue(String value) {
		// TODO Auto-generated method stub
		return getSession().createQuery(//
					"FROM TGAttrRange gar WHERE gar.rangeValue=?")//
					.setParameter(0, value)//
					.list();
	}

}
