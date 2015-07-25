package cn.ssh.service;

import java.util.List;

import cn.ssh.domain.TGAttrRange;
import cn.ssh.domain.TGAttribute;

public interface GAttrRangeService {

	List<TGAttrRange> findByAttr(TGAttribute ga);

	void delete(Integer catRangeId);

	void save(TGAttrRange model);

	TGAttrRange findById(Integer catRangeId);

	void update(TGAttrRange model);

	public String attr2String(List<TGAttrRange> rangeList);
	
	public List<TGAttrRange> string2RangeList(String s);

	void deleteByGoodId(Integer goodsId);

	List<String> stringToRangeList(String attrnow);

	TGAttribute findAttrByValue(String value);






	//List<TGAttrRange> findListByAttrId(Integer attrId);
}
