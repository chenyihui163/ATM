package com.atm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.javassist.runtime.Desc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.atm.Async.AsyncTaskService;
import com.atm.dto.BankNumberUtil;
import com.atm.dto.RandomNumberGenerator;
import com.atm.dto.RandomUtil;
import com.atm.dto.unRepeatCode;
import com.atm.entity.Card;
import com.atm.entity.Deposit;
import com.atm.entity.Transfer;
import com.atm.service.CardService;
import com.atm.service.DepositService;
import com.atm.service.TransferService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes =SpringBootStartApplication.class)  
public  class FormTest {
	
	@Autowired
	private CardService cardService;
	
	@Autowired
	private TransferService transferService;
	
	@Autowired AsyncTaskService asyncTaskService;
	
	
	@Autowired
	private DepositService depositService;
	
	@Test
	public void List1()
	{
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("aid",76152308);
		map.put("sidx", "save_Time");
		map.put("order", "Desc");
		map.put("offset", 0);
		map.put("limit", 10);
		
     List<Deposit> lists =new ArrayList<Deposit>();
		
		lists = depositService.queryList(map);
		
		for(Deposit deposit :lists)
		{
			System.err.println(deposit.toString());
		}
		
	}
	
	
	/*public  void  list()
	{
	
		
		List<Deposit> lists =new ArrayList<Deposit>();
		
		lists = depositService.queryTop(76152308);
		
		for(Deposit deposit :lists)
		{
			System.err.println(deposit.toString());
		}
		
		
	}*/
	
/*	@Test
	public void async()
	{
		Transfer record =new Transfer(76152308, 87914235, 100);

		asyncTaskService.transferAsyncTask1(record);
		
		System.err.println("转账成功");
		
	}*/
/*	
	@Test
	public void add()
	{
		Transfer record =new Transfer(76152308, 87914235, 100);
		transferService.insertSelective(record);
		System.err.println("转账成功");
	}*/
	/*@Test
	public void add()
	{
		cardService.insertSelective(new Card(1,"信用卡" ));
		System.err.println("增加成功");
	}
*/
	/*@Test
	public void addCard()
	{
		cardService.insertSelective(new Card("信用卡","用来贷款或者存取款"));
		cardService.insertSelective(new Card("储蓄卡","用来存取款"));
        System.err.println("增加卡成功");
	}*/
/*	  @Test
	  public void selectCard()
	  {
		  List<Card> cards =new ArrayList<Card>();
		  
		  cards=cardService.queryList(null);
		  
		  for(Card card:cards)
		  {
			  System.err.println(card.toString());
		  }
		  
	  }*/
	
	/*@Test
	public void getRandom()
	{
		System.out.println(BankNumberUtil.getBrankNumber("9"));
		
		System.out.println(RandomNumberGenerator.generateNumber());
		
		System.out.println(RandomNumberGenerator.generateNumber2());

		
	}*/
}
