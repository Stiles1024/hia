package cn.ssh.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TGGoodsEvaluate entity. @author MyEclipse Persistence Tools
 */

public class TGGoodsEvaluate implements java.io.Serializable {

	// Fields

	private Integer id;
	private TUUser TUUser;
	private TGGoods TGGoods;
	private String content;
	private Date postTime;
	private Set TGGoodsEvaluateImgs = new HashSet(0);

	// Constructors

	/** default constructor */
	public TGGoodsEvaluate() {
	}

	/** minimal constructor */
	public TGGoodsEvaluate(TUUser TUUser, TGGoods TGGoods, Date postTime) {
		this.TUUser = TUUser;
		this.TGGoods = TGGoods;
		this.postTime = postTime;
	}

	/** full constructor */
	public TGGoodsEvaluate(TUUser TUUser, TGGoods TGGoods, String content,
			Date postTime, Set TGGoodsEvaluateImgs) {
		this.TUUser = TUUser;
		this.TGGoods = TGGoods;
		this.content = content;
		this.postTime = postTime;
		this.TGGoodsEvaluateImgs = TGGoodsEvaluateImgs;
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

	public TGGoods getTGGoods() {
		return this.TGGoods;
	}

	public void setTGGoods(TGGoods TGGoods) {
		this.TGGoods = TGGoods;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPostTime() {
		return this.postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public Set getTGGoodsEvaluateImgs() {
		return this.TGGoodsEvaluateImgs;
	}

	public void setTGGoodsEvaluateImgs(Set TGGoodsEvaluateImgs) {
		this.TGGoodsEvaluateImgs = TGGoodsEvaluateImgs;
	}

}