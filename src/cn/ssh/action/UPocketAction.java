package cn.ssh.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.ssh.base.BaseAction;
import cn.ssh.domain.TGBrand;
import cn.ssh.domain.TUPocket;
import cn.ssh.domain.TUUser;
@Controller("uPocketAction")
@Scope("prototype")
public class UPocketAction extends BaseAction<TUPocket>{
		
	private Integer authorId;
	public String show(){
		TUUser author=uuserService.findById(authorId);
		System.out.println(authorId+"--------------------------");
		TUUser user=(TUUser) ActionContext.getContext().getSession().get("user");
		if(user==null){
			
		}
		else{
				List<TGBrand> brandList=gbrandService.findListByUser(authorId);
				for(TGBrand b:brandList){
					System.out.println(b.getBrandName()+"==============");
				}
			
			if(user==author){
				
			}
			else{
				
			}
		}
		return "show";
	}
	
	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

}
