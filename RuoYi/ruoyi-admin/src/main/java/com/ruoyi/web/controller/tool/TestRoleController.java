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
 * swagger 角色测试方法
 *
 * @author ruoyi
 */
@Api("角色信息管理")
@RestController
@RequestMapping("/test/role")
public class TestRoleController extends BaseController {

    private final static Map<Integer, RoleEntity> roles = new LinkedHashMap<Integer, RoleEntity>();

    {
        //Integer roleId, String roleName, String roleKey, String roleSort, String dataScope, String status, String delFlag
        roles.put(1, new RoleEntity(1, "普通角色" , "common" , "2" , "2" , "0" , "0"));
        roles.put(12, new RoleEntity(12, "普通角色" , "common" , "2" , "2" , "0" , "0"));
    }


    @ApiOperation("获取角色列表")
    @GetMapping("/list")
    public AjaxResult roleList() {
        List<RoleEntity> roleList = new ArrayList<RoleEntity>(roles.values());
        return AjaxResult.success(roleList);
    }

    @ApiOperation("获取角色详细")
    @ApiImplicitParam(name = "roleId" , value = "角色序号" , required = true, dataType = "int" , paramType = "path")
    @GetMapping("/{roleId}")
    public AjaxResult getRole(@PathVariable Integer roleId) {
        if (!roles.isEmpty() && roles.containsKey(roleId)) {
            return AjaxResult.success(roles.get(roleId));
        } else {
            return error("角色不存在");
        }
    }

    @ApiOperation("新增角色")
    @ApiImplicitParam(name = "RoleEntity" , value = "新增角色信息" , dataType = "RoleEntity")
    @PostMapping("/increaseRole")
    public AjaxResult increaseRole(RoleEntity role) {
        if (StringUtils.isNull(role) || StringUtils.isNull(role.getRoleId())) {
            return error("角色序号不能为空");
        }
        return AjaxResult.success(roles.put(role.getRoleId(), role));
    }

    @ApiOperation("更新角色")
    @ApiImplicitParam(name = "RoleEntity" , value = "更新角色信息" , dataType = "RoleEntity")
    @PutMapping("/updateRole")
    public AjaxResult updateRole(RoleEntity role) {
        if (StringUtils.isNull(role) || StringUtils.isNull(role.getRoleId())) {
            return error("角色序号不能为空");
        }
        if (roles.isEmpty() || !roles.containsKey(role.getRoleId())) {
            return error("角色不存在");
        }
        roles.remove(role.getRoleId());
        return AjaxResult.success(roles.put(role.getRoleId(), role));
    }

    @ApiOperation("删除角色信息")
    @ApiImplicitParam(name = "roleId" , value = "角色序号" , required = true, dataType = "int" , paramType = "path")
    @DeleteMapping("/{roleId}")
    public AjaxResult deleteRole(@PathVariable Integer roleId) {
        if (!roles.isEmpty() && roles.containsKey(roleId)) {
            roles.remove(roleId);
            return success();
        } else {
            return error("角色不存在");
        }
    }


}

@ApiModel("角色实体")
class RoleEntity {

    @ApiModelProperty("角色序号")
    private Integer roleId;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色权限")
    private String roleKey;

    @ApiModelProperty("角色排序")
    private String roleSort;

    @ApiModelProperty("数据范围")
    private String dataScope;

    @ApiModelProperty("角色状态")
    private String status;

    @ApiModelProperty("删除标志")
    private String delFlag;

    public RoleEntity(Integer roleId, String roleName, String roleKey, String roleSort, String dataScope, String status, String delFlag) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleKey = roleKey;
        this.roleSort = roleSort;
        this.dataScope = dataScope;
        this.status = status;
        this.delFlag = delFlag;
    }


    public RoleEntity() {


    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public String getRoleSort() {
        return roleSort;
    }

    public void setRoleSort(String roleSort) {
        this.roleSort = roleSort;
    }

    public String getDataScope() {
        return dataScope;
    }

    public void setDataScope(String dataScope) {
        this.dataScope = dataScope;
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
}