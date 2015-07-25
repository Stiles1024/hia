package cn.ssh.domain;

/**
 * TGGoodsAttr entity. @author MyEclipse Persistence Tools
 */

public class TGGoodsAttr implements java.io.Serializable {

	// Fields

	private Integer goodsAttrId;
	private TGGoods TGGoods;
	private TGAttrRange TGAttrRange;

	// Constructors

	/** default constructor */
	public TGGoodsAttr() {
	}

	/** full constructor */
	public TGGoodsAttr(TGGoods TGGoods, TGAttrRange TGAttrRange) {
		this.TGGoods = TGGoods;
		this.TGAttrRange = TGAttrRange;
	}

	// Property accessors

	public Integer getGoodsAttrId() {
		return this.goodsAttrId;
	}

	public void setGoodsAttrId(Integer goodsAttrId) {
		this.goodsAttrId = goodsAttrId;
	}

	public TGGoods getTGGoods() {
		return this.TGGoods;
	}

	public void setTGGoods(TGGoods TGGoods) {
		this.TGGoods = TGGoods;
	}

	public TGAttrRange getTGAttrRange() {
		return this.TGAttrRange;
	}

	public void setTGAttrRange(TGAttrRange TGAttrRange) {
		this.TGAttrRange = TGAttrRange;
	}

}