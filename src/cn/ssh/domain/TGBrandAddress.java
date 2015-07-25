package cn.ssh.domain;

/**
 * TGBrandAddress entity. @author MyEclipse Persistence Tools
 */

public class TGBrandAddress implements java.io.Serializable {

	// Fields

	private Integer id;
	private TGBrand TGBrand;
	private String shopName;
	private String address;
	private String province;
	private String city;

	// Constructors

	/** default constructor */
	public TGBrandAddress() {
	}

	/** minimal constructor */
	public TGBrandAddress(TGBrand TGBrand) {
		this.TGBrand = TGBrand;
	}

	/** full constructor */
	public TGBrandAddress(TGBrand TGBrand, String shopName, String address,
			String province, String city) {
		this.TGBrand = TGBrand;
		this.shopName = shopName;
		this.address = address;
		this.province = province;
		this.city = city;
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

	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}