package cn.ssh.dao;

import cn.ssh.base.BaseDao;
import cn.ssh.domain.TGBrand;
import cn.ssh.domain.TGBrandFocus;
import cn.ssh.domain.TUUser;

public interface GBrandFocusDao extends BaseDao<TGBrandFocus> {

	TGBrandFocus findByUserBrand(TUUser user, TGBrand gb);

	void delete(TGBrandFocus bf);

}
