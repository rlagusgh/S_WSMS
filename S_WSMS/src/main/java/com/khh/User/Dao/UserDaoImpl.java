package com.khh.User.Dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.khh.User.Domain.UserVo;

@Repository(value="userDaoImpl")
public class UserDaoImpl implements UserDao{
	@Resource(name="userMapper")
	private UserMapper userMapper;
	
	@Override
	public UserVo getUser(String id) {
		return this.userMapper.getUser(id);
	}

	@Override
	public List<UserVo> getAllUsers() {
		return this.userMapper.getAllUsers();
	}

	@Override
	public void addUser(UserVo user) {
		this.userMapper.addUser(user);
	}

	@Override
	public void deleteAllUsers() {
		this.userMapper.deleteAllUsers();
	}

	@Override
	public void deleteUser(String id) {
		this.userMapper.deleteUser(id);
	}

	@Override
	public int getCountAllUsers() {
		return this.userMapper.getAllUsers().size();
	}

	@Override
	public void updateUser(UserVo user) {
		this.userMapper.updateUser();
	}

	@Override
	public int bCheck_id(String id) {
		if(this.userMapper.bCheck_id(id)==null){
			return 0;
		}else{
			return 1;
		}
	}
}
