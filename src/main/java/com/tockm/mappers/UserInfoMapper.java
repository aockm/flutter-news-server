package com.tockm.mappers;

import org.apache.ibatis.annotations.Param;

/**
 *@Description: Mapper
 *@date: 2025/05/25
 */
public interface UserInfoMapper<T,P> extends BaseMapper {

	/**
	 * 根据UserId查询
	 */
	T selectByUserId(@Param("userId") Integer userId);

	/**
	 * 根据UserId更新
	 */
	Integer updateByUserId(@Param("bean") T t, @Param("userId") Integer userId);

	/**
	 * 根据UserId删除
	 */
	Integer deleteByUserId(@Param("userId") Integer userId);

	/**
	 * 根据email查询
	 */
	T selectByEmail(@Param("email") String email);
}