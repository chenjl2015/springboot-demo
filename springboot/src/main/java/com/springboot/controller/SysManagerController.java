package com.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.common.PageInfo;
import com.springboot.bean.vo.SysManager;
import com.springboot.service.SysManagerService;

/**
 * 
 * @ClassName: SysManagerController
 * @Description: 管理员控制层
 * @author chenjl
 * @date 2017-3-16 下午11:26:27
 * 
 */
@RestController
@RequestMapping("/manager")
public class SysManagerController {

	@Resource
	private SysManagerService sysManagerService;

	/**
	 * 
	 * @Title: getAllManagers
	 * @Description: 获取所有管理员列表
	 * @param page 页码
	 * @param rows 条数
	 * @return Object 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/getAllManagers")
	public Object getAllManagers(
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "rows", defaultValue = "10") int rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("rows", rows);
		// map支持还支持条件查询
		// map.put("userName","cjl");
		PageInfo<SysManager> managerList = sysManagerService
				.getAllManagers(map);
		return managerList;
	}
}
