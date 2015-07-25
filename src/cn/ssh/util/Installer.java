package cn.ssh.util;

import javax.annotation.Resource;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.ssh.domain.TUPrivilege;
import cn.ssh.domain.TUPrivilege;
import cn.ssh.domain.TUUser;




import sun.misc.UCDecoder;

@Component

public class Installer {
	
@Resource
SessionFactory sessionFactory;
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		Installer installer=(Installer) ac.getBean("installer");
		installer.install();
		
	}
	@Transactional
		public    void install(){
		Session session=sessionFactory.getCurrentSession();
//		TUUser user=new TUUser();
//		user.setUsername("admin");
//		
//		user.setPassword("admin");
//		session.save(user);
		
		
		//保存权限
		TUPrivilege menu,menu1,menu2,menu3,menu4,menu5,menu6,menu7,menu8;
		
		menu=new TUPrivilege("站内管理",null,null);
		session.save(menu);
		
		menu1=new TUPrivilege("岗位管理","/role_list",menu);
		menu2=new TUPrivilege("添加岗位","/role_add",menu1);
		menu3=new TUPrivilege("删除岗位","/role_delete",menu1);
		menu4=new TUPrivilege("修改岗位","/role_edit",menu1);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(menu4);

		menu1=new TUPrivilege("用户管理","/sysuser_list",menu);
		menu2=new TUPrivilege("添加用户","/sysuser_add",menu1);
		menu3=new TUPrivilege("删除用户","/sysuser_delete",menu1);
		menu4=new TUPrivilege("修改用户","/sysuser_edit",menu1);
		menu5=new TUPrivilege("初始化密码", "/user_initPassword", menu1);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(menu4);
		session.save(menu5);
		
		//=========================================
		
		menu=new TUPrivilege("网上交流",null,null);
		session.save(menu);
		
		menu1=new TUPrivilege("论坛管理","sforumManage_list",menu);
		menu2=new TUPrivilege("论坛","sforum_list",menu);
		session.save(menu1);
		session.save(menu2);
		//=========================================
		menu=new TUPrivilege("产品",null,null);
		session.save(menu);
		menu1=new TUPrivilege("产品管理","ggood_list",menu);
		menu2=new TUPrivilege("品牌管理","gbrand_list",menu);
		menu3=new TUPrivilege("产品分类管理","gcategory_list",menu);
		menu4=new TUPrivilege("新品管理","ggood_newlist",menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(menu4);
		//=========================================
		menu=new TUPrivilege("用户",null,null);
		session.save(menu);
		menu1=new TUPrivilege("用户管理","uuser_list",menu);
		menu2=new TUPrivilege("内容管理","uuser_contents",menu);
		session.save(menu1);
		session.save(menu2);
		//=========================================
		menu=new TUPrivilege("推送管理",null,null);
		session.save(menu);
		menu1=new TUPrivilege("主题管理","stheme_list",menu);
		menu2=new TUPrivilege("消息管理","umessage_list",menu);
		menu3=new TUPrivilege("线上活动",null,menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		//===============================
		menu=new TUPrivilege("管理日志","usyslog_list",null);
		session.save(menu);
	}
}
