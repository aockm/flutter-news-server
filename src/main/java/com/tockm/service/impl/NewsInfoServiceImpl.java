package com.tockm.service.impl;

import com.tockm.entity.po.NewsInfo;
import com.tockm.entity.query.NewsInfoQuery;
import com.tockm.entity.query.SimplePage;
import com.tockm.entity.vo.PaginationResultVo;
import com.tockm.enums.PageSize;
import com.tockm.mappers.NewsInfoMapper;
import com.tockm.service.NewsInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

;

/**
 *@Description: Service
 *@date: 2025/05/31
 */
@Service("newsInfoService")
public class NewsInfoServiceImpl implements NewsInfoService {
	@Resource
	private NewsInfoMapper<NewsInfo, NewsInfoQuery> newsInfoMapper;
	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<NewsInfo> findListByParam(NewsInfoQuery param){
		return this.newsInfoMapper.selectList(param);
	}

	/**
	 * 根据条件查询数量
	 */
	@Override
	public Integer findCountByParam(NewsInfoQuery param){
		return this.newsInfoMapper.selectCount(param);
	}

	/**
	 * 分页查询
	 */
	@Override
	public PaginationResultVo<NewsInfo> findListByPage(NewsInfoQuery query){
		int count = this.findCountByParam(query);
		int pageSize = query.getPageSize()==null?PageSize.SIZE15.getSize():query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<NewsInfo> list = this.findListByParam(query);
		PaginationResultVo<NewsInfo> result = new PaginationResultVo(count,page.getPageSize(),page.getPageNo(),page.getTotalPage(),list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(NewsInfo bean){
		return this.newsInfoMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<NewsInfo> listBean){
		if(listBean==null||listBean.isEmpty()){
			return 0;
		}
		return this.newsInfoMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增/修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<NewsInfo> listBean){
		if(listBean==null||listBean.isEmpty()){
			return 0;
		}
		return this.newsInfoMapper.insertOrUpdateBatch(listBean);
	}


	/**
	 * 根据Id查询
	 */
	@Override
	public NewsInfo getNewsInfoById(String id){
		return this.newsInfoMapper.selectById(id);
	}
    // 查询推荐
	@Override
	public NewsInfo getNewsInfoRecommend(String category) {
		if (category == null || category.isEmpty()) {
			category = "Health";
		}
		return this.newsInfoMapper.selectRecommend(category,1);
	}


}