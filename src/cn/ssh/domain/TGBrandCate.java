package cn.ssh.domain;

/**
 * TGBrandCate entity. @author MyEclipse Persistence Tools
 */

public class TGBrandCate implements java.io.Serializable {

	// Fields

	private Integer id;
	private TGCategory TGCategory;
	private TGBrand TGBrand;

	// Constructors

	/** default constructor */
	public TGBrandCate() {
	}

	/** full constructor */
	public TGBrandCate(TGCategory TGCategory, TGBrand TGBrand) {
		this.TGCategory = TGCategory;
		this.TGBrand = TGBrand;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TGCategory getTGCategory() {
		return this.TGCategory;
	}

	public void setTGCategory(TGCategory TGCategory) {
		this.TGCategory = TGCategory;
	}

	public TGBrand getTGBrand() {
		return this.TGBrand;
	}

	public void setTGBrand(TGBrand TGBrand) {
		this.TGBrand = TGBrand;
	}

}