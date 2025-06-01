package com.tockm.mappers;

import org.apache.ibatis.annotations.Param;

/**
 *@Description: Mapper
 *@date: 2025/05/31
 */
public interface ChannelInfoMapper<T,P> extends BaseMapper {

	/**
	 * 根据Id查询
	 */
	T selectById(@Param("id") Integer id);

	/**
	 * 根据Id更新
	 */
	Integer updateById(@Param("bean") T t, @Param("id") Integer id);

	/**
	 * 根据Id删除
	 */
	Integer deleteById(@Param("id") Integer id);

}