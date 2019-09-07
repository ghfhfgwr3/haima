package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.utils.DateUtilsStr;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;
import springfox.documentation.annotations.ApiIgnore;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 会员表 t_member
 *
 * @author ruoyi
 * @date 2019-06-03
 */

public class TMember extends BaseEntity {
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
     * 会员类型
     */
    @Excel(name = "会员类型")
    private Long memberTypeId;
    /**
     * 会员卡号
     */
    @Excel(name = "卡号")
    private String memberNo;
    /**
     * 会员卡ID
     */
    @Excel(name = "会员卡ID")
    private String cardid;
    /**
     * 会员卡密码
     */
    @Excel(name = "密码")
    private String password;
    /**
     * 会员姓名
     */
    @Excel(name = "姓名")
    private String memberName;
    /**
     * 会员电话
     */
    @Excel(name = "电话")
    private String mobilephones;
    /**
     * 卡现有余额
     */
    @Excel(name = "现有余额")
    private BigDecimal balance;
    /**
     * 奖励金额
     */
    @Excel(name = "奖励金额")
    private BigDecimal complimentaryMoney;
    /**
     * 奖励金额
     */
    @Excel(name = "奖励金额")
    private BigDecimal money;
    /**
     * 是否有计次品相
     */
    @Excel(name = "是否有计次品相")
    private Integer haveCount;
    /**
     * 办卡时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "办卡时间" , width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date addDatetime;

    /**
     * 是否为可用状态（0正常1已挂失）
     */
    @Excel(name = "是否挂失")
    private Integer isloss;
    /**
     * 是否为可用状态（0正常1已注销）
     */
    @Excel(name = "状态")
    private Integer state;
    /**
     * 积分
     */
    @Excel(name = "积分")
    private BigDecimal points;
    /**
     * 有效期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "有效期" , width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date expirydate;
    /**
     * 手续费
     */
    @Excel(name = "手续费")
    private BigDecimal commission;
    /**
     * 出生日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "出生日期" , width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date birtdate;
    /**
     * 性别
     */
    @Excel(name = "性别")
    private String sex;
    /**
     * 国家
     */
    @Excel(name = "国家")
    private String nation;
    /**
     * 血型
     */
    @Excel(name = "血型")
    private String blood;
    /**
     * 身高
     */
    @Excel(name = "身高")
    private BigDecimal stature;
    /**
     * 体重
     */
    @Excel(name = "体重")
    private BigDecimal weight;
    /**
     * 职业
     */
    @Excel(name = "职业")
    private String carrer;
    /**
     * 教育程度
     */
    @Excel(name = "教育程度")
    private String education;
    /**
     * ID卡号
     */
    @Excel(name = "ID卡号")
    private String iDcardno;
    /**
     * 电话
     */
    @Excel(name = "电话")
    private String telephone;
    /**
     * 电子邮件
     */
    @Excel(name = "邮件")
    private String email;

    /**
     * 邮编
     */
    @Excel(name = "邮编")
    private String postcode;
    /**
     * 省份
     */
    @Excel(name = "省")
    private String province;
    /**
     * 市
     */
    @Excel(name = "市")
    private String city;
    /**
     * 备注
     */
    @Excel(name = "备注")
    private String memo;
    /**
     * 区
     */
    @Excel(name = "区")
    private String area;
    /**
     * 地址
     */
    @Excel(name = "地址")
    private String address;

    /**
     * 对应公司表
     */

    private SysDept sysDept = new SysDept();
    /**
     * 对应卡类型表
     */
    private TMemberType tMemberType = new TMemberType();

    /**
     * 字符串办卡时间
     */
    private String addDatetimeStr;
    /**
     * 字符串有效期
     */
    private String expirydateStr;
    /**
     * 字符串有效时间
     */
    private String birtdateStr;


    private Integer ismakeup;


    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }


    public SysDept getSysDept() {
        return sysDept;
    }

    public void setSysDept(SysDept sysDept) {
        this.sysDept = sysDept;
    }

    public void settMemberType(TMemberType tMemberType) {
        this.tMemberType = tMemberType;
    }

    public TMemberType gettMemberType() {
        return tMemberType;
    }

    public String getAddDatetimeStr() {
        if (addDatetime != null) {
            addDatetimeStr = DateUtilsStr.dateFormat(addDatetime, DateUtilsStr.DATE_TIME_PATTERN);
        }
        return addDatetimeStr;
    }

    public void setAddDatetimeStr(String addDatetimeStr) {
        this.addDatetimeStr = addDatetimeStr;
    }

    public String getExpirydateStr() {
        if (expirydate != null) {
            expirydateStr = DateUtilsStr.dateFormat(expirydate, DateUtilsStr.DATE_TIME_PATTERN);
        }
        return expirydateStr;
    }

    public void setExpirydateStr(String expirydateStr) {
        this.expirydateStr = expirydateStr;
    }

    public String getBirtdateStr() {
        if (birtdate != null) {
            birtdateStr = DateUtilsStr.dateFormat(birtdate, DateUtilsStr.DATE_TIME_PATTERN);
        }
        return birtdateStr;
    }

    public void setBirtdateStr(String birtdateStr) {
        this.birtdateStr = birtdateStr;
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

    public void setMemberTypeId(Long memberTypeId) {
        this.memberTypeId = memberTypeId;
    }

    public Long getMemberTypeId() {
        return memberTypeId;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getCardid() {
        return cardid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMobilephones(String mobilephones) {
        this.mobilephones = mobilephones;
    }

    public String getMobilephones() {
        return mobilephones;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setComplimentaryMoney(BigDecimal complimentaryMoney) {
        this.complimentaryMoney = complimentaryMoney;
    }

    public BigDecimal getComplimentaryMoney() {
        return complimentaryMoney;
    }

    public void setHaveCount(Integer haveCount) {
        this.haveCount = haveCount;
    }

    public Integer getHaveCount() {
        return haveCount;
    }

    public void setAddDatetime(Date addDatetime) {
        this.addDatetime = addDatetime;
    }

    public Date getAddDatetime() {
        return addDatetime;
    }

    public void setIsloss(Integer isloss) {
        this.isloss = isloss;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getIsloss() {
        return isloss;
    }

    public Integer getState() {
        return state;
    }


    public void setPoints(BigDecimal points) {
        this.points = points;
    }

    public BigDecimal getPoints() {
        return points;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setBirtdate(Date birtdate) {
        this.birtdate = birtdate;
    }

    public Date getBirtdate() {
        return birtdate;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNation() {
        return nation;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getBlood() {
        return blood;
    }

    public void setStature(BigDecimal stature) {
        this.stature = stature;
    }

    public BigDecimal getStature() {
        return stature;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public String getCarrer() {
        return carrer;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEducation() {
        return education;
    }

    public void setIDcardno(String iDcardno) {
        this.iDcardno = iDcardno;
    }

    public String getIDcardno() {
        return iDcardno;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
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

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince() {
        return province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getMemo() {
        return memo;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id" , getId())
                .append("companyid" , getCompanyid()).append("memberTypeId" , getMemberTypeId())
                .append("memberNo" , getMemberNo()).append("cardid" , getCardid()).append("password" , getPassword())
                .append("memberName" , getMemberName()).append("mobilephones" , getMobilephones())
                .append("balance" , getBalance()).append("complimentaryMoney" , getComplimentaryMoney())
                .append("haveCount" , getHaveCount()).append("addDatetime" , getAddDatetime()).append("isloss" , getIsloss()).append("state" , getState())
                .append("points" , getPoints()).append("expirydate" , getExpirydate())
                .append("commission" , getCommission()).append("birtdate" , getBirtdate()).append("sex" , getSex())
                .append("nation" , getNation()).append("blood" , getBlood()).append("stature" , getStature())
                .append("weight" , getWeight()).append("carrer" , getCarrer()).append("education" , getEducation())
                .append("iDcardno" , getIDcardno()).append("telephone" , getTelephone()).append("email" , getEmail())
                .append("address" , getAddress()).append("postcode" , getPostcode()).append("province" , getProvince())
                .append("city" , getCity()).append("memo" , getMemo()).append("area" , getArea()).toString();
    }

    public Integer getIsmakeup() {
        return ismakeup;
    }

    public void setIsmakeup(Integer ismakeup) {
        this.ismakeup = ismakeup;
    }
}

