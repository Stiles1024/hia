package cn.ssh.dao;

import java.util.List;

import cn.ssh.base.BaseDao;
import cn.ssh.domain.TGGoodsImg;

public interface GGoodsImgDao extends BaseDao<TGGoodsImg> {

	List<TGGoodsImg> findListByGoodId(Integer goodsId);

}
