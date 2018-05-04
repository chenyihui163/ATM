package com.atm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atm.Async.AsyncTaskService;
import com.atm.dto.JsonUtils;
import com.atm.dto.PageUtils;
import com.atm.dto.Query;
import com.atm.dto.ResultMap;
import com.atm.entity.Account;
import com.atm.entity.Deposit;
import com.atm.service.AccountService;
import com.atm.service.DepositService;

/**
 * 存款控制层
 * @author chenyihui
   2018年4月1日
 */

@RestController
@RequestMapping("/deposit")
public class DepositController
{


	private static  Logger logger =LoggerFactory.getLogger(CardController.class);
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private DepositService depositService;
	
	@Autowired
	private AsyncTaskService asyncTaskService;
	/**
	 * 返回前面5条最新记录
	* @Title: listTop
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	  @Return:ResultMap
	  2018年4月18日上午10:35:58
	 */
	@GetMapping("/listTop/{aid}")
	public ResultMap listTop(@PathVariable("aid") Integer aid)
	{
	    List<Deposit> lists =new ArrayList<Deposit>();
		
		lists = depositService.queryTop(aid);
		
		for(Deposit deposit :lists)
		{
			System.err.println(deposit.toString());
		}
		
		return ResultMap.success().put("lists", lists);
				


	}
	
	/**
	 * 获取存款列表信息
	* @Title: list   
	* @Description: TODO(这里用一句话描述这个方法的作用)   
	* @param @param params
	* @param @return    设定文件   
	* @return ResultMap    返回类型   
	* @throws
	 */
	
	@GetMapping("/list")
	public ResultMap list(@RequestParam Map<String,Object> params )
	{
 	   Query query =new Query(params);
       List<Deposit> depositList =depositService.queryList(params);
       Integer total =depositService.queryTotal(params);
       PageUtils pageUtil =new PageUtils(depositList, total, query.getLimit(), query.getPage());
       return ResultMap.success().put("page", pageUtil);
	}
	
	/**
	 * 获取存款的信息
	* @Title: info   
	* @Description: TODO(这里用一句话描述这个方法的作用)   
	* @param @param cardid
	* @param @return    设定文件   
	* @return ResultMap    返回类型   
	* @throws
	 */
	@GetMapping("/info/{id}")
	public ResultMap info(@PathVariable("id") Integer id)
	{
		Deposit deposit=depositService.selectByPrimaryKey(id);
		return ResultMap.success().put("deposit", deposit);
	}
	
	/**
	 * 增加存款
	* @Title: update   
	* @Description: TODO(这里用一句话描述这个方法的作用)   
	* @param @param card
	* @param @return    设定文件   
	* @return ResultMap    返回类型   
	* @throws
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/save")
	@RequiresRoles(value={"user","operator","admin"},logical=Logical.OR)
	public ResultMap save(@RequestBody String deposit)
	{
		Deposit deposit1 =JsonUtils.toObject(deposit, Deposit.class);

		
		depositService.insertSelective(deposit1);
		try {
			Map<String, Object> map =asyncTaskService.ChangeIntegral(deposit1.getAid());
			Account account =accountService.selectByPrimaryKey(deposit1.getAid());
			account.setMoney(account.getMoney()+deposit1.getSaveMoney());
			account.setIntegral(Integer.valueOf(map.get("integral").toString()));
			account.setCreditLevel(Integer.valueOf(map.get("creditLevel").toString()));
			account.setState(1);
			accountService.updateByPrimaryKeySelective(account);
			
		} catch (Exception e) {
			deposit1.setState(0);
			depositService.updateByPrimaryKeySelective(deposit1);
			e.printStackTrace();
			logger.info(e.getMessage());
			
			// TODO: handle exception
		}
		logger.info("存款成功");
		return ResultMap.success();
	}
}
