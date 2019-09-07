package com.ruoyi.web.controller.system;

import java.util.List;

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
import com.ruoyi.system.domain.Consume;
import com.ruoyi.system.service.IConsumeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 消费记录 信息操作处理
 *
 * @author ruoyi
 * @date 2019-08-22
 */
@Controller
@RequestMapping("/system/consume")
public class ConsumeController extends BaseController {
    private String prefix = "system/consume";

    @Autowired
    private IConsumeService consumeService;

    @RequiresPermissions("system:consume:view")
    @GetMapping()
    public String consume() {
        return prefix + "/consume";
    }

    /**
     * 查询消费记录列表
     */
    @RequiresPermissions("system:consume:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Consume consume) {
        startPage();
        List<Consume> list = consumeService.selectConsumeList(consume);
        return getDataTable(list);
    }


    /**
     * 导出消费记录列表
     */
    @RequiresPermissions("system:consume:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Consume consume) {
        List<Consume> list = consumeService.selectConsumeList(consume);
        ExcelUtil<Consume> util = new ExcelUtil<Consume>(Consume. class);
        return util.exportExcel(list, "consume");
    }

    /**
     * 新增消费记录
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存消费记录
     */
    @RequiresPermissions("system:consume:add")
    @Log(title = "消费记录" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Consume consume) {
        return toAjax(consumeService.insertConsume(consume));
    }

    /**
     * 修改消费记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        Consume consume =consumeService.selectConsumeById(id);
        mmap.put("consume" , consume);
        return prefix + "/edit";
    }

    /**
     * 修改保存消费记录
     */
    @RequiresPermissions("system:consume:edit")
    @Log(title = "消费记录" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Consume consume) {
        return toAjax(consumeService.updateConsume(consume));
    }

    /**
     * 删除消费记录
     */
    @RequiresPermissions("system:consume:remove")
    @Log(title = "消费记录" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(consumeService.deleteConsumeByIds(ids));
    }

}
