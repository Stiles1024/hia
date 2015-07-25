package cn.ssh.domain;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;

/**
 * TUUser entity. @author MyEclipse Persistence Tools
 */

public class TUUser implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String img;
	private String email;
	private String password;
	private String phonenum;
	private String username;

	
	private Integer type;
	
	private Date addTime;
	
	private Set TUCollections = new HashSet(0);

	private Set TUMessagesForReceId = new HashSet(0);
	private Set TUMessagesForSendId = new HashSet(0);
	private Set TUTimelines = new HashSet(0);
	
	private Set TUFollowersForUserId = new HashSet(0);
	
	
	private Set TUFollowersForUser2Id = new HashSet(0);
	private Set TUNotepads = new HashSet(0);
	private Set TUSyslogs = new HashSet(0);
	private Set TUPockets = new HashSet(0);
	private Set<TURole> roles=new HashSet<TURole>();
	
	private Set TUFavLookcolls=new HashSet(0);
	private Set TUEvaluateLookcolls=new HashSet(0);
	private Set TUDreams=new HashSet(0);
	private Set TUDreamSends=new HashSet(0);
	private Set TUDreamReces=new HashSet(0);
	private Set TULooks=new HashSet(0);
	
	private Set TGGoodscollShares=new HashSet(0);
	
	private Set TGGoodsEvaluates=new HashSet(0);
	
	private Set TGBrandFocuses=new HashSet(0);
	// Constructors

	//type属性
	public static Integer PERSON=0;
	public static Integer BRAND=1;
	public static Integer ADMIN=2;
	
	/** default constructor */
	public TUUser() {
	}

	/** minimal constructor */
	public TUUser(String password, boolean isdelete, String nickname) {
		this.password = password;
	
	}

	/** full constructor */
	public TUUser(String img, String email, String password, String phonenum,
			String username, String userDesc, Integer newAlbumReply,
			Integer newTieReply, Integer userScore, Integer userGrade,
			Integer type, boolean isdelete, Date addTime,
			String nickname, Set TUCollections, Set TUUserRoles,
			Set TUMessagesForReceId, Set TUMessagesForSendId, Set TUTimelines,
			Set TGCommentLongs, Set TUFollowersForUserId, Set TUReplies,
			Set TGCommentBriefs, Set TUFollowersForUser2Id, Set TUNotepads,
			Set TUSyslogs, Set TUPockets) {
		this.img = img;
		this.email = email;
		this.password = password;
		this.phonenum = phonenum;
		this.username = username;
	
	
		
		this.setType(type);
	
		this.addTime = addTime;
	
		this.TUCollections = TUCollections;
	
		this.TUMessagesForReceId = TUMessagesForReceId;
		this.TUMessagesForSendId = TUMessagesForSendId;
		this.TUTimelines = TUTimelines;
		
		this.TUFollowersForUserId = TUFollowersForUserId;
		
		
		this.TUFollowersForUser2Id = TUFollowersForUser2Id;
		this.TUNotepads = TUNotepads;
		this.TUSyslogs = TUSyslogs;
		this.TUPockets = TUPockets;
	}

	
	public boolean hasPrivilegeByName(String name){
		/*User user=userService.findById(this.getId());*/
		if(this.getUsername().equals("admin"))
			return true;
		else{
				for(TURole role : this.getRoles() ){
					
					for(TUPrivilege p : role.getPrivilegs()){
						
						if(name.equals(p.getName()))
							return true;
					}
				}
				
					return false;
		}
	}
	
public boolean hasPrivilegeByUrl(String privUrl) {
		
		// TODO Auto-generated method stub
	
	
if(this.getUsername().equals("admin"))
				return true;
else{
				// >> 去掉后面的参数
						int pos = privUrl.indexOf("?");
						if (pos > -1) {
							privUrl = privUrl.substring(0, pos);
						}
						// >> 去掉UI后缀
						if (privUrl.endsWith("UI")) {
							privUrl = privUrl.substring(0, privUrl.length() - 2);
						}
				
				// 如果本URL不需要控制，则登录用户就可以使用
				System.out.println("urls");
				Collection<String> urls=(Collection<String>) ActionContext.getContext().getApplication().get("allPrivilegeList");
				System.out.println("urls  ==  " + urls);
				if(!urls.contains(privUrl))
				{
					return true;
				}
				else{
					for(TURole role : this.getRoles() ){
						
						for(TUPrivilege p : role.getPrivilegs()){
							
							if(privUrl.equals(p.getUrl()))
								return true;
						}
					}
					
						return false;
				}
			}
	}
	
	
	
	
	
	// Property accessors



	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhonenum() {
		return this.phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}











	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}



	public Set getTUCollections() {
		return this.TUCollections;
	}

	public void setTUCollections(Set TUCollections) {
		this.TUCollections = TUCollections;
	}



	public Set getTUMessagesForReceId() {
		return this.TUMessagesForReceId;
	}

	public void setTUMessagesForReceId(Set TUMessagesForReceId) {
		this.TUMessagesForReceId = TUMessagesForReceId;
	}

	public Set getTUMessagesForSendId() {
		return this.TUMessagesForSendId;
	}

	public void setTUMessagesForSendId(Set TUMessagesForSendId) {
		this.TUMessagesForSendId = TUMessagesForSendId;
	}

	public Set getTUTimelines() {
		return this.TUTimelines;
	}

	public void setTUTimelines(Set TUTimelines) {
		this.TUTimelines = TUTimelines;
	}



	public Set getTUFollowersForUserId() {
		return this.TUFollowersForUserId;
	}

	public void setTUFollowersForUserId(Set TUFollowersForUserId) {
		this.TUFollowersForUserId = TUFollowersForUserId;
	}





	public Set getTUFollowersForUser2Id() {
		return this.TUFollowersForUser2Id;
	}

	public void setTUFollowersForUser2Id(Set TUFollowersForUser2Id) {
		this.TUFollowersForUser2Id = TUFollowersForUser2Id;
	}

	public Set getTUNotepads() {
		return this.TUNotepads;
	}

	public void setTUNotepads(Set TUNotepads) {
		this.TUNotepads = TUNotepads;
	}

	public Set getTUSyslogs() {
		return this.TUSyslogs;
	}

	public void setTUSyslogs(Set TUSyslogs) {
		this.TUSyslogs = TUSyslogs;
	}

	public Set getTUPockets() {
		return this.TUPockets;
	}

	public void setTUPockets(Set TUPockets) {
		this.TUPockets = TUPockets;
	}

	public Set<TURole> getRoles() {
		return roles;
	}

	public void setRoles(Set<TURole> roles) {
		this.roles = roles;
	}

	public Set getTUFavLookcolls() {
		return TUFavLookcolls;
	}

	public void setTUFavLookcolls(Set tUFavLookcolls) {
		TUFavLookcolls = tUFavLookcolls;
	}

	public Set getTUEvaluateLookcolls() {
		return TUEvaluateLookcolls;
	}

	public void setTUEvaluateLookcolls(Set tUEvaluateLookcolls) {
		TUEvaluateLookcolls = tUEvaluateLookcolls;
	}

	public Set getTUDreams() {
		return TUDreams;
	}

	public void setTUDreams(Set tUDreams) {
		TUDreams = tUDreams;
	}

	public Set getTUDreamSends() {
		return TUDreamSends;
	}

	public void setTUDreamSends(Set tUDreamSends) {
		TUDreamSends = tUDreamSends;
	}

	public Set getTUDreamReces() {
		return TUDreamReces;
	}

	public void setTUDreamReces(Set tUDreamReces) {
		TUDreamReces = tUDreamReces;
	}

	public Set getTULooks() {
		return TULooks;
	}

	public void setTULooks(Set tULooks) {
		TULooks = tULooks;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Set getTGGoodscollShares() {
		return TGGoodscollShares;
	}

	public void setTGGoodscollShares(Set tGGoodscollShares) {
		TGGoodscollShares = tGGoodscollShares;
	}

	public Set getTGGoodsEvaluates() {
		return TGGoodsEvaluates;
	}

	public void setTGGoodsEvaluates(Set tGGoodsEvaluates) {
		TGGoodsEvaluates = tGGoodsEvaluates;
	}

	public Set getTGBrandFocuses() {
		return TGBrandFocuses;
	}

	public void setTGBrandFocuses(Set tGBrandFocuses) {
		TGBrandFocuses = tGBrandFocuses;
	}

	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}