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
 * 员工表 t_worker
 *
 * @author ruoyi
 * @date 2019-06-03
 */
public class TWorker extends BaseEntity {
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
     * 账号
     */
    @Excel(name = "账户名")
    private String loginNo;
    /**
     * 密码
     */
    @Excel(name = "密码")
    private String loginPassword;
    /**
     * 工名
     */
    @Excel(name = "工名")
    private String workerName;
    /**
     * 性别
     */
    @Excel(name = "性别")
    private Integer workerSex;
    /**
     * 国家
     */
    @Excel(name = "国家")
    private String nation;
    /**
     * 教育程度
     */
    @Excel(name = "教育程度")
    private String education;
    /**
     * 家乡
     */
    @Excel(name = "家乡")
    private String homeTown;
    /**
     * 地址
     */
    @Excel(name = "地址")
    private String address;
    /**
     * 邮编
     */
    @Excel(name = "邮编")
    private String postcode;
    /**
     * ID卡号
     */
    @Excel(name = "ID卡号")
    private String iDCardno;
    /**
     * 电子邮件
     */
    @Excel(name = "电子邮件")
    private String email;
    /**
     * 电话
     */
    @Excel(name = "电话")
    private String telephone;
    /**
     * 手机
     */
    @Excel(name = "手机")
    private String mobile;
    /**
     * 薪水
     */
    @Excel(name = "薪水")
    private BigDecimal salary;
    /**
     * 工龄
     */
    @Excel(name = "工龄")
    private Integer workAge;
    /**
     * 是否离职
     */
    @Excel(name = "是否离职")
    private Integer isLeave;
    /**
     * 入职时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "入职时间, width = 30, dateFormat = \"yyyy-MM-dd HH:mm:ss\"")
    private Date hiredate;
    /**
     * 离职日期
     */
    @Excel(name = "离职日期, width = 30, dateFormat = \"yyyy-MM-dd HH:mm:ss\"")

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date leavedate;
    /**
     * 备注
     */
    @Excel(name = "备注")
    private String memo;
    /**
     * 字符串入职时间
     */
    private String hiredateStr;
    /**
     * 字符串离职时间
     */
    private String leavedateStr;
    private SysDept sysDept;

    public SysDept getSysDept() {
        return sysDept;
    }

    public void setSysDept(SysDept sysDept) {
        this.sysDept = sysDept;
    }

    public String getHiredateStr() {
        if (hiredate != null) {
            hiredateStr = DateUtilsStr.dateFormat(hiredate, DateUtilsStr.DATE_TIME_PATTERN);
        }
        return hiredateStr;
    }

    public void setHiredateStr(String hiredateStr) {
        this.hiredateStr = hiredateStr;
    }

    public String getLeavedateStr() {
        if (leavedate != null) {
            leavedateStr = DateUtilsStr.dateFormat(leavedate, DateUtilsStr.DATE_TIME_PATTERN);
        }
        return leavedateStr;
    }

    public void setLeavedateStr(String leavedateStr) {
        this.leavedateStr = leavedateStr;
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

    public void setLoginNo(String loginNo) {
        this.loginNo = loginNo;
    }

    public String getLoginNo() {
        return loginNo;
    }

    public static boolean isLoginNo(String loginNo) {
        return loginNo != null;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerSex(Integer workerSex) {
        this.workerSex = workerSex;
    }

    public Integer getWorkerSex() {
        return workerSex;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNation() {
        return nation;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEducation() {
        return education;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setIDCardno(String iDCardno) {
        this.iDCardno = iDCardno;
    }

    public String getIDCardno() {
        return iDCardno;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setWorkAge(Integer workAge) {
        this.workAge = workAge;
    }

    public Integer getWorkAge() {
        return workAge;
    }

    public void setIsLeave(Integer isLeave) {
        this.isLeave = isLeave;
    }

    public Integer getIsLeave() {
        return isLeave;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setLeavedate(Date leavedate) {
        this.leavedate = leavedate;
    }

    public Date getLeavedate() {
        return leavedate;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getMemo() {
        return memo;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id" , getId())
                .append("companyid" , getCompanyid())
                .append("loginNo" , getLoginNo())
                .append("loginPassword" , getLoginPassword())
                .append("workerName" , getWorkerName())
                .append("workerSex" , getWorkerSex())
                .append("nation" , getNation())
                .append("education" , getEducation())
                .append("homeTown" , getHomeTown())
                .append("address" , getAddress())
                .append("postcode" , getPostcode())
                .append("iDCardno" , getIDCardno())
                .append("email" , getEmail())
                .append("telephone" , getTelephone())
                .append("mobile" , getMobile())
                .append("salary" , getSalary())
                .append("workAge" , getWorkAge())
                .append("isLeave" , getIsLeave())
                .append("hiredate" , getHiredate())
                .append("leavedate" , getLeavedate())
                .append("memo" , getMemo())
                .toString();
    }
}
