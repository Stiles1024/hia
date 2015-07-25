package cn.ssh.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * TGAttrRange entity. @author MyEclipse Persistence Tools
 */

public class TGAttrRange implements java.io.Serializable {

	// Fields

	private Integer catRangeId;
	private TGAttribute TGAttribute;
	private String rangeValue;
	private Set TGGoodsAttrs = new HashSet(0);

	// Constructors

	/** default constructor */
	public TGAttrRange() {
	}

	/** minimal constructor */
	public TGAttrRange(TGAttribute TGAttribute, String value) {
		this.TGAttribute = TGAttribute;
		
	}

	/** full constructor */
	public TGAttrRange(TGAttribute TGAttribute, String value, Set TGGoodsAttrs) {
		this.TGAttribute = TGAttribute;
	
		this.TGGoodsAttrs = TGGoodsAttrs;
	}

	// Property accessors

	public Integer getCatRangeId() {
		return this.catRangeId;
	}

	public void setCatRangeId(Integer catRangeId) {
		this.catRangeId = catRangeId;
	}

	public TGAttribute getTGAttribute() {
		return this.TGAttribute;
	}

	public void setTGAttribute(TGAttribute TGAttribute) {
		this.TGAttribute = TGAttribute;
	}



	public Set getTGGoodsAttrs() {
		return this.TGGoodsAttrs;
	}

	public void setTGGoodsAttrs(Set TGGoodsAttrs) {
		this.TGGoodsAttrs = TGGoodsAttrs;
	}

	public String getRangeValue() {
		return rangeValue;
	}

	public void setRangeValue(String rangeValue) {
		this.rangeValue = rangeValue;
	}

}