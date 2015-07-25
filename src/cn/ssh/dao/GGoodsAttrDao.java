package cn.ssh.dao;

import java.util.List;

import cn.ssh.base.BaseDao;
import cn.ssh.domain.TGGoodsAttr;

public interface GGoodsAttrDao extends BaseDao<TGGoodsAttr> {

	void deleteByGoodId(Integer goodsId);

	List<TGGoodsAttr> findListByGoodsId(Integer goodsId);

}
