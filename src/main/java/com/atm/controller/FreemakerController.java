package com.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.atm.cache.redis.RedisService;


@RestController
@Controller
public class FreemakerController {
	
	@RequestMapping("/freemaker")
	public ModelAndView say(Model model)
	{
		
		ModelAndView mv =new ModelAndView();
	
		mv.addObject("name", "hello world");
	    mv.setViewName("freemaker");
	    return mv;
	    
	}
	
	@Value("${spring.redis.port}")
	private String name;
	
	@Autowired
	RedisService redisService;
	
	
	@GetMapping(value="/hello")
	@ResponseBody
	public String getHello()
	{
		System.err.println(name);
		return "Hello World!"+name;
		
	}
	
	
	/*@GetMapping(value="/get")
	@ResponseBody
	public String get()
	{
		
	}*/
	

}
