package com.atm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.atm.entity.Withdraw;

@Mapper
public interface WithdrawMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Withdraw record);

    int insertSelective(Withdraw record);

    Withdraw selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Withdraw record);

    int updateByPrimaryKey(Withdraw record);
    
    List<Withdraw> queryTop (Integer aid);
    
    /**
     * 条件查询出数组
    * @Title: queryList   
    * @Description: TODO(这里用一句话描述这个方法的作用)   
    * @param @param map
    * @param @return    设定文件   
    * @return List<Deposit>    返回类型   
    * @throws
     */
    List<Withdraw> queryList(Map<String, Object> map);
    
    /**
     * 条件查询出总页数
     */
    Integer queryTotal(Map<String, Object> map);
}