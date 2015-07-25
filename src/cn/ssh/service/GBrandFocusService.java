package cn.ssh.service;

import cn.ssh.domain.TGBrand;
import cn.ssh.domain.TGBrandFocus;
import cn.ssh.domain.TUUser;

public interface GBrandFocusService {

	void save(TGBrandFocus bf);

	TGBrandFocus findByUserBrand(TUUser user, TGBrand gb);

	void delete(TGBrandFocus bf);

}
