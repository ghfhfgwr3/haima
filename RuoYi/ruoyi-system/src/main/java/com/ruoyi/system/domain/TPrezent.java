package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 积分兑换表 t_prezent
 *
 * @author ruoyi
 * @date 2019-07-05
 */
public class TPrezent extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;
    /**
     * 公司ID
     */
    private Long companyid;
    /**
     * 礼品编号
     */
    private String prezentBh;
    /**
     * 礼品名称
     */
    private String prezentName;
    /**
     * 礼品总数
     */
    private Integer prezentTotalnum;
    /**
     * 剩余数量
     */
    private Integer prezentRemain;
    /**
     * 图片
     */
    private String prezentImg;
    /**
     * 所需积分
     */
    private Integer cent;
    /**
     * 操作员
     */
    private String oprator;
    /**
     * 状态
     */
    private Integer state;
    /**
     * 操作时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginDate;
    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;
    private SysDept sysDept;

    public SysDept getSysDept() {
        return sysDept;
    }

    public void setSysDept(SysDept sysDept) {
        this.sysDept = sysDept;
    }

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

    public void setPrezentBh(String prezentBh) {
        this.prezentBh = prezentBh;
    }

    public String getPrezentBh() {
        return prezentBh;
    }

    public void setPrezentName(String prezentName) {
        this.prezentName = prezentName;
    }

    public String getPrezentName() {
        return prezentName;
    }

    public void setPrezentTotalnum(Integer prezentTotalnum) {
        this.prezentTotalnum = prezentTotalnum;
    }

    public Integer getPrezentTotalnum() {
        return prezentTotalnum;
    }

    public void setPrezentRemain(Integer prezentRemain) {
        this.prezentRemain = prezentRemain;
    }

    public Integer getPrezentRemain() {
        return prezentRemain;
    }

    public void setPrezentImg(String prezentImg) {
        this.prezentImg = prezentImg;
    }

    public String getPrezentImg() {
        return prezentImg;
    }

    public void setCent(Integer cent) {
        this.cent = cent;
    }

    public Integer getCent() {
        return cent;
    }

    public void setOprator(String oprator) {
        this.oprator = oprator;
    }

    public String getOprator() {
        return oprator;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getState() {
        return state;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id" , getId())
                .append("companyid" , getCompanyid())
                .append("prezentBh" , getPrezentBh())
                .append("prezentName" , getPrezentName())
                .append("prezentTotalnum" , getPrezentTotalnum())
                .append("prezentRemain" , getPrezentRemain())
                .append("prezentImg" , getPrezentImg())
                .append("cent" , getCent())
                .append("oprator" , getOprator())
                .append("state" , getState())
                .append("createDate" , getCreateDate())
                .append("beginDate" , getBeginDate())
                .append("endDate" , getEndDate())
                .toString();
    }
}
