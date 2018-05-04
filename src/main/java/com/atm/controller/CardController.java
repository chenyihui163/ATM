package com.atm.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atm.dto.PageUtils;
import com.atm.dto.Query;
import com.atm.dto.ResultMap;
import com.atm.entity.Card;
import com.atm.service.CardService;

/**
 * Card控制层
 * @author chenyihui
   2018年3月31日
 */
@RestController
@RequestMapping("/card")
public class CardController {
	
	private static  Logger logger =LoggerFactory.getLogger(CardController.class);
	
	@Autowired
	private CardService cardService;
	
	/**
	 * 获取card列表信息
	* @Title: list   
	* @Description: TODO(这里用一句话描述这个方法的作用)   
	* @param @param params
	* @param @return    设定文件   
	* @return ResultMap    返回类型   
	* @throws
	 */
	@GetMapping("/list")
	public ResultMap list(@RequestParam Map<String,Object> params )
	{
 	   Query query =new Query(params);
       List<Card> cardList =cardService.queryList(params);
       Integer total =cardService.queryTotal(params);
       PageUtils pageUtil =new PageUtils(cardList, total, query.getLimit(), query.getPage());
       return ResultMap.success().put("page", pageUtil);
	}
	
	/**
	 * 获取卡的信息
	* @Title: info   
	* @Description: TODO(这里用一句话描述这个方法的作用)   
	* @param @param cardid
	* @param @return    设定文件   
	* @return ResultMap    返回类型   
	* @throws
	 */
	@GetMapping("/info/{cardid}")
	public ResultMap info(@PathVariable("cardid") Integer cardid)
	{
		Card card =cardService.selectByPrimaryKey(cardid);
		return ResultMap.success().put("card", card);
	}
	
	/**
	 * 修改卡的信息
	* @Title: update   
	* @Description: TODO(这里用一句话描述这个方法的作用)   
	* @param @param card
	* @param @return    设定文件   
	* @return ResultMap    返回类型   
	* @throws
	 */
	@PutMapping("/update")
	public ResultMap update(@RequestBody Card card)
	{
		try {
			cardService.updateByPrimaryKeySelective(card);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			
			// TODO: handle exception
		}
		logger.info("修改卡信息成功");
		return ResultMap.success();
	}

}
