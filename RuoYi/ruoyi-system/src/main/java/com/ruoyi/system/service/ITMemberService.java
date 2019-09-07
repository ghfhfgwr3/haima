package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.TMember;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * 会员 服务层
 *
 * @author ruoyi
 * @date 2019-06-03
 */
@Transactional
public interface ITMemberService {
    /**
     * 校验会员卡名称是否唯一
     *
     * @param id
     * @return 结果
     */
    public String checkDeptNameUnique(TMember dept);

    /**
     * 查询会员信息
     *
     * @return 会员信息
     * @param会员 ID
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
     * 查询会员
     *
     * @return 会员
     */
    public TMember selectMemberNoAndPhone(@Param("memberNo") String memberNo, @Param("mobilephones") String mobilephones);

    /**
     * 查询会员列表
     *
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
     * 充值、退款 消费
     */
    public int updateTMemberNoAndPhone(@Param("memberNo") String memberNo, @Param("mobilephones") String mobilephones, @Param("balance") String balance, @Param("points") String points, @Param("money") String money, @Param("complimentaryMoney") String complimentaryMoney) throws Exception;

    /**
     * 删除会员信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTMemberByIds(String ids);

    /**
     * 会员挂失状态修改
     *
     * @param tMember 会员信息
     * @return 结果
     */
    public int changeLossStatus(TMember tMember);

    /**
     * 会员挂注销态修改
     *
     * @param tMember 会员信息
     * @return 结果
     */
    public int changeState(TMember tMember);

    /**
     * 会员卡号的唯一性
     *
     * @param
     * @return 结果
     */
    public String checkCardNoUnique(TMember tMember);

    /**
     * 会员手机号的唯一性
     *
     * @param
     * @return 结果
     */
    public String checkPhoneUnique(TMember tMember);

    /**
     * 会员卡是否存在
     *
     * @param memberNo 会员卡号
     * @return 结果
     */
    public String checkCardCount(TMember tMember);

}
