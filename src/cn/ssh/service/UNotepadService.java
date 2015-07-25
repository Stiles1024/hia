package cn.ssh.service;


import cn.ssh.domain.TUNotepad;

public interface UNotepadService {

	void save(TUNotepad model);

	TUNotepad findById(Integer eventId);

	void delete(Integer eventId);

}
