package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TCardReplacementMapper;
import com.ruoyi.system.domain.TCardReplacement;
import com.ruoyi.system.service.ITCardReplacementService;
import com.ruoyi.common.core.text.Convert;

/**
 * 补卡记录 服务层实现
 *
 * @author ruoyi
 * @date 2019-06-03
 */
@Service
public class TCardReplacementServiceImpl implements ITCardReplacementService {
    @Autowired

    private TCardReplacementMapper tCardReplacementMapper;

    /**
     * 查询补卡记录信息
     *
     * @param id 补卡记录ID
     * @return 补卡记录信息
     */
    @Override
    @DataScope(tableAlias = "d")
    public TCardReplacement selectTCardReplacementById(Integer id) {
        return tCardReplacementMapper.selectTCardReplacementById(id);
    }

    /**
     * 查询补卡记录列表
     *
     * @param tCardReplacement 补卡记录信息
     * @return 补卡记录集合
     */
    @Override
    @DataScope(tableAlias = "d")
    public List<TCardReplacement> selectTCardReplacementList(TCardReplacement tCardReplacement) {
        return tCardReplacementMapper.selectTCardReplacementList(tCardReplacement);
    }

    /**
     * 新增补卡记录
     *
     * @param tCardReplacement 补卡记录信息
     * @return 结果
     */
    @Override
    @DataScope(tableAlias = "d")
    public int insertTCardReplacement(TCardReplacement tCardReplacement) {
        return tCardReplacementMapper.insertTCardReplacement(tCardReplacement);
    }

    /**
     * 修改补卡记录
     *
     * @param tCardReplacement 补卡记录信息
     * @return 结果
     */
    @Override
    @DataScope(tableAlias = "d")
    public int updateTCardReplacement(TCardReplacement tCardReplacement) {
        return tCardReplacementMapper.updateTCardReplacement(tCardReplacement);
    }

    /**
     * 删除补卡记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @DataScope(tableAlias = "d")
    public int deleteTCardReplacementByIds(String ids) {
        return tCardReplacementMapper.deleteTCardReplacementByIds(Convert.toStrArray(ids));
    }

}
