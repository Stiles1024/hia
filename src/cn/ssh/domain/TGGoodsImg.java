package cn.ssh.domain;

/**
 * TGGoodsImg entity. @author MyEclipse Persistence Tools
 */

public class TGGoodsImg implements java.io.Serializable {

	// Fields

	private Integer goodsImgId;
	private TGGoods TGGoods;
	private String value;

	// Constructors

	/** default constructor */
	public TGGoodsImg() {
	}

	/** minimal constructor */
	public TGGoodsImg(TGGoods TGGoods) {
		this.TGGoods = TGGoods;
	}

	/** full constructor */
	public TGGoodsImg(TGGoods TGGoods, String value) {
		this.TGGoods = TGGoods;
		this.value = value;
	}

	// Property accessors

	public Integer getGoodsImgId() {
		return this.goodsImgId;
	}

	public void setGoodsImgId(Integer goodsImgId) {
		this.goodsImgId = goodsImgId;
	}

	public TGGoods getTGGoods() {
		return this.TGGoods;
	}

	public void setTGGoods(TGGoods TGGoods) {
		this.TGGoods = TGGoods;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}