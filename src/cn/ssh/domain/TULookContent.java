package cn.ssh.domain;

/**
 * TULookContent entity. @author MyEclipse Persistence Tools
 */

public class TULookContent implements java.io.Serializable {

	// Fields

	private Integer id;
	private TULook TULook;
	private TGGoods TGGoods;

	// Constructors

	/** default constructor */
	public TULookContent() {
	}

	/** full constructor */
	public TULookContent(TULook TULook, TGGoods TGGoods) {
		this.TULook = TULook;
		this.TGGoods = TGGoods;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TULook getTULook() {
		return this.TULook;
	}

	public void setTULook(TULook TULook) {
		this.TULook = TULook;
	}

	public TGGoods getTGGoods() {
		return this.TGGoods;
	}

	public void setTGGoods(TGGoods TGGoods) {
		this.TGGoods = TGGoods;
	}

}