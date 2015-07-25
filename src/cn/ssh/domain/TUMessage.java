package cn.ssh.domain;

import java.util.Date;

/**
 * TUMessage entity. @author MyEclipse Persistence Tools
 */

public class TUMessage implements java.io.Serializable {

	// Fields

	private Integer messageId;
	private TUUser TUUserBySendId;
	private TUUser TUUserByReceId;
	private String content;
	private Integer isRead;
	private Date messageTime;
	private boolean isSys;

	// Constructors

	/** default constructor */
	public TUMessage() {
	}

	/** minimal constructor */
	public TUMessage(TUUser TUUserBySendId, Integer isRead, Date messageTime,
			boolean isSys) {
		this.TUUserBySendId = TUUserBySendId;
		this.isRead = isRead;
		this.messageTime = messageTime;
		this.isSys = isSys;
	}

	/** full constructor */
	public TUMessage(TUUser TUUserBySendId, TUUser TUUserByReceId,
			String content, Integer isRead, Date messageTime, boolean isSys) {
		this.TUUserBySendId = TUUserBySendId;
		this.TUUserByReceId = TUUserByReceId;
		this.content = content;
		this.isRead = isRead;
		this.messageTime = messageTime;
		this.isSys = isSys;
	}

	// Property accessors

	public Integer getMessageId() {
		return this.messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public TUUser getTUUserBySendId() {
		return this.TUUserBySendId;
	}

	public void setTUUserBySendId(TUUser TUUserBySendId) {
		this.TUUserBySendId = TUUserBySendId;
	}

	public TUUser getTUUserByReceId() {
		return this.TUUserByReceId;
	}

	public void setTUUserByReceId(TUUser TUUserByReceId) {
		this.TUUserByReceId = TUUserByReceId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getIsRead() {
		return this.isRead;
	}

	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}

	public Date getMessageTime() {
		return this.messageTime;
	}

	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}

	public boolean getIsSys() {
		return this.isSys;
	}

	public void setIsSys(boolean isSys) {
		this.isSys = isSys;
	}

}