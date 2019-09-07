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
import com.ruoyi.system.domain.TConsumerMachine;
import com.ruoyi.system.service.ITConsumerMachineService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 消费机 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-09-04
 */
@Controller
@RequestMapping("/system/tConsumerMachine")
public class TConsumerMachineController extends BaseController
{
    private String prefix = "system/tConsumerMachine";
	
	@Autowired
	private ITConsumerMachineService tConsumerMachineService;
	
	@RequiresPermissions("system:tConsumerMachine:view")
	@GetMapping()
	public String tConsumerMachine()
	{
	    return prefix + "/tConsumerMachine";
	}
	
	/**
	 * 查询消费机列表
	 */
	@RequiresPermissions("system:tConsumerMachine:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TConsumerMachine tConsumerMachine)
	{
		startPage();
        List<TConsumerMachine> list = tConsumerMachineService.selectTConsumerMachineList(tConsumerMachine);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出消费机列表
	 */
	@RequiresPermissions("system:tConsumerMachine:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TConsumerMachine tConsumerMachine)
    {
    	List<TConsumerMachine> list = tConsumerMachineService.selectTConsumerMachineList(tConsumerMachine);
        ExcelUtil<TConsumerMachine> util = new ExcelUtil<TConsumerMachine>(TConsumerMachine.class);
        return util.exportExcel(list, "tConsumerMachine");
    }
	
	/**
	 * 新增消费机
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存消费机
	 */
	@RequiresPermissions("system:tConsumerMachine:add")
	@Log(title = "消费机", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TConsumerMachine tConsumerMachine)
	{		
		return toAjax(tConsumerMachineService.insertTConsumerMachine(tConsumerMachine));
	}

	/**
	 * 修改消费机
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TConsumerMachine tConsumerMachine = tConsumerMachineService.selectTConsumerMachineById(id);
		mmap.put("tConsumerMachine", tConsumerMachine);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存消费机
	 */
	@RequiresPermissions("system:tConsumerMachine:edit")
	@Log(title = "消费机", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TConsumerMachine tConsumerMachine)
	{		
		return toAjax(tConsumerMachineService.updateTConsumerMachine(tConsumerMachine));
	}
	
	/**
	 * 删除消费机
	 */
	@RequiresPermissions("system:tConsumerMachine:remove")
	@Log(title = "消费机", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tConsumerMachineService.deleteTConsumerMachineByIds(ids));
	}
	
}
