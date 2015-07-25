package cn.ssh.service;

import cn.ssh.domain.TGGoods;
import cn.ssh.domain.TUDream;
import cn.ssh.domain.TUDreamContent;

public interface UDreamContentService {

	TUDreamContent findByDreamAndGoods(TUDream dreamBig, TGGoods model);

	void save(TUDreamContent dc);

	void delete(TUDreamContent dc);

}
