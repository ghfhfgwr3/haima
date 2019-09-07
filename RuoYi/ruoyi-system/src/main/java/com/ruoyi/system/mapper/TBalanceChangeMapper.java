package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.TBalanceChange;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 会员余额的增加和减少 数据层
 *
 * @author ruoyi
 * @date 2019-06-03
 */
public interface TBalanceChangeMapper {
    /**
     * 查询会员余额的增加和减少信息
     *
     * @param id 会员余额的增加和减少ID
     * @return 会员余额的增加和减少信息
     */
    public TBalanceChange selectTBalanceChangeById(Long id);

    /**
     * 查询会员余额的增加和减少列表
     *
     * @param tBalanceChange 会员余额的增加和减少信息
     * @return 会员余额的增加和减少集合
     */
    public List<TBalanceChange> selectTBalanceChangeList(TBalanceChange tBalanceChange);

    /**
     * 新增会员余额的增加和减少
     *
     * @param tBalanceChange 会员余额的增加和减少信息
     * @return 结果
     */
    public int insertTBalanceChange(TBalanceChange tBalanceChange);

    /**
     * 修改会员余额的增加和减少
     *
     * @param tBalanceChange 会员余额的增加和减少信息
     * @return 结果
     */
    public int updateTBalanceChange(TBalanceChange tBalanceChange);

    /**
     * 补卡之后修改所有关于此卡的信息
     */
    public int updateTBalanceChangeByMemberNo(@Param("memberNoTwo") String memberNoTwo, @Param("memberNoOne") String memberNoOne);

    /**
     * 删除会员余额的增加和减少
     *
     * @param id 会员余额的增加和减少ID
     * @return 结果
     */
    public int deleteTBalanceChangeById(Long id);

    /**
     * 批量删除会员余额的增加和减少
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTBalanceChangeByIds(String[] ids);

}