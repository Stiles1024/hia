package cn.ssh.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TUPrivilege implements Serializable{
	
	private Integer privilegeId;
	private String name;
	private String url;
	
	public TUPrivilege(){
		
	}
	public TUPrivilege(String name, String url, TUPrivilege parent) {
		super();
		this.name = name;
		this.url = url;
		this.parent = parent;
	}
	private Set<TURole> roles=new HashSet<TURole>();
	private TUPrivilege parent;
	private Set<TUPrivilege> children=new HashSet<TUPrivilege>();
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public TUPrivilege getParent() {
		return parent;
	}
	public void setParent(TUPrivilege parent) {
		this.parent = parent;
	}
	public Set<TUPrivilege> getChildren() {
		return children;
	}
	public void setChildren(Set<TUPrivilege> children) {
		this.children = children;
	}

	public Set<TURole> getRoles() {
		return roles;
	}
	public void setRoles(Set<TURole> roles) {
		this.roles = roles;
	}

	public Integer getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(Integer privilegeId) {
		this.privilegeId = privilegeId;
	}
	

}
