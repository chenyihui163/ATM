package com.atm.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

@Alias("Deposit")
public class Deposit implements Serializable {
    private Integer id;

    private Integer aid;

    private Integer saveMoney;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   
    private Date saveTime;

    private Integer money;

    private Integer state;

    private static final long serialVersionUID = 1L;
    
    
    private Account account;

    
    
    public Deposit() {
		super();
	}

	public Deposit(Integer id, Integer aid, Integer saveMoney, Date saveTime,
			Integer money) {
		super();
		this.id = id;
		this.aid = aid;
		this.saveMoney = saveMoney;
		this.saveTime = saveTime;
		this.money = money;
	}

	public Deposit(Integer aid, Integer saveMoney, Date saveTime) {
		super();
		this.aid = aid;
		this.saveMoney = saveMoney;
		this.saveTime = saveTime;
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

    public Integer getSaveMoney() {
        return saveMoney;
    }

    public void setSaveMoney(Integer saveMoney) {
        this.saveMoney = saveMoney;
    }

    public Date getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(Date saveTime) {
        this.saveTime = saveTime;
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
		return "Deposit [id=" + id + ", aid=" + aid + ", saveMoney="
				+ saveMoney + ", saveTime=" + saveTime + ", money=" + money
				+ ", state=" + state + "]";
	}
    
    
}