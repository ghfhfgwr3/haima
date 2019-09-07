package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.utils.DateUtilsStr;

import java.util.Date;
import java.math.BigDecimal;

/**
 * 会员余额的增加和减少表 t_balance_change
 *
 * @author ruoyi
 * @date 2019-06-03
 */
public class TBalanceChange extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;
    /**
     * 操作时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "操作时间" , width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date operationTime;
    /**
     * 变化金额
     */
    @Excel(name = "变化金额")
    private BigDecimal changeMoney;
    /**
     * 奖励金额
     */
    @Excel(name = "奖励金额")
    private BigDecimal complimentaryMoney;
    /**
     * 员工工号
     */
    @Excel(name = "员工工号")
    private String workerid;
    /**
     * 状态
     */
    private Integer state;
    /**
     * 付款方式
     */
    private Integer paytype;
    /**
     * 订单号
     */
    private String payorderNO;
    /**
     * 备注
     */
    private String memo;
    /**
     * 对应公司表
     */
    private SysDept sysDept;
    /**
     * 公司ID
     */
    private Long companyid;
    /**
     * 会员卡号
     */
    private String memberNo;
    /**
     * 前台展示时间
     */
    private String operationTimeStr;

    public String getOperationTimeStr() {
        if (operationTime != null) {
            operationTimeStr = DateUtilsStr.dateFormat(operationTime, DateUtilsStr.DATE_TIME_PATTERN);
        }
        return operationTimeStr;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
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

    public void setOperationTimeStr(String operationTimeStr) {
        this.operationTimeStr = operationTimeStr;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setChangeMoney(BigDecimal changeMoney) {
        this.changeMoney = changeMoney;
    }

    public BigDecimal getChangeMoney() {
        return changeMoney;
    }

    public void setComplimentaryMoney(BigDecimal complimentaryMoney) {
        this.complimentaryMoney = complimentaryMoney;
    }

    public BigDecimal getComplimentaryMoney() {
        return complimentaryMoney;
    }

    public void setWorkerid(String workerid) {
        this.workerid = workerid;
    }

    public String getWorkerid() {
        return workerid;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getState() {
        return state;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }

    public Integer getPaytype() {
        return paytype;
    }

    public void setPayorderNO(String payorderNO) {
        this.payorderNO = payorderNO;
    }

    public String getPayorderNO() {
        return payorderNO;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getMemo() {
        return memo;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id" , getId())
                .append("operationTime" , getOperationTime()).append("changeMoney" , getChangeMoney())
                .append("complimentaryMoney" , getComplimentaryMoney()).append("workerid" , getWorkerid())
                .append("state" , getState()).append("paytype" , getPaytype()).append("payorderNO" , getPayorderNO())
                .append("memo" , getMemo()).toString();
    }
}
