package cn.ssh.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.ssh.domain.TGAttrRange;
import cn.ssh.service.GAttrRangeService;
import cn.ssh.service.impl.GAttrRangeServiceImpl;

@Repository
public class GAttributeUtil {
	
	//protected GAttrRangeService gattrrangeService = new GAttrRangeServiceImpl();
	@Resource
	protected GAttrRangeService gattrrangeService;
	
	public static String attr2String(List<TGAttrRange> rangeList) {
		String rst = "";
		for(TGAttrRange ar : rangeList) {
			Integer rid = ar.getCatRangeId();
			rst += "_" + rid;
		}
		rst = rst.substring(1);
		//System.out.println(rst);
		return rst;
	}
	
	public List<TGAttrRange> string2RangeList(String s) {
		String[] array = s.split("_");
		List<TGAttrRange> rangeList = new ArrayList<TGAttrRange>();
		for(int i = 0;i < array.length; ++i) {
			rangeList.add(gattrrangeService.findById(Integer.parseInt(array[i])));
		}
		return rangeList;
	}  
}
