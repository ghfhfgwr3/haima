package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.utils.DateUtilsStr;

import java.util.Date;

/**
 * 补卡记录表 t_card_replacement
 *
 * @author ruoyi
 * @date 2019-06-03
 */
public class TCardReplacement extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @Excel(name = "补卡记录ID")
    private Integer id;
    /**
     * 旧卡号
     */
    @Excel(name = "旧卡号")
    private String cardnoOld;
    /**
     * 新卡号
     */
    @Excel(name = "新卡号")
    private String cardnoNew;
    /**
     * 操作时间
     */

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "操作时间")
    private Date operateTime;
    /**
     * 操作人员
     */
    @Excel(name = "操作人员")
    private String operator;
    /**
     * 前台展示时间
     */
    private String operateTimeStr;
    /**
     * 对应公司表
     */
    private SysDept sysDept;
    /**
     * 公司ID
     */
    private Long companyid;

    public String getOperateTimeStr() {
        if (operateTime != null) {
            operateTimeStr = DateUtilsStr.dateFormat(operateTime, DateUtilsStr.DATE_TIME_PATTERN);
        }
        return operateTimeStr;
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

    public void setOperateTimeStr(String operateTimeStr) {
        this.operateTimeStr = operateTimeStr;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setCardnoOld(String cardnoOld) {
        this.cardnoOld = cardnoOld;
    }

    public String getCardnoOld() {
        return cardnoOld;
    }

    public void setCardnoNew(String cardnoNew) {
        this.cardnoNew = cardnoNew;
    }

    public String getCardnoNew() {
        return cardnoNew;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id" , getId())
                .append("cardnoOld" , getCardnoOld()).append("cardnoNew" , getCardnoNew())
                .append("operateTime" , getOperateTime()).append("operator" , getOperator()).toString();
    }
}
