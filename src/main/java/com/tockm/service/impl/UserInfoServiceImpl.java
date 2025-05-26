package com.tockm.service.impl;
import com.tockm.configuration.SecurityProperties;
import com.tockm.entity.vo.UserInfoVo;
import com.tockm.exception.BusinessException;
import com.tockm.service.UserInfoService;
import com.tockm.entity.po.UserInfo;
import com.tockm.entity.query.UserInfoQuery;
import com.tockm.entity.query.SimplePage;
import com.tockm.mappers.UserInfoMapper;
import com.tockm.enums.PageSize;
import com.tockm.entity.vo.PaginationResultVo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;;
import com.tockm.utils.SHA256WithSalt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *@Description: Service
 *@date: 2025/05/25
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	private static final Logger log = LoggerFactory.getLogger(UserInfoServiceImpl.class);
	@Resource
	private UserInfoMapper<UserInfo,UserInfoQuery> userInfoMapper;

	@Resource
	private SecurityProperties securityProperties;
	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<UserInfo> findListByParam(UserInfoQuery param){
		return this.userInfoMapper.selectList(param);
	}

	/**
	 * 根据条件查询数量
	 */
	@Override
	public Integer findCountByParam(UserInfoQuery param){
		return this.userInfoMapper.selectCount(param);
	}

	/**
	 * 分页查询
	 */
	@Override
	public PaginationResultVo<UserInfo> findListByPage(UserInfoQuery query){
		int count = this.findCountByParam(query);
		int pageSize = query.getPageSize()==null?PageSize.SIZE15.getSize():query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<UserInfo> list = this.findListByParam(query);
		PaginationResultVo<UserInfo> result = new PaginationResultVo(count,page.getPageSize(),page.getPageNo(),page.getTotalPage(),list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(UserInfo bean){
		return this.userInfoMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<UserInfo> listBean){
		if(listBean==null||listBean.isEmpty()){
			return 0;
		}
		return this.userInfoMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增/修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<UserInfo> listBean){
		if(listBean==null||listBean.isEmpty()){
			return 0;
		}
		return this.userInfoMapper.insertOrUpdateBatch(listBean);
	}


	/**
	 * 根据UserId查询
	 */
	@Override
	public UserInfo getUserInfoByUserId(Integer userId){
		return this.userInfoMapper.selectByUserId(userId);
	}


	/**
	 * 根据UserId更新
	 */
	@Override
	public Integer updateUserInfoByUserId(UserInfo bean, Integer userId){
		return this.userInfoMapper.updateByUserId(bean,userId);
	}


	/**
	 * 根据UserId删除
	 */
	@Override
	public Integer deleteUserInfoByUserId(Integer userId){
		return this.userInfoMapper.deleteByUserId(userId);
	}

	@Override
	public UserInfoVo login(String email, String password) throws BusinessException {
		UserInfo userInfo = userInfoMapper.selectByEmail(email);
		if (null==userInfo || !userInfo.getPassword().equals(password)) {
			throw new BusinessException("账号或密码不存在");
		}
		List<String> channels = Arrays.asList("dsd","dsd");
		UserInfoVo userInfoVo = new UserInfoVo();
		userInfoVo.setAccessToken("2113");
		userInfoVo.setDisplayName("jhfsa");
		userInfoVo.setChannels(channels);
		return userInfoVo;
	}

	@Override
	public void register(String email, String username, String password) throws BusinessException {
		UserInfo userInfo = this.userInfoMapper.selectByEmail(email);
		if(userInfo != null){
			throw new BusinessException("邮箱账号已存在");
		}
		userInfo = new UserInfo();
		userInfo.setUsername(username);
		userInfo.setEmail(email);
		userInfo.setPassword(SHA256WithSalt.sha256WithSalt(password,securityProperties.getSalt()));
		userInfoMapper.insert(userInfo);
	}
}