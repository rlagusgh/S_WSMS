package com.khh.User.Service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.khh.User.Dao.UserDaoImpl;
import com.khh.User.Domain.UserVo;
import com.khh.security.domain.Role;

public class UserLoginService implements UserDetailsService{
	private static final Logger logger = LoggerFactory.getLogger(UserLoginService.class);
	
	@Autowired
	private UserDaoImpl userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SaltSource saltSource;

	@Override
	public UserVo loadUserByUsername(final String USER_ID)
			throws UsernameNotFoundException {
		logger.info("Login USER_ID "+USER_ID);
		UserVo user = new UserVo();
		
		//ȸ�� ���� Dao���� �о��
		UserVo getUser = userDao.getUser(USER_ID);
		
		//���̵� �������� �������
		if(getUser == null){
			return null;
		}
		
		//password�� ��ȣȭ
		String USER_PASSWORD = passwordEncoder.encodePassword(getUser.getPassword(), saltSource.getSalt(getUser));
		user.setUSER_ID(USER_ID);
		user.setUSER_PASSWORD(USER_PASSWORD);
		
		//���� ����.
		Role role = new Role();
		if(getUser.getUSER_AUTH().equals("ROLE_USER"))
			role.setUSER_AUTH("ROLE_USER");
		else
			role.setUSER_AUTH("ROLE_ADMIN");
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		user.setAuthorities(roles);
		
		return user;
	}
}
