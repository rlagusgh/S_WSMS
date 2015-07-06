package com.khh.User.Service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.khh.User.Dao.UserDao;
import com.khh.User.Domain.UserVo;

@Service(value="userJoinService")
public class UserJoinService {
	@Resource(name="userDaoImpl")
	UserDao userDao;
	
	public UserVo JoinUser(UserVo user){
		UserVo getUser = null;
		
		user.setUSER_AUTH("ROLE_USER");
		this.userDao.addUser(user);
		
		getUser = this.userDao.getUser(user.getUSER_ID());
		
		return getUser;
	}
}
