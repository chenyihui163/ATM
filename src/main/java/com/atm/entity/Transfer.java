package com.atm.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;


@Alias("Transfer")
public class Transfer implements Serializable {
    private Integer tid;

    private Integer senderid;

    private Integer receiverid;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date transferTime;

    private Integer transferMoney;

    private Integer state;
    
    private Account account;

    private static final long serialVersionUID = 1L;

    public Transfer() {
		super();
	}



	public Transfer(Integer senderid, Integer receiverid, Date transferTime,
			Integer transferMoney) {
		super();
		this.senderid = senderid;
		this.receiverid = receiverid;
		this.transferTime = transferTime;
		this.transferMoney = transferMoney;
	}

    

    public Transfer(Integer senderid, Integer receiverid,
			Integer transferMoney) {
		super();
		this.senderid = senderid;
		this.receiverid = receiverid;
		this.transferMoney = transferMoney;
	}
    
	public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getSenderid() {
        return senderid;
    }

    public void setSenderid(Integer senderid) {
        this.senderid = senderid;
    }

    public Integer getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(Integer receiverid) {
        this.receiverid = receiverid;
    }

    public Date getTransferTime() {
        return transferTime;
    }

    public void setTransferTime(Date transferTime) {
        this.transferTime = transferTime;
    }

    public Integer getTransferMoney() {
        return transferMoney;
    }

    public void setTransferMoney(Integer transferMoney) {
        this.transferMoney = transferMoney;
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
		return "Transfer [tid=" + tid + ", senderid=" + senderid
				+ ", receiverid=" + receiverid + ", transferTime="
				+ transferTime + ", transferMoney=" + transferMoney
				+ ", state=" + state + "]";
	}
    
    
}