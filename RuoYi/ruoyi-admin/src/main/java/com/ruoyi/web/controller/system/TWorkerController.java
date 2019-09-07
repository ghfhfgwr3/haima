package com.ruoyi.web.controller.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.TMember;
import io.swagger.annotations.Api;
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
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.TWorker;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ITWorkerService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 员工 信息操作处理
 *
 * @author ruoyi
 * @date 2019-06-12
 */
@Controller
@RequestMapping("/system/tWorker")
public class TWorkerController extends BaseController {
    private String prefix = "system/tWorker";

    @Autowired
    private ITWorkerService tWorkerService;

    @Autowired
    private ISysDeptService deptService;

    @RequiresPermissions("system:tWorker:view")
    @GetMapping()
    public String tWorker() {
        return prefix + "/tWorker";
    }

    /**
     * 校验部门名称
     */
    @PostMapping("/checkDeptNameUnique")
    @ResponseBody
    public String checkDeptNameUnique(SysDept dept) {
        return deptService.checkDeptNameUnique(dept);
    }

    /**
     * 选择部门树
     */
    @GetMapping("/selectDeptTree/{deptId}")
    public String selectDeptTree(@PathVariable("deptId") Long deptId, ModelMap mmap) {
        mmap.put("dept" , deptService.selectDeptById(deptId));
        return prefix + "/tree";
    }

    /**
     * 查询员工列表
     */
    @RequiresPermissions("system:tWorker:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TWorker tWorker) {
        startPage();
        List<TWorker> list = tWorkerService.selectTWorkerList(tWorker);
        return getDataTable(list);
    }


    /**
     * 导出员工列表
     */
    @RequiresPermissions("system:tWorker:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TWorker tWorker) {
        List<TWorker> list = tWorkerService.selectTWorkerList(tWorker);
        ExcelUtil<TWorker> util = new ExcelUtil<TWorker>(TWorker.class);
        return util.exportExcel(list, "员工表");
    }

    /**
     * 新增员工
     */
    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("dept" , deptService.selectDeptById(id));
        return prefix + "/add";
    }

    /**
     * 新增保存员工
     */
    @RequiresPermissions("system:tWorker:add")
    @Log(title = "员工" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TWorker tWorker, HttpServletRequest re) {
        if (StringUtils.isNotNull(tWorker.getId())) {
            return error("不允许修改超级管理员用户");
        }
        String parameter = re.getParameter("parentId");
        tWorker.setCompanyid(Long.valueOf(parameter));

        return toAjax(tWorkerService.insertTWorker(tWorker));
    }

    /**
     * 修改员工
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        TWorker tWorker = tWorkerService.selectTWorkerById(id);
        mmap.put("tWorker" , tWorker);
        return prefix + "/edit";
    }

    /**
     * 修改保存员工
     */
    @RequiresPermissions("system:tWorker:edit")
    @Log(title = "员工" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TWorker tWorker) {
        return toAjax(tWorkerService.updateTWorker(tWorker));
    }

    /**
     * 删除员工
     */
    @RequiresPermissions("system:tWorker:remove")
    @Log(title = "员工" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tWorkerService.deleteTWorkerByIds(ids));
    }

    /**
     * 员工离职状态修改
     */
    @Log(title = "员工管理" , businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:tMember:edit")
    @PostMapping("/changeIsLeave")
    @ResponseBody
    public AjaxResult changeState(TWorker tWorker) {
        return toAjax(tWorkerService.changeIsLeave(tWorker));
    }


}
