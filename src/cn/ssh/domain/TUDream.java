package cn.ssh.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * TUDream entity. @author MyEclipse Persistence Tools
 */

public class TUDream implements java.io.Serializable {

	// Fields

	private Integer id;
	private TUUser TUUser;
	private String name;
	private String dreamDesc;
	private Integer type;
	public static final Integer BIGDREAM=0;//type=0 则心愿单为大的 总体心愿单
	public static final Integer SMALLDREAM=1;//type=1 则心愿单为小的 后创建的
	private Set TUDreamContents = new HashSet(0);
	private Set TUDreamSendreceives = new HashSet(0);
	

	// Constructors

	/** default constructor */
	public TUDream() {
	}

	/** minimal constructor */
	public TUDream(TUUser TUUser, String name, String dreamDesc) {
		this.TUUser = TUUser;
		this.name = name;
		this.dreamDesc = dreamDesc;
	}

	/** full constructor */
	public TUDream(TUUser TUUser, String name, String dreamDesc,
			Set TUDreamContents) {
		this.TUUser = TUUser;
		this.name = name;
		this.dreamDesc = dreamDesc;
		this.TUDreamContents = TUDreamContents;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TUUser getTUUser() {
		return this.TUUser;
	}

	public void setTUUser(TUUser TUUser) {
		this.TUUser = TUUser;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDreamDesc() {
		return this.dreamDesc;
	}

	public void setDreamDesc(String dreamDesc) {
		this.dreamDesc = dreamDesc;
	}

	public Set getTUDreamContents() {
		return this.TUDreamContents;
	}

	public void setTUDreamContents(Set TUDreamContents) {
		this.TUDreamContents = TUDreamContents;
	}

	public Set getTUDreamSendreceives() {
		return TUDreamSendreceives;
	}

	public void setTUDreamSendreceives(Set tUDreamSendreceives) {
		TUDreamSendreceives = tUDreamSendreceives;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}