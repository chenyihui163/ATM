package com.atm.service;

import java.util.Map;

import com.atm.entity.User;
import java.util.List;

public interface UserService {
	
	public int insertSelective(User record) ;

	public User selectByPrimaryKey(Integer userid) ;

	public int updateByPrimaryKeySelective(User record) ;

	public User selectIdentityCard(String identityCard);
	
	public User selectAccountbyUser(Integer userid);
	
	public User getByUser(String username) ;

	
	public User getUserByUsername(String username) ;

	
	public List<User> queryList(Map<String, Object> map);

	
	public Integer queryTotal(Map<String, Object> map) ;

}
