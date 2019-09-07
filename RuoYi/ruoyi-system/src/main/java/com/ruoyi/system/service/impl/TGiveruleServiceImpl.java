package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TGiveruleMapper;
import com.ruoyi.system.domain.TGiverule;
import com.ruoyi.system.service.ITGiveruleService;
import com.ruoyi.common.core.text.Convert;

/**
 * 奖励规则 服务层实现
 *
 * @author ruoyi
 * @date 2019-07-12
 */
@Service
public class TGiveruleServiceImpl implements ITGiveruleService {
    @Autowired
    private TGiveruleMapper tGiveruleMapper;

    /**
     * 查询奖励规则信息
     *
     * @param id 奖励规则ID
     * @return 奖励规则信息
     */
    @Override
    public TGiverule selectTGiveruleById(Integer id) {
        return tGiveruleMapper.selectTGiveruleById(id);
    }

    @Override
//	public TGiverule selectTGiveruleByCompanyidAndCardType(Integer companyid, Integer cardtype)
//	{
//		return tGiveruleMapper.selectTGiveruleByCompanyidAndCardType(companyid,cardtype);
//	}
    public List<TGiverule> selectTGiveruleByCompanyidAndCardType(Integer companyid, Integer cardtype) {
        return tGiveruleMapper.selectTGiveruleByCompanyidAndCardType(companyid, cardtype);
    }

    /**
     * 查询奖励规则列表
     *
     * @param tGiverule 奖励规则信息
     * @return 奖励规则集合
     */
    @Override
    public List<TGiverule> selectTGiveruleList(TGiverule tGiverule) {
        return tGiveruleMapper.selectTGiveruleList(tGiverule);
    }

    /**
     * 新增奖励规则
     *
     * @param tGiverule 奖励规则信息
     * @return 结果
     */
    @Override
    public int insertTGiverule(TGiverule tGiverule) {
        return tGiveruleMapper.insertTGiverule(tGiverule);
    }

    /**
     * 修改奖励规则
     *
     * @param tGiverule 奖励规则信息
     * @return 结果
     */
    @Override
    public int updateTGiverule(TGiverule tGiverule) {
        return tGiveruleMapper.updateTGiverule(tGiverule);
    }

    /**
     * 删除奖励规则对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTGiveruleByIds(String ids) {
        return tGiveruleMapper.deleteTGiveruleByIds(Convert.toStrArray(ids));
    }

}
