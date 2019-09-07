package com.ruoyi.web.controller.tool;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;


/**
 * swagger
 *
 * @author ruoyi
 */

@Api("会员余额增加或减少信息管理")
@RestController
@RequestMapping("/test/balance")
public class TestBalanceChangeController extends BaseController {

    private final static Map<Integer, BalanceChangeEntity> balances = new LinkedHashMap<Integer, BalanceChangeEntity>();

    {
        balances.put(4, new BalanceChangeEntity(4, new Date(), 100.5, 0.6, "金海马" , 0, 0, "201906141016521" , "充值"));
        balances.put(5, new BalanceChangeEntity(5, new Date(), 100.2, 10.2, "金海马" , 0, 0, "201906141016521" , "退款"));

    }

    @ApiOperation("获取会员余额视图")
    @GetMapping("/view")
    public ModelAndView balanceChangeView() {

        ModelAndView mv = new ModelAndView("index");
        List<BalanceChangeEntity> balanceChangeList = new ArrayList<BalanceChangeEntity>(balances.values());
        mv.addObject("balanceChangeList" , "balanceChangeList");
        return mv;

    }


    @ApiOperation("获取会员余额列表")
    @GetMapping("/list")
    public AjaxResult balanceChangeList() {
        List<BalanceChangeEntity> balanceChangeList = new ArrayList<BalanceChangeEntity>(balances.values());
        return AjaxResult.success(balanceChangeList);
    }


    @ApiOperation("获取会员余额详细")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id" , value = "ID" , required = true, dataType = "int" , paramType = "query"),
            @ApiImplicitParam(name = "operationTime" , value = "operationTime" , required = true, dataType = "int" , paramType = "query"),
            @ApiImplicitParam(name = "changeMoney" , value = "changeMoney" , required = true, dataType = "int" , paramType = "query")})

    @GetMapping("/getBalanceChange")
    public AjaxResult getBalanceChange(@RequestParam(value = "id" , required = false) Integer id, @RequestParam(value = "operationTime" , required = false) Date operationTime, @RequestParam(value = "changeMoney" , required = false) Double changeMoney) {
        if (!balances.isEmpty() && balances.containsKey(id)) {
            return AjaxResult.success(balances.get(id));
        } else {
            return error("用户不存在");
        }
    }


    @ApiOperation("新增余额变化表")
    @ApiImplicitParam(name = "balanceChangeEntity" , value = "新增余额变化信息" , dataType = "BalanceChangeEntity")
    @PostMapping("/save")
    public AjaxResult save(BalanceChangeEntity balance) {
        if (StringUtils.isNull(balance) || StringUtils.isNull(balance.getId())) {
            return error("id 不能为空");
        }
        return AjaxResult.success(balances.put(balance.getId(), balance));
    }

    @ApiOperation("更新余额变化表")
    @ApiImplicitParam(name = "balanceChangeEntity" , value = "更新余额变化信息" , dataType = "BalanceChangeEntity")
    @PutMapping("/update")
    public AjaxResult update(BalanceChangeEntity balance) {
        if (StringUtils.isNull(balance) || StringUtils.isNull(balance.getId())) {
            return error("id 不能为空");
        }
        if (balances.isEmpty() || !balances.containsKey(balance.getId())) {
            return error("用户不存在");
        }
        balances.remove(balance.getId());
        return AjaxResult.success(balances.put(balance.getId(), balance));
    }

    @ApiOperation("删除会员余额变化信息")
    @ApiImplicitParam(name = "id" , value = "ID" , required = true, dataType = "int" , paramType = "path")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Integer id) {
        if (!balances.isEmpty() && balances.containsKey(id)) {
            balances.remove(id);
            return success();
        } else {
            return error("用户不存在");
        }
    }


}

class BalanceChangeEntity {

    @ApiModelProperty("ID")
    private Integer id;
    @ApiModelProperty("操作时间")
    private Date operationTime;
    @ApiModelProperty("变化金额")
    private Double changeMoney;
    @ApiModelProperty("奖励金额")
    private Double complimentaryMoney;
    @ApiModelProperty("员工工号")
    private String workerid;
    @ApiModelProperty("状态")
    private Integer state;
    @ApiModelProperty("付款方式")
    private Integer paytype;
    @ApiModelProperty("订单号")
    private String payorderNO;

    @ApiModelProperty("备注")
    private String memo;

    public BalanceChangeEntity(Integer id, Date operationTime, Double changeMoney, Double complimentaryMoney, String workerid, Integer state, Integer paytype, String payorderNO, String memo) {
        this.id = id;
        this.operationTime = operationTime;
        this.changeMoney = changeMoney;
        this.complimentaryMoney = complimentaryMoney;
        this.workerid = workerid;
        this.state = state;
        this.paytype = paytype;
        this.payorderNO = payorderNO;
        this.memo = memo;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public BalanceChangeEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public Double getChangeMoney() {
        return changeMoney;
    }

    public void setChangeMoney(Double changeMoney) {
        this.changeMoney = changeMoney;
    }

    public Double getComplimentaryMoney() {
        return complimentaryMoney;
    }

    public void setComplimentaryMoney(Double complimentaryMoney) {
        this.complimentaryMoney = complimentaryMoney;
    }

    public String getWorkerid() {
        return workerid;
    }

    public void setWorkerid(String workerid) {
        this.workerid = workerid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }

    public String getPayorderNO() {
        return payorderNO;
    }

    public void setPayorderNO(String payorderNO) {
        this.payorderNO = payorderNO;
    }


}