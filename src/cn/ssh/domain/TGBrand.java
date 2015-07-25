package cn.ssh.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * TGBrand entity. @author MyEclipse Persistence Tools
 */

public class TGBrand implements java.io.Serializable {

	// Fields

	private Integer brandId;
	private String brandName;
	private String brandBrief;
	private String logo;
	private String sitUrl;
	private Integer focusCount=0;
	
	   private Set TGGoodses = new HashSet(0);
	   private Set TGBrandCates = new HashSet(0);
	  
	   private Set  TGBrandAddresses = new HashSet(0);
	   
	   private Set TGBrandDiscounts = new HashSet(0);
	  
	   private Set  TGBrandFocuses = new HashSet(0);
	// Constructors

	/** default constructor */
	public TGBrand() {
	}

	/** minimal constructor */
	public TGBrand(String brandName, Integer focusCount) {
		this.brandName = brandName;
		this.focusCount = focusCount;
	}

	/** full constructor */
	public TGBrand(String brandName, String brandBrief, String logo,
			String sitUrl, Integer focusCount) {
		this.brandName = brandName;
		this.brandBrief = brandBrief;
		this.logo = logo;
		this.sitUrl = sitUrl;
		this.focusCount = focusCount;
	}

	// Property accessors

	

	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandBrief() {
		return this.brandBrief;
	}

	public void setBrandBrief(String brandBrief) {
		this.brandBrief = brandBrief;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getSitUrl() {
		return this.sitUrl;
	}

	public void setSitUrl(String sitUrl) {
		this.sitUrl = sitUrl;
	}

	public Integer getFocusCount() {
		return this.focusCount;
	}

	public void setFocusCount(Integer focusCount) {
		this.focusCount = focusCount;
	}

	public Set getTGGoodses() {
		return TGGoodses;
	}

	public void setTGGoodses(Set tGGoodses) {
		TGGoodses = tGGoodses;
	}

	public Set getTGBrandCates() {
		return TGBrandCates;
	}

	public void setTGBrandCates(Set tGBrandCates) {
		TGBrandCates = tGBrandCates;
	}

	public Set getTGBrandDiscounts() {
		return TGBrandDiscounts;
	}

	public void setTGBrandDiscounts(Set tGBrandDiscounts) {
		TGBrandDiscounts = tGBrandDiscounts;
	}

	public Set getTGBrandAddresses() {
		return TGBrandAddresses;
	}

	public void setTGBrandAddresses(Set tGBrandAddresses) {
		TGBrandAddresses = tGBrandAddresses;
	}

	public Set getTGBrandFocuses() {
		return TGBrandFocuses;
	}

	public void setTGBrandFocuses(Set tGBrandFocuses) {
		TGBrandFocuses = tGBrandFocuses;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

}