package cn.ssh.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.GBrandDao;
import cn.ssh.domain.PageBean;
import cn.ssh.domain.TGBrand;
import cn.ssh.domain.TGBrandCate;
import cn.ssh.domain.TGCategory;
import cn.ssh.domain.TGGoods;
import cn.ssh.service.GBrandService;
import cn.ssh.util.QueryHelper;
@Service
@Transactional
public class GBrandServiceImpl implements GBrandService{

	@Resource
	GBrandDao gbrandDao;
	
	public TGBrand findById(Integer parentId) {
		// TODO Auto-generated method stub
		return gbrandDao.findById(parentId);
	}
	
	public void delete(Integer catId) {
		// TODO Auto-generated method stub
		gbrandDao.delete(catId);
	}

	public void save(TGBrand model) {
		// TODO Auto-generated method stub
		gbrandDao.save(model);
	}

	public void update(TGBrand model) {
		// TODO Auto-generated method stub
		gbrandDao.udate(model);
	}

	public List<TGBrand> findRootList() {
		// TODO Auto-generated method stub
		return gbrandDao.findRootList();
	}

	public List<TGBrand> findAll() {
		// TODO Auto-generated method stub
		return gbrandDao.findAll();
	}
	
	public List<TGGoods> findListByBrand(Integer brandId) {
		// TODO Auto-generated method stub
		return gbrandDao.findListByBrand(brandId);
	}

	public List<TGGoods> findListByCat(Integer catId, Integer brandId) {
		// TODO Auto-generated method stub
		return gbrandDao.findListByCat(catId,brandId);
	}

	public List<TGGoods> findListByAttr(String s, Integer brandId) {
		// TODO Auto-generated method stub
		return gbrandDao.findListByAttr(s,brandId);
	}

	public List<TGGoods> findListByCatlist(List<TGCategory> soncatlist,Integer brandId) {
		// TODO Auto-generated method stub
		return gbrandDao.findListByCatList(soncatlist,brandId);
	}

	public PageBean getPageBean(int pageNum, int pageSize, String attrnow,Integer brandId) {
		// TODO Auto-generated method stub
		return gbrandDao.getPageBean2(pageNum, pageSize, attrnow, brandId);
	}
	
	public PageBean getPageBean(int pageNum, int pageSize, QueryHelper qp) {
		// TODO Auto-generated method stub
		return gbrandDao.getPageBean(pageNum,  pageSize, qp);
	}

	public List<TGCategory> findCates(TGBrand gbrand) {
		// TODO Auto-generated method stub
		Collection<TGBrandCate> gbcatelist= gbrand.getTGBrandCates();
		List<TGCategory>cateList = new ArrayList<TGCategory>();
		for(TGBrandCate gbc :gbcatelist){
			cateList.add(gbc.getTGCategory());
		}
		return cateList;
	}

	public void findList(List<TGBrand> fList, List<TGBrand> fListNum,
			List<TGBrand> fListCH, List<TGBrand> fListEN) {
		// TODO Auto-generated method stub
		int ascNum;
		for(TGBrand gb : fList){
			byte[] gc=gb.getBrandName().getBytes();
			ascNum = (int) gc[0];
			//System.out.println("Nmae="+gb.getBrandName());
			//System.out.println("ascNUm=================="+ascNum);
			if((ascNum>=48)&&(ascNum<=57)){
				fListNum.add(gb);
			}
			else{
				if((ascNum >=65)&&(ascNum<=122)){
					fListEN.add(gb);
				}
				else {
					fListCH.add(gb);
				}
			}
			
			
		}
	}

	public void findMap(List<TGBrand> fListEN, Map<String, List<TGBrand>> mapF) {
		// TODO Auto-generated method stub
		int ascNum;
		for(int i=65;i<=90;i++){
			for(TGBrand gb:fListEN)
			{
				byte[] gc=gb.getBrandName().getBytes();
				ascNum = (int) gc[0];
				if((ascNum==i)||(ascNum==i+32)){
					String al=String.valueOf(gb.getBrandName().charAt(0)).toUpperCase();
					if(mapF.containsKey(al)){
						mapF.get(al).add(gb);
					}
					else{
						List<TGBrand> temp=new ArrayList<TGBrand>();
						temp.add(gb);
						mapF.put(al, temp);
					}
					
				}
			}
		}
	}

	public PageBean getPageBean2(int pageNum, int pageSize, String attrnow,
			Integer brandId) {
		// TODO Auto-generated method stub
		return gbrandDao.getPageBean22(pageNum, pageSize, attrnow, brandId);
	}

	public PageBean getPageBean2(int pageNum, int pageSize, String attrnow,
			Integer brandId, Integer cateId) {
		// TODO Auto-generated method stub
		return gbrandDao.getPageBean22(pageNum, pageSize, attrnow, brandId,cateId);
	}

	public List<TGBrand> findListByUser(Integer authorId) {
		return gbrandDao.findListByuser(authorId);
		// TODO Auto-generated method stub
	}

	

	
	
}
