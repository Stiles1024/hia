package cn.ssh.domain;

import java.util.Date;

/**
 * TGGoodsDiscount entity. @author MyEclipse Persistence Tools
 */

public class TGGoodsDiscount implements java.io.Serializable {

	// Fields

	private Integer id;
	private TGGoods TGGoods;
	private double oldPrice;
	private double nowPrice;
	private Date occurTime;
	private String discountDesc;

	// Constructors

	/** default constructor */
	public TGGoodsDiscount() {
	}

	/** minimal constructor */
	public TGGoodsDiscount(Integer goodsId, double oldPrice, double nowPrice,
			Date occurTime) {
	
		this.oldPrice = oldPrice;
		this.nowPrice = nowPrice;
		this.occurTime = occurTime;
	}

	/** full constructor */
	public TGGoodsDiscount(Integer goodsId, double oldPrice, double nowPrice,
			Date occurTime, String discountDesc) {
		
		this.oldPrice = oldPrice;
		this.nowPrice = nowPrice;
		this.occurTime = occurTime;
		this.discountDesc = discountDesc;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public double getOldPrice() {
		return this.oldPrice;
	}

	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}

	public double getNowPrice() {
		return this.nowPrice;
	}

	public void setNowPrice(double nowPrice) {
		this.nowPrice = nowPrice;
	}

	public Date getOccurTime() {
		return this.occurTime;
	}

	public void setOccurTime(Date occurTime) {
		this.occurTime = occurTime;
	}

	public String getDiscountDesc() {
		return this.discountDesc;
	}

	public void setDiscountDesc(String discountDesc) {
		this.discountDesc = discountDesc;
	}

	public TGGoods getTGGoods() {
		return TGGoods;
	}

	public void setTGGoods(TGGoods tGGoods) {
		TGGoods = tGGoods;
	}

}