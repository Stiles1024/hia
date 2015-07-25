package cn.ssh.service;

import java.util.List;

import cn.ssh.domain.PageBean;
import cn.ssh.domain.TUUser;
import cn.ssh.util.QueryHelper;

public interface UUserService {
	void save(TUUser model);
	
	void delete(Integer idt);
	
	TUUser findById(Integer id);
	
	List<TUUser> findAll();

	void update(TUUser user);

	TUUser findByNameAndPassword(String username, String password);

	PageBean getPageBean(int pageNum, int pageSize, QueryHelper qp);

	TUUser findByName(String username);

	TUUser findByNum(String phonenum);

	TUUser findByPhoneOrEmailAndPassword(String phonenum, String password);

	TUUser findByPhoneOrEmail(String phonenum);
}
