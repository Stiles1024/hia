package cn.ssh.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * TGAttribute entity. @author MyEclipse Persistence Tools
 */

public class TGAttribute implements java.io.Serializable {

	// Fields

	private Integer attrId;
	private TGCategory TGCategory;
	private String attrName;

	private Set TGAttrRanges = new HashSet(0);

	// Constructors

	/** default constructor */
	public TGAttribute() {
	}

	/** minimal constructor */
	public TGAttribute(TGCategory TGCategory, String attrName,
			Integer attrInputType) {
		this.TGCategory = TGCategory;
		this.attrName = attrName;
		
	}

	/** full constructor */
	public TGAttribute(TGCategory TGCategory, String attrName,
			Integer attrInputType, Set TGAttrRanges) {
		this.TGCategory = TGCategory;
		this.attrName = attrName;
	
		this.TGAttrRanges = TGAttrRanges;
	}

	// Property accessors

	public Integer getAttrId() {
		return this.attrId;
	}

	public void setAttrId(Integer attrId) {
		this.attrId = attrId;
	}

	public TGCategory getTGCategory() {
		return this.TGCategory;
	}

	public void setTGCategory(TGCategory TGCategory) {
		this.TGCategory = TGCategory;
	}

	public String getAttrName() {
		return this.attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}



	public Set getTGAttrRanges() {
		return this.TGAttrRanges;
	}

	public void setTGAttrRanges(Set TGAttrRanges) {
		this.TGAttrRanges = TGAttrRanges;
	}

}