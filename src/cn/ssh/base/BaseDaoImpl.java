package cn.ssh.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.ssh.domain.PageBean;
import cn.ssh.util.QueryHelper;

public class BaseDaoImpl<T> implements BaseDao<T>{
	private Class<T> clazz=null;
	public BaseDaoImpl() {
		// 使用反射技术得到T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass(); // 获取当前new的对象的 泛型的父类 类型
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0]; // 获取第一个类型参数的真实类型
		//System.out.println("clazz ---> " + clazz);
	}
	
	@Resource
	SessionFactory sessionFactory;
	
	protected Session  getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public void save(T t) {
		// TODO Auto-generated method stub
		getSession().save(t);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getSession().delete(findById(id));
	}

	public void udate(T t) {
		// TODO Auto-generated method stub
		getSession().update(t);
	}

	public T findById(Integer id) {
		// TODO Auto-generated method stub
		if(id==null)
		{return null;}
		else{
			
			return (T) getSession().get(clazz, id);
		}
		
	}

	public List<T> findByIds(Integer [ ] ids) {
		// TODO Auto-generated method stub
		if(ids==null||ids.length==0){
			return Collections.EMPTY_LIST;
		}
		else 
		return getSession().createQuery(//
				"FROM "+clazz.getSimpleName()+" WHERE id IN (:ids)")//
				.setParameterList("ids", ids)//
				.list();
	}

	public List<T> findAll() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from "+clazz.getSimpleName()).list();
	}

	public PageBean getPageBean(int pageNum, int pageSize, QueryHelper qp) {
		// 参数列表
		List<Object> parameters = qp.getParameters();

		// 查询本页的数据列表
		Query listQuery = getSession().createQuery(qp.getListQueryHql()); // 创建查询对象
		if (parameters != null) { // 设置参数
			for (int i = 0; i < parameters.size(); i++) {
				listQuery.setParameter(i, parameters.get(i));
			}
		}
		listQuery.setFirstResult((pageNum - 1) * pageSize);
		listQuery.setMaxResults(pageSize);
		List list = listQuery.list(); // 执行查询

		// 查询总记录数量
		Query countQuery = getSession().createQuery(qp.getCountQueryHql());
		if (parameters != null) { // 设置参数
			for (int i = 0; i < parameters.size(); i++) {
				countQuery.setParameter(i, parameters.get(i));
			}
		}
		Long count = (Long) countQuery.uniqueResult(); // 执行查询

		return new PageBean(pageNum, pageSize, count.intValue(), list);
	}
	



}
