package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.TWorker;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 员工 数据层
 *
 * @author ruoyi
 * @date 2019-06-03
 */
public interface TWorkerMapper {
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
     * 删除员工
     *
     * @param id 员工ID
     * @return 结果
     */
    public int deleteTWorkerById(Long id);

    /**
     * 批量删除员工
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTWorkerByIds(String[] ids);

}