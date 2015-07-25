package cn.ssh.domain;

import java.util.Date;

/**
 * TGBrandDiscount entity. @author MyEclipse Persistence Tools
 */

public class TGBrandDiscount implements java.io.Serializable {

	// Fields

	private Integer id;
	private TGBrand TGBrand;
	private Date addTime;
	private String discountDesc;

	// Constructors

	/** default constructor */
	public TGBrandDiscount() {
	}

	/** full constructor */
	public TGBrandDiscount(TGBrand TGBrand, Date addTime, String discountDesc) {
		this.TGBrand = TGBrand;
		this.addTime = addTime;
		this.discountDesc = discountDesc;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TGBrand getTGBrand() {
		return this.TGBrand;
	}

	public void setTGBrand(TGBrand TGBrand) {
		this.TGBrand = TGBrand;
	}

	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getDiscountDesc() {
		return this.discountDesc;
	}

	public void setDiscountDesc(String discountDesc) {
		this.discountDesc = discountDesc;
	}

}