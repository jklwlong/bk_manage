package com.gr.bk.service.persistence.role;

import com.gr.bk.common.domain.RoleDomain;
import com.gr.bk.common.domain.TestDto;

import java.util.List;
import java.util.Set;

public interface RoleDomainMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbggenerated Thu Dec 07 14:11:58 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbggenerated Thu Dec 07 14:11:58 CST 2017
     */
    int insert(RoleDomain record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbggenerated Thu Dec 07 14:11:58 CST 2017
     */
    int insertSelective(RoleDomain record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbggenerated Thu Dec 07 14:11:58 CST 2017
     */
    RoleDomain selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbggenerated Thu Dec 07 14:11:58 CST 2017
     */
    int updateByPrimaryKeySelective(RoleDomain record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbggenerated Thu Dec 07 14:11:58 CST 2017
     */
    int updateByPrimaryKey(RoleDomain record);

    Set<String> queryRoleByUser(String userUuid);

    List<? extends RoleDomain> queryAll();
}