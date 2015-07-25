package cn.ssh.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.GCategoryDao;
import cn.ssh.domain.TGBrand;
import cn.ssh.domain.TGBrandCate;
import cn.ssh.domain.TGCategory;
import cn.ssh.domain.TGGoods;
import cn.ssh.service.GCategoryService;
@Service
@Transactional
public class GCategoryServiceImpl implements GCategoryService{

	@Resource
	GCategoryDao gcategoryDao;
	
	public TGCategory findById(Integer parentId) {
		// TODO Auto-generated method stub
		return gcategoryDao.findById(parentId);
	}

	public List<TGCategory> findTopList() {
		// TODO Auto-generated method stub
		return gcategoryDao.findTopList();
	}

	public List<TGCategory> findChildList(Integer parentId) {
		// TODO Auto-generated method stub
		return gcategoryDao.findChildList(parentId);
	}

	public void delete(Integer catId) {
		// TODO Auto-generated method stub
		gcategoryDao.delete(catId);
	}

	public void save(TGCategory model) {
		// TODO Auto-generated method stub
		gcategoryDao.save(model);
	}

	public void update(TGCategory model) {
		// TODO Auto-generated method stub
		gcategoryDao.udate(model);
	}

	public List<TGCategory> findRootList() {
		// TODO Auto-generated method stub
		return gcategoryDao.findRootList();
	}

	public TGCategory findByName(String string) {
		// TODO Auto-generated method stub
		return gcategoryDao.findByName(string);
	}

	public List<TGBrand> findbListBycate(TGCategory gct) {
		// TODO Auto-generated method stub
		if(gct.getTGBrandCates()==null)
		{
			return null;
		}
		Collection< TGBrandCate> coll=gct.getTGBrandCates();
		
		List<TGBrand>gblist=new ArrayList<TGBrand>();
		for(TGBrandCate gbc: coll){
			gblist.add(gbc.getTGBrand());
		}
		return gblist;
	}

	public void findSelListByNmae(List<TGCategory> seListF,
			List<TGCategory> allList, TGCategory gcF) {
		// TODO Auto-generated method stub
		 for(TGCategory gct :allList){
			 if(gct.getParent()==gcF)
			 {
				 seListF.add(gct);
			 }
		 }
		
	}

	public void findMapBySel(List<TGCategory> seListB,
			List<TGCategory> allList, Map<TGCategory, List<TGCategory>> mapF) {
		// TODO Auto-generated method stub
		 for(TGCategory gct :seListB){
			 List<TGCategory> temp=new ArrayList<TGCategory>();
			 for(TGCategory gctt:allList){
				 if(gctt.getParent()==gct){
					 temp.add(gctt);
				 }
			 }
			 mapF.put(gct, temp);
		 }
	}

	

	

}
