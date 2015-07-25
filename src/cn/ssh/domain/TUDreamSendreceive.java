package cn.ssh.domain;

import java.util.Date;

/**
 * TUDreamSendreceive entity. @author MyEclipse Persistence Tools
 */

public class TUDreamSendreceive implements java.io.Serializable {

	// Fields

	private Integer id;
	private TUUser TUUserByUser2Id;//收到该心愿单的用户
	private TUUser TUUserByUserId;//发送该心愿单的用户
	private Date time;
	private TUDream TUDream;

	// Constructors

	/** default constructor */
	public TUDreamSendreceive() {
	}

	/** full constructor */
	public TUDreamSendreceive(TUUser TUUserByUser2Id, TUUser TUUserByUserId,
			Date time) {
		this.TUUserByUser2Id = TUUserByUser2Id;
		this.TUUserByUserId = TUUserByUserId;
		this.time = time;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TUUser getTUUserByUser2Id() {
		return this.TUUserByUser2Id;
	}

	public void setTUUserByUser2Id(TUUser TUUserByUser2Id) {
		this.TUUserByUser2Id = TUUserByUser2Id;
	}

	public TUUser getTUUserByUserId() {
		return this.TUUserByUserId;
	}

	public void setTUUserByUserId(TUUser TUUserByUserId) {
		this.TUUserByUserId = TUUserByUserId;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public TUDream getTUDream() {
		return TUDream;
	}

	public void setTUDream(TUDream tUDream) {
		TUDream = tUDream;
	}

}