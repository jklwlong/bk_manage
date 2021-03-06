package com.gr.bk.service.persistence.user;

import com.gr.bk.common.domain.UserDomain;

import java.util.List;

public interface UserDomainMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Thu Dec 07 14:40:22 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Thu Dec 07 14:40:22 CST 2017
     */
    int insert(UserDomain record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Thu Dec 07 14:40:22 CST 2017
     */
    int insertSelective(UserDomain record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Thu Dec 07 14:40:22 CST 2017
     */
    UserDomain selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Thu Dec 07 14:40:22 CST 2017
     */
    int updateByPrimaryKeySelective(UserDomain record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Thu Dec 07 14:40:22 CST 2017
     */
    int updateByPrimaryKey(UserDomain record);
	
	List<UserDomain> queryAll();

    UserDomain findUserByUserName(String username);
}