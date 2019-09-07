package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 奖励规则表 t_giverule
 *
 * @author ruoyi
 * @date 2019-07-12
 */
public class TGiverule extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer id;
    /**
     * 会员卡类型
     */
    private Integer cardtype;
    /**
     * 开始金额
     */
    private BigDecimal beginMoney;
    /**
     * 结束金额
     */
    private BigDecimal andMoney;
    /**
     * 赠送方式
     */
    private Integer giveType;
    /**
     * 赠送金额
     */
    private BigDecimal giveMoney;
    /**
     * 开始时间
     */
    private String beginDate;
    /**
     * 结束时间
     */
    private String andDate;
    /**
     * 实物奖励编号
     */
    private String givePxs;
    /**
     * 领奖编号
     */
    private Integer ljType;
    /**
     * 数量
     */
    private Integer giveCount;
    /**
     * 有效天数
     */
    private Integer yxts;
    /**
     * 公司ID
     */
    private Long companyid;
    /**
     * 对应公司表
     */
    private SysDept sysDept;
    /**
     * 对应卡类型表
     */
    private TMemberType tMemberType;

    private BigDecimal perCentage;

    public BigDecimal getPerCentage() {
        return perCentage;
    }

    public void setPerCentage(BigDecimal perCentage) {
        this.perCentage = perCentage;
    }

    public Long getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Long companyid) {
        this.companyid = companyid;
    }

    public SysDept getSysDept() {
        return sysDept;
    }

    public void setSysDept(SysDept sysDept) {
        this.sysDept = sysDept;
    }

    public TMemberType gettMemberType() {
        return tMemberType;
    }

    public void settMemberType(TMemberType tMemberType) {
        this.tMemberType = tMemberType;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setCardtype(Integer cardtype) {
        this.cardtype = cardtype;
    }

    public Integer getCardtype() {
        return cardtype;
    }

    public void setBeginMoney(BigDecimal beginMoney) {
        this.beginMoney = beginMoney;
    }

    public BigDecimal getBeginMoney() {
        return beginMoney;
    }

    public void setAndMoney(BigDecimal andMoney) {
        this.andMoney = andMoney;
    }

    public BigDecimal getAndMoney() {
        return andMoney;
    }

    public void setGiveType(Integer giveType) {
        this.giveType = giveType;
    }

    public Integer getGiveType() {
        return giveType;
    }

    public void setGiveMoney(BigDecimal giveMoney) {
        this.giveMoney = giveMoney;
    }

    public BigDecimal getGiveMoney() {
        return giveMoney;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setAndDate(String andDate) {
        this.andDate = andDate;
    }

    public String getAndDate() {
        return andDate;
    }

    public void setGivePxs(String givePxs) {
        this.givePxs = givePxs;
    }

    public String getGivePxs() {
        return givePxs;
    }

    public void setLjType(Integer ljType) {
        this.ljType = ljType;
    }

    public Integer getLjType() {
        return ljType;
    }

    public void setGiveCount(Integer giveCount) {
        this.giveCount = giveCount;
    }

    public Integer getGiveCount() {
        return giveCount;
    }

    public void setYxts(Integer yxts) {
        this.yxts = yxts;
    }

    public Integer getYxts() {
        return yxts;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id" , getId())
                .append("cardtype" , getCardtype())
                .append("beginMoney" , getBeginMoney())
                .append("andMoney" , getAndMoney())
                .append("giveType" , getGiveType())
                .append("giveMoney" , getGiveMoney())
                .append("beginDate" , getBeginDate())
                .append("andDate" , getAndDate())
                .append("givePxs" , getGivePxs())
                .append("ljType" , getLjType())
                .append("giveCount" , getGiveCount())
                .append("yxts" , getYxts())
                .append("perCentage" , getPerCentage())
                .toString();
    }
}
