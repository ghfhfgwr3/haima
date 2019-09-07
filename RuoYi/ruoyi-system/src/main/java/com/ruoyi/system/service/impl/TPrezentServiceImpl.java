package com.ruoyi.system.service.impl;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.TPrezent;
import com.ruoyi.system.mapper.TPrezentMapper;
import com.ruoyi.system.service.ITPrezentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 积分兑换 服务层实现
 *
 * @author ruoyi
 * @date 2019-07-05
 */
@Service
public class TPrezentServiceImpl implements ITPrezentService {
    @Autowired
    private TPrezentMapper tPrezentMapper;

    /**
     * 查询积分兑换信息
     *
     * @param id 积分兑换ID
     * @return 积分兑换信息
     */
    @Override
    public TPrezent selectTPrezentById(Long id) {
        return tPrezentMapper.selectTPrezentById(id);
    }

    /**
     * 查询积分兑换列表
     *
     * @param tPrezent 积分兑换信息
     * @return 积分兑换集合
     */
    @Override
    @DataScope(tableAlias = "d")
    public List<TPrezent> selectTPrezentList(TPrezent tPrezent) {
        return tPrezentMapper.selectTPrezentList(tPrezent);
    }

    /**
     * 新增积分兑换
     *
     * @param tPrezent 积分兑换信息
     * @return 结果
     */
    @Override
    public int insertTPrezent(TPrezent tPrezent) {
        return tPrezentMapper.insertTPrezent(tPrezent);
    }

    /**
     * 修改积分兑换
     *
     * @param tPrezent 积分兑换信息
     * @return 结果
     */
    @Override
    public int updateTPrezent(TPrezent tPrezent) {
        return tPrezentMapper.updateTPrezent(tPrezent);
    }

    /**
     * 删除积分兑换对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTPrezentByIds(String ids) {
        return tPrezentMapper.deleteTPrezentByIds(Convert.toStrArray(ids));
    }

    /**
     * 奖品兑换状态的修改
     *
     * @param tPrezent 会员信息
     * @return 结果
     */
    @Override
    public int changeState(TPrezent tPrezent) {

        return tPrezentMapper.updateTPrezent(tPrezent);
    }

    /**
     * 校验礼品编号的唯一性
     *
     * @param memberNo 卡号
     * @return
     */
    @Override
    public String checkBhUnique(TPrezent tPrezent) {
        int count = tPrezentMapper.checkBhUnique(tPrezent);
        if (count > 0) {
            return UserConstants.USER_NAME_NOT_UNIQUE;
        }
        return UserConstants.USER_NAME_UNIQUE;
    }
}
