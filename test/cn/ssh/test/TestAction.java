package cn.ssh.test;


import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class TestAction extends ActionSupport{
	@Resource
	TestService testService; 
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		testService.addTwoUsers();
		System.out.println("TestAction.execute()");
		return "success";
	}

}
