package com.ruoyi.web.controller.tool;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * swagger 字典数据测试方法
 *
 * @author ruoyi
 */
@Api("字典数据信息管理")
@RestController
@RequestMapping("/test/dictData")
public class TestDictDataController extends BaseController {

    private final static Map<Integer, DictDataEntity> dictDatas = new LinkedHashMap<Integer, DictDataEntity>();

    {

        //Integer dictCode, Integer dictSort, String dictLabel, String dictValue, String dictType, String cssClass, String listClass, String isDefault, String status
        dictDatas.put(1, new DictDataEntity(1, 1, "男" , "0" , "sys_user_sex" , "0" , "" , " Y" , "0"));
        dictDatas.put(2, new DictDataEntity(2, 1, "男" , "0" , "sys_user_sex" , "0" , "" , " N" , "0"));

    }


    @ApiOperation("获取数据字典列表")
    @GetMapping("/list")
    public AjaxResult dictDataList() {
        List<DictDataEntity> dictDataList = new ArrayList<DictDataEntity>(dictDatas.values());
        return AjaxResult.success(dictDataList);
    }

    @ApiOperation("获取数据字典详细")
    @ApiImplicitParam(name = "dictCode" , value = "字典编码" , required = true, dataType = "int" , paramType = "path")
    @GetMapping("/{dictCode}")
    public AjaxResult getDictData(@PathVariable Integer dictCode) {
        if (!dictDatas.isEmpty() && dictDatas.containsKey(dictCode)) {
            return AjaxResult.success(dictDatas.get(dictCode));
        } else {
            return error("此条数据字典不存在");
        }
    }

    @ApiOperation("新增数据字典")
    @ApiImplicitParam(name = "dictDataEntity" , value = "新增数据字典信息" , dataType = "DictDataEntity")
    @PostMapping("/increaseDictData")
    public AjaxResult increaseDictData(DictDataEntity dictData) {
        if (StringUtils.isNull(dictData) || StringUtils.isNull(dictData.getDictCode())) {
            return error("字典编码不能为空");
        }
        return AjaxResult.success(dictDatas.put(dictData.getDictCode(), dictData));
    }

    @ApiOperation("更新数据字典")
    @ApiImplicitParam(name = "DictDataEntity" , value = "新增数据字典信息" , dataType = "DictDataEntity")
    @PutMapping("/updateDictData")
    public AjaxResult updateDictData(DictDataEntity dictData) {
        if (StringUtils.isNull(dictData) || StringUtils.isNull(dictData.getDictCode())) {
            return error("字典编码不能为空");
        }
        if (dictDatas.isEmpty() || !dictDatas.containsKey(dictData.getDictCode())) {
            return error("此条数据字典不存在");
        }
        dictDatas.remove(dictData.getDictCode());
        return AjaxResult.success(dictDatas.put(dictData.getDictCode(), dictData));
    }

    @ApiOperation("删除数据字典信息")
    @ApiImplicitParam(name = "dictCode" , value = "字典编码" , required = true, dataType = "int" , paramType = "path")
    @DeleteMapping("/{dictCode}")
    public AjaxResult deleteDictData(@PathVariable Integer dictCode) {
        if (!dictDatas.isEmpty() && dictDatas.containsKey(dictCode)) {
            dictDatas.remove(dictCode);
            return success();
        } else {
            return error("此条数据字典不存在");
        }
    }


}


class DictDataEntity {

    @ApiModelProperty("字典编码")
    private Integer dictCode;

    @ApiModelProperty("字典排序")
    private Integer dictSort;

    @ApiModelProperty("字典标签")
    private String dictLabel;

    @ApiModelProperty("字典键值")
    private String dictValue;

    @ApiModelProperty("字典类型")
    private String dictType;

    @ApiModelProperty("样式属性")
    private String cssClass;

    @ApiModelProperty("表格字典样式")
    private String listClass;

    @ApiModelProperty("是否默认")
    private String isDefault;

    @ApiModelProperty("状态")
    private String status;

    public DictDataEntity(Integer dictCode, Integer dictSort, String dictLabel, String dictValue, String dictType, String cssClass, String listClass, String isDefault, String status) {
        this.dictCode = dictCode;
        this.dictSort = dictSort;
        this.dictLabel = dictLabel;
        this.dictValue = dictValue;
        this.dictType = dictType;
        this.cssClass = cssClass;
        this.listClass = listClass;
        this.isDefault = isDefault;
        this.status = status;
    }

    public DictDataEntity() {
    }

    public Integer getDictCode() {
        return dictCode;
    }

    public void setDictCode(Integer dictCode) {
        this.dictCode = dictCode;
    }

    public Integer getDictSort() {
        return dictSort;
    }

    public void setDictSort(Integer dictSort) {
        this.dictSort = dictSort;
    }

    public String getDictLabel() {
        return dictLabel;
    }

    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getListClass() {
        return listClass;
    }

    public void setListClass(String listClass) {
        this.listClass = listClass;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}