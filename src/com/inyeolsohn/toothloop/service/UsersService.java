package com.inyeolsohn.toothloop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inyeolsohn.toothloop.dao.User;
import com.inyeolsohn.toothloop.dao.UsersDao;

@Service("usersService")
public class UsersService {
	
	private UsersDao usersDao;
	
	@Autowired
	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	
	public void create(User user) {
		usersDao.create(user);
	}
	
	public boolean exist(String username)
	{
		return usersDao.exists(username);
	}
	

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return usersDao.getAllUsers();
	}


	
}
