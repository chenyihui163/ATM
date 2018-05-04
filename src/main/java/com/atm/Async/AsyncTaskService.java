package com.atm.Async;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.atm.dto.JsonUtils;
import com.atm.dto.ResultMap;
import com.atm.entity.Account;
import com.atm.entity.Transfer;
import com.atm.service.AccountService;
import com.atm.service.TransferService;

/**
 * 通过@Async 注解表明该方法是个异步方法，如果注解在类级别，则表明该类所有的方法都是异步的，
 * 而这里的方法自动被注入使用ThreadPoolTaskExecutor 作为TaskExecutor
 * @author chenyihui
   2018年4月1日
 */
@Service
public class AsyncTaskService {
	
	private static Logger logger =LoggerFactory.getLogger(AsyncTaskService.class);
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TransferService transferService;
	
	
	public Map<String, Object> ChangeIntegral(Integer aid)
	{
		Map<String, Object> map =new HashMap<String, Object>();
		Account account =accountService.selectByPrimaryKey(aid);
		int k =(int) (account.getMoney()/100.00);
		if(k>0)
		{			
			account.setIntegral(account.getIntegral()+k);
			if(account.getIntegral()<=10)
				account.setCreditLevel(1);
			else if(account.getIntegral()<=30)
				account.setCreditLevel(2);
			else if(account.getIntegral()<=50)
				account.setCreditLevel(3);
			else if(account.getIntegral()<=100)
				account.setCreditLevel(4);
			else
				account.setCreditLevel(5);
		}
		else
		{

			account.setIntegral(0);
			account.setCreditLevel(0);
		}
		
		System.err.println("积分"+account.getIntegral()+" "+"等级"+account.getCreditLevel());
	
		map.put("integral", account.getIntegral());
		map.put("creditLevel", account.getCreditLevel());
		
		return map;

	}

	@Async
	public ResultMap transferAsyncTask(@RequestBody String transfer1 )
	{
		Transfer transfer =JsonUtils.toObject(transfer1, Transfer.class);
		System.err.println(transfer);
		try {
			
			transferService.insertSelective(transfer);
			Account account1=accountService.selectByPrimaryKey(transfer.getSenderid());
			if(account1.getMoney()<transfer.getTransferMoney())
			{
			       return ResultMap.error("转账金额已超过余额，转账失败");
			}
			account1.setMoney(account1.getMoney()-transfer.getTransferMoney());
			
			accountService.updateByPrimaryKeySelective(account1);
			Account account2=accountService.selectByPrimaryKey(transfer.getReceiverid());
			account2.setMoney(account2.getMoney()+transfer.getTransferMoney());
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
	
	
	@Async
	public ResultMap transferAsyncTask1( Transfer transfer )
	{
		//Transfer transfer =JsonUtils.toObject(transfer1, Transfer.class);
		System.err.println(transfer);
		try {
			
			transferService.insertSelective(transfer);
			Account account1=accountService.selectByPrimaryKey(transfer.getSenderid());
			if(account1.getMoney()<transfer.getTransferMoney())
			{
			       return ResultMap.error("转账金额已超过余额，转账失败");
			}
			account1.setMoney(account1.getMoney()-transfer.getTransferMoney());
			
			accountService.updateByPrimaryKeySelective(account1);
			Account account2=accountService.selectByPrimaryKey(transfer.getReceiverid());
			account2.setMoney(account2.getMoney()+transfer.getTransferMoney());
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
	
    @Async
    public void executeAsyncTask(Integer i){
        System.out.println("执行异步任务：" + i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("执行异步任务+1：" + (i+1));
    }
}