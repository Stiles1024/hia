package cn.ssh.service;

import java.util.List;

import cn.ssh.domain.TGGoods;
import cn.ssh.domain.TGGoodsImg;

public interface GGoodsImgService {

	List<TGGoodsImg> findListByGoodId(Integer goodsId);

	void save(TGGoodsImg goodimg);

	TGGoodsImg findById(Integer imgid);

	void delete(Integer imgid);



}
