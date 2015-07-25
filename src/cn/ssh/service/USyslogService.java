package cn.ssh.service;

import java.util.List;

import cn.ssh.domain.PageBean;
import cn.ssh.domain.TUSyslog;
import cn.ssh.util.QueryHelper;

public interface USyslogService {

	void save(TUSyslog model);
	
	void delete(Integer idt);
	
	TUSyslog findById(Integer id);
	
	List<TUSyslog> findAll();

	PageBean getPageBean(int pageNum, int pageSize, QueryHelper qp);

	void addSyslog(String string);
	
}
