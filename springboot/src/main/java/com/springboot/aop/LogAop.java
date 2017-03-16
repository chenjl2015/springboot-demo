package com.springboot.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: LogAop
 * @Description: AOP切面，用于记录日志和时间
 * @author chenjl
 * @date 2017-3-16 下午11:23:54
 * 
 */
@Aspect
@Component
public class LogAop {

	private Logger logger = Logger.getLogger(getClass());

	/**
	 * 定义一个切入点. 解释下：
	 * 
	 * ~ 第一个 * 代表任意修饰符及任意返回值. ~ 第二个 * 定义在web包或者子包 ~ 第三个 * 任意方法 ~ .. 匹配任意数量的参数.
	 */
	@Pointcut("execution(* com.springboot..*.*(..))")
	public void logPointcut() {
	}

	@org.aspectj.lang.annotation.Around("logPointcut()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		// LOG.debug("logPointcut " + joinPoint + "\t");
		long start = System.currentTimeMillis();
		try {
			Object result = joinPoint.proceed();
			long end = System.currentTimeMillis();
			logger.debug("+++++around " + joinPoint + "\tUse time : "
					+ (end - start) + " ms!");
			return result;

		} catch (Throwable e) {
			long end = System.currentTimeMillis();
			logger.error("+++++around " + joinPoint + "\tUse time : "
					+ (end - start) + " ms with exception : " + e.getMessage());
			throw e;
		}

	}

}
