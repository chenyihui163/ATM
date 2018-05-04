package com.atm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.atm.entity.Deposit;
import com.atm.service.DepositService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes =SpringBootStartApplication.class)  
public class ListTest {
	
	@Autowired
	private DepositService depositService;
	
	@Test
	public  void  list()
	{
		Map <String,Object> params =new HashMap<String, Object>();
		
		params.put("aid", 76152308);
		
		params.put("sidx", " save_Time");
		
		params.put("order", "desc");
		
		params.put("offset", 0);
		
		params.put("limit", 5);
		
		List<Deposit> lists =new ArrayList<Deposit>();
		
		lists = depositService.queryList(params);
		
		for(Deposit deposit :lists)
		{
			System.err.println(deposit.getSaveMoney());
		}
		
		
	}
	
	

}
