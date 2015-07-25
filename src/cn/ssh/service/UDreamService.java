package cn.ssh.service;

import cn.ssh.domain.TUDream;
import cn.ssh.domain.TUUser;

public interface UDreamService {

	TUDream findBDreamByUser(TUUser user, Integer bigdream);

	void save(TUDream dreamBig);

}
