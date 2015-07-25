package cn.ssh.domain;

/**
 * TUPocketContent entity. @author MyEclipse Persistence Tools
 */

public class TUPocketContent implements java.io.Serializable {

	// Fields

	private Integer id;
	private TUPocket TUPocket;
	private TGGoods TGGoods;

	// Constructors

	/** default constructor */
	public TUPocketContent() {
	}

	/** full constructor */
	public TUPocketContent(TUPocket TUPocket, TGGoods TGGoods) {
		this.TUPocket = TUPocket;
		this.TGGoods = TGGoods;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TUPocket getTUPocket() {
		return this.TUPocket;
	}

	public void setTUPocket(TUPocket TUPocket) {
		this.TUPocket = TUPocket;
	}

	public TGGoods getTGGoods() {
		return this.TGGoods;
	}

	public void setTGGoods(TGGoods TGGoods) {
		this.TGGoods = TGGoods;
	}

}