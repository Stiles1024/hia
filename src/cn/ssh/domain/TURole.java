package cn.ssh.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TURole implements Serializable{
	private Integer roleId;
	private String name;
	private String description;
	private Set<TUPrivilege> privilegs=new HashSet<TUPrivilege>();
	
	private Set<TUUser> users=new HashSet<TUUser>(0);
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Set<TUPrivilege> getPrivilegs() {
		return privilegs;
	}
	public void setPrivilegs(Set<TUPrivilege> privilegs) {
		this.privilegs = privilegs;
	}
	public Set<TUUser> getUsers() {
		return users;
	}
	public void setUsers(Set<TUUser> users) {
		this.users = users;
	}


	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}
