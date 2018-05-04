package com.atm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.atm.entity.Account;

@Mapper
public interface AccountMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
    
    /**
     * 通过aid获得实体类
    * @Title: selectUserCard_byAccount   
    * @Description: TODO(这里用一句话描述这个方法的作用)   
    * @param @param aid
    * @param @return    设定文件   
    * @return Account    返回类型   
    * @throws
     */
    Account selectUserCard_byAccount(Integer aid);
    
    Account getByAccount (Integer aid);
    
    /**
     * 根据条件查询数组
    * @Title: queryList   
    * @Description: TODO(这里用一句话描述这个方法的作用)   
    * @param @param map
    * @param @return    设定文件   
    * @return List<Account>    返回类型   
    * @throws
     */
    List<Account> queryList(Map<String, Object> map);
    
    
    /**
     * 查询可见记录总数
     * @param map
     * @return
     */
    Integer queryTotal(Map<String, Object> map);
    
}