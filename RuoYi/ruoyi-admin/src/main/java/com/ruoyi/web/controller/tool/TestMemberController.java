package com.ruoyi.web.controller.tool;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import io.swagger.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

/**
 * swagger 用户测试方法
 *
 * @author ruoyi
 */
@Api("会员信息管理")
@RestController
@RequestMapping("/test/member")
public class TestMemberController extends BaseController {


    private final static Map<Integer, MemberEntity> members = new LinkedHashMap<Integer, MemberEntity>();

    {
        members.put(1, new MemberEntity(1, 103, 2, "55" , "1" , "11" , "100" , "15630190930" , 100.3, 0.0, 0, "2015-02-12" , 2, 15.6, "12" , 10.9, "2015-10-04" , "男" , "中国" , "A" , 181.9, 50.8, "医生" , "大专" , "111" , "15630190930" , "15630190930@qq.com" , "石家庄" , "054000" , "河北省" , "石家庄" , "裕华区" , "怀特商业广场" , "2015-05-30" , "15" , 100, "市场部"));
        members.put(2, new MemberEntity(2, 103, 2, "55" , "1" , "11" , "100" , "15630190930" , 100.1, 0.2, 0, "2015-02-12" , 2, 15.2, "12" , 10.1, "2015-10-04" , "男" , "中国" , "A" , 181.2, 50.2, "医生" , "大专" , "111" , "15630190930" , "15630190930@qq.com" , "石家庄" , "054000" , "河北省" , "石家庄" , "裕华区" , "怀特商业广场" , "2015-05-30" , "15" , 100, "市场部"));

    }

    @ApiOperation("获取会员列表")
    @GetMapping("/list")
    public AjaxResult memberList() {
        List<MemberEntity> memberList = new ArrayList<MemberEntity>(members.values());
        return AjaxResult.success(memberList);
    }

    @ApiOperation("获取会员详细")
    @ApiImplicitParam(name = "id" , value = "会员id" , required = true, dataType = "int" , paramType = "path")
    @GetMapping("/{id}")
    public AjaxResult getMember(@PathVariable Integer id) {
        if (!members.isEmpty() && members.containsKey(id)) {
            return AjaxResult.success(members.get(id));
        } else {
            return error("会员不存在");
        }
    }

    @ApiOperation("新增会员")
    @ApiImplicitParam(name = "memberEntity" , value = "新增会员信息" , dataType = "MemberEntity")
    @PostMapping("/increaseMember")
    public AjaxResult increaseMember(MemberEntity member) {
        if (StringUtils.isNull(member) || StringUtils.isNull(member.getId())) {
            return error("会员ID不能为空");
        }
        return AjaxResult.success(members.put(member.getId(), member));
    }


    @ApiOperation("更新会员")
    @ApiImplicitParam(name = "memberEntity" , value = "新增会员信息" , dataType = "MemberEntity")
    @PutMapping("/updateMember")
    public AjaxResult updateMember(MemberEntity member) {
        if (StringUtils.isNull(member) || StringUtils.isNull(member.getId())) {
            return error("会员ID不能为空");
        }
        if (members.isEmpty() || !members.containsKey(member.getId())) {
            return error("会员不存在");
        }

        members.remove(member.getId());
        return AjaxResult.success(members.put(member.getId(), member));
    }

    @ApiOperation("删除会员信息")
    @ApiImplicitParam(name = "id" , value = "会员ID" , required = true, dataType = "int" , paramType = "path")
    @DeleteMapping("/{id}")
    public AjaxResult deleteMember(@PathVariable Integer id) {
        if (!members.isEmpty() && members.containsKey(id)) {
            members.remove(id);
            return success();
        } else {
            return error("会员不存在");
        }
    }
}

@ApiModel("会员实体")
class MemberEntity {

    @ApiModelProperty("ID")
    private Integer id;
    @ApiModelProperty("公司ID")
    private Integer companyid;
    @ApiModelProperty("会员类型")
    private Integer memberTypeId;
    @ApiModelProperty("会员卡号")
    private String memberNo;
    @ApiModelProperty("会员卡ID")
    private String cardid;
    @ApiModelProperty("会员卡密码")
    private String password;
    @ApiModelProperty("会员姓名")
    private String memberName;
    @ApiModelProperty("会员电话")
    private String mobilephones;
    @ApiModelProperty("卡现有余额")
    private Double balance;
    @ApiModelProperty("奖励金额")
    private Double complimentaryMoney;

    @ApiModelProperty("是否有计次品相")
    private Integer haveCount;
    @ApiModelProperty("办卡时间")
    private String addDatetime;
    @ApiModelProperty("可用状态")
    private Integer state;
    @ApiModelProperty("积分")
    private Double points;
    @ApiModelProperty("有效期")
    private String expirydate;
    @ApiModelProperty("手续费")
    private Double commission;
    @ApiModelProperty("出生日期")
    private String birtdate;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("国家")
    private String nation;

    @ApiModelProperty("血型")
    private String blood;
    @ApiModelProperty("身高")
    private Double stature;

    @ApiModelProperty("体重")

    private Double weight;

    @ApiModelProperty("职业")

    private String carrer;
    @ApiModelProperty("教育程度")

    private String education;
    @ApiModelProperty("ID卡号")

    private String iDcardno;
    @ApiModelProperty("电话")

    private String telephone;
    @ApiModelProperty("电子邮件")

    private String email;

    @ApiModelProperty("邮编")

    private String postcode;
    @ApiModelProperty("省份")
    private String province;
    @ApiModelProperty("市")
    private String city;

    @ApiModelProperty("区")

    private String area;
    @ApiModelProperty("地址")

    private String address;

    @ApiModelProperty("办卡时间")

    private String addDatetimeStr;

    @ApiModelProperty("有效期")

    private String expirydateStr;

    @ApiModelProperty("有效时间 ")
    private String birtdateStr;
    @ApiModelProperty("店铺Id ")
    private Integer deptId;
    @ApiModelProperty("店铺名字 ")
    private String deptName;

    public MemberEntity(Integer id, Integer companyid, Integer memberTypeId, String memberNo, String cardid, String password, String memberName, String mobilephones, Double balance, Double complimentaryMoney, Integer haveCount, String addDatetime, Integer state, Double points, String expirydate, Double commission, String birtdate, String sex, String nation, String blood, Double stature, Double weight, String carrer, String education, String iDcardno, String telephone, String email, String postcode, String province, String city, String area, String address, String addDatetimeStr, String expirydateStr, String birtdateStr, Integer deptId, String deptName) {
        this.id = id;
        this.companyid = companyid;
        this.memberTypeId = memberTypeId;
        this.memberNo = memberNo;
        this.cardid = cardid;
        this.password = password;
        this.memberName = memberName;
        this.mobilephones = mobilephones;
        this.balance = balance;
        this.complimentaryMoney = complimentaryMoney;
        this.haveCount = haveCount;
        this.addDatetime = addDatetime;
        this.state = state;
        this.points = points;
        this.expirydate = expirydate;
        this.commission = commission;
        this.birtdate = birtdate;
        this.sex = sex;
        this.nation = nation;
        this.blood = blood;
        this.stature = stature;
        this.weight = weight;
        this.carrer = carrer;
        this.education = education;
        this.iDcardno = iDcardno;
        this.telephone = telephone;
        this.email = email;
        this.postcode = postcode;
        this.province = province;
        this.city = city;
        this.area = area;
        this.address = address;
        this.addDatetimeStr = addDatetimeStr;
        this.expirydateStr = expirydateStr;
        this.birtdateStr = birtdateStr;
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public MemberEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public Integer getMemberTypeId() {
        return memberTypeId;
    }

    public void setMemberTypeId(Integer memberTypeId) {
        this.memberTypeId = memberTypeId;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMobilephones() {
        return mobilephones;
    }

    public void setMobilephones(String mobilephones) {
        this.mobilephones = mobilephones;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getComplimentaryMoney() {
        return complimentaryMoney;
    }

    public void setComplimentaryMoney(Double complimentaryMoney) {
        this.complimentaryMoney = complimentaryMoney;
    }

    public Integer getHaveCount() {
        return haveCount;
    }

    public void setHaveCount(Integer haveCount) {
        this.haveCount = haveCount;
    }

    public String getAddDatetime() {
        return addDatetime;
    }

    public void setAddDatetime(String addDatetime) {
        this.addDatetime = addDatetime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public String getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(String expirydate) {
        this.expirydate = expirydate;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public String getBirtdate() {
        return birtdate;
    }

    public void setBirtdate(String birtdate) {
        this.birtdate = birtdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public Double getStature() {
        return stature;
    }

    public void setStature(Double stature) {
        this.stature = stature;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getCarrer() {
        return carrer;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getiDcardno() {
        return iDcardno;
    }

    public void setiDcardno(String iDcardno) {
        this.iDcardno = iDcardno;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddDatetimeStr() {
        return addDatetimeStr;
    }

    public void setAddDatetimeStr(String addDatetimeStr) {
        this.addDatetimeStr = addDatetimeStr;
    }

    public String getExpirydateStr() {
        return expirydateStr;
    }

    public void setExpirydateStr(String expirydateStr) {
        this.expirydateStr = expirydateStr;
    }

    public String getBirtdateStr() {
        return birtdateStr;
    }

    public void setBirtdateStr(String birtdateStr) {
        this.birtdateStr = birtdateStr;
    }
}