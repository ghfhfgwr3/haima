package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.DateUtilsStr;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.*;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/system/tfastconsumption")
public class TFastConsumptionController extends BaseController {
    private String prefix = "system/tfastconsumption";

    @Autowired
    private ITMemberService tMemberService;
    @Autowired
    private ITMemberTypeService tMemberTypeService;
    @Autowired
    private ITBalanceChangeService tBalanceChangeService;
    @Autowired
    private ITMemberConsumeService tMemberConsumeService;

    @Autowired
    private ITCardReplacementService tCardReplacementService;

    @RequiresPermissions("system:tfastconsumption:view")
    @GetMapping()
    public String tBalanceChange() {
        return prefix + "/tfastconsumption";
    }

    /**
     * 修改会员余额的增加和减少
     */
    @RequiresPermissions("system:tfastconsumption:list")
    @PostMapping("/list")
    @Log(title = "会员消费" , businessType = BusinessType.UPDATE)
    @ResponseBody
    public TMember edit(@Param("memberNo") String memberNo, @Param("mobilephones") String mobilephones, ModelMap mmap) {

        startPage();
        TMember tMember = new TMember();
        if (tMemberService.selectMemberNoAndPhone(memberNo, mobilephones) == null) {
            tMember.setMemberNo("不存在");
        } else {
            tMember = tMemberService.selectMemberNoAndPhone(memberNo, mobilephones);
        }


        return tMember;
    }

    @Log(title = "快速消费" , businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:tfastconsumption:money")
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult editSave(@Param("memberNo") String memberNo, @Param("mobilephones") String mobilephones, @Param("totalmoney") String totalmoney, @Param("balance") String balance, @Param("points") String points, @Param("m") String m, @Param("cardType") String cardType) {
        TMemberConsume tMemberConsume = new TMemberConsume();
        TBalanceChange tBalanceChange = new TBalanceChange();
        TMember tMember = new TMember();

        tMember = tMemberService.selectMemberNoAndPhone(memberNo, mobilephones);
        SysUser user = ShiroUtils.getSysUser();
        String djh = DateUtils.dateTimeNow() + user.getUserId();
        BigDecimal i = new BigDecimal(balance);
        BigDecimal Money = new BigDecimal(0);

        Integer companyid = 0;
        String BalanceMemberNo = "";
        String MemberName = "";
        if (m.equals("0")) {

            Money = tMember.getBalance().subtract(i);

            companyid = Integer.valueOf(tMember.getCompanyid().toString());
            BalanceMemberNo = tMember.getMemberNo();
            MemberName = tMember.getMemberName();


            tBalanceChange.setMemo("消费");
        }
        //插入一条消费记录

        tMemberConsume.setCardno(memberNo);
        tMemberConsume.setMemberName(MemberName);
        tMemberConsume.setPhone(mobilephones);
        tMemberConsume.setDjh(djh);
        tMemberConsume.setTotalMoney(totalmoney);
        tMemberConsume.setMoney(balance);
        tMemberConsume.setRealMoney(i);
        tMemberConsume.setConsumeType("快速消费");
        tMemberConsume.setPaytype("快速消费");
        tMemberConsume.setCompanyid(Long.valueOf(companyid));
        tMemberConsume.setConsumeTime(DateUtils.getNowDate());
        tMemberConsume.setOprator(user.getUserName());
        tMemberConsume.setCardType(cardType);
        tMemberConsume.setCardpay(i);
        // tMemberConsume.setCashpay(0.0);
        // tMemberConsume.setBankpay(0);
        // tMemberConsume.setCentpay(0);
        //tMemberConsume.setCashcoupon(0);
        //tMemberConsume.setMoling(0);
        int mConsume = tMemberConsumeService.insertTMemberConsume(tMemberConsume);
        int updateTMemberNoAndPhone = 0;
        if (mConsume == 1) {
            //插入一条余额变化记录
            //修改tmember表记录
            try {

                //updateTMemberNoAndPhone = tMemberService.updateTMemberNoAndPhone(memberNo, mobilephones,Money.toString(),points);
            } catch (Exception e) {
                e.printStackTrace();
            }

            tBalanceChange.setChangeMoney(i);//变化金额

            tBalanceChange.setWorkerid(user.getUserName());//获取用户
            tBalanceChange.setPayorderNO(djh);
            tBalanceChange.setCompanyid(Long.valueOf(companyid));
            tBalanceChange.setMemberNo(BalanceMemberNo);
            tBalanceChangeService.insertTBalanceChange(tBalanceChange);
        }
        return toAjax(updateTMemberNoAndPhone);

    }

    /**
     * 校验部门名称
     */
    @PostMapping("/checkTMemberIslossUnique")
    @ResponseBody
    public String checkTMemberNameUnique(TMember tMember) {
        return tMemberService.checkDeptNameUnique(tMember);
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
    @RequiresPermissions("system:tfastconsumption:edit")
    @Log(title = "快速消费" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Param("memberNo") String memberNo, @Param("memberNoTwo") String memberNoTwo, @Param("id") String id) {
        /*首先根据id获取要插入的信息*/
        TMember tMemberById = tMemberService.selectTMemberById(Long.valueOf(id));
        /*在插入的过程中设置要修改的卡号*/
        tMemberById.setId(null);
        tMemberById.setMemberNo(memberNoTwo);
        tMemberById.setIsloss(0);

        tMemberService.insertTMember(tMemberById);

        TMember tMember = new TMember();
        //tMember.setMemberNo(memberNoTwo);
        tMember.setId(Long.valueOf(id));
        BigDecimal money = new BigDecimal(0);
        /*保留原卡信息并现有金额和奖励金额清零*/
        tMember.setBalance(money);
        tMember.setComplimentaryMoney(money);
        int updateTMember = tMemberService.updateTMember(tMember);
        TCardReplacement tCardReplacement = new TCardReplacement();
        tCardReplacement.setCardnoOld(memberNo);
        tCardReplacement.setCardnoNew(memberNoTwo);
        SysUser user = ShiroUtils.getSysUser();
        tCardReplacement.setOperator(user.getUserName());
        tCardReplacement.setOperateTime(DateUtilsStr.dateStrUtils(DateUtils.getTime(), DateUtilsStr.DATE_TIME_PATTERN));
        TMember tMemberCompanyid = tMemberService.selectTMemberById(Long.valueOf(id));
//        System.out.println(tMemberCompanyid.getCompanyid());
//        System.out.println(tMemberCompanyid.getCompanyid());
//        System.out.println(tMemberCompanyid.getCompanyid());
        tCardReplacement.setCompanyid(tMemberCompanyid.getCompanyid());
        /*插入一条补卡记录*/
        tCardReplacementService.insertTCardReplacement(tCardReplacement);
        return toAjax(updateTMember);
    }


}
