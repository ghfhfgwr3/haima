package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 消费机表 t_consumer_machine
 * 
 * @author ruoyi
 * @date 2019-09-04
 */
public class TConsumerMachine extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private Integer id;
	/** 商户信息 */
	private String shopInfo;
	/** 商户编号   ,店铺表的外键*/
	private String shopNum;
	/** 卡密 */
	private String kalman;
	/** 本设备模式 */
	private String devMode;
	/** 服务器域名 */
	private String domain;
	/** 端口号 */
	private String port;
	/** 最大消费金额 */
	private String maxMoney;
	/** 押金 */
	private String deposit;
	/** 当次限额 */
	private String current;
	/** 卡标示 */
	private String cardLabeling;
	/** 折扣 */
	private String discount;
	/** 卡类型 */
	private String cardType;
	/** 本设备名称 */
	private String devName;
	/** 升级文件目录及信息 */
	private String file;
	/** 请求路径 */
	private String path;
	/** 账号 */
	private String account;
	/** 密码 */
	private String pwd;
	/** 设备ID */
	private String devId;
	/** 设备请求时间 */
	private String time;

	/**
	 * 状态
	 * @param id
	 */
	private  Integer state;

	/**
	 * 会员类型表
	 */
	private TMemberType tMemberType;

	/**
	 * 公司表
	 * @param id
	 */
	private SysDept sysDept;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setShopInfo(String shopInfo) 
	{
		this.shopInfo = shopInfo;
	}

	public String getShopInfo() 
	{
		return shopInfo;
	}
	public void setShopNum(String shopNum) 
	{
		this.shopNum = shopNum;
	}

	public String getShopNum() 
	{
		return shopNum;
	}
	public void setKalman(String kalman) 
	{
		this.kalman = kalman;
	}

	public String getKalman() 
	{
		return kalman;
	}
	public void setDevMode(String devMode) 
	{
		this.devMode = devMode;
	}

	public String getDevMode() 
	{
		return devMode;
	}
	public void setDomain(String domain) 
	{
		this.domain = domain;
	}

	public String getDomain() 
	{
		return domain;
	}
	public void setPort(String port) 
	{
		this.port = port;
	}

	public String getPort() 
	{
		return port;
	}
	public void setMaxMoney(String maxMoney) 
	{
		this.maxMoney = maxMoney;
	}

	public String getMaxMoney() 
	{
		return maxMoney;
	}
	public void setDeposit(String deposit) 
	{
		this.deposit = deposit;
	}

	public String getDeposit() 
	{
		return deposit;
	}
	public void setCurrent(String current) 
	{
		this.current = current;
	}

	public String getCurrent() 
	{
		return current;
	}
	public void setCardLabeling(String cardLabeling) 
	{
		this.cardLabeling = cardLabeling;
	}

	public String getCardLabeling() 
	{
		return cardLabeling;
	}
	public void setDiscount(String discount) 
	{
		this.discount = discount;
	}

	public String getDiscount() 
	{
		return discount;
	}
	public void setCardType(String cardType) 
	{
		this.cardType = cardType;
	}

	public String getCardType() 
	{
		return cardType;
	}
	public void setDevName(String devName) 
	{
		this.devName = devName;
	}

	public String getDevName() 
	{
		return devName;
	}
	public void setFile(String file) 
	{
		this.file = file;
	}

	public String getFile() 
	{
		return file;
	}
	public void setPath(String path) 
	{
		this.path = path;
	}

	public String getPath() 
	{
		return path;
	}
	public void setAccount(String account) 
	{
		this.account = account;
	}

	public String getAccount() 
	{
		return account;
	}
	public void setPwd(String pwd) 
	{
		this.pwd = pwd;
	}

	public String getPwd() 
	{
		return pwd;
	}
	public void setDevId(String devId) 
	{
		this.devId = devId;
	}

	public String getDevId() 
	{
		return devId;
	}
	public void setTime(String time) 
	{
		this.time = time;
	}

	public String getTime() 
	{
		return time;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("shopInfo", getShopInfo())
            .append("shopNum", getShopNum())
            .append("kalman", getKalman())
            .append("devMode", getDevMode())
            .append("domain", getDomain())
            .append("port", getPort())
            .append("maxMoney", getMaxMoney())
            .append("deposit", getDeposit())
            .append("current", getCurrent())
            .append("cardLabeling", getCardLabeling())
            .append("discount", getDiscount())
            .append("cardType", getCardType())
            .append("devName", getDevName())
            .append("file", getFile())
            .append("path", getPath())
            .append("account", getAccount())
            .append("pwd", getPwd())
            .append("devId", getDevId())
            .append("time", getTime())
				.append("state",getState())
            .toString();
    }

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public TMemberType gettMemberType() {
		return tMemberType;
	}

	public void settMemberType(TMemberType tMemberType) {
		this.tMemberType = tMemberType;
	}

	public SysDept getSysDept() {
		return sysDept;
	}

	public void setSysDept(SysDept sysDept) {
		this.sysDept = sysDept;
	}
}
