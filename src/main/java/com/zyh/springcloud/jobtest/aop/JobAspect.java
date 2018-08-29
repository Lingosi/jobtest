package com.zyh.springcloud.jobtest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


//@Aspect
//@Component
public class JobAspect {
	@Before("execution(* com.zyh.springcloud.jobtest.job.TestJob.*(..))")
	public void execute(JoinPoint point){
		System.out.println("aop============");
	}
}
