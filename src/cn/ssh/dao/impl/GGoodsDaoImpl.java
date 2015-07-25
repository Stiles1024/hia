package cn.ssh.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import cn.ssh.base.BaseDaoImpl;
import cn.ssh.dao.GGoodsDao;
import cn.ssh.domain.PageBean;
import cn.ssh.domain.TGAttrRange;
import cn.ssh.domain.TGCategory;
import cn.ssh.domain.TGGoods;
import cn.ssh.util.QueryHelper;
@Repository
public class GGoodsDaoImpl extends BaseDaoImpl<TGGoods> implements GGoodsDao {

	public List<TGGoods> findListByCat(Integer catId) {
		// TODO Auto-generated method stub
		return getSession().createQuery(//
				"FROM TGGoods good WHERE good.TGCategory.catId=?")//
				.setParameter(0, catId)//
				.list();
	}
	
	

	public List<TGGoods> findListByAttr(String s) {
		// TODO Auto-generated method stub
		//return null;
		
		/*if(s == null || s.equals("")) {
			return this.findAll();
		}
		
		String[] array = s.split("_");
		String hql = "Select TGGoods FROM TGGoodsAttr ga WHERE ga.TGAttrRange.catRangeId in (";
		String addition = "";
		for(int i = 0; i < array.length; ++i) {
			addition += ",'" + array[i] + "'"; 
		}
		addition = addition.substring(1);
		hql = hql + addition + ")";
		
		String sq = "select * from t_g_goods where not EXISTS(select * from (select * from t_g_attr_range where cat_range_id in (2,4)) as attribute where not EXISTS( select * from t_g_goods_attr  where goods_id=t_g_goods.goods_id and attr_range_id=attribute.cat_range_id))";
		List<TGGoods> goodsid = (List<TGGoods>)getSession().createSQLQuery(sq).addEntity(TGGoods.class).list();
		for(TGGoods i:goodsid) {
			System.out.println("goodsid == " + i.getGoodsId());
		}
		return getSession().createQuery(hql).list();
		*/
		
		//sql  ok!
		
		if(s == null || s.equals("")) {
			return this.findAll();
		}
		
		String[] array = s.split("_");
		String sq = "select * from t_g_goods where not EXISTS(select * from (select * from t_g_attr_range where cat_range_id in (";
		String addition = "";
		for(int i = 0; i < array.length; ++i) {
			addition += "," + array[i]; 
		}
		addition = addition.substring(1);
		
		sq = sq + addition + ")) as attribute where not EXISTS( select * from t_g_goods_attr  where goods_id=t_g_goods.goods_id and attr_range_id=attribute.cat_range_id))";
		
		return getSession().createSQLQuery(sq).addEntity(TGGoods.class).list();
		
		
		
		/*String[] array = s.split("_");
		String hql = "Select TGGoods FROM TGGoodsAttr ga WHERE ga.TGAttrRange.catRangeId in (";
		String addition = "";
		for(int i = 0; i < array.length; ++i) {
			addition += ",'" + array[i] + "'"; 
		}
		addition = addition.substring(1);
		String hq = "Select TGGoods FROM TGGoodsAttr ga WHERE NOT EXISTS ( SELECT * FROM (SELECT * FROM TGAttribute WHERE attrId in(" + 
			addition + ")) attribute WHERE NOT EXISTS (SELECT * FROM TGGoodsAttr gsr where gsr.TGGoods.goodsId = ga.TGGoods.goodsId AND gsr.goodsAttrId = attribute.goodsAttrId))";
		System.out.println("hql == " + hq);
		return getSession().createQuery(hq).list();*/
		
	}
	
	public List<Integer> findListByAttr2(String s) {
		
		String[] array = s.split("_");
		String sq = "select goods_id from t_g_goods where not EXISTS(select * from (select * from t_g_attr_range where cat_range_id in (";
		String addition = "";
		for(int i = 0; i < array.length; ++i) {
			addition += "," + array[i]; 
		}
		addition = addition.substring(1);
		sq = sq + addition + ")) as attribute where not EXISTS( select * from t_g_goods_attr  where goods_id=t_g_goods.goods_id and attr_range_id=attribute.cat_range_id))";
		return getSession().createSQLQuery(sq).list();
	}

	public List<TGGoods> findListByCatList(List<TGCategory> soncatlist) {
		// TODO Auto-generated method stub
		String hql = "FROM TGGoods good WHERE good.TGCategory.catId in (";
		String addition = "";
		for(TGCategory tc : soncatlist) {
			addition += "," + tc.getCatId();
		}
		addition = addition.substring(1);
		hql = hql + addition + ")";
		//System.out.println(hql);
		return getSession().createQuery(hql).list();
	}



	public PageBean getPageBean2(int pageNum, int pageSize,
			String attrnow) {
		// TODO Auto-generated method stub
		String s = attrnow;
		String[] array = s.split("_");
		String sq1 = "select * from t_g_goods where not EXISTS(select * from (select * from t_g_attr_range where cat_range_id in (";
		String addition = "";
		for(int i = 0; i < array.length; ++i) {
			addition += "," + array[i]; 
		}
		addition = addition.substring(1);
		
		String sql = sq1 + addition + ")) as attribute where not EXISTS( select * from t_g_goods_attr  where goods_id=t_g_goods.goods_id and attr_range_id=attribute.cat_range_id))";
		
		SQLQuery listQuery = getSession().createSQLQuery(sql).addEntity(TGGoods.class);
		listQuery.setFirstResult((pageNum - 1) * pageSize);
		listQuery.setMaxResults(pageSize);
		List list = listQuery.list(); // 执行查询
		
		
		String sq2 = "select count(*) from t_g_goods where not EXISTS(select * from (select * from t_g_attr_range where cat_range_id in (";
		sql = sq2 + addition + ")) as attribute where not EXISTS( select * from t_g_goods_attr  where goods_id=t_g_goods.goods_id and attr_range_id=attribute.cat_range_id))";
		SQLQuery countQuery = getSession().createSQLQuery(sql);
		BigInteger count =  (BigInteger)countQuery.uniqueResult(); // 执行查询
		
		return new PageBean(pageNum, pageSize, count.intValue(), list);
		//return getSession().createSQLQuery(sq).addEntity(TGGoods.class).list();
	}
	

	
}
