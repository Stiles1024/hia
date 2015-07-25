package cn.ssh.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.GAttrRangeDao;
import cn.ssh.domain.TGAttrRange;
import cn.ssh.domain.TGAttribute;
import cn.ssh.service.GAttrRangeService;

@Service
@Transactional
public class GAttrRangeServiceImpl implements GAttrRangeService{

	@Resource
	GAttrRangeDao gattrrangeDao;

	public List<TGAttrRange> findByAttr(TGAttribute ga) {
		// TODO Auto-generated method stub
		return gattrrangeDao.findByAttr(ga);
	}

	public void delete(Integer catRangeId) {
		// TODO Auto-generated method stub
		gattrrangeDao.delete(catRangeId);
	}

	public void save(TGAttrRange model) {
		// TODO Auto-generated method stub
		gattrrangeDao.save(model);
	}

	public TGAttrRange findById(Integer catRangeId) {
		// TODO Auto-generated method stub
		return gattrrangeDao.findById(catRangeId);
	}

	public void update(TGAttrRange model) {
		// TODO Auto-generated method stub
		gattrrangeDao.udate(model);
	}
	
	public String attr2String(List<TGAttrRange> rangeList) {
		if(rangeList.size() == 0) return "";
		String rst = "";
		for(TGAttrRange ar : rangeList) {
			Integer rid = ar.getCatRangeId();
			rst += "_" + rid;
		}
		rst = rst.substring(1);
		//System.out.println("rst == " + rst);
		return rst;
	}
	
	public List<TGAttrRange> string2RangeList(String s) {
		//System.out.println("s == "+s);
		if(s == null || s.equals("")) return null;
		String[] array = s.split("_");
		//System.out.println("s.size == " + s + "    " + array.length);
		List<TGAttrRange> rangeList = new ArrayList<TGAttrRange>();
		for(int i = 0;i < array.length; ++i) {
			rangeList.add(this.findById(Integer.parseInt(array[i])));
		}
		//System.out.println("size == " + rangeList.size());
		return rangeList;
	}

	public void deleteByGoodId(Integer goodsId) {
		// TODO Auto-generated method stub
		gattrrangeDao.deleteByGoodId(goodsId);
	}

	public List<String> stringToRangeList(String attrnow) {
		// TODO Auto-generated method stub
		if(attrnow== null || attrnow.equals("")) return null;
		String[] array = attrnow.split("_");
		//System.out.println("s.size == " + s + "    " + array.length);
		List<String> rangeList = new ArrayList<String>();
		for(int i = 0;i < array.length; ++i) {
			rangeList.add(array[i]);
		}
		//System.out.println("size == " + rangeList.size());
		return rangeList;
	}

	public TGAttribute findAttrByValue(String value) {
		// TODO Auto-generated method stub
		List<TGAttrRange>attrRangList=gattrrangeDao.findAttrByValue(value);
		TGAttribute attr=null;
		for(TGAttrRange attrR:attrRangList){
			attr=attrR.getTGAttribute();
		}
		return attr;
	}

	





}
