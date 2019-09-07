package com.ruoyi.web.controller.tool;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.util.ShiroUtils;

import com.ruoyi.system.service.ISysDeptService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 店铺测试方法
 */
@Api("店铺信息管理")
@RestController
@RequestMapping("/test/dept")
public class TestDeptController extends BaseController {

    private final static Map<Integer, DeptEntity> depts = new LinkedHashMap<Integer, DeptEntity>();

    {
        depts.put(104, new DeptEntity(104, 101, "0,100,101" , "市场部门" , "2" , "金海马" , "15000000000" , "15000000000@qq.com" , "0" , "0" , "1000" , "050000" , "河北省" , "石家庄市" , "新华区" , "裕彤体育场"));
        depts.put(105, new DeptEntity(105, 101, "0,100,101" , "测试部门" , "3" , "金海马" , "15000000000" , "15000000000@qq.com" , "0" , "0" , "10001" , "050000" , "河北省" , "石家庄市" , "长安区" , "新天地"));

    }

    @ApiOperation("获取店铺列表")
    @GetMapping("/list")
    public AjaxResult deptList() {
        List<DeptEntity> deptList = new ArrayList<DeptEntity>(depts.values());
        return AjaxResult.success(deptList);
    }

    @ApiOperation("获取店铺详细")
    @ApiImplicitParam(name = "deptId" , value = "店铺ID" , required = true, dataType = "int" , paramType = "path")
    @GetMapping("/{deptId}")
    public AjaxResult getDept(@PathVariable Integer deptId) {
        System.out.println("1111111111111111111111111111111111111111");

        System.out.println(depts + "000000000000000000000000000000");

        System.out.println(depts.get(1) + "1100000000000000000000");
        if (!depts.isEmpty() && depts.containsKey(deptId)) {

            return AjaxResult.success(depts.get(deptId));
        } else {
            System.out.println("22222222222222222222222222222222222222222222");
            return error("店铺不存在");
        }

    }

    @ApiOperation("新增店铺")
    @ApiImplicitParam(name = "DeptEntity" , value = "新增店铺信息" , dataType = "DeptEntity")
    @PostMapping("/save")
    public AjaxResult increaseDept(DeptEntity dept) {
        if (StringUtils.isNull(dept) || StringUtils.isNull(dept.getDeptId())) {
            return error("店铺ID不能为空");
        }
        return AjaxResult.success(depts.put(dept.getDeptId(), dept));
    }

    @ApiOperation("更新店铺")
    @ApiImplicitParam(name = "DeptEntity" , value = "更新店铺信息" , dataType = "DeptEntity")
    @PutMapping("/update")
    public AjaxResult updateDept(DeptEntity dept) {
        if (StringUtils.isNull(dept) || StringUtils.isNull(dept.getDeptId())) {
            return error("店铺ID不能为空");
        }
        if (depts.isEmpty() || !depts.containsKey(dept.getDeptId())) {
            return error("店铺不存在");
        }
        depts.remove(dept.getDeptId());
        return AjaxResult.success(depts.put(dept.getDeptId(), dept));
    }

    @ApiOperation("删除店铺信息")
    @ApiImplicitParam(name = "deptId" , value = "店铺ID" , required = true, dataType = "int" , paramType = "path")
    @DeleteMapping("/{deptId}")
    public AjaxResult delete(@PathVariable Integer deptId) {
        if (!depts.isEmpty() && depts.containsKey(deptId)) {
            depts.remove(deptId);
            return success();
        } else {
            return error("店铺不存在");
        }
    }


}

@ApiModel("店铺实体")
class DeptEntity {

    @ApiModelProperty("部门ID")
    private Integer deptId;

    @ApiModelProperty("父部门ID ")
    private Integer parentId;
    @ApiModelProperty("祖级列表 ")
    private String ancestors;
    @ApiModelProperty("部门名称 ")
    private String deptName;
    @ApiModelProperty("显示顺序 ")
    private String orderNum;

    @ApiModelProperty("负责人 ")
    private String leader;
    @ApiModelProperty("联系电话  ")
    private String phone;
    @ApiModelProperty("邮箱 ")
    private String email;
    @ApiModelProperty("部门状态 ")
    private String status;
    @ApiModelProperty("删除标志 ")
    private String delFlag;

    @ApiModelProperty("公司编号")
    private String companyNo;
    @ApiModelProperty("省")
    private String province;
    @ApiModelProperty("市")
    private String city;
    @ApiModelProperty("区")
    private String area;
    @ApiModelProperty("公司地址")
    private String companyAddress;
    @ApiModelProperty("邮编")
    private String Postcode;

    public DeptEntity() {
    }

    public DeptEntity(Integer deptId, Integer parentId, String ancestors, String deptName, String orderNum, String leader, String phone, String email, String status, String delFlag, String companyNo, String postcode, String province, String city, String area, String companyAddress) {
        this.deptId = deptId;
        this.parentId = parentId;
        this.ancestors = ancestors;
        this.deptName = deptName;
        this.orderNum = orderNum;
        this.leader = leader;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.delFlag = delFlag;

        this.companyNo = companyNo;
        this.province = province;
        this.city = city;
        this.area = area;
        this.companyAddress = companyAddress;
        Postcode = postcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
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

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String postcode) {
        Postcode = postcode;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getAncestors() {
        return ancestors;
    }

    public void setAncestors(String ancestors) {
        this.ancestors = ancestors;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }


    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }
}
