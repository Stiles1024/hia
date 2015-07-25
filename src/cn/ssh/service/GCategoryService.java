package cn.ssh.service;

import java.util.List;
import java.util.Map;

import cn.ssh.domain.TGBrand;
import cn.ssh.domain.TGCategory;
import cn.ssh.domain.TGGoods;

public interface GCategoryService {

	TGCategory findById(Integer parentId);

	List<TGCategory> findTopList();

	List<TGCategory> findChildList(Integer parentId);

	void delete(Integer catId);

	void save(TGCategory model);

	void update(TGCategory model);

	List<TGCategory> findRootList();

	TGCategory findByName(String string);

	List<TGBrand> findbListBycate(TGCategory gct);

	void findSelListByNmae(List<TGCategory> seListF, List<TGCategory> allList,
			TGCategory gcF);

	void findMapBySel(List<TGCategory> seListB, List<TGCategory> allList,
			Map<TGCategory, List<TGCategory>> mapF);

	

}
