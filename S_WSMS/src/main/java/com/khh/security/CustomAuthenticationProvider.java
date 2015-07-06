package com.khh.security;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.khh.User.Domain.UserVo;
import com.khh.User.Service.UserLoginService;

public class CustomAuthenticationProvider implements AuthenticationProvider{
	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
	@Autowired
	private UserLoginService loginService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SaltSource saltSource;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		
		String USER_ID = authentication.getName();
		String USER_PASSWORD = (String)authentication.getCredentials();

		UserVo user;
		Collection<? extends GrantedAuthority> authorities;
		
		try{
			user = loginService.loadUserByUsername(USER_ID);
			
			if(user == null){
				logger.info("아이디가 존재하지 않음");
				throw new BadCredentialsException("아이디가 존재하지 않습니다.");
			}
			
			String comparePassword = passwordEncoder.encodePassword(USER_PASSWORD, saltSource.getSalt(user));
			
			logger.info("USER ID :"+USER_ID+"/USER PASSWORD :"+USER_PASSWORD+"/hash PASSWORD:"+comparePassword);
			logger.info("USER ID :"+user.getUSER_ID()+"/USER PASSWORD :"+USER_PASSWORD);
			
			if(!comparePassword.equals(user.getPassword())) 
				throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
			
			authorities = user.getAuthorities();
		}catch(UsernameNotFoundException e) {
            logger.info(e.toString());
            throw new UsernameNotFoundException(e.getMessage());
        } catch(BadCredentialsException e) {
            logger.info(e.toString());
            throw new BadCredentialsException(e.getMessage());
        } catch(Exception e) {
            logger.info(e.toString());
            throw new RuntimeException(e.getMessage());
        }
		
		return new UsernamePasswordAuthenticationToken(user,USER_PASSWORD,authorities);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}
}
