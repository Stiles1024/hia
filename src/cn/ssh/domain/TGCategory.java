package cn.ssh.domain;

import java.util.HashSet;
import java.util.Set;


/**
 * TGCategory entity. @author MyEclipse Persistence Tools
 */

public class TGCategory  implements java.io.Serializable {


    // Fields    

     private Integer catId;
     private TGCategory parent;
     private String catName;
     private String keywords;
     private String catDesc;
    
     private Integer isLeaf;
   
     private Set children = new HashSet(0);
     private Set TGAttributes = new HashSet(0);
     private Set TGGoodses = new HashSet(0);
     private Set TGBrandCates = new HashSet(0);
     
     //is_leaf=0不为叶子节点
     //is_leaf=1为叶子节点
   
 	
    // Constructors

    /** default constructor */
    public TGCategory() {
    }

	/** minimal constructor */
    public TGCategory(String catName, Integer sortOrder, Integer showInNav, Integer isShow, Integer isLeaf) {
        this.catName = catName;
       
        this.isLeaf = isLeaf;
    }
    
    /** full constructor */
    public TGCategory(TGCategory TGCategory, String catName, String keywords, String catDesc, Integer sortOrder, Integer showInNav, Integer isShow, Integer isLeaf, Set TGGoodsCats, Set TGCategories, Set TGAttributes, Set TGGoodses) {
        this.parent = TGCategory;
        this.catName = catName;
        this.keywords = keywords;
        this.catDesc = catDesc;
     
        this.isLeaf = isLeaf;
     
        this.children = TGCategories;
        this.TGAttributes = TGAttributes;
        this.TGGoodses = TGGoodses;
    }

   
    // Property accessors

    public Integer getCatId() {
        return this.catId;
    }
    
    public void setCatId(Integer catId) {
        this.catId = catId;
    }

 

    public String getCatName() {
        return this.catName;
    }
    
    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getKeywords() {
        return this.keywords;
    }
    
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getCatDesc() {
        return this.catDesc;
    }
    
    public void setCatDesc(String catDesc) {
        this.catDesc = catDesc;
    }






    public Integer getIsLeaf() {
        return this.isLeaf;
    }
    
    public void setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
    }




    public Set getTGAttributes() {
        return this.TGAttributes;
    }
    
    public void setTGAttributes(Set TGAttributes) {
        this.TGAttributes = TGAttributes;
    }

    public Set getTGGoodses() {
        return this.TGGoodses;
    }
    
    public void setTGGoodses(Set TGGoodses) {
        this.TGGoodses = TGGoodses;
    }

	public TGCategory getParent() {
		return parent;
	}

	public void setParent(TGCategory parent) {
		this.parent = parent;
	}

	public Set getChildren() {
		return children;
	}

	public void setChildren(Set children) {
		this.children = children;
	}

	public Set getTGBrandCates() {
		return TGBrandCates;
	}

	public void setTGBrandCates(Set tGBrandCates) {
		TGBrandCates = tGBrandCates;
	}
   








}