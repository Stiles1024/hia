package cn.ssh.domain;

/**
 * TUFollower entity. @author MyEclipse Persistence Tools
 */

public class TUFollower implements java.io.Serializable {

	// Fields

	private Integer follId;
	private TUUser TUUserByUser2Id;//粉丝
	private TUUser TUUserByUserId;//被关注用户

	// Constructors

	/** default constructor */
	public TUFollower() {
	}

	/** full constructor */
	public TUFollower(TUUser TUUserByUser2Id, TUUser TUUserByUserId) {
		this.TUUserByUser2Id = TUUserByUser2Id;
		this.TUUserByUserId = TUUserByUserId;
	}

	// Property accessors

	public Integer getFollId() {
		return this.follId;
	}

	public void setFollId(Integer follId) {
		this.follId = follId;
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

}