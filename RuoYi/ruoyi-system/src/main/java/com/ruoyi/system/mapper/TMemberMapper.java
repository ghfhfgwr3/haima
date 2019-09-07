package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.TMember;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 会员 数据层
 *
 * @author ruoyi
 * @date 2019-06-03
 */
public interface TMemberMapper {
    /**
     * 校验会员卡名称是否唯一
     *
     * @param id
     * @return 结果
     */
    public TMember checkDeptNameUnique(@Param("memberNo") Long memberNo, @Param("companyid") Long companyid);

    /**
     * 查询会员信息
     *
     * @param id 会员ID
     * @return 会员信息
     */
    public TMember selectTMemberById(Long memberNo);

    /**
     * 查询会员列表
     *
     * @param tMember 会员信息
     * @return 会员集合
     */
    public List<TMember> selectTMemberList(TMember tMember);

    /**
     * 查询会员列表
     *
     * @param memberNo 会员信息
     * @return 会员集合
     */
    public TMember selectMemberNoAndPhone(@Param("memberNo") String memberNo, @Param("mobilephones") String mobilephones);

    /**
     * 查询会员列表
     *
     * @param memberNo 会员信息
     * @return 会员集合
     */
    public TMember selectByMemberNoAndPhone(@Param("memberNo") String memberNo, @Param("mobilephones") String mobilephones);

    /**
     * 新增会员
     *
     * @param tMember 会员信息
     * @return 结果
     */
    public int insertTMember(TMember tMember);

    /**
     * 修改会员
     *
     * @param tMember 会员信息
     * @return 结果
     */
    public int updateTMember(TMember tMember);

    /**
     * 修改会员
     *
     * @param tMember 会员信息
     * @return 结果
     */
    public int updateTMemberByMemberNo(TMember tMember);

    /**
     * 充值
     */
    public int updateTMemberNoAndPhone(@Param("memberNo") String memberNo, @Param("mobilephones") String mobilephones, @Param("balance") String balance, @Param("points") String points, @Param("money") String money, @Param("complimentaryMoney") String complimentaryMoney);

    /**
     * 删除会员
     *
     * @param id 会员ID
     * @return 结果
     */
    public int deleteTMemberById(Long id);

    /**
     * 批量删除会员
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTMemberByIds(String[] ids);

    /**
     * 校验卡号是否唯一
     *
     * @param memberNo 卡号名称
     * @return 结果
     */
    public int checkCardNoUnique(TMember tMember);

    /**
     * 校验手机号是否唯一
     *
     * @param
     * @return 结果
     */
    public int checkPhoneUnique(TMember tMember);

    /**
     * 校验卡号是否唯一
     *
     * @param memberNo 卡号名称
     * @return 结果
     */
    public int checkCardCount(TMember tMember);
}