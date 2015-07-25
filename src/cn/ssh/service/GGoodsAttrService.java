package cn.ssh.service;

import java.util.List;

import cn.ssh.domain.TGGoodsAttr;

public interface GGoodsAttrService {

	void save(TGGoodsAttr model);

	void deleteByGoodId(Integer goodsId);

	List<TGGoodsAttr> findListByGoodsId(Integer goodsId);
}
