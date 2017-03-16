package com.springboot.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.springboot.common.PageInfo;
import com.springboot.mapper.SysManagerMapper;
import com.springboot.bean.vo.SysManager;
import com.github.pagehelper.PageHelper;

/**
 * 
 * @ClassName: SysManagerDao
 * @Description: 管理员DAO类
 * @author chenjl
 * @date 2017-3-16 下午11:30:12
 * 
 */
@Repository
public class SysManagerDao extends BaseDao {

	public PageInfo<SysManager> selectManagersPageByParams(
			Map<String, Object> map) {
		PageHelper.startPage((int) map.get("page"), (int) map.get("rows"));
		SysManagerMapper mapper = sessionFactory.openSession().getMapper(
				SysManagerMapper.class);
		List<SysManager> userList = mapper.selectManagersPageByParams(map);
		PageInfo<SysManager> pageInfo = new PageInfo<SysManager>(userList);
		return pageInfo;
	}
}
