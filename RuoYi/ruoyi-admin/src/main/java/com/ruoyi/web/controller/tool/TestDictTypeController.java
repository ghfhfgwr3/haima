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
 * swagger 字典类型测试方法
 *
 * @author ruoyi
 */
@Api("字典类型信息管理")
@RestController
@RequestMapping("/test/dictType")
public class TestDictTypeController extends BaseController {

    private final static Map<Integer, DictTypeEntity> dictTypes = new LinkedHashMap<Integer, DictTypeEntity>();

    {
        //Integer dictId, String dictName, String dictType, String status
        dictTypes.put(1, new DictTypeEntity(1, "用户性别" , "sys_user_sex" , "0"));
        dictTypes.put(2, new DictTypeEntity(1, "菜单状态" , "sys_show_hide" , "0"));

    }

    @ApiOperation("获取字典类型列表")
    @GetMapping("/list")
    public AjaxResult dictTypeList() {
        List<DictTypeEntity> dictTypeList = new ArrayList<DictTypeEntity>(dictTypes.values());
        return AjaxResult.success(dictTypeList);
    }

    @ApiOperation("获取字典类型详细")
    @ApiImplicitParam(name = "dictId" , value = "字典主键" , required = true, dataType = "int" , paramType = "path")
    @GetMapping("/{dictId}")
    public AjaxResult getDictType(@PathVariable Integer dictId) {
        if (!dictTypes.isEmpty() && dictTypes.containsKey(dictId)) {
            return AjaxResult.success(dictTypes.get(dictId));
        } else {
            return error("此条字典不存在");
        }
    }

    @ApiOperation("新增字典类型")
    @ApiImplicitParam(name = "dictTypeEntity" , value = "新增字典类型信息" , dataType = "DictTypeEntity")
    @PostMapping("/increaseDictType")
    public AjaxResult increaseDictType(DictTypeEntity dictType) {
        if (StringUtils.isNull(dictType) || StringUtils.isNull(dictType.getDictId())) {
            return error("字典主键不能为空");
        }
        return AjaxResult.success(dictTypes.put(dictType.getDictId(), dictType));
    }

    @ApiOperation("更新字典类型")
    @ApiImplicitParam(name = "dictTypeEntity" , value = "更新字典类型信息" , dataType = "DictTypeEntity")
    @PutMapping("/update")
    public AjaxResult update(DictTypeEntity dictType) {
        if (StringUtils.isNull(dictType) || StringUtils.isNull(dictType.getDictId())) {
            return error("字典主键不能为空");
        }
        if (dictTypes.isEmpty() || !dictTypes.containsKey(dictType.getDictId())) {
            return error("此条字典不存在");
        }
        dictTypes.remove(dictType.getDictId());
        return AjaxResult.success(dictTypes.put(dictType.getDictId(), dictType));
    }

    @ApiOperation("删除字典类型信息")
    @ApiImplicitParam(name = "dictId" , value = "字典主键" , required = true, dataType = "int" , paramType = "path")
    @DeleteMapping("/{dictId}")
    public AjaxResult delete(@PathVariable Integer dictId) {
        if (!dictTypes.isEmpty() && dictTypes.containsKey(dictId)) {
            dictTypes.remove(dictId);
            return success();
        } else {
            return error("此条数据字典不存在");
        }
    }


}


@ApiModel("字典类型实体")
class DictTypeEntity {


    @ApiModelProperty("字典主键")
    private Integer dictId;


    @ApiModelProperty("字典名称")
    private String dictName;


    @ApiModelProperty("字典类型")
    private String dictType;


    @ApiModelProperty("状态")
    private String status;

    public DictTypeEntity(Integer dictId, String dictName, String dictType, String status) {
        this.dictId = dictId;
        this.dictName = dictName;
        this.dictType = dictType;
        this.status = status;
    }

    public DictTypeEntity() {
    }

    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}