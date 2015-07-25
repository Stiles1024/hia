package cn.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.UUserDao;
import cn.ssh.domain.PageBean;
import cn.ssh.domain.TUUser;
import cn.ssh.service.UUserService;
import cn.ssh.util.QueryHelper;


@Service
@Transactional
public class UUserServiceImpl implements UUserService {
	@Resource
	UUserDao uuserDao;
	
	public void save(TUUser model) {
		uuserDao.save(model);
	}
	
	public void delete(Integer idt) {
		uuserDao.delete(idt);
	}
	
	public TUUser findById(Integer id) {
		return uuserDao.findById(id);
	}

	public List<TUUser> findAll() {
		// TODO Auto-generated method stub
		return uuserDao.findAll();
	}

	public void update(TUUser user) {
		// TODO Auto-generated method stub
		uuserDao.udate(user);
	}

	public TUUser findByNameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		//String md5=DigestUtils.md5Hex(password);
		String md5 = password;
		
		return uuserDao.findByNameAndPassword(username, md5);
	}

	public PageBean getPageBean(int pageNum, int pageSize, QueryHelper qp) {
		// TODO Auto-generated method stub
		return uuserDao.getPageBean(pageNum, pageSize, qp);
	}

	public TUUser findByName(String username) {
		// TODO Auto-generated method stub
		return uuserDao.findByName(username);
	}

	public TUUser findByNum(String phonenum) {
		// TODO Auto-generated method stub
		return uuserDao.findByNum(phonenum);
	}

	public TUUser findByPhoneOrEmailAndPassword(String phonenum, String password) {
		// TODO Auto-generated method stub
		TUUser user=uuserDao.findByphoneAndPassword(phonenum,password);
		if(user!=null){
			return user;
		}
		else{
			user=uuserDao.findByEmailAndPassword(phonenum,password);
			if(user!=null){
				return user;
			}
			else{
				return null;
			}
		}
		
	}

	public TUUser findByPhoneOrEmail(String phonenum) {
		// TODO Auto-generated method stub
		TUUser user=uuserDao.findByPhone(phonenum);
		if(user!=null){
			return user;
		}
		else{
			user=uuserDao.findByEmaild(phonenum);
			if(user!=null){
				return user;
			}
			else{
				return null;
			}
		}
	}
	
	
	
	
}
