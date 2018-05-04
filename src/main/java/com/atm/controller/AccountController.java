package com.atm.controller;

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

import com.atm.dto.Cryptography;
import com.atm.dto.PageUtils;
import com.atm.dto.Query;
import com.atm.dto.ResultMap;
import com.atm.entity.Account;
import com.atm.service.AccountService;
import com.atm.service.UserService;


/**
 * Account控制层
 * @author chenyihui
   2018年3月31日
 */
@RestController
@RequestMapping("/account")
@RequiresRoles(value={"user","operator","admin"},logical=Logical.OR)
public class AccountController {
	
       private static Logger logger =LoggerFactory.getLogger(AccountController.class);
       
       @Autowired
       private AccountService accountService;
       
       @Autowired
       private UserService userService;
       
       /**
        * 查询账号列表信息
       * @Title: list   
       * @Description: TODO(这里用一句话描述这个方法的作用)   
       * @param @param params
       * @param @return    设定文件   
       * @return ResultMap    返回类型   
       * @throws
        */
       @RequiresRoles(value={"admin","operator"},logical=Logical.OR)
       @GetMapping("/list")
       public ResultMap list(@RequestParam Map<String,Object> params)
       {
    	   Query query =new Query(params);
    	   List<Account> accountList= accountService.queryList(params);
    	   Integer total=accountService.queryTotal(params);
    	   PageUtils pageUtil =new PageUtils(accountList, total, query.getLimit(), query.getPage());
    	   return ResultMap.success().put("page", pageUtil);
    	    	   
       }
       
      
       
       /**
        * 获取账号信息
       * @Title: info   
       * @Description: TODO(这里用一句话描述这个方法的作用)   
       * @param @param aid
       * @param @return    设定文件   
       * @return ResultMap    返回类型   
       * @throws
        */
       @GetMapping(value="/info/{aid}" )
       public ResultMap info(@PathVariable("aid") Integer aid)
       {
    	   Account account =accountService.selectUserCard_byAccount(aid);
    	  // System.err.println("info:"+account.toString());
    	   //避免密码被获取
    	   account.setPassword(null);
    	   return ResultMap.success().put("account", account);
       }
       
   /**
    * 修改密码
    */
    @PostMapping(value="/update")
    public ResultMap update(@RequestBody Account account )
    {
    	try {
			if(account.getPassword()!=null&&account.getPassword()!="")
			{
	    		account.setPassword(Cryptography.MD5Hash(account.getPassword(), account.getAid().toString()));

			}
			
    		accountService.updateByPrimaryKeySelective(account);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			// TODO: handle exception
		}
    	logger.info("修改密码成功");
    	
    	return ResultMap.success();
    }
    
  
       
}
