package com.ruoyi.system.service;

import com.ruoyi.system.domain.TMember;
import com.ruoyi.system.domain.TMemberType;

import java.util.List;

/**
 * 会员类型 服务层
 *
 * @author ruoyi
 * @date 2019-06-03
 */
public interface ITMemberTypeService {
    /**
     * 查询会员类型信息
     *
     * @param id 会员类型ID
     * @return 会员类型信息
     */
    public TMemberType selectTMemberTypeById(Integer id);

    /**
     * 查询会员类型列表
     *
     * @param tMemberType 会员类型信息
     * @return 会员类型集合
     */
    public List<TMemberType> selectTMemberTypeList(TMemberType tMemberType);

    /**
     * 新增会员类型
     *
     * @param tMemberType 会员类型信息
     * @return 结果
     */
    public int insertTMemberType(TMemberType tMemberType);

    /**
     * 修改会员类型
     *
     * @param tMemberType 会员类型信息
     * @return 结果
     */
    public int updateTMemberType(TMemberType tMemberType);

    /**
     * 删除会员类型信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTMemberTypeByIds(String ids);


    /**
     * 挂失
     *
     * @param 会员类型信息
     * @return 结果
     */
    public int replaceTMemberType(TMemberType tMemberType);

    /**
     * 注销
     *
     * @param 会员类型信息
     * @return 结果
     */
    public int cancelTMemberType(TMemberType tMemberType);

    public int updateTMemberTypeAndStatus(String isMemberPrice, String isPoints, String isRerurn, String isM1, String isEncourage, String isAllowother, String id);

    public List<TMemberType> selectTMemberTypeListAndMemberTypeName(TMemberType tMemberType);

    /**
     * 查询会员类型信息
     *
     * @param companyid 公司ID
     * @return 会员类型信息
     */
    public List<TMemberType> selectTMemberTypeByCompanyId(Integer companyid);

    /**
     * 校验部门名称是否唯一
     *
     * @param tMemberType 部门信息
     * @return 结果
     */
    public String checkDeptNameUnique(TMemberType tMemberType);
}
