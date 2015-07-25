package cn.ssh.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * TUPocket entity. @author MyEclipse Persistence Tools
 */

public class TUPocket implements java.io.Serializable {

	// Fields

	private Integer pocketId;
	private TUUser TUUser;
	private String pocketName;
	private Set TUCollections = new HashSet(0);
	private Set TUPocketContents = new HashSet(0);
	// Constructors

	/** default constructor */
	public TUPocket() {
	}

	/** full constructor */
	public TUPocket(TUUser TUUser, String pocketName) {
		this.TUUser = TUUser;
		this.pocketName = pocketName;
	}

	// Property accessors

	public Integer getPocketId() {
		return this.pocketId;
	}

	public void setPocketId(Integer pocketId) {
		this.pocketId = pocketId;
	}

	public TUUser getTUUser() {
		return this.TUUser;
	}

	public void setTUUser(TUUser TUUser) {
		this.TUUser = TUUser;
	}

	public String getPocketName() {
		return this.pocketName;
	}

	public void setPocketName(String pocketName) {
		this.pocketName = pocketName;
	}

	public Set getTUCollections() {
		return TUCollections;
	}

	public void setTUCollections(Set tUCollections) {
		TUCollections = tUCollections;
	}

	public Set getTUPocketContents() {
		return TUPocketContents;
	}

	public void setTUPocketContents(Set tUPocketContents) {
		TUPocketContents = tUPocketContents;
	}

}