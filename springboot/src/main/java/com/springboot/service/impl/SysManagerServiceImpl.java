package com.springboot.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springboot.common.PageInfo;
import com.springboot.dao.SysManagerDao;
import com.springboot.service.SysManagerService;
import com.springboot.bean.vo.SysManager;

/**
 * 
 * @ClassName: SysManagerServiceImpl
 * @Description: 管理员服务接口实现层
 * @author chenjl
 * @date 2017-3-16 下午11:36:05
 * 
 */
@Service
public class SysManagerServiceImpl implements SysManagerService {

	@Resource
	private SysManagerDao sysManagerDao;

	@Override
	public PageInfo<SysManager> getAllManagers(Map<String, Object> map) {
		PageInfo<SysManager> managerList = sysManagerDao
				.selectManagersPageByParams(map);
		return managerList;
	}

}
