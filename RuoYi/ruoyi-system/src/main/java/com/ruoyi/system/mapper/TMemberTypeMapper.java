package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.TMemberType;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 会员类型 数据层
 *
 * @author ruoyi
 * @date 2019-06-03
 */
public interface TMemberTypeMapper {
    /**
     * 查询会员类型信息
     *
     * @param id 会员类型ID
     * @return 会员类型信息
     */
    public TMemberType selectTMemberTypeById(Integer id);

    /**
     * 查询会员类型信息
     *
     * @param companyid 会员类型ID
     * @return 会员类型信息
     */
    public List<TMemberType> selectTMemberTypeByCompanyId(Integer companyid);

    /**
     * 校验会员卡名称是否唯一
     *
     * @param memberTypeName 会员卡名称
     * @param companyid      父部门ID
     * @return 结果
     */
    public TMemberType checkDeptNameUnique(@Param("memberTypeName") String memberTypeName, @Param("companyid") Long companyid);

    /**
     * 查询会员类型列表
     *
     * @param tMemberType 会员类型信息
     * @return 会员类型集合
     */
    public List<TMemberType> selectTMemberTypeList(TMemberType tMemberType);

    /**
     * 查询会员卡类型列表
     *
     * @param tMemberType 会员类型信息
     * @return 会员类型集合
     */
    public List<TMemberType> selectTMemberTypeListAndMemberTypeName(TMemberType tMemberType);

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
     * 修改会员类型
     *
     * @param tMemberType 会员类型信息
     * @return 结果
     */
    public int updateTMemberTypeAndStatus(@Param("isMemberPrice") String isMemberPrice, @Param("isPoints") String isPoints, @Param("isRerurn") String isRerurn, @Param("isM1") String isM1, @Param("isEncourage") String isEncourage, @Param("isAllowother") String isAllowother, @Param("id") String id);

    /**
     * 删除会员类型
     *
     * @param id 会员类型ID
     * @return 结果
     */
    public int deleteTMemberTypeById(Integer id);

    /**
     * 批量删除会员类型
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTMemberTypeByIds(String[] ids);


}