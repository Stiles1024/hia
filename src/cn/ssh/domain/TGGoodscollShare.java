package cn.ssh.domain;

import java.util.Date;

/**
 * TGGoodscollShare entity. @author MyEclipse Persistence Tools
 */

public class TGGoodscollShare implements java.io.Serializable {

	// Fields

	private Integer id;
	private TUUser TUUser;
	private Integer goodsCollId;//goodsId h或者collectionId
	private String sharePf;
	private Date shareTime;
	private Integer type;//0为goods 1为 collection

	// Constructors

	/** default constructor */
	public TGGoodscollShare() {
	}

	/** full constructor */
	public TGGoodscollShare(TUUser TUUser, Integer goodsCollId, String sharePf,
			Date shareTime, Integer type) {
		this.TUUser = TUUser;
		this.goodsCollId = goodsCollId;
		this.sharePf = sharePf;
		this.shareTime = shareTime;
		this.type = type;
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

	public Integer getGoodsCollId() {
		return this.goodsCollId;
	}

	public void setGoodsCollId(Integer goodsCollId) {
		this.goodsCollId = goodsCollId;
	}

	public String getSharePf() {
		return this.sharePf;
	}

	public void setSharePf(String sharePf) {
		this.sharePf = sharePf;
	}

	public Date getShareTime() {
		return this.shareTime;
	}

	public void setShareTime(Date shareTime) {
		this.shareTime = shareTime;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}