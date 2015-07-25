package cn.ssh.base;

import java.util.List;

import cn.ssh.domain.PageBean;
import cn.ssh.util.QueryHelper;

public interface BaseDao<T> {
	
		void save(T t);
		
		void delete(Integer idt);
		
		void udate(T t);
		
		T findById(Integer id);
		
		List<T>findByIds(Integer [ ] ids);
		
		List<T>findAll();
		PageBean getPageBean(int pageNum, int pageSize, QueryHelper qp);

}
