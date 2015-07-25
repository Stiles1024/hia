package cn.ssh.domain;

import java.util.Date;

/**
 * TUNotepad entity. @author MyEclipse Persistence Tools
 */

public class TUNotepad implements java.io.Serializable {

	// Fields

	private Integer eventId;
	private TUUser TUUser;
	private Date occurTime;
	private String context;
	private Integer type;

	// Constructors

	/** default constructor */
	public TUNotepad() {
	}

	/** full constructor */
	public TUNotepad(TUUser TUUser, Date occurTime, String context, Integer type) {
		this.TUUser = TUUser;
		this.occurTime = occurTime;
		this.context = context;
		this.type = type;
	}

	// Property accessors

	public Integer getEventId() {
		return this.eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public TUUser getTUUser() {
		return this.TUUser;
	}

	public void setTUUser(TUUser TUUser) {
		this.TUUser = TUUser;
	}

	public Date getOccurTime() {
		return this.occurTime;
	}

	public void setOccurTime(Date occurTime) {
		this.occurTime = occurTime;
	}

	public String getContext() {
		return this.context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}