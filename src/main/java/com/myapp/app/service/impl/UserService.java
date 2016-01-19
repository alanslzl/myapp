package com.myapp.app.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myapp.app.entity.User;
import com.myapp.app.service.IBaseService;
import com.myapp.app.service.IUserService;

@Service("userService")
public class UserService extends BaseService implements IUserService{
	@Resource(name="baseService")
	private IBaseService baseService;

	public User getByAccount(String account){
		User user = null;
		try {
			user = (User) baseService.getUniqueResultByJpql("from User as o where o.account=?", account);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public boolean register(User user){
		boolean flag = false;
		try {
			baseService.save(user);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
