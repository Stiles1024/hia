package cn.ssh.test;


import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ssh.domain.TUUser;


@Service("testService")
public class TestService {
	@Resource
	private SessionFactory sessionFactory;
	@Transactional
	public void addTwoUsers() throws Exception{
		Session session=sessionFactory.getCurrentSession();
		//session.save(new TUUser(24,"shenjie",false,false,22,false,false));
		//session.save(new TUUser("shenjie","mima"));
		//session.save(new User("lilijing"));*/
		System.out.println("......................................");
	}
}
