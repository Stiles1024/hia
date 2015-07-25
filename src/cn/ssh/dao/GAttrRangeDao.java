package cn.ssh.dao;

import java.util.List;

import cn.ssh.base.BaseDao;
import cn.ssh.domain.TGAttrRange;
import cn.ssh.domain.TGAttribute;

public interface GAttrRangeDao extends BaseDao<TGAttrRange>{

	List<TGAttrRange> findByAttr(TGAttribute ga);

	void deleteByGoodId(Integer goodsId);

	List<TGAttrRange> findAttrByValue(String value);

}
