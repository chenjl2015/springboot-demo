package com.springboot.common;

import javax.sql.DataSource;

import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 
 * @ClassName: DataBaseConfiguration
 * @Description: 数据库连接配置类
 * @author chenjl
 * @date 2017-3-16 下午11:25:11
 * 
 */
@Configuration
@EnableTransactionManagement
public class DataBaseConfiguration implements EnvironmentAware {

	private RelaxedPropertyResolver propertyResolver;

	@Override
	public void setEnvironment(Environment env) {
		this.propertyResolver = new RelaxedPropertyResolver(env,
				"spring.datasource.");
	}

	@Bean(destroyMethod = "close", initMethod = "init")
	public DataSource writeDataSource() {
		DruidDataSource dataSource = new DruidDataSource();

		/**
		 * 配置这个属性的意义在于，如果存在多个数据源，监控的时候 可以通过名字来区分开来。如果没有配置，将会生成一个名字，
		 * 格式是："DataSource-" + System.identityHashCode(this)
		 */
		dataSource.setName("DataSource-Springboot");

		dataSource.setUrl(propertyResolver.getProperty("url"));
		dataSource.setUsername(propertyResolver.getProperty("username"));// 用户名
		dataSource.setPassword(propertyResolver.getProperty("password"));// 密码
		dataSource.setDriverClassName(propertyResolver
				.getProperty("driver-class-name"));
		/**
		 * 初始化时建立物理连接的个数。初始化发生在显示调用init方法， 或者第一次getConnection时
		 */
		dataSource.setInitialSize(2);
		/**
		 * 最大连接池数量
		 */
		dataSource.setMaxActive(20);
		/**
		 * 最小连接池数量
		 */
		dataSource.setMinIdle(0);

		/**
		 * 获取连接时最大等待时间，单位毫秒。配置了maxWait之后，缺省启用公平锁，
		 * 并发效率会有所下降，如果需要可以通过配置useUnfairLock属性为true使用非公平锁。
		 */
		dataSource.setMaxWait(60000);

		/**
		 * 用来检测连接是否有效的sql，要求是一个查询语句。
		 * 如果validationQuery为null，testOnBorrow、testOnReturn、
		 * testWhileIdle都不会其作用。
		 */
		dataSource.setValidationQuery("SELECT 1");
		/**
		 * 申请连接时执行validationQuery检测连接是否有效， 做了这个配置会降低性能。
		 */
		dataSource.setTestOnBorrow(false);
		/**
		 * 归还连接时执行validationQuery检测连接是否有效， 做了这个配置会降低性能
		 */
		dataSource.setTestOnReturn(false);
		/**
		 * 建议配置为true，不影响性能，并且保证安全性。 申请连接的时候检测，如果空闲时间大于
		 * timeBetweenEvictionRunsMillis， 执行validationQuery检测连接是否有效。
		 */
		dataSource.setTestWhileIdle(true);

		// 这里配置提交方式，默认就是TRUE，可以不用配置
		// dataSource.setDefaultAutoCommit(true);

		/**
		 * 打开PSCache，并且指定每个连接上PSCache的大小是否缓存preparedStatement，也就是PSCache。
		 * PSCache对支持游标的数据库性能提升巨大，比如说oracle。 在mysql5.5以下的版本中没有PSCache功能，建议关闭掉。
		 * 5.5及以上版本有PSCache，建议开启。 要启用PSCache，必须配置大于0，当大于0时，
		 * poolPreparedStatements自动触发修改为true。
		 * 在Druid中，不会存在Oracle下PSCache占用内存过多的问题， 可以把这个数值配置大一些，比如说100
		 */
		// <property name="poolPreparedStatements" value="true" />
		// <property name="maxPoolPreparedStatementPerConnectionSize"
		// value="20" />
		dataSource.setPoolPreparedStatements(false);

		return dataSource;
	}

}
