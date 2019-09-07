package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.TMemberConsume;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 会员消费 数据层
 *
 * @author ruoyi
 * @date 2019-07-02
 */
public interface TMemberConsumeMapper {
    /**
     * 查询会员消费信息
     *
     * @param id 会员消费ID
     * @return 会员消费信息
     */
    public TMemberConsume selectTMemberConsumeById(Long id);

    /**
     * 查询会员消费列表
     *
     * @param tMemberConsume 会员消费信息
     * @return 会员消费集合
     */
    public List<TMemberConsume> selectTMemberConsumeList(TMemberConsume tMemberConsume);

    /**
     * 新增会员消费
     *
     * @param tMemberConsume 会员消费信息
     * @return 结果
     */
    public int insertTMemberConsume(TMemberConsume tMemberConsume);

    /**
     * 修改会员消费
     *
     * @param tMemberConsume 会员消费信息
     * @return 结果
     */
    public int updateTMemberConsume(TMemberConsume tMemberConsume);

    /**
     * 删除会员消费
     *
     * @param id 会员消费ID
     * @return 结果
     */
    public int deleteTMemberConsumeById(Long id);

    /**
     * 批量删除会员消费
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTMemberConsumeByIds(String[] ids);

}