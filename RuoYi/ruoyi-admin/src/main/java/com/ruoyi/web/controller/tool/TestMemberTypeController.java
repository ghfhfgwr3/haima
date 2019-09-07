package com.ruoyi.web.controller.tool;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * swagger 会员类型测试方法
 *
 * @author ruoyi
 */
@Api("会员类型信息管理")
@RestController
@RequestMapping("/test/memberType")
public class TestMemberTypeController extends BaseController {

    private final static Map<Integer, MemberTypeEntity> members = new LinkedHashMap<Integer, MemberTypeEntity>();

    {

        //Integer id, Integer companyid, String memberTypeName, Integer discount, Integer validDays, Integer isMemberPrice, Integer isPoints, Integer isRerurn, Integer isM1, Double maxConsume, Double makeUpCost, Integer isEncourage, Integer isAllowother, String memo, String deptId, String deptName
        members.put(1, new MemberTypeEntity(1, 1, "1" , 1, 2, 1, 1, 0, 1, 1.5, 1.6, 0, 1, "1" , "1" , "1"));
        members.put(2, new MemberTypeEntity(2, 3, "1" , 1, 2, 1, 1, 0, 1, 1.8, 1.8, 0, 1, "1" , "1" , "1"));

    }

    @ApiOperation("获取会员类型列表")
    @GetMapping("/list")
    public AjaxResult memberTypeList() {
        List<MemberTypeEntity> memberTypeList = new ArrayList<MemberTypeEntity>(members.values());
        return AjaxResult.success(memberTypeList);
    }


    @ApiOperation("获取会员类型详细")
    @ApiImplicitParam(name = "id" , value = "ID" , required = true, dataType = "int" , paramType = "path")
    @GetMapping("/{id}")
    public AjaxResult getMemberType(@PathVariable Integer id) {
        if (!members.isEmpty() && members.containsKey(id)) {
            return AjaxResult.success(members.get(id));
        } else {
            return error("会员类型不存在");
        }
    }

    @ApiOperation("新增会员类型信息")
    @ApiImplicitParam(name = "memberTypeEntity" , value = "新增会员类型信息" , dataType = "MemberTypeEntity")
    @PostMapping("/increaseMemberType")
    public AjaxResult increaseMemberType(MemberTypeEntity member) {
        if (StringUtils.isNull(member) || StringUtils.isNull(member.getId())) {
            return error("会员类型ID不能为空");
        }
        return AjaxResult.success(members.put(member.getId(), member));
    }

    @ApiOperation("更新会员类型信息")
    @ApiImplicitParam(name = "memberTypeEntity" , value = "新增会员类型信息" , dataType = "MemberTypeEntity")
    @PutMapping("/updateMemberType")
    public AjaxResult updateMemberType(MemberTypeEntity member) {
        if (StringUtils.isNull(member) || StringUtils.isNull(member.getId())) {
            return error("会员类型ID不能为空");
        }
        if (members.isEmpty() || !members.containsKey(member.getId())) {
            return error("会员类型不存在");
        }
        members.remove(member.getId());
        return AjaxResult.success(members.put(member.getId(), member));
    }


    @ApiOperation("删除会员类型信息")
    @ApiImplicitParam(name = "id" , value = "id" , required = true, dataType = "int" , paramType = "path")
    @DeleteMapping("/{id}")
    public AjaxResult deleteMemberType(@PathVariable Integer id) {
        if (!members.isEmpty() && members.containsKey(id)) {
            members.remove(id);
            return success();
        } else {
            return error("会员类型不存在");
        }
    }


}

@ApiModel("会员类型实体")
class MemberTypeEntity {


    @ApiModelProperty("ID")
    private Integer id;
    @ApiModelProperty("公司ID")
    private Integer companyid;
    @ApiModelProperty("会员卡类型")
    private String memberTypeName;
    @ApiModelProperty("折扣")
    private Integer discount;
    @ApiModelProperty("有效期")
    private Integer validDays;
    @ApiModelProperty("是否会员价")
    private Integer isMemberPrice;
    @ApiModelProperty("是否积分")
    private Integer isPoints;
    @ApiModelProperty("是否可退")
    private Integer isRerurn;
    @ApiModelProperty("是否M1卡")
    private Integer isM1;
    @ApiModelProperty("最大消费")
    private double maxConsume;
    @ApiModelProperty("补办费用")
    private double makeUpCost;
    @ApiModelProperty("是否奖励")
    private Integer isEncourage;
    @ApiModelProperty("是否允许跨店消费")
    private Integer isAllowother;
    @ApiModelProperty("备注")
    private String memo;
    @ApiModelProperty("部门id")
    private String deptId;
    @ApiModelProperty("部门名字")
    private String deptName;

    public MemberTypeEntity(Integer id, Integer companyid, String memberTypeName, Integer discount, Integer validDays, Integer isMemberPrice, Integer isPoints, Integer isRerurn, Integer isM1, Double maxConsume, Double makeUpCost, Integer isEncourage, Integer isAllowother, String memo, String deptId, String deptName) {
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
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public MemberTypeEntity() {
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

    public Integer getIsMemberPrice() {
        return isMemberPrice;
    }

    public void setIsMemberPrice(Integer isMemberPrice) {
        this.isMemberPrice = isMemberPrice;
    }

    public Integer getIsPoints() {
        return isPoints;
    }

    public void setIsPoints(Integer isPoints) {
        this.isPoints = isPoints;
    }

    public Integer getIsRerurn() {
        return isRerurn;
    }

    public void setIsRerurn(Integer isRerurn) {
        this.isRerurn = isRerurn;
    }

    public Integer getIsM1() {
        return isM1;
    }

    public void setIsM1(Integer isM1) {
        this.isM1 = isM1;
    }

    public Double getMaxConsume() {
        return maxConsume;
    }

    public void setMaxConsume(Double maxConsume) {
        this.maxConsume = maxConsume;
    }

    public Double getMakeUpCost() {
        return makeUpCost;
    }

    public void setMakeUpCost(Double makeUpCost) {
        this.makeUpCost = makeUpCost;
    }

    public Integer getIsEncourage() {
        return isEncourage;
    }

    public void setIsEncourage(Integer isEncourage) {
        this.isEncourage = isEncourage;
    }

    public Integer getIsAllowother() {
        return isAllowother;
    }

    public void setIsAllowother(Integer isAllowother) {
        this.isAllowother = isAllowother;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}