package com.atm.controller;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atm.dto.PageUtils;
import com.atm.dto.Query;
import com.atm.dto.ResultMap;
import com.atm.entity.User;
import com.atm.service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {
	
	private static Logger logger =LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * 查询列表
	* @Title: list   
	* @Description: TODO(这里用一句话描述这个方法的作用)   
	* @param @param params
	* @param @return    设定文件   
	* @return ResultMap    返回类型   
	* @throws
	 */
	@RequestMapping("/list")
	public ResultMap list(@RequestParam Map<String, Object> params)
	{
 	   Query query =new Query(params);
 	   List<User> userList=userService.queryList(params);
 	   Integer total =userService.queryTotal(params);
	   PageUtils pageUtil =new PageUtils(userList, total, query.getLimit(), query.getPage());
	   return ResultMap.success().put("page", pageUtil);
	   
	}
	
	/**
	 * 查询用户信息
	* @Title: info   
	* @Description: TODO(这里用一句话描述这个方法的作用)   
	* @param @param userid
	* @param @return    设定文件   
	* @return ResultMap    返回类型   
	* @throws
	 */
	@RequestMapping("/info/{userid}")
	public ResultMap info(@PathVariable("userid") Integer userid)
	{
		User user =userService.selectAccountbyUser(userid);
		
		return ResultMap.success().put("user", user);
		
	}
	
	/**
	 * 修改用户信息
	* @Title: update   
	* @Description: TODO(这里用一句话描述这个方法的作用)   
	* @param @param user
	* @param @return    设定文件   
	* @return ResultMap    返回类型   
	* @throws
	 */
	@RequestMapping("/update")
	public ResultMap update(@RequestBody User user)
	{
		try {
			userService.updateByPrimaryKeySelective(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		logger.info("修改用户信息成功");
		return ResultMap.success();
	}

}
