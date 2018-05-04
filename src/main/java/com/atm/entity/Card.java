package com.atm.entity;

import java.io.Serializable;


/**
 * 信用卡实体类
 * @author chenyihui
   2018年3月29日
 */
public class Card implements Serializable {
    private Integer cardid;//卡id

    private String cardtype;//卡类型

    private String carddescription;//卡描述


    private static final long serialVersionUID = 1L;
    
    
    public Card()
    {
    	super();
    }
    
    public Card(String cardtype, String carddescription) {
		super();
		this.cardtype = cardtype;
		this.carddescription = carddescription;
	}


    public Card(Integer cardid, String cardtype, String carddescription) {
		super();
		this.cardid = cardid;
		this.cardtype = cardtype;
		this.carddescription = carddescription;
	}

	public Integer getCardid() {
        return cardid;
    }

    public void setCardid(Integer cardid) {
        this.cardid = cardid;
    }

 

    public String getCardtype() {
		return cardtype;
	}


	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}


	public String getCarddescription() {
        return carddescription;
    }

    public void setCarddescription(String carddescription) {
        this.carddescription = carddescription == null ? null : carddescription.trim();
    }


	@Override
	public String toString() {
		return "Card [cardid=" + cardid + ", cardtype=" + cardtype
				+ ", carddescription=" + carddescription + "]";
	}

  

  

	
    
}