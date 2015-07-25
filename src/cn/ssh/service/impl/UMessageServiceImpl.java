package cn.ssh.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.UMessageDao;
import cn.ssh.domain.TUMessage;
import cn.ssh.service.UMessageService;

@Service
@Transactional
public class UMessageServiceImpl implements UMessageService {
	@Resource
	UMessageDao umessageDao;

	public void delete(Integer messageId) {
		// TODO Auto-generated method stub
		umessageDao.delete(messageId);
	}

	public void save(TUMessage model) {
		// TODO Auto-generated method stub
		umessageDao.save(model);
	}

	public TUMessage findById(Integer messageId) {
		// TODO Auto-generated method stub
		return umessageDao.findById(messageId);
	}
}
