package cn.ssh.domain;

/**
 * TUDreamContent entity. @author MyEclipse Persistence Tools
 */

public class TUDreamContent implements java.io.Serializable {

	// Fields

	private Integer id;
	private TUDream TUDream;
	private TGGoods TGGoods;
	private String remarks;

	// Constructors

	/** default constructor */
	public TUDreamContent() {
	}

	/** full constructor */
	public TUDreamContent(TUDream TUDream, TGGoods TGGoods, String remarks) {
		this.TUDream = TUDream;
		this.TGGoods = TGGoods;
		this.remarks = remarks;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TUDream getTUDream() {
		return this.TUDream;
	}

	public void setTUDream(TUDream TUDream) {
		this.TUDream = TUDream;
	}

	public TGGoods getTGGoods() {
		return this.TGGoods;
	}

	public void setTGGoods(TGGoods TGGoods) {
		this.TGGoods = TGGoods;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}