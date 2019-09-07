package com.ruoyi.web.controller.tool;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * swagger 会员充值退款测试方法
 *
 * @author ruoyi
 */
@Api("会员充值退款信息管理")
@RestController
@RequestMapping("/test/recharge")
public class TestRechargeController extends BaseController {


    private final static Map<Integer, RechargeEntity> recharges = new LinkedHashMap<Integer, RechargeEntity>();

    {
        recharges.put(1, new RechargeEntity(1, 103, 2, "55" , "1" , "11" , "100" , "15630190930" , 100.3, 0.0, 0, "2015-02-12" , 2, 15.6, "12" , 10.9, "2015-10-04" , "男" , "中国" , "A" , 181.9, 50.8, "医生" , "大专" , "111" , "15630190930" , "15630190930@qq.com" , "石家庄" , "054000" , "河北省" , "石家庄" , "裕华区" , "怀特商业广场" , "2015-05-30" , "15" , 100, "市场部" , "储蓄卡" , 5.2, "充值"));

        recharges.put(3, new RechargeEntity(3, 103, 2, "56" , "1" , "11" , "100" , "15630190931" , 100.3, 0.0, 0, "2015-02-12" , 2, 15.6, "12" , 10.9, "2015-10-04" , "男" , "中国" , "A" , 181.9, 50.8, "医生" , "大专" , "111" , "15630190930" , "15630190930@qq.com" , "石家庄" , "054000" , "河北省" , "石家庄" , "裕华区" , "怀特商业广场" , "2015-05-30" , "15" , 100, "市场部" , "积分卡" , 6.3, "充值"));
    }


    @ApiOperation("获取会员详细")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberNo" , value = "会员卡号" , required = false, dataType = "String" , paramType = "query"),
            @ApiImplicitParam(name = "mobilephones" , value = "会员电话" , required = false, dataType = "String" , paramType = "query")})
    @GetMapping("/getMember")
    public AjaxResult getMember(@RequestParam(value = "memberNo" , required = false) String memberNo, @RequestParam(value = "mobilephones" , required = false) String mobilephones) {


        if ((memberNo == null || memberNo.equals("")) && (mobilephones == null || mobilephones.equals(""))) {


            return error("会员不存在");

        } else if ((memberNo == null || "".equals(memberNo)) && (mobilephones != null && !(mobilephones).equals(""))) {

            List<Integer> key = new ArrayList<>();
            for (Map.Entry<Integer, RechargeEntity> s : recharges.entrySet()) {
                System.out.println("key****************" + s.getKey());
                key.add(s.getKey());
            }
            for (Integer m : key) {
                if (recharges.get(m).getMobilephones().equals(mobilephones)) {
                    return AjaxResult.success(recharges.get(m));
                }


            }

        } else if ((!(memberNo).equals("") || memberNo != null) && (mobilephones == null || (mobilephones).equals(""))) {

            List<Integer> key = new ArrayList<>();
            //插入记录带的Key值。
            for (Map.Entry<Integer, RechargeEntity> s : recharges.entrySet()) {
                System.out.println("key黄渤" + s.getKey());
                key.add(s.getKey());
            }
            for (Integer m : key) {

                if (recharges.get(m).getMemberNo().equals(memberNo)) {
                    return AjaxResult.success(recharges.get(m));
                }


            }

        } else if ((!(memberNo).equals("") || memberNo != null) && (mobilephones != null && !(mobilephones).equals(""))) {

            List<Integer> key = new ArrayList<>();

            for (Map.Entry<Integer, RechargeEntity> s : recharges.entrySet()) {
                System.out.println("key********王********" + s.getKey());
                key.add(s.getKey());
            }


            for (Integer m : key) {
                boolean a = recharges.get(m).getMobilephones().equals(mobilephones);
                boolean b = recharges.get(m).getMemberNo().equals(memberNo);
                if (a && b && a == b) {
                    return AjaxResult.success(recharges.get(m));
                }


            }


        }


        return error("会员不存在");


    }

   /* @ApiOperation("会员充值")
    @ApiImplicitParams({  @ApiImplicitParam(name = "changeMoney", value = "变化金额", required = true, dataType = "double", paramType = "query"),
            @ApiImplicitParam(name = "memberNo", value = "会员卡号", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "mobilephones", value = "会员电话", required = false, dataType = "String", paramType = "query")
            })
    @PostMapping("/recharge")
    public  AjaxResult  recharge(@RequestParam (value = "memberNo" ,required =false) String memberNo,@RequestParam (value = "mobilephones" ,required =false) String mobilephones,@RequestParam(value = "changeMoney",required = false) Double changeMoney){



      if(!recharges.isEmpty() && recharges.containsKey(id)){

            RechargeEntity rr = recharges.get(id);
            System.out.println(rr+"111111111111111111111111111");

            Double money =rr.getBalance()+changeMoney;
            rr.setBalance(money);
            rr.setMemo("充值");
            rr.setChangeMoney(changeMoney);
            return AjaxResult.success(recharges.put(rr.getId(),rr));

        }

            return error("充值失败");

    }*/

}

@ApiModel("实体")
class RechargeEntity {


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
    @ApiModelProperty("会员卡类型名字 ")
    private String memberTypeName;
    @ApiModelProperty("变化金额 ")
    private Double changeMoney;
    @ApiModelProperty("备注 ")
    private String memo;

    public RechargeEntity(Integer id, Integer companyid, Integer memberTypeId, String memberNo, String cardid, String password, String memberName, String mobilephones, Double balance, Double complimentaryMoney, Integer haveCount, String addDatetime, Integer state, Double points, String expirydate, Double commission, String birtdate, String sex, String nation, String blood, Double stature, Double weight, String carrer, String education, String iDcardno, String telephone, String email, String postcode, String province, String city, String area, String address, String addDatetimeStr, String expirydateStr, String birtdateStr, Integer deptId, String deptName, String memberTypeName, Double changeMoney, String memo) {
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
        this.memberTypeName = memberTypeName;
        this.changeMoney = changeMoney;
        this.memo = memo;
    }

    public RechargeEntity() {


    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Double getChangeMoney() {
        return changeMoney;
    }

    public void setChangeMoney(Double changeMoney) {
        this.changeMoney = changeMoney;
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

    public String getMemberTypeName() {
        return memberTypeName;
    }

    public void setMemberTypeName(String memberTypeName) {
        this.memberTypeName = memberTypeName;
    }
}