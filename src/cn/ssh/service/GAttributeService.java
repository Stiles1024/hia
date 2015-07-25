package cn.ssh.service;

import java.util.List;

import cn.ssh.domain.TGAttribute;
import cn.ssh.domain.TGCategory;

public interface GAttributeService {

	

	List<TGAttribute> findByCat(TGCategory gc);

	void delete(Integer attrId);

	void save(TGAttribute model);

	TGAttribute findById(Integer attrId);

	void update(TGAttribute model);

}
