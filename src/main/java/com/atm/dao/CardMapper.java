package com.atm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.atm.entity.Card;

@Mapper
public interface CardMapper {
    int deleteByPrimaryKey(Integer cardid);

    int insert(Card record);

    int insertSelective(Card record);

    Card selectByPrimaryKey(Integer cardid);

    int updateByPrimaryKeySelective(Card record);

    int updateByPrimaryKey(Card record);
    
    /**
     * 
    * @Title: selectAccountbyCard   
    * @Description:高级映射查询account  
    * 
     */
    Card selectAccountbyCard(Integer cardid);
    
 
    /**
     * 条件查询数组
     * @param map
     * @return
     */
    List<Card> queryList(Map<String, Object> map);
    
    /**
     * 条件查询记录总数
    * @Title: queryTotal   
    * @Description: TODO(这里用一句话描述这个方法的作用)   
    * @param @param map
    * @param @return    设定文件   
    * @return Integer    返回类型   
    * @throws
     */
    Integer queryTotal(Map<String, Object> map);
    
}