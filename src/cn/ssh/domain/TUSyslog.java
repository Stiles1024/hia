package cn.ssh.domain;

import java.util.Date;

/**
 * TUSyslog entity. @author MyEclipse Persistence Tools
 */

public class TUSyslog implements java.io.Serializable {

	// Fields

	private Integer syslogId;
	private TUUser TUUser;
	private String content;
	private String ipAddr;
	private Date posttime;

	// Constructors

	/** default constructor */
	public TUSyslog() {
	}

	/** full constructor */
	public TUSyslog(TUUser TUUser, String content, String ipAddr, Date posttime) {
		this.TUUser = TUUser;
		this.content = content;
		this.ipAddr = ipAddr;
		this.posttime = posttime;
	}

	// Property accessors

	public Integer getSyslogId() {
		return this.syslogId;
	}

	public void setSyslogId(Integer syslogId) {
		this.syslogId = syslogId;
	}

	public TUUser getTUUser() {
		return this.TUUser;
	}

	public void setTUUser(TUUser TUUser) {
		this.TUUser = TUUser;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIpAddr() {
		return this.ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public Date getPosttime() {
		return this.posttime;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}

}