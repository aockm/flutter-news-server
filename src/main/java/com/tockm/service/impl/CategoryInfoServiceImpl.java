package com.tockm.service.impl;

import com.tockm.entity.po.CategoryInfo;
import com.tockm.entity.query.CategoryInfoQuery;
import com.tockm.entity.query.SimplePage;
import com.tockm.entity.vo.PaginationResultVo;
import com.tockm.enums.PageSize;
import com.tockm.mappers.CategoryInfoMapper;
import com.tockm.service.CategoryInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

;

/**
 *@Description: Service
 *@date: 2025/05/28
 */
@Service("categoryInfoService")
public class CategoryInfoServiceImpl implements CategoryInfoService {
	@Resource
	private CategoryInfoMapper<CategoryInfo,CategoryInfoQuery> categoryInfoMapper;
	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<CategoryInfo> findListByParam(CategoryInfoQuery param){
		return this.categoryInfoMapper.selectList(param);
	}

	/**
	 * 根据条件查询数量
	 */
	@Override
	public Integer findCountByParam(CategoryInfoQuery param){
		return this.categoryInfoMapper.selectCount(param);
	}

	/**
	 * 分页查询
	 */
	@Override
	public PaginationResultVo<CategoryInfo> findListByPage(CategoryInfoQuery query){
		int count = this.findCountByParam(query);
		int pageSize = query.getPageSize()==null?PageSize.SIZE15.getSize():query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<CategoryInfo> list = this.findListByParam(query);
		PaginationResultVo<CategoryInfo> result = new PaginationResultVo(count,page.getPageSize(),page.getPageNo(),page.getTotalPage(),list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(CategoryInfo bean){
		return this.categoryInfoMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<CategoryInfo> listBean){
		if(listBean==null||listBean.isEmpty()){
			return 0;
		}
		return this.categoryInfoMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增/修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<CategoryInfo> listBean){
		if(listBean==null||listBean.isEmpty()){
			return 0;
		}
		return this.categoryInfoMapper.insertOrUpdateBatch(listBean);
	}


	/**
	 * 根据Id查询
	 */
	@Override
	public CategoryInfo getCategoryInfoById(Integer id){
		return this.categoryInfoMapper.selectById(id);
	}


	/**
	 * 根据Id更新
	 */
	@Override
	public Integer updateCategoryInfoById(CategoryInfo bean, Integer id){
		return this.categoryInfoMapper.updateById(bean,id);
	}


	/**
	 * 根据Id删除
	 */
	@Override
	public Integer deleteCategoryInfoById(Integer id){
		return this.categoryInfoMapper.deleteById(id);
	}

}