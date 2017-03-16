package com.springboot.service;

import java.util.Map;

import com.springboot.bean.vo.SysManager;
import com.springboot.common.PageInfo;

/**
 * 
 * @ClassName: SysManagerService
 * @Description: 管理员服务接口层
 * @author chenjl
 * @date 2017-3-16 下午11:34:12
 * 
 */
public interface SysManagerService {

	/**
	 * 
	 * @Title: getAllManagers
	 * @Description: 根据入参获取所有管理管理员
	 * @param map
	 * @return PageInfo<SysManager> 返回类型
	 * @throws
	 */
	public PageInfo<SysManager> getAllManagers(Map<String, Object> map);
}
