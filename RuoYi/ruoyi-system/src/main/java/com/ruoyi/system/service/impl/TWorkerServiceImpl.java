package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.system.domain.TMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TWorkerMapper;
import com.ruoyi.system.domain.TWorker;
import com.ruoyi.system.service.ITWorkerService;
import com.ruoyi.common.core.text.Convert;

/**
 * 员工 服务层实现
 *
 * @author ruoyi
 * @date 2019-06-03
 */
@Service
public class TWorkerServiceImpl implements ITWorkerService {
    @Autowired
    private TWorkerMapper tWorkerMapper;

    /**
     * 查询员工信息
     *
     * @param id 员工ID
     * @return 员工信息
     */
    @Override
    public TWorker selectTWorkerById(Long id) {
        return tWorkerMapper.selectTWorkerById(id);
    }

    /**
     * 查询员工列表
     *
     * @param tWorker 员工信息
     * @return 员工集合
     */
    @Override
    @DataScope(tableAlias = "d")
    public List<TWorker> selectTWorkerList(TWorker tWorker) {
        return tWorkerMapper.selectTWorkerList(tWorker);
    }

    /**
     * 新增员工
     *
     * @param tWorker 员工信息
     * @return 结果
     */
    @Override
    public int insertTWorker(TWorker tWorker) {
        return tWorkerMapper.insertTWorker(tWorker);
    }

    /**
     * 修改员工
     *
     * @param tWorker 员工信息
     * @return 结果
     */
    @Override
    public int updateTWorker(TWorker tWorker) {
        return tWorkerMapper.updateTWorker(tWorker);
    }

    /**
     * 删除员工对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTWorkerByIds(String ids) {
        return tWorkerMapper.deleteTWorkerByIds(Convert.toStrArray(ids));
    }

    /**
     * 员工离职状态状态修改
     *
     * @param TWorker tWorker 会员信息
     * @return 结果
     */
    @Override
    public int changeIsLeave(TWorker tWorker) {

        return tWorkerMapper.updateTWorker(tWorker);
    }
}
