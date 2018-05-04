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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atm.Async.AsyncTaskService;
import com.atm.dto.JsonUtils;
import com.atm.dto.ResultMap;
import com.atm.entity.Account;
import com.atm.entity.Transfer;
import com.atm.entity.Withdraw;
import com.atm.service.AccountService;
import com.atm.service.TransferService;

@RestController
@RequestMapping("/transfer")
@RequiresRoles(value={"user","operator","admin"},logical=Logical.OR)
public class TransferController {
	
	private static Logger logger =LoggerFactory.getLogger(TransferController.class);


	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TransferService transferService;
	
	@Autowired
	private AsyncTaskService asyncTaskService;
	

	
	@GetMapping("/listTop/{senderid}")
	public ResultMap listTop(@PathVariable("senderid") Integer senderid)
	{
	    List<Transfer> lists =new ArrayList<Transfer>();
		
		lists = transferService.queryTop(senderid);
		
		for(Transfer withdraw :lists)
		{
			System.err.println(withdraw.toString());
		}
		
		return ResultMap.success().put("lists", lists);
				


	}
	
	@RequestMapping("/toTransfer")
	public ResultMap transferAsyncTask(@RequestBody String transfer1 )
	{
		Transfer transfer =JsonUtils.toObject(transfer1, Transfer.class);
		
		try {
			Map<String, Object> map1 =asyncTaskService.ChangeIntegral(transfer.getSenderid());
			Map<String, Object> map2 =asyncTaskService.ChangeIntegral(transfer.getReceiverid());

			transferService.insertSelective(transfer);
			Account account1=accountService.selectByPrimaryKey(transfer.getSenderid());
			if(account1.getMoney()<transfer.getTransferMoney())
			{
			       return ResultMap.error("转账金额已超过余额，转账失败");
			}
			account1.setMoney(account1.getMoney()-transfer.getTransferMoney());
			account1.setIntegral(Integer.valueOf(map1.get("integral").toString()));
			account1.setCreditLevel(Integer.valueOf(map1.get("creditLevel").toString()));
			accountService.updateByPrimaryKeySelective(account1);
			Account account2=accountService.selectByPrimaryKey(transfer.getReceiverid());
			account2.setMoney(account2.getMoney()+transfer.getTransferMoney());
			account2.setIntegral(Integer.valueOf(map2.get("integral").toString()));
			account2.setCreditLevel(Integer.valueOf(map2.get("creditLevel").toString()));
			accountService.updateByPrimaryKeySelective(account2);
			
			transfer.setState(1);
			transferService.updateByPrimaryKeySelective(transfer);
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			logger.info(e.getMessage());
			
		}
		logger.info("转账成功");
		return ResultMap.success();
		
		
	}
	

}
