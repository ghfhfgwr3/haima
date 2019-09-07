package com.ruoyi.web.controller.system;

import java.util.List;

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
import com.ruoyi.system.domain.TBalanceChange;
import com.ruoyi.system.service.ITBalanceChangeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 会员余额的增加和减少 信息操作处理
 *
 * @author ruoyi
 * @date 2019-06-03
 */
@Controller
@RequestMapping("/system/tBalanceChange")
public class TBalanceChangeController extends BaseController {
    private String prefix = "system/tBalanceChange";

    @Autowired
    private ITBalanceChangeService tBalanceChangeService;

    @RequiresPermissions("system:tBalanceChange:view")
    @GetMapping()
    public String tBalanceChange() {
        return prefix + "/tBalanceChange";
    }

    /**
     * 查询会员余额的增加和减少列表
     */
    @RequiresPermissions("system:tBalanceChange:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TBalanceChange tBalanceChange) {
        startPage();
        List<TBalanceChange> list = tBalanceChangeService.selectTBalanceChangeList(tBalanceChange);
        return getDataTable(list);
    }


    /**
     * 导出会员余额的增加和减少列表
     */
    @RequiresPermissions("system:tBalanceChange:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TBalanceChange tBalanceChange) {
        List<TBalanceChange> list = tBalanceChangeService.selectTBalanceChangeList(tBalanceChange);
        ExcelUtil<TBalanceChange> util = new ExcelUtil<TBalanceChange>(TBalanceChange.class);
        return util.exportExcel(list, "会员余额变化表");
    }

    /**
     * 新增会员余额的增加和减少
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存会员余额的增加和减少
     */
    @RequiresPermissions("system:tBalanceChange:add")
    @Log(title = "会员余额的增加和减少" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TBalanceChange tBalanceChange) {
        return toAjax(tBalanceChangeService.insertTBalanceChange(tBalanceChange));
    }

    /**
     * 修改会员余额的增加和减少
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        TBalanceChange tBalanceChange = tBalanceChangeService.selectTBalanceChangeById(id);
        mmap.put("tBalanceChange" , tBalanceChange);
        return prefix + "/edit";
    }

    /**
     * 修改保存会员余额的增加和减少
     */
    @RequiresPermissions("system:tBalanceChange:edit")
    @Log(title = "会员余额的增加和减少" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TBalanceChange tBalanceChange) {
        return toAjax(tBalanceChangeService.updateTBalanceChange(tBalanceChange));
    }

    /**
     * 删除会员余额的增加和减少
     */
    @RequiresPermissions("system:tBalanceChange:remove")
    @Log(title = "会员余额的增加和减少" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tBalanceChangeService.deleteTBalanceChangeByIds(ids));
    }

}
