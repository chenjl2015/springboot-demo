package com.springboot.mapper;

import java.util.List;
import java.util.Map;

import com.springboot.bean.vo.SysManager;

/**
 * 
 * @ClassName: SysManagerMapper
 * @Description: 管理员Mapper对象
 * @author chenjl
 * @date 2017-3-16 下午11:31:32
 * 
 */
public interface SysManagerMapper {

	public List<SysManager> selectManagersPageByParams(Map<String, Object> map);
}
