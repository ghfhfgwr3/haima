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
import com.ruoyi.system.domain.TMemberConsume;
import com.ruoyi.system.service.ITMemberConsumeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 会员消费 信息操作处理
 *
 * @author ruoyi
 * @date 2019-07-02
 */
@Controller
@RequestMapping("/system/tMemberConsume")
public class TMemberConsumeController extends BaseController {
    private String prefix = "system/tMemberConsume";

    @Autowired
    private ITMemberConsumeService tMemberConsumeService;

    @RequiresPermissions("system:tMemberConsume:view")
    @GetMapping()
    public String tMemberConsume() {
        return prefix + "/tMemberConsume";
    }

    /**
     * 查询会员消费列表
     */
    @RequiresPermissions("system:tMemberConsume:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TMemberConsume tMemberConsume) {
        startPage();
        List<TMemberConsume> list = tMemberConsumeService.selectTMemberConsumeList(tMemberConsume);
        return getDataTable(list);
    }


    /**
     * 导出会员消费列表
     */
    @RequiresPermissions("system:tMemberConsume:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TMemberConsume tMemberConsume) {
        List<TMemberConsume> list = tMemberConsumeService.selectTMemberConsumeList(tMemberConsume);
        ExcelUtil<TMemberConsume> util = new ExcelUtil<TMemberConsume>(TMemberConsume.class);
        return util.exportExcel(list, "tMemberConsume");
    }

    /**
     * 新增会员消费
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存会员消费
     */
    @RequiresPermissions("system:tMemberConsume:add")
    @Log(title = "会员消费" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TMemberConsume tMemberConsume) {
        return toAjax(tMemberConsumeService.insertTMemberConsume(tMemberConsume));
    }

    /**
     * 修改会员消费
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        TMemberConsume tMemberConsume = tMemberConsumeService.selectTMemberConsumeById(id);
        mmap.put("tMemberConsume" , tMemberConsume);
        return prefix + "/edit";
    }

    /**
     * 修改保存会员消费
     */
    @RequiresPermissions("system:tMemberConsume:edit")
    @Log(title = "会员消费" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TMemberConsume tMemberConsume) {
        return toAjax(tMemberConsumeService.updateTMemberConsume(tMemberConsume));
    }

    /**
     * 删除会员消费
     */
    @RequiresPermissions("system:tMemberConsume:remove")
    @Log(title = "会员消费" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tMemberConsumeService.deleteTMemberConsumeByIds(ids));
    }

}
