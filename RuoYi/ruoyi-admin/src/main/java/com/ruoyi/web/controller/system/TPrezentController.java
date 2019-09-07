package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.TPrezent;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ITPrezentService;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 积分兑换 信息操作处理
 *
 * @author ruoyi
 * @date 2019-07-05
 */
@Controller
@RequestMapping("/system/tPrezent")
public class TPrezentController extends BaseController {
    private String prefix = "system/tPrezent";
    private String prefix2 = "system/tWorker";

    @Autowired
    private ITPrezentService tPrezentService;
    @Autowired
    private ISysDeptService deptService;

    @RequiresPermissions("system:tPrezent:view")
    @GetMapping()
    public String tPrezent() {
        return prefix + "/tPrezent";
    }

    /**
     * 查询积分兑换列表
     */
    @RequiresPermissions("system:tPrezent:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TPrezent tPrezent) {
        startPage();
        List<TPrezent> list = tPrezentService.selectTPrezentList(tPrezent);
        return getDataTable(list);
    }


    /**
     * 导出积分兑换列表
     */
    @RequiresPermissions("system:tPrezent:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TPrezent tPrezent) {
        List<TPrezent> list = tPrezentService.selectTPrezentList(tPrezent);
        ExcelUtil<TPrezent> util = new ExcelUtil<TPrezent>(TPrezent.class);
        return util.exportExcel(list, "tPrezent");
    }

    /**
     * 新增积分兑换
     */
    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") Long id, ModelMap mmap) {
        SysUser user = ShiroUtils.getSysUser();
        TPrezent tPrezent = new TPrezent();
        tPrezent.setOprator(user.getUserName());
        mmap.put("dept" , deptService.selectDeptById(id));
        return prefix + "/add";
    }

    /**
     * 新增保存积分兑换
     */
    @RequiresPermissions("system:tPrezent:add")
    @Log(title = "积分兑换" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TPrezent tPrezent) {
        return toAjax(tPrezentService.insertTPrezent(tPrezent));
    }

    /**
     * 修改积分兑换
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        TPrezent tPrezent = tPrezentService.selectTPrezentById(id);
        mmap.put("tPrezent" , tPrezent);
        return prefix + "/edit";
    }

    /**
     * 修改保存积分兑换
     */
    @RequiresPermissions("system:tPrezent:edit")
    @Log(title = "积分兑换" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TPrezent tPrezent) {
        return toAjax(tPrezentService.updateTPrezent(tPrezent));
    }

    /**
     * 删除积分兑换
     */
    @RequiresPermissions("system:tPrezent:remove")
    @Log(title = "积分兑换" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tPrezentService.deleteTPrezentByIds(ids));
    }

    /**
     * 选择部门树
     */
    @GetMapping("/selectDeptTree/{deptId}")
    public String selectDeptTree(@PathVariable("deptId") Long deptId, ModelMap mmap) {
        mmap.put("dept" , deptService.selectDeptById(deptId));
        return prefix2 + "/tree";
    }

    /**
     * 奖品兑换状态的修改
     */
    @Log(title = "奖品管理" , businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:tPrezent:edit")
    @PostMapping("/changeState")
    @ResponseBody
    public AjaxResult changeState(TPrezent tPrezent) {
        return toAjax(tPrezentService.changeState(tPrezent));
    }

    /**
     * 校验礼品编号的唯一性
     */
    @PostMapping("/checkBhUnique")
    @ResponseBody
    public String checkBhUnique(TPrezent tPrezent) {
        //System.out.println("-------------------"+tPrezent.getPrezentBh());
        return tPrezentService.checkBhUnique(tPrezent);
    }
}
