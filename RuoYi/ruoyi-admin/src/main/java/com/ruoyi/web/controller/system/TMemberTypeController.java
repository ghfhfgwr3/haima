package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.service.ISysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TMember;
import com.ruoyi.system.domain.TMemberType;
import com.ruoyi.system.service.ITMemberTypeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 会员类型 信息操作处理
 *
 * @author ruoyi
 * @date 2019-06-03
 */
@Controller
@RequestMapping("/system/tMemberType")
public class TMemberTypeController extends BaseController {
    private String prefix = "system/tMemberType";

    @Autowired
    private ITMemberTypeService tMemberTypeService;
    @Autowired
    private ISysDeptService deptService;

    @RequiresPermissions("system:tMemberType:view")
    @GetMapping()
    public String tMemberType() {
        return prefix + "/tMemberType";
    }


    /**
     * 校验部门名称
     */
    @PostMapping("/checkTMemberTypeNameUnique")
    @ResponseBody
    public String checkDeptNameUnique(TMemberType tMemberType) {
        //System.out.println(tMemberType);
        return tMemberTypeService.checkDeptNameUnique(tMemberType);
    }

    /**
     * 选择部门树
     */
    @GetMapping("/selectDeptTree/{deptId}")
    public String selectDeptTree(@PathVariable("deptId") Long deptId, ModelMap mmap) {
        mmap.put("dept" , deptService.selectDeptById(deptId));
        return "system/tMember/tree";
    }


    /**
     * 查询会员类型列表
     */
    @RequiresPermissions("system:tMemberType:list")
    @PostMapping("/list")
    @ResponseBody

    public TableDataInfo list(TMemberType tMemberType, ModelMap mmap) {
        startPage();
        List<TMemberType> list = tMemberTypeService.selectTMemberTypeList(tMemberType);
        return getDataTable(list);
    }

    /**
     * 查询会员类型列表
     */
    @PostMapping("/listTypeName")
    @ResponseBody

    public List<TMemberType> listTypeName(TMemberType tMemberType, ModelMap mmap) {
        return tMemberTypeService.selectTMemberTypeListAndMemberTypeName(tMemberType);
    }

    @PostMapping("/TypeName")
    @ResponseBody

    public List<TMemberType> listTypeNmae(@Param("id") Integer id, TMemberType tMemberType, ModelMap mmap) {
        //	mmap.put("tMemberType", tMemberType);
        List<TMemberType> tMemberTypes = tMemberTypeService.selectTMemberTypeByCompanyId(id);
		/*for (TMemberType tt: tMemberTypes) {
			System.out.println(tt);
		}*/
        return tMemberTypeService.selectTMemberTypeByCompanyId(id);
    }


    /**
     * 导出会员类型列表
     */
    @RequiresPermissions("system:tMemberType:export")
    @PostMapping("/export")
    @ResponseBody

    public AjaxResult export(TMemberType tMemberType) {
        List<TMemberType> list = tMemberTypeService.selectTMemberTypeList(tMemberType);
        ExcelUtil<TMemberType> util = new ExcelUtil<TMemberType>(TMemberType.class);
        return util.exportExcel(list, "tMemberType");
    }

    /**
     * 新增会员类型
     */
    @GetMapping("/add/{id}")

    public String add(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("dept" , deptService.selectDeptById(id));
        return prefix + "/add";
    }

    /**
     * 新增保存会员类型
     */
    @RequiresPermissions("system:tMemberType:add")
    @Log(title = "会员类型" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody

    public AjaxResult addSave(TMemberType tMemberType) {
        if (tMemberType.getValidDays() == null) {
            tMemberType.setValidDays(3650);
        }
        return toAjax(tMemberTypeService.insertTMemberType(tMemberType));
    }

    /**
     * 修改会员类型
     */
    @GetMapping("/edit/{id}")

    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        TMemberType tMemberType = tMemberTypeService.selectTMemberTypeById(id);
        mmap.put("tMemberType" , tMemberType);
        return prefix + "/edit";
    }

    /**
     * 修改保存会员类型
     */
    @RequiresPermissions("system:tMemberType:edit")
    @Log(title = "会员类型" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TMemberType tMemberType) {
        return toAjax(tMemberTypeService.updateTMemberType(tMemberType));
    }

    /**
     * 修改保存会员状态
     */
    @RequiresPermissions("system:tMemberType:update")
    @Log(title = "会员类型" , businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(@Param("isMemberPrice") String isMemberPrice, @Param("isPoints") String isPoints, @Param("isRerurn") String isRerurn, @Param("isM1") String isM1, @Param("isEncourage") String isEncourage, @Param("isAllowother") String isAllowother, @Param("id") String id) {
        return toAjax(tMemberTypeService.updateTMemberTypeAndStatus(isMemberPrice, isPoints, isRerurn, isM1, isEncourage, isAllowother, id));
    }

    /**
     * 删除会员类型
     */
    @RequiresPermissions("system:tMemberType:remove")
    @Log(title = "会员类型" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tMemberTypeService.deleteTMemberTypeByIds(ids));
    }

    /**
     * 挂失锁定(状态修改)
     */

    @RequiresPermissions("system:tMemberType:replace")
    @Log(title = "会员类型" , businessType = BusinessType.UPDATE)
    @PostMapping("/replace")
    @ResponseBody

    public AjaxResult replace(TMemberType tMemberType) {
        return toAjax(tMemberTypeService.replaceTMemberType(tMemberType));
    }

    /**
     * 注销会员卡
     */
    @RequiresPermissions("system:tMemberType:cancel")
    @Log(title = "会员类型" , businessType = BusinessType.UPDATE)
    @PostMapping("/cancelTMemberType")
    @ResponseBody

    public AjaxResult cancelTMemberType(TMemberType tMemberType) {
        return toAjax(tMemberTypeService.cancelTMemberType(tMemberType));
    }

}