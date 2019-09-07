package com.ruoyi.system.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import springfox.documentation.annotations.ApiIgnore;

import java.math.BigDecimal;
import java.util.List;

/**
 * 会员类型表 t_member_type
 *
 * @author ruoyi
 * @date 2019-06-03
 */
public class TMemberType extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Integer id;

    /**
     * 公司ID
     */
    private Long companyid;
    /**
     * 会员卡类型
     */
    private String memberTypeName;
    /**
     * 折扣
     */
    private Integer discount;
    /**
     * 有效期
     */
    private Integer validDays;
    /**
     * 是否会员价
     */
    private String isMemberPrice;
    /**
     * 是否积分
     */
    private String isPoints;
    /**
     * 是否可退
     */
    private String isRerurn;
    /**
     * 是否M1卡
     */
    private String isM1;
    /**
     * 最大消费
     */
    private BigDecimal maxConsume;
    /**
     * 补办费用
     */
    private BigDecimal makeUpCost;
    /**
     * 是否奖励
     */
    private String isEncourage;
    /**
     * 是否允许跨店消费
     */
    private String isAllowother;
    /**
     * 备注
     */
    private String memo;
    /**
     * 积分规则
     */
    private Integer points_rule;
    /**
     * 对应公司表
     */
    private SysDept sysDept;
    /**
     * 对应奖励表
     */
    private TGiverule giverule;


    private List arrList;

    public TGiverule getGiverule() {
        return giverule;
    }

    public void setGiverule(TGiverule giverule) {
        this.giverule = giverule;
    }

    public List getArrList() {
        return arrList;
    }

    public void setArrList(List arrList) {
        this.arrList = arrList;
    }

    public Integer getPoints_rule() {
        return points_rule;
    }

    public void setPoints_rule(Integer points_rule) {
        this.points_rule = points_rule;
    }

    public TMemberType() {
        super();
        // TODO Auto-generated constructor stub
    }

    public TMemberType(Integer id, Long companyid, String memberTypeName, Integer discount, Integer validDays, String isMemberPrice, String isPoints, String isRerurn, String isM1, BigDecimal maxConsume, BigDecimal makeUpCost, String isEncourage, String isAllowother, String memo, Integer points_rule, SysDept sysDept, List arrList) {
        this.id = id;
        this.companyid = companyid;
        this.memberTypeName = memberTypeName;
        this.discount = discount;
        this.validDays = validDays;
        this.isMemberPrice = isMemberPrice;
        this.isPoints = isPoints;
        this.isRerurn = isRerurn;
        this.isM1 = isM1;
        this.maxConsume = maxConsume;
        this.makeUpCost = makeUpCost;
        this.isEncourage = isEncourage;
        this.isAllowother = isAllowother;
        this.memo = memo;
        this.points_rule = points_rule;
        this.sysDept = sysDept;
        this.arrList = arrList;
    }

//	public TMemberType(Integer id, Long companyid, String memberTypeName, Integer discount, Integer validDays, String isMemberPrice, String isPoints, String isRerurn, String isM1, BigDecimal maxConsume, BigDecimal makeUpCost, String isEncourage, String isAllowother, String memo, SysDept sysDept) {
//		this.id = id;
//		this.companyid = companyid;
//		this.memberTypeName = memberTypeName;
//		this.discount = discount;
//		this.validDays = validDays;
//		this.isMemberPrice = isMemberPrice;
//		this.isPoints = isPoints;
//		this.isRerurn = isRerurn;
//		this.isM1 = isM1;
//		this.maxConsume = maxConsume;
//		this.makeUpCost = makeUpCost;
//		this.isEncourage = isEncourage;
//		this.isAllowother = isAllowother;
//		this.memo = memo;
//		this.sysDept = sysDept;
//	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Long companyid) {
        this.companyid = companyid;
    }

    public String getMemberTypeName() {
        return memberTypeName;
    }

    public void setMemberTypeName(String memberTypeName) {
        this.memberTypeName = memberTypeName;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getValidDays() {
        return validDays;
    }

    public void setValidDays(Integer validDays) {
        this.validDays = validDays;
    }

    public String getIsMemberPrice() {
        return isMemberPrice;
    }

    public void setIsMemberPrice(String isMemberPrice) {
        this.isMemberPrice = isMemberPrice;
    }

    public String getIsPoints() {
        return isPoints;
    }

    public void setIsPoints(String isPoints) {
        this.isPoints = isPoints;
    }

    public String getIsRerurn() {
        return isRerurn;
    }

    public void setIsRerurn(String isRerurn) {
        this.isRerurn = isRerurn;
    }

    public String getIsM1() {
        return isM1;
    }

    public void setIsM1(String isM1) {
        this.isM1 = isM1;
    }

    public BigDecimal getMaxConsume() {
        return maxConsume;
    }

    public void setMaxConsume(BigDecimal maxConsume) {
        this.maxConsume = maxConsume;
    }

    public BigDecimal getMakeUpCost() {
        return makeUpCost;
    }

    public void setMakeUpCost(BigDecimal makeUpCost) {
        this.makeUpCost = makeUpCost;
    }

    public String getIsEncourage() {
        return isEncourage;
    }

    public void setIsEncourage(String isEncourage) {
        this.isEncourage = isEncourage;
    }

    public String getIsAllowother() {
        return isAllowother;
    }

    public void setIsAllowother(String isAllowother) {
        this.isAllowother = isAllowother;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }


    public SysDept getSysDept() {
        return sysDept;
    }

    public void setSysDept(SysDept sysDept) {
        this.sysDept = sysDept;
    }

	/*public String toString() {

		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id", getId())
				.append("companyid", getCompanyid())
				.append("memberTypeName", getMemberTypeName())
				.append("discount", getDiscount())
				.append("validDays", getValidDays())
				.append("isMemberPrice", getIsMemberPrice())
				.append("isPoints", getIsPoints())
				.append("isRerurn", getIsRerurn())
				.append("isM1", getIsM1())
				.append("maxConsume", getMaxConsume())
				.append("makeUpCost", getMakeUpCost())
				.append("isEncourage", getIsEncourage())
				.append("isAllowother", getIsAllowother())
				.append("memo", getMemo())
				.toString();
	}*/
}
