package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TMemberConsumeMapper;
import com.ruoyi.system.domain.TMemberConsume;
import com.ruoyi.system.service.ITMemberConsumeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 会员消费 服务层实现
 *
 * @author ruoyi
 * @date 2019-07-02
 */
@Service
public class TMemberConsumeServiceImpl implements ITMemberConsumeService {
    @Autowired
    private TMemberConsumeMapper tMemberConsumeMapper;

    /**
     * 查询会员消费信息
     *
     * @param id 会员消费ID
     * @return 会员消费信息
     */
    @Override
    public TMemberConsume selectTMemberConsumeById(Long id) {
        return tMemberConsumeMapper.selectTMemberConsumeById(id);
    }

    /**
     * 查询会员消费列表
     *
     * @param tMemberConsume 会员消费信息
     * @return 会员消费集合
     */
    @Override
    @DataScope(tableAlias = "d")
    public List<TMemberConsume> selectTMemberConsumeList(TMemberConsume tMemberConsume) {
        return tMemberConsumeMapper.selectTMemberConsumeList(tMemberConsume);
    }

    /**
     * 新增会员消费
     *
     * @param tMemberConsume 会员消费信息
     * @return 结果
     */
    @Override
    public int insertTMemberConsume(TMemberConsume tMemberConsume) {
        return tMemberConsumeMapper.insertTMemberConsume(tMemberConsume);
    }

    /**
     * 修改会员消费
     *
     * @param tMemberConsume 会员消费信息
     * @return 结果
     */
    @Override
    public int updateTMemberConsume(TMemberConsume tMemberConsume) {
        return tMemberConsumeMapper.updateTMemberConsume(tMemberConsume);
    }

    /**
     * 删除会员消费对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTMemberConsumeByIds(String ids) {
        return tMemberConsumeMapper.deleteTMemberConsumeByIds(Convert.toStrArray(ids));
    }

}
