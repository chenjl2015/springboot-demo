package com.springboot.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

/**
 * 
 * @ClassName: BaseDao
 * @Description: dao基础类
 * @author chenjl
 * @date 2017-3-16 下午11:29:35
 * 
 */
@Repository
public class BaseDao {

	@Resource
	protected SqlSessionFactory sessionFactory;
}
