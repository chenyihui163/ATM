package com.atm.controller;

import java.util.ArrayList;
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
import com.atm.entity.Withdraw;
import com.atm.service.AccountService;
import com.atm.service.WithdrawService;

/**
 * 取款控制层
 * @author chenyihui
   2018年4月7日
 */

@RestController
@RequestMapping("/withdraw")
public class WithdrawController {
	
	
	private static Logger logger =LoggerFactory.getLogger(WithdrawController.class);
	
	
	@Autowired
	private WithdrawService withdrawService;
	
	@Autowired
	private AccountService accountService;
	
	
	@Autowired
	private AsyncTaskService asyncTaskService;
	
	@GetMapping("/listTop/{aid}")
	public ResultMap listTop(@PathVariable("aid") Integer aid)
	{
	    List<Withdraw> lists =new ArrayList<Withdraw>();
		
		lists = withdrawService.queryTop(aid);
		
		for(Withdraw withdraw :lists)
		{
			System.err.println(withdraw.toString());
		}
		
		return ResultMap.success().put("lists", lists);
				


	}
	
	/**
	 * 获取取款信息
	* @Title: list   
	* @Description: TODO(这里用一句话描述这个方法的作用)   
	* @param @param params
	* @param @return    设定文件   
	* @return ResultMap    返回类型   
	* @throws
	 */
	@GetMapping("/list")
	public ResultMap list(@RequestParam Map<String,Object> params)
	{
		 Query query =new Query(params);
		 List<Withdraw> withdrawList =withdrawService.queryList(params);
	     Integer total =withdrawService.queryTotal(params);
	     PageUtils pageUtil =new PageUtils(withdrawList, total, query.getLimit(), query.getPage());
	    return ResultMap.success().put("page", pageUtil);
	}
	
	/**
	 * 查找取款信息
	* @Title: info   
	* @Description: TODO(这里用一句话描述这个方法的作用)   
	* @param @param id
	* @param @return    设定文件   
	* @return ResultMap    返回类型   
	* @throws
	 */
	@GetMapping("/info/{id}")
	public ResultMap info(@PathVariable("id") Integer id)
	{
		Withdraw withdraw=withdrawService.selectByPrimaryKey(id);
		return ResultMap.success().put("withdraw", withdraw);
	}
	@PostMapping("/save")
	@RequiresRoles(value={"user","operator","admin"},logical=Logical.OR)
    public ResultMap save(@RequestBody String withdraw1)
	{
		Withdraw withdraw =JsonUtils.toObject(withdraw1, Withdraw.class);
		
		withdrawService.insertSelective(withdraw);
		try {
			Map<String, Object> map =asyncTaskService.ChangeIntegral(withdraw.getAid());

			Account account =accountService.selectByPrimaryKey(withdraw.getAid());
			if(account.getMoney() < withdraw.getTakeMoney())
			{
			       return ResultMap.error("取款的金额已超过余额，不能取款");
			}
			account.setMoney(account.getMoney()-withdraw.getTakeMoney());
			account.setIntegral(Integer.valueOf(map.get("integral").toString()));
			account.setCreditLevel(Integer.valueOf(map.get("creditLevel").toString()));
			accountService.updateByPrimaryKeySelective(account);
			return ResultMap.success();
			
		} catch (Exception e) {
			
			// TODO: handle exception			
			withdraw.setState(0);
			withdrawService.updateByPrimaryKeySelective(withdraw);
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		
		logger.info("取款成功");
		return ResultMap.error("取款出现异常，失败");
		
	}
	

}
