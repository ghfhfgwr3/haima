package com.ruoyi.web.controller.system;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.DateUtilsStr;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.*;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.util.ShiroUtils;

@Controller
@RequestMapping("/system/recharge")
public class RechargeController extends BaseController {
    private String prefix = "system/recharge";

    @Autowired
    private ITMemberService tMemberService;

    @Autowired
    private ITBalanceChangeService tBalanceChangeService;

    @Autowired
    private ITCardReplacementService tCardReplacementService;

    @Autowired
    private ITGiveruleService itGiveruleService;

    @Autowired
    private ISysUserService userService;

    @RequiresPermissions("system:recharge:view")
    @GetMapping()
    public String tBalanceChange() {
        return prefix + "/recharge";
    }

    /**
     * 修改会员余额的增加和减少
     */
    @RequiresPermissions("system:recharge:list")
    @PostMapping("/list")
    @ResponseBody
    public TMember edit(@Param("memberNo") String memberNo, @Param("mobilephones") String mobilephones, ModelMap mmap) {
        startPage();
        TMember list = new TMember();
        if (tMemberService.selectMemberNoAndPhone(memberNo, mobilephones) == null) {
            list.setMemberNo("不存在");

        } else {
            list = tMemberService.selectMemberNoAndPhone(memberNo, mobilephones);
        }
        return list;
    }

    @PostMapping("/offTMember")
    @ResponseBody
    public TMember offTMember(@Param("memberNo") String memberNo, @Param("mobilephones") String mobilephones) {
        TMember tMember = new TMember();
        if (tMemberService.selectMemberNoAndPhone(memberNo, mobilephones) == null) {
            tMember.setMemberNo("不存在");
        } else {
            tMember = tMemberService.selectMemberNoAndPhone(memberNo, mobilephones);
        }
        return tMember;
    }

    @PostMapping("/scbct")
    @ResponseBody
    public List<TGiverule> selectCompanyidByCardType(@Param("companyid") String companyid, @Param("cardtype") String cardtype) {
        //System.out.println(companyid+"**********"+cardtype);
        List<TGiverule> list_tGiverule = itGiveruleService.selectTGiveruleByCompanyidAndCardType(Integer.valueOf(companyid), Integer.valueOf(cardtype));

        return list_tGiverule;
    }

    @Log(title = "会员" , businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:recharge:money")
    @PostMapping("/update")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult editSave(@Param("memberNo") String memberNo, @Param("mobilephones") String mobilephones, @Param("balance") String balance, @Param("paytype") String paytype, @Param("m") String m, @Param("money") String money) throws Exception {
        TMember tMember = tMemberService.selectMemberNoAndPhone(memberNo, mobilephones);
        BigDecimal i = new BigDecimal(balance);//充值金额
        BigDecimal o = new BigDecimal(money);//总计金额
        BigDecimal c = o.subtract(i);//奖励金额
        BigDecimal MoneyOne = new BigDecimal(0);
        BigDecimal MoneyTwo = new BigDecimal(0);
        BigDecimal MoneyThree = new BigDecimal(0);
        BigDecimal points = new BigDecimal(0);
        TBalanceChange tBalanceChange = new TBalanceChange();
        Integer companyid = 0;
        String BalanceMemberNo = "";
        if (m.equals("1")) {
            MoneyOne = tMember.getBalance().add(i);//充值金额
            System.out.println(tMember.getMoney() + "*************************");
            MoneyTwo = tMember.getMoney().add(o);//总计
            MoneyThree = tMember.getComplimentaryMoney().add(c);//奖励
            points = tMember.getPoints();
            companyid = Integer.valueOf(tMember.getCompanyid().toString());
            BalanceMemberNo = tMember.getMemberNo();
            tBalanceChange.setMemo("0");
            tBalanceChange.setPaytype(Integer.valueOf(paytype));
        } else if (m.equals("0")) {
            MoneyOne = tMember.getBalance().subtract(i);//退款金额
            MoneyTwo = tMember.getMoney().subtract(o);//总计
            MoneyThree = tMember.getComplimentaryMoney().subtract(c);//奖励
            points = tMember.getPoints();
            companyid = Integer.valueOf(tMember.getCompanyid().toString());
            BalanceMemberNo = tMember.getMemberNo();
            tBalanceChange.setMemo("1");
        }
        int updateTMemberNoAndPhone = 0;

        try {
            updateTMemberNoAndPhone = tMemberService.updateTMemberNoAndPhone(memberNo, mobilephones, MoneyOne.toString(), points.toString(), MoneyTwo.toString(), MoneyThree.toString());
            tBalanceChange.setChangeMoney(i);//充值金额
            SysUser user = ShiroUtils.getSysUser();
            tBalanceChange.setWorkerid(user.getUserName());//获取用户
            tBalanceChange.setPayorderNO(DateUtils.dateTimeNow() + user.getUserId());
            tBalanceChange.setCompanyid(Long.valueOf(companyid));
            tBalanceChange.setMemberNo(BalanceMemberNo);

            tBalanceChangeService.insertTBalanceChange(tBalanceChange);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toAjax(updateTMemberNoAndPhone);
    }

    /**
     * 校验部门名称
     */
    @PostMapping("/checkTMemberIslossUnique")
    @ResponseBody
    public String checkTMemberNameUnique(TMember tMember) {
        SysUser user = ShiroUtils.getSysUser();
        //user.getLoginName();//登录名称
        SysUser sysUser = userService.selectUserByLoginName(user.getLoginName());
        tMember.setCompanyid(sysUser.getDeptId());
        System.out.println(tMember);
        String s = tMemberService.checkDeptNameUnique(tMember);
        return s;
    }

    /**
     * 校验卡号
     */
    @PostMapping("/checkCardCount")
    @ResponseBody
    public String checkCardCount(TMember tMember) {
        //System.out.println("-------------------"+tMember.getMemberTypeId());
        return tMemberService.checkCardCount(tMember);
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
    @RequiresPermissions("system:recharge:edit")
    @Log(title = "会员" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Param("memberNoOne") String memberNoOne, @Param("memberNoTwo") String memberNoTwo) {
        /*首先根据id获取要插入的信息*/
        TMember tMemberById = tMemberService.selectTMemberById(Long.valueOf(memberNoOne));
        System.out.println(tMemberById);
        /*在插入的过程中设置要修改的卡号*/
        tMemberById.setId(null);
        tMemberById.setMemberNo(memberNoTwo);
        tMemberById.setIsloss(0);
        tMemberService.insertTMember(tMemberById);

        TMember tMember = new TMember();
        tMember.setMemberNo(memberNoOne);
        BigDecimal money = new BigDecimal(0);
        /*保留原卡信息并现有金额和奖励金额清零*/
        tMember.setBalance(money);
        tMember.setComplimentaryMoney(money);
        int updateTMember = tMemberService.updateTMemberByMemberNo(tMember);
        TCardReplacement tCardReplacement = new TCardReplacement();
        tCardReplacement.setCardnoOld(memberNoOne);
        tCardReplacement.setCardnoNew(memberNoTwo);
        SysUser user = ShiroUtils.getSysUser();
        tCardReplacement.setOperator(user.getUserName());
        tCardReplacement.setOperateTime(DateUtilsStr.dateStrUtils(DateUtils.getTime(), DateUtilsStr.DATE_TIME_PATTERN));
        TMember tMemberCompanyid = tMemberService.selectTMemberById(Long.valueOf(memberNoOne));
        tCardReplacement.setCompanyid(tMemberCompanyid.getCompanyid());
        /*插入一条补卡记录*/
        tCardReplacementService.insertTCardReplacement(tCardReplacement);
        tBalanceChangeService.updateTBalanceChangeByMemberNo(memberNoTwo, memberNoOne);
        return toAjax(updateTMember);
    }

}
