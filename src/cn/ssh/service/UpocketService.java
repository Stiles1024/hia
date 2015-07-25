package cn.ssh.service;

import cn.ssh.domain.TUPocket;
import cn.ssh.domain.TUUser;

public interface UpocketService {

	TUPocket findByUserAndName(TUUser user, String string);

	void save(TUPocket p1);

}
