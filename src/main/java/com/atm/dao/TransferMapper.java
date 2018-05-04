package com.atm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.atm.entity.Transfer;

@Mapper
public interface TransferMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(Transfer record);

    int insertSelective(Transfer record);

    Transfer selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Transfer record);

    int updateByPrimaryKey(Transfer record);
    
    List<Transfer> queryTop (Integer senderid);
    
    
    /**
     * 条件查询数组
    * @Title: queryList   
    * @Description: TODO(这里用一句话描述这个方法的作用)   
    * @param @param map
    * @param @return    设定文件   
    * @return List<Transfer>    返回类型   
    * @throws
     */
    List<Transfer> queryList(Map<String, Object> map);
    
    /**
     * 条件查询总记录数
    * @Title: queryTotal   
    * @Description: TODO(这里用一句话描述这个方法的作用)   
    * @param @param map
    * @param @return    设定文件   
    * @return Integer    返回类型   
    * @throws
     */
    Integer queryTotal(Map<String, Object> map);

    
}