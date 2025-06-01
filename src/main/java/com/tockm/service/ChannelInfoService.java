package com.tockm.service;

import com.tockm.entity.po.ChannelInfo;
import com.tockm.entity.query.ChannelInfoQuery;
import com.tockm.entity.vo.PaginationResultVo;

import java.util.List;

/**
 *@Description: Service
 *@date: 2025/05/31
 */
public interface ChannelInfoService {
	/**
	 * 根据条件查询列表
	 */
	List<ChannelInfo> findListByParam(ChannelInfoQuery param);
	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(ChannelInfoQuery param);
	/**
	 * 分页查询
	 */
	PaginationResultVo<ChannelInfo> findListByPage(ChannelInfoQuery param);
	/**
	 * 新增
	 */
	Integer add(ChannelInfo bean);
	/**
	 * 批量新增
	 */
	Integer addBatch(List<ChannelInfo> listBean);
	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<ChannelInfo> bean);

	/**
	 * 根据Id查询
	 */
	ChannelInfo getChannelInfoById(Integer id);

	/**
	 * 根据Id更新
	 */
	Integer updateChannelInfoById(ChannelInfo bean, Integer id);

	/**
	 * 根据Id删除
	 */
	Integer deleteChannelInfoById(Integer id);

	List<ChannelInfo> getChannels();
}