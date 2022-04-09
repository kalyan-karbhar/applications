package com.app.aspects;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Pointcut that matches all repositories, services and web REST endoints.
	 */
	@Pointcut("within(@org.springframework.stereotype.Repository *)"+
	 "||within(@org.springframework.stereotype.Service *)"+
	 "||within(@org.springframework.web.bind.annotation.RestController  *)")
	public void beanPointCut() {}
	
	@Around("beanPointCut()")
	public Object logAround(ProceedingJoinPoint joinpoint)throws Throwable {
		long startTime = System.currentTimeMillis();
		log.info("Enter : {}.{} with argument[s] = {}",joinpoint.getSignature().getDeclaringTypeName(),
				joinpoint.getSignature().getName(),Arrays.toString(joinpoint.getArgs()));
		Object object;
		try {
		object = joinpoint.proceed();	
		}catch(Exception ex) {
			throw ex;
		}finally {
			long endTime = System.currentTimeMillis();
			log.info("Class Name: "+joinpoint.getSignature().getDeclaringTypeName()+
					". Method Name: "+joinpoint.getSignature().getName()+
					". Time taken for Execution is : "+(endTime-startTime)+"ms");
		}
		return object;
	}

}
