package cn.ssh.util;



import cn.ssh.domain.TUUser;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckPrivilegeInterceptor extends AbstractInterceptor {

	public String intercept(ActionInvocation invocation) throws Exception {
		 System.out.println("---------> 之前");
		// String result = invocation.invoke(); // 放行
		// System.out.println("---------> 之后");
		// return result;

		// 获取信息
		TUUser user = (TUUser) ActionContext.getContext().getSession().get("user"); // 当前登录用户
		String namespace = invocation.getProxy().getNamespace();
		String actionName = invocation.getProxy().getActionName();
		String privUrl = namespace + actionName; // 对应的权限URL

		// 如果未登录
		if (user == null) {
			if (privUrl.startsWith("/uuser_login")) { // "/user_loginUI", "/user_login"
				// 如果是去登录，就放行
				return invocation.invoke();
			} else {
				// 如果不是去登录，就转到登录页面
				return "loginUI";
			}
		}
		// 如果已登 录，就判断权限
		else {
			System.out.println("url == " + privUrl);
			System.out.println("user == " + user.getUsername());
			System.out.println("rst == " + user.hasPrivilegeByUrl(privUrl));
			if (user.hasPrivilegeByUrl(privUrl)) {
				// 如果有权限，就放行
				System.out.println("enter");
				return invocation.invoke();
			} else {
				System.out.println("outer");
				// 如果没有权限，就转到提示页面
				return "noPrivilegeError";
			}
		}
	}

}