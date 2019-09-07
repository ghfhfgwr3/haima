package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.TPrezent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 积分兑换 数据层
 *
 * @author ruoyi
 * @date 2019-07-05
 */
public interface TPrezentMapper {
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
     * 删除积分兑换
     *
     * @param id 积分兑换ID
     * @return 结果
     */
    public int deleteTPrezentById(Long id);

    /**
     * 批量删除积分兑换
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTPrezentByIds(String[] ids);

    /**
     * 校验礼品编号的唯一性
     *
     * @param tPrezent 礼品
     * @return 结果
     */
    public int checkBhUnique(TPrezent tPrezent);

}