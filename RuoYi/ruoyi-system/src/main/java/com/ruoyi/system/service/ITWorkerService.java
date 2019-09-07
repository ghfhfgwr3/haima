package com.ruoyi.system.service;

import com.ruoyi.system.domain.TMember;
import com.ruoyi.system.domain.TWorker;

import java.util.List;

/**
 * 员工 服务层
 *
 * @author ruoyi
 * @date 2019-06-03
 */
public interface ITWorkerService {
    /**
     * 查询员工信息
     *
     * @param id 员工ID
     * @return 员工信息
     */
    public TWorker selectTWorkerById(Long id);

    /**
     * 查询员工列表
     *
     * @param tWorker 员工信息
     * @return 员工集合
     */
    public List<TWorker> selectTWorkerList(TWorker tWorker);

    /**
     * 新增员工
     *
     * @param tWorker 员工信息
     * @return 结果
     */
    public int insertTWorker(TWorker tWorker);

    /**
     * 修改员工
     *
     * @param tWorker 员工信息
     * @return 结果
     */
    public int updateTWorker(TWorker tWorker);

    /**
     * 删除员工信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTWorkerByIds(String ids);

    /**
     * 员工离职状态
     *
     * @param tWorker 员工信息
     * @return 结果
     */
    public int changeIsLeave(TWorker tWorker);
}
