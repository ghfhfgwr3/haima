package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ConsumeMapper;
import com.ruoyi.system.domain.Consume;
import com.ruoyi.system.service.IConsumeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 消费记录 服务层实现
 *
 * @author ruoyi
 * @date 2019-08-22
 */
@Service
public class ConsumeServiceImpl implements IConsumeService {
    @Autowired
    private ConsumeMapper consumeMapper;

    /**
     * 查询消费记录信息
     *
     * @param id 消费记录ID
     * @return 消费记录信息
     */
    @Override
    public Consume selectConsumeById(Integer id) {
        return consumeMapper.selectConsumeById(id);
    }

    /**
     * 查询消费记录列表
     *
     * @param consume 消费记录信息
     * @return 消费记录集合
     */
    @Override
    public List<Consume> selectConsumeList(Consume consume) {
        return consumeMapper.selectConsumeList(consume);
    }

    /**
     * 新增消费记录
     *
     * @param consume 消费记录信息
     * @return 结果
     */
    @Override
    public int insertConsume(Consume consume) {
        return consumeMapper.insertConsume(consume);
    }

    /**
     * 修改消费记录
     *
     * @param consume 消费记录信息
     * @return 结果
     */
    @Override
    public int updateConsume(Consume consume) {
        return consumeMapper.updateConsume(consume);
    }

    /**
     * 删除消费记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteConsumeByIds(String ids) {
        return consumeMapper.deleteConsumeByIds(Convert.toStrArray(ids));
    }

}
