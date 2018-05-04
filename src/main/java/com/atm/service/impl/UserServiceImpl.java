package com.atm.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atm.dao.UserMapper;
import com.atm.entity.User;
import com.atm.service.UserService;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserMapper userMapper;
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return this.userMapper.insertSelective(record);
	}

	public User selectByPrimaryKey(Integer userid) {
		// TODO Auto-generated method stub
		return this.userMapper.selectByPrimaryKey(userid);
	}

	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return this.userMapper.updateByPrimaryKeySelective(record);
	}

	
	public User selectAccountbyUser(Integer userid) {
		// TODO Auto-generated method stub
		return this.userMapper.selectAccountbyUser(userid);
	}

	
	public User getByUser(String username) {
		// TODO Auto-generated method stub
		return this.userMapper.getByUser(username);
	}

	
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return this.userMapper.getUserByUsername(username);
	}

	
	public List<User> queryList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.userMapper.queryList(map);
	}

	
	public Integer queryTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.userMapper.queryTotal(map);
	}

	@Override
	public User selectIdentityCard(String identityCard) {
		// TODO Auto-generated method stub
		return this.userMapper.selectIdentityCard(identityCard);
	}

}
