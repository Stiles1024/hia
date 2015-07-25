package cn.ssh.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * TULook entity. @author MyEclipse Persistence Tools
 */

public class TULook implements java.io.Serializable {

	// Fields

	private Integer id;
	private TUUser TUUser;
	private String lookDesc;
	private String lookImg;
	private Integer likeCount;
	private Integer replyCount;
	private Set TULookContents = new HashSet(0);

	// Constructors

	/** default constructor */
	public TULook() {
	}

	/** minimal constructor */
	public TULook(TUUser TUUser, String lookDesc, String lookImg,
			Integer likeCount, Integer replyCount) {
		this.TUUser = TUUser;
		this.lookDesc = lookDesc;
		this.lookImg = lookImg;
		this.likeCount = likeCount;
		this.replyCount = replyCount;
	}

	/** full constructor */
	public TULook(TUUser TUUser, String lookDesc, String lookImg,
			Integer likeCount, Integer replyCount, Set TULookContents) {
		this.TUUser = TUUser;
		this.lookDesc = lookDesc;
		this.lookImg = lookImg;
		this.likeCount = likeCount;
		this.replyCount = replyCount;
		this.TULookContents = TULookContents;
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

	public String getLookDesc() {
		return this.lookDesc;
	}

	public void setLookDesc(String lookDesc) {
		this.lookDesc = lookDesc;
	}

	public String getLookImg() {
		return this.lookImg;
	}

	public void setLookImg(String lookImg) {
		this.lookImg = lookImg;
	}

	public Integer getLikeCount() {
		return this.likeCount;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	public Integer getReplyCount() {
		return this.replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	public Set getTULookContents() {
		return this.TULookContents;
	}

	public void setTULookContents(Set TULookContents) {
		this.TULookContents = TULookContents;
	}

}