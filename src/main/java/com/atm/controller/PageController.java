package com.atm.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;






import com.atm.dto.BusCode;
import com.atm.dto.Cryptography;
import com.atm.dto.RandomNumberGenerator;
import com.atm.dto.ResultMap;
import com.atm.entity.Account;
import com.atm.entity.Card;
import com.atm.entity.User;
import com.atm.service.AccountService;
import com.atm.service.CardService;
import com.atm.service.UserService;
import com.atm.shiro.ShiroUtils;

/**
 * 控制页面跳转
 * @author chenyihui
   2018年3月30日
 */

@Controller
/*@RequiresRoles(value={"user","operator","admin"},logical=Logical.OR)
*/
public class PageController {
	
	
	private static  final Logger logger =LoggerFactory.getLogger(PageController.class);
	

	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CardService cardService;
	
	/**
	 * 控制IFrame子模块页面跳转
	* @Title: showPage   
	* @Description: TODO(这里用一句话描述这个方法的作用)   
	* @param @param request
	* @param @param htmlName
	* @param @return    设定文件   
	* @return String    返回类型   
	* @throws
	 */
	@RequestMapping("/module/{htmlName}")
	public String showPage(HttpServletRequest request,@PathVariable("htmlName") String htmlName)
	{
		return "/module/"+htmlName;
	}
	
	@RequestMapping(value="/Sign_in",method =RequestMethod.POST)
	@ResponseBody
	public ResultMap Sign_in(@RequestBody  Account account)
	{
		System.err.println(account.toString());
		try {
			Subject subject =ShiroUtils.getSubject();
			
			UsernamePasswordToken token =new UsernamePasswordToken(account.getAid().toString(),
					Cryptography.MD5Hash(account.getPassword(), account.getAid().toString()));
			subject.login(token);
			
		} catch (UnknownAccountException e) {
			// TODO: handle exception
			return ResultMap.error("账号不存在");
		} catch(IncorrectCredentialsException e)
		{
			return ResultMap.error("账号或密码不正确");
		}		
		catch(LockedAccountException e)
		{
			return ResultMap.error("账号已禁止登陆,请联系管理员");
		}catch (DisabledAccountException e)
		{
			return ResultMap.error("由于密码输入错误次数大于5次，帐号已经禁止登录");
		}
		catch(AuthenticationException e)
		{
			return ResultMap.error("账户验证失败");
		}
		
		return ResultMap.success();
	}
	
	
	 /**
     * 增加账号
    * @Title: save   
    * @Description: TODO(这里用一句话描述这个方法的作用)   
    * @param @param account
    * @param @return    设定文件   
    * @return ResultMap    返回类型   
    * @throws
     */
    
    @RequestMapping(value="/saveAccount",method =RequestMethod.POST)
    @ResponseBody
    public ResultMap save(@RequestBody Account account)
    {
    	
 	   if(userService.selectIdentityCard(account.getUser().getIdentityCard())!=null)
 		   return ResultMap.error("该账号已被注册");
 	   
 	   
 	   int res=0;
 	   try {
 		   account.setAid(Integer.valueOf(RandomNumberGenerator.generateNumber2()));
           System.err.println(account.getAid());
 		   account.setPassword(Cryptography.MD5Hash(account.getPassword(), account.getAid().toString())) ;
 		   account.setMoney(0.000);
 		   account.setState(1);
 		   System.err.println("增加后："+account.toString());
 		   User user =new User(account.getUser());
 		   user.setUserid(Integer.valueOf(RandomNumberGenerator.generateNumber())); 		
 		   System.err.println(user.getUserid());
 		   user.setState(1);
 		   user.setIdentityType(0);
 		   System.err.println("增加后："+user.toString());
 		   userService.insertSelective(user);
 		   account.setUserid(user.getUserid());
 		   res =accountService.insertSelective(account);
 		   
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.getMessage());
			return ResultMap.error(BusCode.FAIL_RECODE_ADD);
		}
 	   System.err.println(res);
        logger.info("保存成功");
        return ResultMap.success();
    }
    
	
    @RequestMapping("/listCard")
    @ResponseBody
    public List<Card> listCard()
    {
    	List<Card> cards=new ArrayList<Card>();
    	try {
    		
    		cards=cardService.queryList(null);
    		return cards;
    		
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.getMessage());
			return null;
		}
    }
    
    /**
     * 
     */
    
    
    
	/**
    *  Home页面跳转     私有
    */
   
   @RequestMapping("/home")
   @RequiresRoles(value={"user","operator","admin"},logical=Logical.OR)
   public ModelAndView home() {
       Map<String,Object> map=new HashMap<String,Object>();

       map.put("LOGINER",ShiroUtils.getSubject().getPrincipal());
       //登陆校验
       //       return "index";
       return new ModelAndView("module/atm_client",map);
   }
   
   /**
    * 登录页面跳转
   * @Title: login   
   * @Description: TODO(这里用一句话描述这个方法的作用)   
   * @param @return    设定文件   
   * @return ModelAndView    返回类型   
   * @throws
    */
   @RequestMapping("/login.jhtml")
   public ModelAndView login()
   {
	   return new ModelAndView("login");
   }
	
   
   @RequestMapping(value="/logout" ,method =RequestMethod.GET)
   public String logout()
   {
	   ShiroUtils.logout();
	   return "redirect:/login.jhtml";
   }
   
   /**
    * 没有权限跳转
   * @Title: unauthorizedurl   
   * @Description: TODO(这里用一句话描述这个方法的作用)   
   * @param @return    设定文件   
   * @return String    返回类型   
   * @throws
    */
   @RequestMapping("/unauthorizedurl.jhtml") 
   public String unauthorizedurl()
   {
	   return "unauthorizedurl";
   }
   
   /**
    * 测试角色权限
   * @Title: testRole   
   * @Description: TODO(这里用一句话描述这个方法的作用)   
   * @param @return    设定文件   
   * @return String    返回类型   
   * @throws
    */
   @RequestMapping("/testRole")
   @ResponseBody
   @RequiresRoles("ADMIN")
   public String testRole()
   {
	   return "仅管理员可见";
   }

}
