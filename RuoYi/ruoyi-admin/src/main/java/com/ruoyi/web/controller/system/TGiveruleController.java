package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.service.ISysDeptService;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TGiverule;
import com.ruoyi.system.service.ITGiveruleService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * 奖励规则 信息操作处理
 *
 * @author ruoyi
 * @date 2019-07-12
 */
@Controller
@RequestMapping("/system/tGiverule")
public class TGiveruleController extends BaseController {
    private String prefix = "system/tGiverule";

    @Autowired
    private ITGiveruleService tGiveruleService;
    @Autowired
    private ISysDeptService deptService;

    @RequiresPermissions("system:tGiverule:view")
    @GetMapping()
    public String tGiverule() {
        return prefix + "/tGiverule";
    }

    /**
     * 查询奖励规则列表
     */
    @RequiresPermissions("system:tGiverule:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TGiverule tGiverule) {
        startPage();
        List<TGiverule> list = tGiveruleService.selectTGiveruleList(tGiverule);
        return getDataTable(list);
    }


    /**
     * 导出奖励规则列表
     */
    @RequiresPermissions("system:tGiverule:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TGiverule tGiverule) {
        List<TGiverule> list = tGiveruleService.selectTGiveruleList(tGiverule);
        ExcelUtil<TGiverule> util = new ExcelUtil<TGiverule>(TGiverule.class);
        return util.exportExcel(list, "tGiverule");
    }

    /**
     * 新增奖励规则
     */
    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("dept" , deptService.selectDeptById(id));
        return prefix + "/add";
    }

    /**
     * 选择部门树
     */
    @GetMapping("/selectDeptTree/{deptId}")
    public String selectDeptTree(@PathVariable("deptId") Long deptId, ModelMap mmap) {
        mmap.put("dept" , deptService.selectDeptById(deptId));
        return "/system/tMember/tree";
    }


    /**
     * 新增保存奖励规则
     */
    @RequiresPermissions("system:tGiverule:add")
    @Log(title = "奖励规则" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TGiverule tGiverule, HttpServletRequest re) {
        String parameter = re.getParameter("parentId");
        tGiverule.setCompanyid(Long.valueOf(parameter));
        System.out.println(tGiverule);
        return toAjax(tGiveruleService.insertTGiverule(tGiverule));
    }

    /**
     * 修改奖励规则
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        TGiverule tGiverule = tGiveruleService.selectTGiveruleById(id);
        mmap.put("tGiverule" , tGiverule);
        return prefix + "/edit";
    }

    @ResponseBody
    @PostMapping("/SelectById")
    public TGiverule selectById(@Param("id") Integer id) {
        return tGiveruleService.selectTGiveruleById(id);
    }

    /**
     * 修改保存奖励规则
     */
    @RequiresPermissions("system:tGiverule:edit")
    @Log(title = "奖励规则" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TGiverule tGiverule) {
        return toAjax(tGiveruleService.updateTGiverule(tGiverule));
    }

    /**
     * 删除奖励规则
     */
    @RequiresPermissions("system:tGiverule:remove")
    @Log(title = "奖励规则" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tGiveruleService.deleteTGiveruleByIds(ids));
    }

}
