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
import com.ruoyi.system.domain.TCardReplacement;
import com.ruoyi.system.service.ITCardReplacementService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 补卡记录 信息操作处理
 *
 * @author ruoyi
 * @date 2019-06-03
 */
@Controller
@RequestMapping("/system/tCardReplacement")
public class TCardReplacementController extends BaseController {
    private String prefix = "system/tCardReplacement";

    @Autowired
    private ITCardReplacementService tCardReplacementService;

    @RequiresPermissions("system:tCardReplacement:view")
    @GetMapping()
    public String tCardReplacement() {
        return prefix + "/tCardReplacement";
    }

    /**
     * 查询补卡记录列表
     */
    @RequiresPermissions("system:tCardReplacement:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TCardReplacement tCardReplacement) {
        startPage();
        List<TCardReplacement> list = tCardReplacementService.selectTCardReplacementList(tCardReplacement);
        return getDataTable(list);
    }


    /**
     * 导出补卡记录列表
     */
    @RequiresPermissions("system:tCardReplacement:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TCardReplacement tCardReplacement) {
        List<TCardReplacement> list = tCardReplacementService.selectTCardReplacementList(tCardReplacement);
        ExcelUtil<TCardReplacement> util = new ExcelUtil<TCardReplacement>(TCardReplacement.class);
        return util.exportExcel(list, "补卡记录表");
    }

    /**
     * 新增补卡记录
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存补卡记录
     */
    @RequiresPermissions("system:tCardReplacement:add")
    @Log(title = "补卡记录" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TCardReplacement tCardReplacement) {
        return toAjax(tCardReplacementService.insertTCardReplacement(tCardReplacement));
    }

    /**
     * 修改补卡记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        TCardReplacement tCardReplacement = tCardReplacementService.selectTCardReplacementById(id);
        mmap.put("tCardReplacement" , tCardReplacement);
        return prefix + "/edit";
    }

    /**
     * 修改保存补卡记录
     */
    @RequiresPermissions("system:tCardReplacement:edit")
    @Log(title = "补卡记录" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TCardReplacement tCardReplacement) {
        return toAjax(tCardReplacementService.updateTCardReplacement(tCardReplacement));
    }

    /**
     * 删除补卡记录
     */
    @RequiresPermissions("system:tCardReplacement:remove")
    @Log(title = "补卡记录" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tCardReplacementService.deleteTCardReplacementByIds(ids));
    }

}
