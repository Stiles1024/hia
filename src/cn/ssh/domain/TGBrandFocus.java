package cn.ssh.domain;

/**
 * TGBrandFocus entity. @author MyEclipse Persistence Tools
 */

public class TGBrandFocus implements java.io.Serializable {

	// Fields

	private Integer id;
	private TUUser TUUser;
	private TGBrand TGBrand;

	// Constructors

	/** default constructor */
	public TGBrandFocus() {
	}

	/** full constructor */
	public TGBrandFocus(TUUser TUUser, TGBrand TGBrand) {
	/*	this.TUUser = TUUser;*/
		this.TGBrand = TGBrand;
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

	public TGBrand getTGBrand() {
		return this.TGBrand;
	}

	public void setTGBrand(TGBrand TGBrand) {
		this.TGBrand = TGBrand;
	}

}