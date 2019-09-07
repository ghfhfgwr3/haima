package com.ruoyi.web.controller.tool;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * swagger 员工测试方法
 *
 * @author ruoyi
 */
@Api("员工信息管理")
@RestController
@RequestMapping("/test/worker")
public class TestWorkerController extends BaseController {


    private final static Map<Integer, WorkerEntity> workers = new LinkedHashMap<Integer, WorkerEntity>();

    {


        workers.put(1, new WorkerEntity(1, 103, "001" , "123" , "金海马" , 0, "中国" , "大专" , "平山" , "无极县" , "050000" , "11022101" , "634931184@qq.com" , "15630190930" , "15630190930" , 2313.36, 3, 0, "2015-03-12" , "2018-05-12" , "正常" , 110, "测试部"));
        workers.put(2, new WorkerEntity(2, 103, "002" , "123" , "金海马" , 0, "中国" , "大专" , "灵兽" , "无极县" , "050000" , "11022101" , "634931184@qq.com" , "15630190930" , "15630190930" , 3123.6, 3, 0, "2016-03-13" , "2018-08-12" , "正常" , 100, "开发部"));

    }


    @ApiOperation("获取员工列表")
    @GetMapping("/list")
    public AjaxResult workerList() {
        List<WorkerEntity> workerList = new ArrayList<WorkerEntity>(workers.values());
        return AjaxResult.success(workerList);
    }

    @ApiOperation("获取员工详细")
    @ApiImplicitParam(name = "id" , value = "id" , required = true, dataType = "int" , paramType = "path")
    @GetMapping("/{id}")
    public AjaxResult getWorker(@PathVariable Integer id) {
        if (!workers.isEmpty() && workers.containsKey(id)) {
            return AjaxResult.success(workers.get(id));
        } else {
            return error("员工不存在");
        }
    }

    @ApiOperation("新增员工")
    @ApiImplicitParam(name = "workerEntity" , value = "新增员工信息" , dataType = "WorkerEntity")
    @PostMapping("/increase")
    public AjaxResult increaseWorker(WorkerEntity worker) {
        if (StringUtils.isNull(worker) || StringUtils.isNull(worker.getId())) {
            return error("员工ID不能为空");
        }
        return AjaxResult.success(workers.put(worker.getId(), worker));
    }

    @ApiOperation("更新员工")
    @ApiImplicitParam(name = "workerEntity" , value = "更新员工信息" , dataType = "WorkerEntity")
    @PutMapping("/updateWorker")
    public AjaxResult updateWorker(WorkerEntity worker) {
        if (StringUtils.isNull(worker) || StringUtils.isNull(worker.getId())) {
            return error("员工ID不能为空");
        }
        if (workers.isEmpty() || !workers.containsKey(worker.getId())) {
            return error("员工不存在");
        }
        workers.remove(worker.getId());
        return AjaxResult.success(workers.put(worker.getId(), worker));
    }

    @ApiOperation("删除员工信息")
    @ApiImplicitParam(name = "id " , value = "员工ID" , required = true, dataType = "int" , paramType = "path")
    @DeleteMapping("/{id}")
    public AjaxResult deleteWorker(@PathVariable Integer id) {
        if (!workers.isEmpty() && workers.containsKey(id)) {
            workers.remove(id);
            return success();
        } else {
            return error("员工不存在");
        }
    }


}

@ApiModel("员工实体")
class WorkerEntity {


    @ApiModelProperty("ID")
    private Integer id;
    /**
     * 公司ID
     */
    @ApiModelProperty("公司ID")
    private Integer companyid;
    @ApiModelProperty("账号")
    private String loginNo;
    @ApiModelProperty("密码")
    private String loginPassword;
    @ApiModelProperty("工名")
    private String workerName;
    @ApiModelProperty("性别")
    private Integer workerSex;
    @ApiModelProperty("国家")
    private String nation;
    @ApiModelProperty("教育程度")
    private String education;
    @ApiModelProperty("家乡")
    private String homeTown;
    @ApiModelProperty("地址")
    private String address;
    @ApiModelProperty("邮编")
    private String postcode;
    @ApiModelProperty("ID卡号")
    private String iDCardno;
    @ApiModelProperty("电子邮件")
    private String email;
    @ApiModelProperty("电话")
    private String telephone;
    @ApiModelProperty("手机")
    private String mobile;
    @ApiModelProperty("薪水")
    private Double salary;
    @ApiModelProperty("工龄")
    private Integer workAge;
    @ApiModelProperty("是否离职")
    private Integer isLeave;
    @ApiModelProperty("入职时间")
    private String hiredate;
    @ApiModelProperty("离职日期")
    private String leavedate;
    @ApiModelProperty("备注")
    private String memo;
    @ApiModelProperty("部门id")
    private Integer deptId;
    @ApiModelProperty("部门名字")
    private String deptName;

    public WorkerEntity() {

    }

    public WorkerEntity(Integer id, Integer companyid, String loginNo, String loginPassword, String workerName, Integer workerSex, String nation, String education, String homeTown, String address, String postcode, String iDCardno, String email, String telephone, String mobile, Double salary, Integer workAge, Integer isLeave, String hiredate, String leavedate, String memo, Integer deptId, String deptName) {
        this.id = id;
        this.companyid = companyid;
        this.loginNo = loginNo;
        this.loginPassword = loginPassword;
        this.workerName = workerName;
        this.workerSex = workerSex;
        this.nation = nation;
        this.education = education;
        this.homeTown = homeTown;
        this.address = address;
        this.postcode = postcode;
        this.iDCardno = iDCardno;
        this.email = email;
        this.telephone = telephone;
        this.mobile = mobile;
        this.salary = salary;
        this.workAge = workAge;
        this.isLeave = isLeave;
        this.hiredate = hiredate;
        this.leavedate = leavedate;
        this.memo = memo;
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getLoginNo() {
        return loginNo;
    }

    public void setLoginNo(String loginNo) {
        this.loginNo = loginNo;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public Integer getWorkerSex() {
        return workerSex;
    }

    public void setWorkerSex(Integer workerSex) {
        this.workerSex = workerSex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getiDCardno() {
        return iDCardno;
    }

    public void setiDCardno(String iDCardno) {
        this.iDCardno = iDCardno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getWorkAge() {
        return workAge;
    }

    public void setWorkAge(Integer workAge) {
        this.workAge = workAge;
    }

    public Integer getIsLeave() {
        return isLeave;
    }

    public void setIsLeave(Integer isLeave) {
        this.isLeave = isLeave;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public String getLeavedate() {
        return leavedate;
    }

    public void setLeavedate(String leavedate) {
        this.leavedate = leavedate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}