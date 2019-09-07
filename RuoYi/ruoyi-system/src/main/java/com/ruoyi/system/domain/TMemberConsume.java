package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.math.BigDecimal;

/**
 * 会员消费表 t_member_consume
 *
 * @author ruoyi
 * @date 2019-07-02
 */
public class TMemberConsume extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;
    /**
     * 公司ID
     */
    @Excel(name = "公司ID")
    private Long companyid;
    /**
     * 单据号
     */
    @Excel(name = "单据号")
    private String djh;
    /**
     * 卡号
     */
    @Excel(name = "卡号")
    private String cardno;
    /**
     * 手机号
     */
    @Excel(name = "手机号")
    private String phone;
    /**
     * 会员姓名
     */
    @Excel(name = "会员姓名")
    private String memberName;
    /**
     * 消费类型
     */
    @Excel(name = "消费类型")
    private String consumeType;
    /**
     * 消费时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "消费时间" , width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date consumeTime;
    /**
     * 操作员
     */
    @Excel(name = "操作员")
    private String oprator;
    /**
     * 总金额
     */
    @Excel(name = "总金额")
    private String totalMoney;
    /**
     * 折扣后金额
     */
    @Excel(name = "折扣后金额")
    private String money;
    /**
     * 支付类型
     */
    @Excel(name = "支付类型")
    private String paytype;
    /**
     * 会员卡类型
     */
    @Excel(name = "会员卡类型")
    private String cardType;
    /**
     * 会员卡支付
     */
    @Excel(name = "会员卡支付")
    private BigDecimal cardpay;
    /**
     * 现金支付
     */
    @Excel(name = "现金支付")
    private BigDecimal cashpay;
    /**
     * 银行卡支付
     */
    @Excel(name = "银行卡支付")
    private BigDecimal bankpay;
    /**
     * 积分支付
     */
    @Excel(name = "积分支付")
    private BigDecimal centpay;
    /**
     * 现金券
     */
    @Excel(name = "现金券")
    private BigDecimal cashcoupon;
    /**
     * 抹零金额
     */
    @Excel(name = "抹零金额")
    private BigDecimal moling;
    /**
     * 实付金额
     */
    @Excel(name = "实付金额")
    private BigDecimal realMoney;
    /**
     * 对应公司表
     */
    private SysDept sysDept;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCompanyid(Long companyid) {
        this.companyid = companyid;
    }

    public Long getCompanyid() {
        return companyid;
    }

    public void setDjh(String djh) {
        this.djh = djh;
    }

    public String getDjh() {
        return djh;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getCardno() {
        return cardno;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setConsumeType(String consumeType) {
        this.consumeType = consumeType;
    }

    public String getConsumeType() {
        return consumeType;
    }

    public void setConsumeTime(Date consumeTime) {
        this.consumeTime = consumeTime;
    }

    public Date getConsumeTime() {
        return consumeTime;
    }

    public void setOprator(String oprator) {
        this.oprator = oprator;
    }

    public String getOprator() {
        return oprator;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getMoney() {
        return money;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardpay(BigDecimal cardpay) {
        this.cardpay = cardpay;
    }

    public BigDecimal getCardpay() {
        return cardpay;
    }

    public void setCashpay(BigDecimal cashpay) {
        this.cashpay = cashpay;
    }

    public BigDecimal getCashpay() {
        return cashpay;
    }

    public void setBankpay(BigDecimal bankpay) {
        this.bankpay = bankpay;
    }

    public BigDecimal getBankpay() {
        return bankpay;
    }

    public void setCentpay(BigDecimal centpay) {
        this.centpay = centpay;
    }

    public BigDecimal getCentpay() {
        return centpay;
    }

    public void setCashcoupon(BigDecimal cashcoupon) {
        this.cashcoupon = cashcoupon;
    }

    public BigDecimal getCashcoupon() {
        return cashcoupon;
    }

    public void setMoling(BigDecimal moling) {
        this.moling = moling;
    }

    public BigDecimal getMoling() {
        return moling;
    }

    public void setRealMoney(BigDecimal realMoney) {
        this.realMoney = realMoney;
    }

    public BigDecimal getRealMoney() {
        return realMoney;
    }

    public SysDept getSysDept() {
        return sysDept;
    }

    public void setSysDept(SysDept sysDept) {
        this.sysDept = sysDept;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id" , getId())
                .append("companyid" , getCompanyid())
                .append("djh" , getDjh())
                .append("cardno" , getCardno())
                .append("phone" , getPhone())
                .append("memberName" , getMemberName())
                .append("consumeType" , getConsumeType())
                .append("consumeTime" , getConsumeTime())
                .append("oprator" , getOprator())
                .append("totalMoney" , getTotalMoney())
                .append("money" , getMoney())
                .append("paytype" , getPaytype())
                .append("cardType" , getCardType())
                .append("cardpay" , getCardpay())
                .append("cashpay" , getCashpay())
                .append("bankpay" , getBankpay())
                .append("centpay" , getCentpay())
                .append("cashcoupon" , getCashcoupon())
                .append("moling" , getMoling())
                .append("realMoney" , getRealMoney())
                .toString();
    }
}
