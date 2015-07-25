package cn.ssh.domain;

import java.util.Date;

/**
 * TUEvaluateLookcoll entity. @author MyEclipse Persistence Tools
 */

public class TUEvaluateLookcoll implements java.io.Serializable {

	// Fields

	private Integer id;
	private TUUser TUUser;
	private Integer lookCollId;
	private Date time;
	private Integer type;

	// Constructors

	/** default constructor */
	public TUEvaluateLookcoll() {
	}

	/** full constructor */
	public TUEvaluateLookcoll(Integer userId, Integer lookCollId, Date time,
			Integer type) {
	
		this.lookCollId = lookCollId;
		this.time = time;
		this.type = type;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public Integer getLookCollId() {
		return this.lookCollId;
	}

	public void setLookCollId(Integer lookCollId) {
		this.lookCollId = lookCollId;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public TUUser getTUUser() {
		return TUUser;
	}

	public void setTUUser(TUUser tUUser) {
		TUUser = tUUser;
	}

}