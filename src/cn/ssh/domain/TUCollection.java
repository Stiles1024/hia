package cn.ssh.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TUCollection entity. @author MyEclipse Persistence Tools
 */

public class TUCollection implements java.io.Serializable {

	// Fields

	private Integer collId;
	private TUPocket TUPocket;
	private TUUser TUUser;
	private String name;
	private String collDesc;
	private Integer focusCount=0;
	private Date collTime;
	private Date updateTime;
	
	private Set TUCollectionContents = new HashSet(0);

	// Constructors

	/** default constructor */
	public TUCollection() {
	}

	/** minimal constructor */
	public TUCollection(TUPocket TUPocket, TUUser TUUser, Integer focusCount,
			Date collTime, Date updateTime) {
		this.TUPocket = TUPocket;
		this.TUUser = TUUser;
		this.focusCount = focusCount;
		this.collTime = collTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public TUCollection(TUPocket TUPocket, TUUser TUUser, String name,
			String collDesc, Integer focusCount, Date collTime, Date updateTime) {
		this.TUPocket = TUPocket;
		this.TUUser = TUUser;
		this.name = name;
		this.collDesc = collDesc;
		this.focusCount = focusCount;
		this.collTime = collTime;
		this.updateTime = updateTime;
	}

	// Property accessors

	public Integer getCollId() {
		return this.collId;
	}

	public void setCollId(Integer collId) {
		this.collId = collId;
	}

	public TUPocket getTUPocket() {
		return this.TUPocket;
	}

	public void setTUPocket(TUPocket TUPocket) {
		this.TUPocket = TUPocket;
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

	public String getCollDesc() {
		return this.collDesc;
	}

	public void setCollDesc(String collDesc) {
		this.collDesc = collDesc;
	}

	public Integer getFocusCount() {
		return this.focusCount;
	}

	public void setFocusCount(Integer focusCount) {
		this.focusCount = focusCount;
	}

	public Date getCollTime() {
		return this.collTime;
	}

	public void setCollTime(Date collTime) {
		this.collTime = collTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Set getTUCollectionContents() {
		return TUCollectionContents;
	}

	public void setTUCollectionContents(Set tUCollectionContents) {
		TUCollectionContents = tUCollectionContents;
	}

}