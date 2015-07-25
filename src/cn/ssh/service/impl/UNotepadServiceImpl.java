package cn.ssh.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.UNotepad;

import cn.ssh.domain.TUNotepad;
import cn.ssh.service.UNotepadService;
@Service
@Transactional
public class UNotepadServiceImpl implements UNotepadService {

	@Resource
	UNotepad ueventDao;

	public void save(TUNotepad model) {
		// TODO Auto-generated method stub
		ueventDao.save(model);
	}

	public TUNotepad findById(Integer eventId) {
		// TODO Auto-generated method stub
		return ueventDao.findById(eventId);
	}

	public void delete(Integer eventId) {
		// TODO Auto-generated method stub
		ueventDao.delete(eventId);
	}
	
	
}
