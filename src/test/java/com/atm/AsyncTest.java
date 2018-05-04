package com.atm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.atm.Async.AsyncTaskConfig;
import com.atm.Async.AsyncTaskService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =SpringBootStartApplication.class)  
public class AsyncTest {
	/*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AsyncTaskConfig.class);

    AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);*/
	@Autowired
	private AsyncTaskService asyncTaskService;
	
	@Test
	public void test(){
		
		

        for(int i = 0; i < 10; i++){
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }
    }

}
