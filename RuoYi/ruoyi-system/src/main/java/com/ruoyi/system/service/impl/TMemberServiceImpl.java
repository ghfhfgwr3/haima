package com.ruoyi.system.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.TMemberType;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TMemberMapper;
import com.ruoyi.system.domain.TMember;
import com.ruoyi.system.service.ITMemberService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 会员 服务层实现
 *
 * @author ruoyi
 * @date 2019-06-03
 */
@Service
public class TMemberServiceImpl implements ITMemberService {
    @Autowired
    private TMemberMapper tMemberMapper;

    /**
     * 校验部门名称是否唯一
     *
     * @param dept 部门信息
     * @return 结果
     */
    @Override
    public String checkDeptNameUnique(TMember dept) {
        TMember info = tMemberMapper.checkDeptNameUnique(Long.valueOf(dept.getMemberNo()), dept.getCompanyid());
        System.out.println("info *********************");
        System.out.println("info *********************");
        System.out.println("info *********************" + info);
        if (StringUtils.isNotNull(info) && info.getIsloss().longValue() == 0) {
            return UserConstants.DEPT_NAME_NOT_UNIQUE;
        }
        return UserConstants.DEPT_NAME_UNIQUE;
    }


    /**
     * 查询会员信息
     *
     * @param id 会员ID
     * @return 会员信息
     */
    @Override
    public TMember selectTMemberById(Long memberNo) {
        return tMemberMapper.selectTMemberById(memberNo);
    }

    /**
     * 查询会员列表
     *
     * @param tMember 会员信息
     * @return 会员集合
     */
    @Override
    @DataScope(tableAlias = "d")
    public List<TMember> selectTMemberList(TMember tMember) {
        return tMemberMapper.selectTMemberList(tMember);
    }

    /**
     * 根据会员卡号或手机号查询信息
     *
     * @param memberNo     会员卡号
     * @param mobilephones 会员手机号
     * @return 会员集合
     */
    @Override
    public TMember selectMemberNoAndPhone(String memberNo, String mobilephones) {
        return tMemberMapper.selectMemberNoAndPhone(memberNo, mobilephones);
    }

    /**
     * 根据会员卡号或手机号查询信息
     *
     * @param memberNo     会员卡号
     * @param mobilephones 会员手机号
     * @return 会员集合
     */
    @Override
    public TMember selectByMemberNoAndPhone(String memberNo, String mobilephones) {
        return tMemberMapper.selectByMemberNoAndPhone(memberNo, mobilephones);
    }

    /**
     * 会员充值
     *
     * @param memberNo     会员卡号
     * @param mobilephones 会员手机号
     * @return 影响条数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateTMemberNoAndPhone(String memberNo, String mobilephones, @Param("balance") String balance, @Param("points") String points, @Param("money") String money, @Param("complimentaryMoney") String complimentaryMoney) throws Exception {
        int i = 0;
        try {
            i = tMemberMapper.updateTMemberNoAndPhone(memberNo, mobilephones, balance, points, money, complimentaryMoney);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 新增会员
     *
     * @param tMember 会员信息
     * @return 结果
     */
    @Override
    public int insertTMember(TMember tMember) {
        return tMemberMapper.insertTMember(tMember);
    }

    /**
     * 修改会员
     *
     * @param tMember 会员信息
     * @return 结果
     */
    @Override
    public int updateTMember(TMember tMember) {
        return tMemberMapper.updateTMember(tMember);
    }

    /**
     * 修改会员
     *
     * @param tMember 会员信息
     * @return 结果
     */
    @Override
    public int updateTMemberByMemberNo(TMember tMember) {
        return tMemberMapper.updateTMemberByMemberNo(tMember);
    }

    /**
     * 删除会员对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTMemberByIds(String ids) {
        return tMemberMapper.deleteTMemberByIds(Convert.toStrArray(ids));
    }

    /**
     * 会员挂失状态修改
     *
     * @param tMember 会员信息
     * @return 结果
     */
    @Override
    public int changeLossStatus(TMember tMember) {
//		if (SysUser.isAdmin(tMember.getId()))
//		{
//			throw new BusinessException("不允许修改超级管理员用户");
//		}
        return tMemberMapper.updateTMember(tMember);
    }

    /**
     * 会员挂失状态修改
     *
     * @param tMember 会员信息
     * @return 结果
     */
    @Override
    public int changeState(TMember tMember) {
//	if (TMember.isLoss(tMember.getId()))
//		{
//			throw new BusinessException("不允许修改超级管理员用户");
//		}
        return tMemberMapper.updateTMember(tMember);
    }

    /**
     * 校验卡号是否唯一
     *
     * @param memberNo 卡号
     * @return
     */
    @Override
    public String checkCardNoUnique(TMember tMember) {
        int count = tMemberMapper.checkCardNoUnique(tMember);
        if (count > 0) {
            return UserConstants.USER_NAME_NOT_UNIQUE;
        }
        return UserConstants.USER_NAME_UNIQUE;
    }

    /**
     * 校验手机号是否唯一
     *
     * @param memberNo 卡号
     * @return
     */
    @Override
    public String checkPhoneUnique(TMember tMember) {
        int count = tMemberMapper.checkPhoneUnique(tMember);
        if (count > 0) {
            return UserConstants.USER_NAME_NOT_UNIQUE;
        }
        return UserConstants.USER_NAME_UNIQUE;
    }

    /**
     * 校验卡号是否唯一
     *
     * @param memberNo 卡号
     * @return
     */
    @Override
    public String checkCardCount(TMember tMember) {
        int count = tMemberMapper.checkCardCount(tMember);
        if (count > 0) {
            return UserConstants.USER_NAME_NOT_UNIQUE;
        }
        return UserConstants.USER_NAME_UNIQUE;
    }


}
