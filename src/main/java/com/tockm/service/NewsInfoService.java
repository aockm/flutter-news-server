package com.tockm.service;

import com.tockm.entity.po.NewsInfo;
import com.tockm.entity.query.NewsInfoQuery;
import com.tockm.entity.vo.PaginationResultVo;

import java.util.List;

/**
 *@Description: Service
 *@date: 2025/05/31
 */
public interface NewsInfoService {
	/**
	 * 根据条件查询列表
	 */
	List<NewsInfo> findListByParam(NewsInfoQuery param);
	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(NewsInfoQuery param);
	/**
	 * 分页查询
	 */
	PaginationResultVo<NewsInfo> findListByPage(NewsInfoQuery param);
	/**
	 * 新增
	 */
	Integer add(NewsInfo bean);
	/**
	 * 批量新增
	 */
	Integer addBatch(List<NewsInfo> listBean);
	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<NewsInfo> bean);

	/**
	 * 根据Id查询
	 */
	NewsInfo getNewsInfoById(String id);

    NewsInfo getNewsInfoRecommend(String category);
}