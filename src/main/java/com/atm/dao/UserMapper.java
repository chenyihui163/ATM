package com.atm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.atm.entity.User;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    /**
     * 根据身份证号查询
    * @Title: selectIdentityCard   
    * @Description: TODO(这里用一句话描述这个方法的作用)   
    * @param @param identityCard
    * @param @return    设定文件   
    * @return User    返回类型   
    * @throws
     */
    User selectIdentityCard(String identityCard);
    /*
     * 高级映射出account实体类
     */
    User selectAccountbyUser(Integer userid);
    
   /**
    * 通过username获取状态正常的实体类
   * @Title: getByUser   
   * @Description: TODO(这里用一句话描述这个方法的作用)   
   * @param @param username
   * @param @return    设定文件   
   * @return User    返回类型   
   * @throws
    */
    User getByUser(String username);
    
    /**
     * 通过username获取的实体类
    * @Title: getUserByUsername   
    * @Description: TODO(这里用一句话描述这个方法的作用)   
    * @param @param username
    * @param @return    设定文件   
    * @return User    返回类型   
    * @throws
     */
    User getUserByUsername(String username);
    
    /**
     * 根据条件查询数组
    * @Title: queryList   
    * @Description: TODO(这里用一句话描述这个方法的作用)   
    * @param @param map
    * @param @return    设定文件   
    * @return List<Account>    返回类型   
    * @throws
     */
    List<User> queryList(Map<String, Object> map);
    
    
    /**
     * 查询可见记录总数
     * @param map
     * @return
     */
    Integer queryTotal(Map<String, Object> map);
}