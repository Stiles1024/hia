package cn.ssh.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import cn.ssh.base.BaseDaoImpl;
import cn.ssh.dao.GBrandDao;
import cn.ssh.domain.PageBean;
import cn.ssh.domain.TGBrand;
import cn.ssh.domain.TGCategory;
import cn.ssh.domain.TGGoods;
import cn.ssh.util.QueryHelper;
@Repository
public class GBrandDaoImpl extends BaseDaoImpl<TGBrand> implements GBrandDao{

	public List<TGBrand> findRootList() {
		// TODO Auto-generated method stub
		return getSession().createQuery(//
				"FROM TGBrand gb  ")//
				.list();
	}

	public List<TGGoods> findListByBrand(Integer brandId) {
		// TODO Auto-generated method stub
		return getSession().createQuery(//
				"FROM TGGoods goods WHERE goods.TGBrand.brandId=?")//
				.setParameter(0, brandId)//
				.list();
	}

	public List<TGGoods> findListByCat(Integer catId, Integer brandId) {
		// TODO Auto-generated method stub
		return getSession().createQuery(//
				"FROM TGGoods goods WHERE goods.TGCategory.catId=? and goods.TGBrand.brandId=?")//
				.setParameter(0, catId).setParameter(1, brandId)//
				.list();
	}

	public List<TGGoods> findListByAttr(String s, Integer brandId) {
		// TODO Auto-generated method stub
		if(s == null || s.equals("")) {
			return this.findListByBrand(brandId);
		}
		
		String[] array = s.split("_");
		String sq1 = "select * from t_g_goods where brand_id = ";
		String sq2 = " and (not EXISTS(select * from (select * from t_g_attr_range where cat_range_id in (";
		String addition = "";
		for(int i = 0; i < array.length; ++i) {
			addition += "," + array[i]; 
		}
		addition = addition.substring(1);
		String sq = sq1 + brandId + sq2 + addition + ")) as attribute where not EXISTS( select * from t_g_goods_attr  where goods_id=t_g_goods.goods_id and attr_range_id=attribute.cat_range_id)))";
		return getSession().createSQLQuery(sq).addEntity(TGGoods.class).list();
	}

	public List<TGGoods> findListByCatList(List<TGCategory> soncatlist,Integer brandId) {
		// TODO Auto-generated method stub
		String hql = "FROM TGGoods good WHERE good.TGCategory.catId in (";
		String addition = "";
		for(TGCategory tc : soncatlist) {
			addition += "," + tc.getCatId();
		}
		addition = addition.substring(1);
		String hql1 = "and good.TGBrand.brandId=?";//
		hql = hql + addition + ")" + hql1;//
		//System.out.println(hql);
		return getSession().createQuery(hql).setParameter(0, brandId).list();//
	}

	public PageBean getPageBean2(int pageNum, int pageSize, String attrnow, Integer brandId) {
		// TODO Auto-generated method stub
		String s = attrnow;
		String[] array = s.split("_");
		String sq11 = "select * from t_g_goods where brand_id = ";//---
		String sql2 = " and (not EXISTS(select * from (select * from t_g_attr_range where cat_range_id in (";//---
		String addition = "";
		for(int i = 0; i < array.length; ++i) {
			addition += "," + array[i]; 
		}
		addition = addition.substring(1);
		
		String sql = sq11 + brandId + sql2 + addition + ")) as attribute where not EXISTS( select * from t_g_goods_attr  where goods_id=t_g_goods.goods_id and attr_range_id=attribute.cat_range_id)))";
		
		SQLQuery listQuery = getSession().createSQLQuery(sql).addEntity(TGGoods.class);
		listQuery.setFirstResult((pageNum - 1) * pageSize);
		listQuery.setMaxResults(pageSize);
		List list = listQuery.list(); // 执行查询
		
		
		String sq1 = "select count(*) from t_g_goods where brand_id = ";//---
		String sq2 = " and (not EXISTS(select * from (select * from t_g_attr_range where cat_range_id in (";//---
		sql = sq1+ brandId + sq2 + addition + ")) as attribute where not EXISTS( select * from t_g_goods_attr  where goods_id=t_g_goods.goods_id and attr_range_id=attribute.cat_range_id)))";
		SQLQuery countQuery = getSession().createSQLQuery(sql);
		BigInteger count =  (BigInteger)countQuery.uniqueResult(); // 执行查询
		
		return new PageBean(pageNum, pageSize, count.intValue(), list);
	}

	public PageBean getPageBean22(int pageNum, int pageSize, String attrnow,
			Integer brandId) {
		// TODO Auto-generated method stub
		String s = attrnow;
	
		String[] array = s.split("_");
		String sq11 = "select * from t_g_goods where brand_id = ";//---
		String sql2 = " and (not EXISTS(select * from (select * from t_g_attr_range where rangeValue in (";//---
		String addition = "";
		for(int i = 0; i < array.length; ++i) {
			addition += "," +"'"+array[i]+"'"; 
		}
		addition = addition.substring(1);
		
		String sql = sq11 + brandId + sql2 + addition + ")) as attribute where not EXISTS( select * from(select gtr.goods_id,arr.rangeValue from t_g_goods_attr gtr,t_g_attr_range arr where gtr.attr_range_id=arr.cat_range_id) as temp where temp.goods_id=t_g_goods.goods_id and temp.rangeValue=attribute.rangeValue)))";
		
		SQLQuery listQuery = getSession().createSQLQuery(sql).addEntity(TGGoods.class);
		listQuery.setFirstResult((pageNum - 1) * pageSize);
		listQuery.setMaxResults(pageSize);
		List list = listQuery.list(); // 执行查询
		
		
		String sq1 = "select count(*) from t_g_goods where brand_id = ";//---
		String sq2 = " and (not EXISTS(select * from (select * from t_g_attr_range where rangeValue in (";//---
		sql = sq1+ brandId + sq2 + addition + ")) as attribute where not EXISTS( select * from (select gtr.goods_id,arr.rangeValue from t_g_goods_attr gtr,t_g_attr_range arr where gtr.attr_range_id=arr.cat_range_id) as temp where temp.goods_id=t_g_goods.goods_id and temp.rangeValue=attribute.rangeValue)))";
		SQLQuery countQuery = getSession().createSQLQuery(sql);
		BigInteger count =  (BigInteger)countQuery.uniqueResult(); // 执行查询
		
		return new PageBean(pageNum, pageSize, count.intValue(), list);
	}

	public PageBean getPageBean22(int pageNum, int pageSize, String attrnow,
			Integer brandId, Integer cateId) {
		// TODO Auto-generated method stub
		String s = attrnow;
		
		String[] array = s.split("_");
		String sq11 = "select * from t_g_goods where brand_id = ";//---
		String sqlcate=" and cat_id=";
		String sql2 = " and (not EXISTS(select * from (select * from t_g_attr_range where rangeValue in (";//---
		String addition = "";
		for(int i = 0; i < array.length; ++i) {
			addition += "," +"'"+array[i]+"'"; 
		}
		addition = addition.substring(1);
		
		String sql = sq11 + brandId +sqlcate+cateId+ sql2 + addition + ")) as attribute where not EXISTS( select * from(select gtr.goods_id,arr.rangeValue from t_g_goods_attr gtr,t_g_attr_range arr where gtr.attr_range_id=arr.cat_range_id) as temp where temp.goods_id=t_g_goods.goods_id and temp.rangeValue=attribute.rangeValue)))";
		
		SQLQuery listQuery = getSession().createSQLQuery(sql).addEntity(TGGoods.class);
		listQuery.setFirstResult((pageNum - 1) * pageSize);
		listQuery.setMaxResults(pageSize);
		List list = listQuery.list(); // 执行查询
		
		
		String sq1 = "select count(*) from t_g_goods where brand_id = ";//---
		String sq2 = " and (not EXISTS(select * from (select * from t_g_attr_range where rangeValue in (";//---
		sql = sq1+ brandId + sqlcate+cateId+sq2 + addition + ")) as attribute where not EXISTS( select * from (select gtr.goods_id,arr.rangeValue from t_g_goods_attr gtr,t_g_attr_range arr where gtr.attr_range_id=arr.cat_range_id) as temp where temp.goods_id=t_g_goods.goods_id and temp.rangeValue=attribute.rangeValue)))";
		SQLQuery countQuery = getSession().createSQLQuery(sql);
		BigInteger count =  (BigInteger)countQuery.uniqueResult(); // 执行查询
		
		return new PageBean(pageNum, pageSize, count.intValue(), list);
	}

	public List<TGBrand> findListByuser(Integer authorId) {
		// TODO Auto-generated method stub
		String sql1="SELECT * FROM t_g_brand b where exists(	select * from 	(select pg.goods_id,g.brand_id from (select p.pocket_id,c.goods_id from (select * from t_u_pocket where user_id =";
		
		String sql2=") as p,t_u_pocket_content c where p.pocket_id =c.pocket_id)as pg,t_g_goods g where pg.goods_id=g.goods_id)as pb where pb.brand_id=b.brand_id)";
		
		String sql=sql1+authorId+sql2;
		return getSession().createSQLQuery(sql).addEntity(TGBrand.class).list();
	}
	
}
