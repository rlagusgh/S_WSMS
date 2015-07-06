package com.khh.User.Dao;

import java.util.List;

import com.khh.User.Domain.UserVo;

public interface UserDao {
	UserVo getUser(String id);
	List<UserVo> getAllUsers();
	void addUser(UserVo user);
	void deleteAllUsers();
	void deleteUser(String id);
	int getCountAllUsers();
	void updateUser(UserVo user);
	int bCheck_id(String id);
}
