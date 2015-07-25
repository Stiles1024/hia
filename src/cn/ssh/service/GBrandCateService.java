package cn.ssh.service;

import java.util.List;

import cn.ssh.domain.TGBrand;
import cn.ssh.domain.TGBrandCate;

public interface GBrandCateService {

	void save(TGBrandCate gbcate);

	List findcateListBybrand(TGBrand gbrand);

}
