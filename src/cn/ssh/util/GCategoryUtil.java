package cn.ssh.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.ssh.domain.TGCategory;



public class GCategoryUtil {

	public static List<TGCategory> findAll(List<TGCategory> topList) {
		// TODO Auto-generated method stub
		List<TGCategory> gcategoryList=new ArrayList<TGCategory>();
		saveTreeList(topList,"",gcategoryList);
		return gcategoryList;
	}
	private static void saveTreeList(Collection<TGCategory> topList,String prefix,List<TGCategory> gcategoryList){
		for(TGCategory top : topList){
			TGCategory copy=new TGCategory();
			copy.setCatId(top.getCatId());
			copy.setCatName(prefix+top.getCatName());
			gcategoryList.add(copy);
			Collection<TGCategory>children = top.getChildren();
			saveTreeList(children,"　"+prefix, gcategoryList);
			
		}
	}
}
