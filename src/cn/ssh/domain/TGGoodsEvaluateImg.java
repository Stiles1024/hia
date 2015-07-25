package cn.ssh.domain;

/**
 * TGGoodsEvaluateImg entity. @author MyEclipse Persistence Tools
 */

public class TGGoodsEvaluateImg implements java.io.Serializable {

	// Fields

	private Integer id;
	private TGGoodsEvaluate TGGoodsEvaluate;
	private String imgUrl;

	// Constructors

	/** default constructor */
	public TGGoodsEvaluateImg() {
	}

	/** full constructor */
	public TGGoodsEvaluateImg(TGGoodsEvaluate TGGoodsEvaluate, String imgUrl) {
		this.TGGoodsEvaluate = TGGoodsEvaluate;
		this.imgUrl = imgUrl;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TGGoodsEvaluate getTGGoodsEvaluate() {
		return this.TGGoodsEvaluate;
	}

	public void setTGGoodsEvaluate(TGGoodsEvaluate TGGoodsEvaluate) {
		this.TGGoodsEvaluate = TGGoodsEvaluate;
	}

	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}