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
 * swagger 菜单测试方法
 *
 * @author ruoyi
 */
@Api("菜单信息管理")
@RestController
@RequestMapping("/test/menu")
public class TestMenuController extends BaseController {

    private final static Map<Integer, MenuEntity> menus = new LinkedHashMap<Integer, MenuEntity>();

    {
        //Integer menuId, String menuName, String parentName, Integer parentId, String orderNum, String url, String target, String menuType, String visible, String perms, String icon
        menus.put(1, new MenuEntity(1, "系统管理" , "一级菜单" , 1, "1" , "#" , "" , "M" , "0" , "" , "fa fa-gear"));
        menus.put(3, new MenuEntity(3, "系统工具" , "二级菜单" , 1, "1" , "#" , "" , "M" , "0" , "" , "fa fa-bars"));
    }


    @ApiOperation("获取菜单列表")
    @GetMapping("/list")
    public AjaxResult menuList() {
        List<MenuEntity> menuList = new ArrayList<MenuEntity>(menus.values());
        return AjaxResult.success(menuList);
    }

    @ApiOperation("获取菜单详细")
    @ApiImplicitParam(name = "menuId" , value = "菜单ID" , required = true, dataType = "int" , paramType = "path")
    @GetMapping("/{menuId}")
    public AjaxResult getMenu(@PathVariable Integer menuId) {
        if (!menus.isEmpty() && menus.containsKey(menuId)) {
            return AjaxResult.success(menus.get(menuId));
        } else {
            return error("菜单不存在");
        }
    }


    @ApiOperation("新增菜单")
    @ApiImplicitParam(name = "menuEntity" , value = "新增菜单信息" , dataType = "MenuEntity")
    @PostMapping("/increaseMenu")
    public AjaxResult increaseMenu(MenuEntity menu) {
        if (StringUtils.isNull(menu) || StringUtils.isNull(menu.getMenuId())) {
            return error("菜单ID不能为空");
        }
        return AjaxResult.success(menus.put(menu.getMenuId(), menu));
    }

    @ApiOperation("更新菜单")
    @ApiImplicitParam(name = "menuEntity" , value = "更新菜单信息" , dataType = "MenuEntity")
    @PutMapping("/updateMenu")
    public AjaxResult updateMenu(MenuEntity menu) {
        if (StringUtils.isNull(menu) || StringUtils.isNull(menu.getMenuId())) {
            return error("菜单ID不能为空");
        }
        if (menus.isEmpty() || !menus.containsKey(menu.getMenuId())) {
            return error("菜单不存在");
        }
        menus.remove(menu.getMenuId());
        return AjaxResult.success(menus.put(menu.getMenuId(), menu));
    }

    @ApiOperation("删除菜单信息")
    @ApiImplicitParam(name = "menuId" , value = "菜单ID" , required = true, dataType = "int" , paramType = "path")
    @DeleteMapping("/{menuId}")
    public AjaxResult delete(@PathVariable Integer menuId) {
        if (!menus.isEmpty() && menus.containsKey(menuId)) {
            menus.remove(menuId);
            return success();
        } else {
            return error("菜单不存在");
        }
    }


}

@ApiModel("菜单实体")
class MenuEntity {

    @ApiModelProperty("菜单ID")
    private Integer menuId;

    @ApiModelProperty("菜单名称")
    private String menuName;

    @ApiModelProperty("父菜单名称")
    private String parentName;

    @ApiModelProperty("父菜单ID")
    private Integer parentId;

    @ApiModelProperty("显示顺序")
    private String orderNum;

    @ApiModelProperty("菜单URL")
    private String url;

    @ApiModelProperty("打开方式")
    private String target;

    @ApiModelProperty("类型")
    private String menuType;

    @ApiModelProperty("菜单状态")
    private String visible;

    @ApiModelProperty("权限字符串")
    private String perms;

    @ApiModelProperty("菜单图标")
    private String icon;


    public MenuEntity() {
    }

    public MenuEntity(Integer menuId, String menuName, String parentName, Integer parentId, String orderNum, String url, String target, String menuType, String visible, String perms, String icon) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.parentName = parentName;
        this.parentId = parentId;
        this.orderNum = orderNum;
        this.url = url;
        this.target = target;
        this.menuType = menuType;
        this.visible = visible;
        this.perms = perms;
        this.icon = icon;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}