package cn.ssh.domain;

import java.util.Date;

/**
 * TUFavLookcoll entity. @author MyEclipse Persistence Tools
 */

public class TUFavLookcoll implements java.io.Serializable {

	// Fields

	private Integer id;
	private TUUser TUUser;
	private Integer lookCollId;
	private String type;
	private Date time;

	// Constructors

	/** default constructor */
	public TUFavLookcoll() {
	}

	/** full constructor */
	public TUFavLookcoll(TUUser TUUser, Integer lookCollId, String type,
			Date time) {
		this.TUUser = TUUser;
		this.lookCollId = lookCollId;
		this.type = type;
		this.time = time;
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

	public Integer getLookCollId() {
		return this.lookCollId;
	}

	public void setLookCollId(Integer lookCollId) {
		this.lookCollId = lookCollId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}