package cn.ssh.util;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


import cn.ssh.domain.TUPrivilege;
import cn.ssh.service.UPrivilegeService;

public class InitListener implements ServletContextListener {


	public void contextInitialized(ServletContextEvent sce) {
		// 获取容器与相关的Service对象
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		UPrivilegeService privilegeService = (UPrivilegeService) ac.getBean("uprivilegeServiceImpl");

		// 准备数据：topPrivilegeList
		List<TUPrivilege> topPrivilegeList = privilegeService.findTopList();
		sce.getServletContext().setAttribute("topPrivilegeList", topPrivilegeList);
		//System.out.println("------------> 已准备数据 <------------");
		
		//得到需要权限的url列表
		List<String> allPrivilegeList = privilegeService.findAllPrivilege();
		sce.getServletContext().setAttribute("allPrivilegeList", allPrivilegeList);
		for(String url: allPrivilegeList){
			System.out.println("..................."+url);
		}
	}

	public void contextDestroyed(ServletContextEvent arg0) {

	}
}
