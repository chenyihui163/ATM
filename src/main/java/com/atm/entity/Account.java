package com.atm.entity;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;


/**
 * 账户实体类
 * @author chenyihui
   2018年3月29日
 */
@Alias("Account")
public class Account implements Serializable {
	
   private static final long serialVersionUID = 1L;
	
    private  Integer aid;//银行卡账号，银行卡号

    private Integer userid;//用户账号

    private String password;//密码

    private Double money=0.00;//余额

    private Integer state;//状态

    private Integer creditLevel=0;//信用等级

    private Integer cardid;//卡的id

    private Integer integral=0;//积分

    private User user;
    
   
	
	public Account()
	{
		super();
	}

    public Account(Integer aid, String password) {
		super();
		this.aid = aid;
		this.password = password;
	}
    
    

	public Account(Integer aid, Integer userid, String password, Double money,
			Integer state, Integer creditLevel, Integer cardid, Integer integral) {
		super();
		this.aid = aid;
		this.userid = userid;
		this.password = password;
		this.money = money;
		this.state = state;
		this.creditLevel = creditLevel;
		this.cardid = cardid;
		this.integral = integral;
	}

	public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCreditLevel() {
        return creditLevel;
    }

    public void setCreditLevel(Integer creditLevel) {
        this.creditLevel = creditLevel;
    }

    public Integer getCardid() {
        return cardid;
    }

    public void setCardid(Integer cardid) {
        this.cardid = cardid;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }



	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	@Override
	public String toString() {
		return "Account [aid=" + aid + ", userid=" + userid + ", password="
				+ password + ", money=" + money + ", state=" + state
				+ ", creditLevel=" + creditLevel + ", cardid=" + cardid
				+ ", integral=" + integral + "]";
	}
    
    
}