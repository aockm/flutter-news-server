package com.tockm.service.impl;

import com.tockm.entity.po.ChannelInfo;
import com.tockm.entity.query.ChannelInfoQuery;
import com.tockm.entity.query.SimplePage;
import com.tockm.entity.vo.PaginationResultVo;
import com.tockm.enums.PageSize;
import com.tockm.mappers.ChannelInfoMapper;
import com.tockm.service.ChannelInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

;

/**
 *@Description: Service
 *@date: 2025/05/31
 */
@Service("channelInfoService")
public class ChannelInfoServiceImpl implements ChannelInfoService {
	@Resource
	private ChannelInfoMapper<ChannelInfo,ChannelInfoQuery> channelInfoMapper;
	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<ChannelInfo> findListByParam(ChannelInfoQuery param){
		return this.channelInfoMapper.selectList(param);
	}

	/**
	 * 根据条件查询数量
	 */
	@Override
	public Integer findCountByParam(ChannelInfoQuery param){
		return this.channelInfoMapper.selectCount(param);
	}

	/**
	 * 分页查询
	 */
	@Override
	public PaginationResultVo<ChannelInfo> findListByPage(ChannelInfoQuery query){
		int count = this.findCountByParam(query);
		int pageSize = query.getPageSize()==null?PageSize.SIZE15.getSize():query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<ChannelInfo> list = this.findListByParam(query);
		PaginationResultVo<ChannelInfo> result = new PaginationResultVo(count,page.getPageSize(),page.getPageNo(),page.getTotalPage(),list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(ChannelInfo bean){
		return this.channelInfoMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<ChannelInfo> listBean){
		if(listBean==null||listBean.isEmpty()){
			return 0;
		}
		return this.channelInfoMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增/修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<ChannelInfo> listBean){
		if(listBean==null||listBean.isEmpty()){
			return 0;
		}
		return this.channelInfoMapper.insertOrUpdateBatch(listBean);
	}


	/**
	 * 根据Id查询
	 */
	@Override
	public ChannelInfo getChannelInfoById(Integer id){
		return this.channelInfoMapper.selectById(id);
	}


	/**
	 * 根据Id更新
	 */
	@Override
	public Integer updateChannelInfoById(ChannelInfo bean, Integer id){
		return this.channelInfoMapper.updateById(bean,id);
	}


	/**
	 * 根据Id删除
	 */
	@Override
	public Integer deleteChannelInfoById(Integer id){
		return this.channelInfoMapper.deleteById(id);
	}

	@Override
	public List<ChannelInfo> getChannels() {
		return this.channelInfoMapper.selectList(new ChannelInfoQuery());
	}
}