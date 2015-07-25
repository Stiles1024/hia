package cn.ssh.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;

import cn.ssh.dao.USyslogDao;
import cn.ssh.domain.PageBean;
import cn.ssh.domain.TUSyslog;
import cn.ssh.domain.TUUser;
import cn.ssh.service.USyslogService;
import cn.ssh.util.QueryHelper;


@Service
@Transactional
public class USyslogServiceImpl implements USyslogService{
	@Resource
	USyslogDao USyslogDao;

	public void save(TUSyslog model) {
		// TODO Auto-generated method stub
		USyslogDao.save(model);
	}

	public void delete(Integer idt) {
		// TODO Auto-generated method stub
		USyslogDao.delete(idt);
	}

	public TUSyslog findById(Integer id) {
		// TODO Auto-generated method stub
		return USyslogDao.findById(id);
	}

	public List<TUSyslog> findAll() {
		// TODO Auto-generated method stub
		return USyslogDao.findAll();
	}

	public PageBean getPageBean(int pageNum, int pageSize, QueryHelper qp) {
		// TODO Auto-generated method stub
		return USyslogDao.getPageBean(pageNum, pageSize, qp);
	}
	
	public void addSyslog(String operationName){
		TUUser user=(TUUser)ActionContext.getContext().getSession().get("user");
		TUSyslog log = new TUSyslog();
		log.setTUUser(user);
		log.setPosttime(new Date());
		log.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		log.setContent(operationName);
		USyslogDao.save(log);
	}

}
