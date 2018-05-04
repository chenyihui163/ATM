package com.atm.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * 用户个人信息
 * @author chenyihui
   2018年3月29日
 */
@Alias("User")
public class User implements Serializable {
    private Integer userid;//个人id

    private String username;//名字

    private String sex;//性别

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;//出生日期

    private Integer state;//状态

    private Integer identityType;//身份类型

    private String phone;//电话号码

    private String identityCard;//身份证号

    private String address;//地址
    
	private Account account;

    private static final long serialVersionUID = 1L;

    public User(){
    	super();
    }
    
    public User(User user)
    {
    	super();
    	this.username=user.getUsername();
    	this.sex=user.getSex();
    	this.birth=user.getBirth();
    	this.identityType=user.getIdentityType();
    	this.identityCard=user .getIdentityCard();
    	this.phone =user.getPhone();
    	this.address=user.getAddress();
    }
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getIdentityType() {
        return identityType;
    }

    public void setIdentityType(Integer identityType) {
        this.identityType = identityType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", sex="
				+ sex + ", birth=" + birth + ", state=" + state
				+ ", identityType=" + identityType + ", phone=" + phone
				+ ", identityCard=" + identityCard + ", address=" + address
				+ "]";
	}
    
    
    
}