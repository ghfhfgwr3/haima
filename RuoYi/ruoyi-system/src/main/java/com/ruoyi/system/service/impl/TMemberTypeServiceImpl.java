package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysDept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TMemberTypeMapper;
import com.ruoyi.system.domain.TMemberType;
import com.ruoyi.system.service.ITMemberTypeService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;

/**
 * 会员类型 服务层实现
 *
 * @author ruoyi
 * @date 2019-06-03
 */
@Service
public class TMemberTypeServiceImpl implements ITMemberTypeService {
    @Autowired
    private TMemberTypeMapper tMemberTypeMapper;

    /**
     * 校验部门名称是否唯一
     *
     * @param dept 部门信息
     * @return 结果
     */
    @Override
    public String checkDeptNameUnique(TMemberType dept) {
        Long Companyid = StringUtils.isNull(dept.getId()) ? -1L : dept.getId();
        System.out.println("deptId******" + Companyid);
        TMemberType info = tMemberTypeMapper.checkDeptNameUnique(dept.getMemberTypeName(), dept.getCompanyid());
        System.out.println("info*********" + info);
        if (StringUtils.isNotNull(info) && info.getCompanyid().longValue() != Companyid.longValue()) {
            return UserConstants.DEPT_NAME_NOT_UNIQUE;
        }
        return UserConstants.DEPT_NAME_UNIQUE;
    }


    /**
     * 查询会员类型信息
     *
     * @param id 会员类型ID
     * @return 会员类型信息
     */
    @Override
    public TMemberType selectTMemberTypeById(Integer id) {


        return tMemberTypeMapper.selectTMemberTypeById(id);
    }

    /**
     * 查询会员类型信息
     *
     * @param companyid 会员类型ID
     * @return 会员类型信息
     */
    @Override
    public List<TMemberType> selectTMemberTypeByCompanyId(Integer companyid) {

        return tMemberTypeMapper.selectTMemberTypeByCompanyId(companyid);
    }

//		return tMemberTypeMapper.selectTMemberTypeById(id);
//	}

    /**
     * 查询会员类型列表
     *
     * @param tMemberType 会员类型信息
     * @return 会员类型集合
     */
    @Override
    @DataScope(tableAlias = "d")
    public List<TMemberType> selectTMemberTypeList(TMemberType tMemberType) {
        return tMemberTypeMapper.selectTMemberTypeList(tMemberType);
    }

    /**
     * 查询会员类型列表
     *
     * @param tMemberType 会员类型信息
     * @return 会员类型集合
     */
    @Override
    public List<TMemberType> selectTMemberTypeListAndMemberTypeName(TMemberType tMemberType) {
        return tMemberTypeMapper.selectTMemberTypeListAndMemberTypeName(tMemberType);
    }

    /**
     * 新增会员类型
     *
     * @param tMemberType 会员类型信息
     * @return 结果
     */
    @Override
    public int insertTMemberType(TMemberType tMemberType) {
        return tMemberTypeMapper.insertTMemberType(tMemberType);
    }

    /**
     * 修改会员类型
     *
     * @param tMemberType 会员类型信息
     * @return 结果
     */
    @Override
    public int updateTMemberType(TMemberType tMemberType) {
        return tMemberTypeMapper.updateTMemberType(tMemberType);
    }

    @Override
    public int updateTMemberTypeAndStatus(String isMemberPrice, String isPoints, String isRerurn, String isM1, String isEncourage, String isAllowother, String id) {
        return tMemberTypeMapper.updateTMemberTypeAndStatus(isMemberPrice, isPoints, isRerurn, isM1, isEncourage, isAllowother, id);
    }

    /**
     * 删除会员类型对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTMemberTypeByIds(String ids) {
        return tMemberTypeMapper.deleteTMemberTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 挂失
     *
     * @param tMemberType
     * @return 结果
     */

    @Override
    public int replaceTMemberType(TMemberType tMemberType) {

        return tMemberTypeMapper.updateTMemberType(tMemberType);
    }

    /**
     * 注销
     *
     * @param tMemberType
     * @return 结果
     */
    @Override
    public int cancelTMemberType(TMemberType tMemberType) {
        //System.out.println("11111111111111111111111111111");
/*

		List<TMemberType>  q = tMemberTypeMapper.selectTMemberTypeList(tMemberType);

		String a = null;
		for(TMemberType t : q){
			a = t.getDeep();
		}
		if(a.equals("0")){
			throw new BusinessException("不允许注销会员卡");
		}*/
        return tMemberTypeMapper.updateTMemberType(tMemberType);


    }


}
