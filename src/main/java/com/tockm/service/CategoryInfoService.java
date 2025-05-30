package com.tockm.service;

import com.tockm.entity.po.CategoryInfo;
import com.tockm.entity.query.CategoryInfoQuery;
import com.tockm.entity.vo.PaginationResultVo;

import java.util.List;

/**
 *@Description: Service
 *@date: 2025/05/28
 */
public interface CategoryInfoService {
	/**
	 * 根据条件查询列表
	 */
	List<CategoryInfo> findListByParam(CategoryInfoQuery param);
	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(CategoryInfoQuery param);
	/**
	 * 分页查询
	 */
	PaginationResultVo<CategoryInfo> findListByPage(CategoryInfoQuery param);
	/**
	 * 新增
	 */
	Integer add(CategoryInfo bean);
	/**
	 * 批量新增
	 */
	Integer addBatch(List<CategoryInfo> listBean);
	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<CategoryInfo> bean);

	/**
	 * 根据Id查询
	 */
	CategoryInfo getCategoryInfoById(Integer id);

	/**
	 * 根据Id更新
	 */
	Integer updateCategoryInfoById(CategoryInfo bean, Integer id);

	/**
	 * 根据Id删除
	 */
	Integer deleteCategoryInfoById(Integer id);
}