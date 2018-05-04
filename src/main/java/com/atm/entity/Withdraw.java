package com.atm.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 取款实体类
 * @author chenyihui
   2018年3月29日
 */
@Alias("Withdraw")
public class Withdraw implements Serializable {
    private Integer id;//主键id

    private Integer aid;//账号id

    private Integer takeMoney;//取款金额

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date takeTime;//取款时间

    private Integer money;//余额

    private Integer state;//状态

    private static final long serialVersionUID = 1L;
    
    private Account account;

    
    
    public Withdraw() {
		super();
	}

	public Withdraw(Integer aid, Integer takeMoney ,Date takeTime) {
		super();
		this.aid = aid;
		this.takeMoney = takeMoney;
		this.takeTime=takeTime;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getTakeMoney() {
        return takeMoney;
    }

    public void setTakeMoney(Integer takeMoney) {
        this.takeMoney = takeMoney;
    }

    public Date getTakeTime() {
        return takeTime;
    }

    public void setTakeTime(Date takeTime) {
        this.takeTime = takeTime;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Withdraw [id=" + id + ", aid=" + aid + ", takeMoney="
				+ takeMoney + ", takeTime=" + takeTime + ", money=" + money
				+ ", state=" + state + "]";
	}
    
    
}