package com.myapp.app.service;

import com.myapp.app.entity.User;

public interface IUserService extends IBaseService {
	public User getByAccount(String account);
	public boolean register(User user);
}
