package com.tockm.mappers;

import org.apache.ibatis.annotations.Param;

/**
 *@Description: Mapper
 *@date: 2025/05/31
 */
public interface NewsInfoMapper<T,P> extends BaseMapper {

	/**
	 * 根据Id查询
	 */
	T selectById(@Param("id") String id);


    T selectRecommend(@Param("category") String category, @Param("recommend") Integer recommend);
	/**
	 * 根据Id删除
	 */
	Integer deleteById(@Param("id") String id);

}