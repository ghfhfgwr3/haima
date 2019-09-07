package com.ruoyi.system.service;

import com.ruoyi.system.domain.TPrezent;

import java.util.List;

/**
 * 积分兑换 服务层
 *
 * @author ruoyi
 * @date 2019-07-05
 */
public interface ITPrezentService {
    /**
     * 查询积分兑换信息
     *
     * @param id 积分兑换ID
     * @return 积分兑换信息
     */
    public TPrezent selectTPrezentById(Long id);

    /**
     * 查询积分兑换列表
     *
     * @param tPrezent 积分兑换信息
     * @return 积分兑换集合
     */
    public List<TPrezent> selectTPrezentList(TPrezent tPrezent);

    /**
     * 新增积分兑换
     *
     * @param tPrezent 积分兑换信息
     * @return 结果
     */
    public int insertTPrezent(TPrezent tPrezent);

    /**
     * 修改积分兑换
     *
     * @param tPrezent 积分兑换信息
     * @return 结果
     */
    public int updateTPrezent(TPrezent tPrezent);

    /**
     * 删除积分兑换信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTPrezentByIds(String ids);

    /**
     * 奖品兑换状态的修改
     *
     * @param tPrezent 奖品信息
     * @return 结果
     */
    public int changeState(TPrezent tPrezent);

    /**
     * 会员卡是否存在
     *
     * @param tPrezent 会员卡号
     * @return 结果
     */
    public String checkBhUnique(TPrezent tPrezent);
}
