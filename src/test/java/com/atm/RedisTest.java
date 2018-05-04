package com.atm;




import org.jboss.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.atm.cache.redis.RedisService;
import com.atm.config.Global;


/**
 * Redis相关测试
 * @author chenyihui
   2018年3月26日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes =SpringBootStartApplication.class)  
public class RedisTest {
	
	@Autowired
	RedisService redisService;
	
	@Autowired
    Global global;

	private Logger logger =Logger.getLogger(RedisTest.class);
	
	 /**
     * 测试Redis连接
     */
/*	@Test
	public void testLink()
	{
		redisService.add("key2", "123");
		System.err.println( (String)redisService.get("key2"));
		
		redisService.add("k1", "122451");
		System.out.println("k1:"+(String) redisService.get("k1"));
		  for(int i=0;i<10;i++)
		        this.logger.error("aaaaaaaa");
	}*/
	
	
	  @Test
	    public  void  hashInput(){
        this.redisService.hmGet("sadasdasdasd","asdasdasd");
	       
	    }
	
	

}
