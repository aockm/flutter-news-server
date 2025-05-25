package com.tockm.controller;
import com.tockm.exception.BusinessException;
import com.tockm.service.UserInfoService;
import com.tockm.entity.po.UserInfo;
import com.tockm.entity.query.UserInfoQuery;
import com.tockm.entity.vo.ResponseVo;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *@Description: Service
 *@date: 2025/05/25
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController extends ABaseController {
	private static final Logger log = LoggerFactory.getLogger(UserInfoController.class);
	@Resource
	private UserInfoService userInfoService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVo loadDataList(UserInfoQuery query){
		return getSuccessResponseVo(userInfoService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("add")
	public ResponseVo add(UserInfo bean){
		userInfoService.add(bean);
		return getSuccessResponseVo(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("addBatch")
	public ResponseVo addBatch(@RequestBody List<UserInfo> listBean){
		userInfoService.addBatch(listBean);
		return getSuccessResponseVo(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("addOrUpdateBatch")
	public ResponseVo addOrUpdateBatch(@RequestBody List<UserInfo> listBean){
		userInfoService.addOrUpdateBatch(listBean);
		return getSuccessResponseVo(null);
	}


	/**
	 * 根据UserId查询
	 */
	@RequestMapping("getUserInfoByUserId")
	public ResponseVo getUserInfoByUserId(Integer userId){
		return getSuccessResponseVo(userInfoService.getUserInfoByUserId(userId));
	}

	/**
	 * 用户登录
	 */
	@RequestMapping("/login")
	public ResponseVo login(@NotEmpty @Email String email,
							@NotEmpty String password) throws BusinessException {
		return getSuccessResponseVo(userInfoService.login(email,password));
	}

	@RequestMapping("/test")
	public ResponseVo login() {
		return getSuccessResponseVo(null);
	}

}