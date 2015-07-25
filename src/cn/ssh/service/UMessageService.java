package cn.ssh.service;

import cn.ssh.domain.TUMessage;

public interface UMessageService {

	void delete(Integer messageId);

	void save(TUMessage model);

	TUMessage findById(Integer messageId);

}
