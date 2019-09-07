package com.ruoyi.web.controller.tool;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TestConfigController extends BaseController {


    private final static Map<Integer, ConfigEntity> configs = new LinkedHashMap<Integer, ConfigEntity>();

    {
        configs.put(1, new ConfigEntity(1, "主框架页-默认皮肤样式名称" , "sys.index.skinName" , "skin-blue" , "Y"));
        configs.put(2, new ConfigEntity(2, "用户管理-账号初始密码" , "sys.user.initPassword" , "123456" , "Y"));

    }

    @ApiOperation("获取参数配置列表")
    @GetMapping("/list")
    public AjaxResult configList() {
        List<ConfigEntity> configList = new ArrayList<ConfigEntity>(configs.values());
        return AjaxResult.success(configList);
    }

    @ApiOperation("获取参数配置详细")
    @ApiImplicitParam(name = "configId" , value = "参数主键" , required = true, dataType = "int" , paramType = "path")
    @GetMapping("/{configId}")
    public AjaxResult getConfig(@PathVariable Integer configId) {
        if (!configs.isEmpty() && configs.containsKey(configId)) {
            return AjaxResult.success(configs.get(configId));
        } else {
            return error("此配置不存在");
        }
    }

    @ApiOperation("新增参数配置")
    @ApiImplicitParam(name = "configEntity" , value = "新增参数配置信息" , dataType = "ConfigEntity")
    @PostMapping("/increaseConfig")
    public AjaxResult increaseConfig(ConfigEntity config) {
        if (StringUtils.isNull(config) || StringUtils.isNull(config.getConfigId())) {
            return error("参数主键ID不能为空");
        }
        return AjaxResult.success(configs.put(config.getConfigId(), config));
    }

    @ApiOperation("更新参数配置")
    @ApiImplicitParam(name = "configEntity" , value = "新增参数配置信息" , dataType = "ConfigEntity")
    @PutMapping("/updateConfig")
    public AjaxResult updateConfig(ConfigEntity config) {
        if (StringUtils.isNull(config) || StringUtils.isNull(config.getConfigId())) {
            return error("参数主键ID不能为空");
        }
        if (configs.isEmpty() || !configs.containsKey(config.getConfigId())) {
            return error("此参数不存在");
        }
        configs.remove(config.getConfigId());
        return AjaxResult.success(configs.put(config.getConfigId(), config));
    }


    @ApiOperation("删除参数配置信息")
    @ApiImplicitParam(name = "configId" , value = "参数主键" , required = true, dataType = "int" , paramType = "path")
    @DeleteMapping("/{configId}")
    public AjaxResult delete(@PathVariable Integer configId) {
        if (!configs.isEmpty() && configs.containsKey(configId)) {
            configs.remove(configId);
            return success();
        } else {
            return error("此参数配置不存在");
        }
    }

}


@ApiModel("配置实体")
class ConfigEntity {

    @ApiModelProperty("参数主键")
    private Integer configId;

    @ApiModelProperty("参数名称")
    private String configName;

    @ApiModelProperty("参数键名")
    private String configKey;

    @ApiModelProperty("参数键值")
    private String configValue;

    @ApiModelProperty("系统内置")
    private String configType;

    public ConfigEntity(Integer configId, String configName, String configKey, String configValue, String configType) {
        this.configId = configId;
        this.configName = configName;
        this.configKey = configKey;
        this.configValue = configValue;
        this.configType = configType;
    }

    public ConfigEntity() {
    }

    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public String getConfigType() {
        return configType;
    }

    public void setConfigType(String configType) {
        this.configType = configType;
    }
}