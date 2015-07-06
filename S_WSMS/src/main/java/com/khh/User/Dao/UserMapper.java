package com.khh.User.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.khh.User.Domain.UserVo;

@Repository(value="userMapper")
public interface UserMapper {
	UserVo getUser(String id);
	List<UserVo> getAllUsers();
	void addUser(UserVo userVo);
	void deleteAllUsers();
	void deleteUser(String id);
	void updateUser();
	UserVo bCheck_id(String id);
}
