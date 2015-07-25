package cn.ssh.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TGGoods entity. @author MyEclipse Persistence Tools
 */

public class TGGoods implements java.io.Serializable {

	// Fields

	private Integer goodsId;
	private TGCategory TGCategory;
	private TGBrand TGBrand;
	private String goodsName;
	private String goodsDesc;
	private String goodsSn;
	private Integer clickCount = 0;
	private double oPrice=0.00;//原价
	private double nPrice=0.00;//现价
	
	

	private String keyword;
	private String goodsBrief;
	private String imgSmall;
	private Date addTime;
	
	private Integer eavCount=0;
	private Integer dreamCount=0;
	private Integer shareCount=0;
	private String gUrl;
	
	
	private Integer isDelete = 0;
	private Integer isBest = 0;
	private Integer isNew = 0;
	private Set TGGoodsAttrs = new HashSet(0);
	private Set TGGoodsImgs = new HashSet(0);
	
	
	private Set TUCollectionContents = new HashSet(0);
	
	
	
  
	private Set TUPocketContents=new HashSet(0);
	private Set TULookContents=new HashSet(0);
	
	private Set TGGoodsEvaluates=new HashSet(0);
	private Set TGGoodsDiscounts=new HashSet(0);
	// Constructors

	

	/** default constructor */
	public TGGoods() {
	}

	/** minimal constructor */
	public TGGoods(TGCategory TGCategory, TGBrand TGBrand, String goodsName,
			String goodsSn, Integer clickCount, double price,
			Integer sortOrder, Integer isDelete, Integer isBest, Integer isNew) {
		this.TGCategory = TGCategory;
		this.TGBrand = TGBrand;
		this.goodsName = goodsName;
		this.goodsSn = goodsSn;
		this.clickCount = clickCount;
	
		
		this.isDelete = isDelete;
		this.isBest = isBest;
		this.isNew = isNew;
	}

	/** full constructor */
	public TGGoods(TGCategory TGCategory, TGBrand TGBrand, String goodsName,
			String goodsDesc, String goodsSn, Integer clickCount, double price,
			String keyword, String goodsBrief, String imgSmall, Date addTime,
			Integer sortOrder, Integer isDelete, Integer isBest, Integer isNew,
			Set TGGoodsAttrs, Set TGGoodsImgs, Set TGGoodsCats,
			Set TGCommentBriefs, Set TUCollectionContents, Set TGCommentLongs) {
		this.TGCategory = TGCategory;
		this.TGBrand = TGBrand;
		this.goodsName = goodsName;
		this.goodsDesc = goodsDesc;
		this.goodsSn = goodsSn;
		this.clickCount = clickCount;
	
		this.keyword = keyword;
		this.goodsBrief = goodsBrief;
		this.imgSmall = imgSmall;
		this.addTime = addTime;
		
		this.isDelete = isDelete;
		this.isBest = isBest;
		this.isNew = isNew;
		this.TGGoodsAttrs = TGGoodsAttrs;
		this.TGGoodsImgs = TGGoodsImgs;
		
		
		this.TUCollectionContents = TUCollectionContents;
		
	}

	// Property accessors

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public TGCategory getTGCategory() {
		return this.TGCategory;
	}

	public void setTGCategory(TGCategory TGCategory) {
		this.TGCategory = TGCategory;
	}

	public TGBrand getTGBrand() {
		return this.TGBrand;
	}

	public void setTGBrand(TGBrand TGBrand) {
		this.TGBrand = TGBrand;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsDesc() {
		return this.goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public String getGoodsSn() {
		return this.goodsSn;
	}

	public void setGoodsSn(String goodsSn) {
		this.goodsSn = goodsSn;
	}

	public Integer getClickCount() {
		return this.clickCount;
	}

	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}

	

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getGoodsBrief() {
		return this.goodsBrief;
	}

	public void setGoodsBrief(String goodsBrief) {
		this.goodsBrief = goodsBrief;
	}

	public String getImgSmall() {
		return this.imgSmall;
	}

	public void setImgSmall(String imgSmall) {
		this.imgSmall = imgSmall;
	}

	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getIsBest() {
		return this.isBest;
	}

	public void setIsBest(Integer isBest) {
		this.isBest = isBest;
	}

	public Integer getIsNew() {
		return this.isNew;
	}

	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}

	public Set getTGGoodsAttrs() {
		return this.TGGoodsAttrs;
	}

	public void setTGGoodsAttrs(Set TGGoodsAttrs) {
		this.TGGoodsAttrs = TGGoodsAttrs;
	}

	public Set getTGGoodsImgs() {
		return this.TGGoodsImgs;
	}

	public void setTGGoodsImgs(Set TGGoodsImgs) {
		this.TGGoodsImgs = TGGoodsImgs;
	}

	



	public Set getTUCollectionContents() {
		return this.TUCollectionContents;
	}

	public void setTUCollectionContents(Set TUCollectionContents) {
		this.TUCollectionContents = TUCollectionContents;
	}

	

	public Set getTUPocketContents() {
		return TUPocketContents;
	}

	public void setTUPocketContents(Set tUPocketContents) {
		TUPocketContents = tUPocketContents;
	}

	public Set getTULookContents() {
		return TULookContents;
	}

	public void setTULookContents(Set tULookContents) {
		TULookContents = tULookContents;
	}

	public Integer getEavCount() {
		return eavCount;
	}

	public void setEavCount(Integer eavCount) {
		this.eavCount = eavCount;
	}

	public Integer getDreamCount() {
		return dreamCount;
	}

	public void setDreamCount(Integer dreamCount) {
		this.dreamCount = dreamCount;
	}

	public Integer getShareCount() {
		return shareCount;
	}

	public void setShareCount(Integer shareCount) {
		this.shareCount = shareCount;
	}

	public String getgUrl() {
		return gUrl;
	}

	public void setgUrl(String gUrl) {
		this.gUrl = gUrl;
	}
	public double getoPrice() {
		return oPrice;
	}

	public void setoPrice(double oPrice) {
		this.oPrice = oPrice;
	}

	public double getnPrice() {
		return nPrice;
	}

	public void setnPrice(double nPrice) {
		this.nPrice = nPrice;
	}

	public Set getTGGoodsEvaluates() {
		return TGGoodsEvaluates;
	}

	public void setTGGoodsEvaluates(Set tGGoodsEvaluates) {
		TGGoodsEvaluates = tGGoodsEvaluates;
	}

	public Set getTGGoodsDiscounts() {
		return TGGoodsDiscounts;
	}

	public void setTGGoodsDiscounts(Set tGGoodsDiscounts) {
		TGGoodsDiscounts = tGGoodsDiscounts;
	}

}