package com.ruoyi.web.controller.system;

import com.alibaba.fastjson.JSONArray;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.DateUtilsStr;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ITBalanceChangeService;
import com.ruoyi.system.service.ITMemberService;
import com.ruoyi.system.service.ITMemberTypeService;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;


/**
 * 会员 信息操作处理
 *
 * @author ruoyi
 * @date 2019-06-03
 */

@Controller
@RequestMapping("/system/tMember")
public class TMemberController extends BaseController {
    private String prefix = "system/tMember";

    @Autowired
    private ITMemberService tMemberService;
    @Autowired
    private ITBalanceChangeService tBalanceChangeService;
    @Autowired
    private ISysDeptService deptService;
    @Autowired
    private ITMemberTypeService tMemberTypeService;

    @RequiresPermissions("system:tMember:view")
    @GetMapping()
    public String tMember() {
        return prefix + "/tMember";
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
     * 选择部门树
     */
    @GetMapping("/selectCardType/{deptId}")
    public String selectCardType(@PathVariable("deptId") Long deptId, ModelMap mmap) {
        mmap.put("dept" , deptService.selectDeptById(deptId));
        return prefix + "/tree";
    }

    /**
     * 查询会员列表
     */
    @RequiresPermissions("system:tMember:list")
    @PostMapping("/list")
    //@RequestMapping(value = "/list", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")

    @ResponseBody
    public TableDataInfo list( TMember tMember) {
        startPage();
        List<TMember> list = tMemberService.selectTMemberList(tMember);
        return getDataTable(list);
    }


    /**
     * 导出会员列表
     */
    @RequiresPermissions("system:tMember:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TMember tMember) {
        List<TMember> list = tMemberService.selectTMemberList(tMember);
        ExcelUtil<TMember> util = new ExcelUtil<TMember>(TMember.class);
        return util.exportExcel(list, "会员表");
    }

    /**
     * 新增会员
     */
    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("dept" , deptService.selectDeptById(id));
        //mmap.put("type", tMemberTypeService.selectTMemberTypeByCompanyId(id));
        return prefix + "/add";
    }


    /**
     * 新增保存会员
     */
    @RequiresPermissions("system:tMember:add")
    @Log(title = "会员" , businessType = BusinessType.INSERT)
    @PostMapping("/add")

    @ResponseBody
    public AjaxResult addSave(TMember tMember) {
        //, HttpServletRequest re
        //String parameter = re.getParameter("parentId");
        //tMember.setCompanyid(Long.valueOf(parameter));
        System.out.println("12000000000000000000000000000000000");
        System.out.println(tMember.getMemberTypeId().toString() + "110000000000000000000");
        TMemberType tMemberType = tMemberTypeService.selectTMemberTypeById(Integer.valueOf(tMember.getMemberTypeId().toString()));

        tMember.setExpirydate(DateUtilsStr.dateAddDays(null, tMemberType.getValidDays()));
        int num = tMemberService.insertTMember(tMember);

        BigDecimal Money = tMember.getBalance();
        TBalanceChange tBalanceChange = new TBalanceChange();
        //

        String BalanceMemberNo = tMember.getMemberNo();
        tBalanceChange.setChangeMoney(Money);//办卡金额
        SysUser user = ShiroUtils.getSysUser();
        tBalanceChange.setWorkerid(user.getUserName());//获取用户
        tBalanceChange.setPayorderNO(DateUtils.dateTimeNow() + user.getUserId());
        Integer companyid = Integer.valueOf(tMember.getCompanyid().toString());
        tBalanceChange.setCompanyid(Long.valueOf(companyid));
        tBalanceChange.setMemberNo(BalanceMemberNo);
        tBalanceChange.setMemo("2");
        tBalanceChangeService.insertTBalanceChange(tBalanceChange);


        return toAjax(num);
    }

    /**
     * 修改会员
     */
    @GetMapping("/edit/{id}")

    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        TMember tMember = tMemberService.selectTMemberById(id);
        mmap.put("tMember" , tMember);
        return prefix + "/edit";
    }

    /**
     * 修改保存会员
     */
    @ApiOperation("修改保存会员列表")
    @RequiresPermissions("system:tMember:edit")
    @Log(title = "会员" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")

    @ResponseBody
    public AjaxResult editSave(TMember tMember) {
        return toAjax(tMemberService.updateTMember(tMember));
    }

    /**
     * 删除会员
     */

    @RequiresPermissions("system:tMember:remove")
    @Log(title = "会员" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        System.out.println("删除+1111111111111111111111");
        return toAjax(tMemberService.deleteTMemberByIds(ids));
    }

    /**
     * 会员挂失状态修改
     */
    @Log(title = "会员管理" , businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:tMember:edit")
    @PostMapping("/changeLossStatus")
    @ResponseBody
    public AjaxResult changeLossStatus(TMember tMember) {

        return toAjax(tMemberService.changeLossStatus(tMember));
    }

    /**
     * 会员注销状态修改
     */
    @Log(title = "会员管理" , businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:tMember:edit")
    @PostMapping("/changeState")
    @ResponseBody
    public AjaxResult changeState(TMember tMember) {

        return toAjax(tMemberService.changeState(tMember));
    }

    /**
     * 校验卡号
     */
    @PostMapping("/checkCardNoUnique")
    @ResponseBody
    public String checkCardNoUnique(TMember tMember) {
        //System.out.println("-------------------"+tMember.getMemberTypeId());
        return tMemberService.checkCardNoUnique(tMember);
    }

    /**
     * 校验手机号的唯一性
     */
    @PostMapping("/checkPhoneUnique")
    @ResponseBody
    public String checkPhoneUnique(TMember tMember) {
        //System.out.println("-------------------"+tMember.getMemberTypeId());
        return tMemberService.checkPhoneUnique(tMember);
    }




}
