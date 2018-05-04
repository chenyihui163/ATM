package com.atm.service;

import java.util.List;
import java.util.Map;

import com.atm.entity.Card;

public interface CardService {
	
	
	public int insertSelective(Card record) ;
	
	public Card selectByPrimaryKey(Integer cardid);

	
	public int updateByPrimaryKeySelective(Card record) ;

	
	public Card selectAccountbyCard(Integer cardid);
    
	
	public List<Card> queryList(Map<String, Object> map) ;

	
	public Integer queryTotal(Map<String, Object> map) ;


}
