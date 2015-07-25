package cn.ssh.domain;

/**
 * TUCollectionContent entity. @author MyEclipse Persistence Tools
 */

public class TUCollectionContent implements java.io.Serializable {

	// Fields

	private Integer id;
	private TGGoods TGGoods;
	private TUCollection TUCollection;

	// Constructors

	/** default constructor */
	public TUCollectionContent() {
	}

	/** full constructor */
	

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	
	public TGGoods getTGGoods() {
		return TGGoods;
	}

	public void setTGGoods(TGGoods tGGoods) {
		TGGoods = tGGoods;
	}

	public TUCollection getTUCollection() {
		return TUCollection;
	}

	public void setTUCollection(TUCollection tUCollection) {
		TUCollection = tUCollection;
	}



}