package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TConsumerMachineMapper;
import com.ruoyi.system.domain.TConsumerMachine;
import com.ruoyi.system.service.ITConsumerMachineService;
import com.ruoyi.common.core.text.Convert;

/**
 * 消费机 服务层实现
 * 
 * @author ruoyi
 * @date 2019-09-04
 */
@Service
public class TConsumerMachineServiceImpl implements ITConsumerMachineService 
{
	@Autowired
	private TConsumerMachineMapper tConsumerMachineMapper;

	/**
     * 查询消费机信息
     * 
     * @param id 消费机ID
     * @return 消费机信息
     */
    @Override
	public TConsumerMachine selectTConsumerMachineById(Integer id)
	{
	    return tConsumerMachineMapper.selectTConsumerMachineById(id);
	}
	
	/**
     * 查询消费机列表
     * 
     * @param tConsumerMachine 消费机信息
     * @return 消费机集合
     */
	@Override
	public List<TConsumerMachine> selectTConsumerMachineList(TConsumerMachine tConsumerMachine)
	{
	    return tConsumerMachineMapper.selectTConsumerMachineList(tConsumerMachine);
	}
	
    /**
     * 新增消费机
     * 
     * @param tConsumerMachine 消费机信息
     * @return 结果
     */
	@Override
	public int insertTConsumerMachine(TConsumerMachine tConsumerMachine)
	{
	    return tConsumerMachineMapper.insertTConsumerMachine(tConsumerMachine);
	}
	
	/**
     * 修改消费机
     * 
     * @param tConsumerMachine 消费机信息
     * @return 结果
     */
	@Override
	public int updateTConsumerMachine(TConsumerMachine tConsumerMachine)
	{
	    return tConsumerMachineMapper.updateTConsumerMachine(tConsumerMachine);
	}

	/**
     * 删除消费机对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTConsumerMachineByIds(String ids)
	{
		return tConsumerMachineMapper.deleteTConsumerMachineByIds(Convert.toStrArray(ids));
	}

	@Override
	public TConsumerMachine selectTConsumerMachineByMachineId(String devId) {
		return tConsumerMachineMapper.selectTConsumerMachineByMachineId(devId);
	}

}
