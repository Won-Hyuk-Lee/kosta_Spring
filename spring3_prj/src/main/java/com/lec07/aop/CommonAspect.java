package com.lec07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component //인스턴스 초기화
@Aspect    //공통기능 :: AnnotationAwareAspectJAutoProxyCreator 
public class CommonAspect {
	
	@Pointcut("execution(public * com.lec07..*DAO.*(..))")
	public void dummyDAOCut() {}
	
	@Pointcut("execution(public * com.lec07..*Impl.*(..))")
	public void dummyImplCut() {}
	
	
	//@Before("dummyImplCut()")
	@Before("dummyImplCut()")
	public void beforeAdvice() {
		System.out.println("\t 실행전::CommonAspect.beforeAdvice()");
	}
	
	@After("dummyImplCut()")
	public void afterAdvice() {
		System.out.println("\t 실행후무조건::CommonAspect.afterAdvice()");
	}
	
//	@AfterThrowing(pointcut="dummyImplCut()", throwing="ex")
//	public void afterThrowingAdvice(Exception ex) {
//		System.out.println("\t 실행후에러시::CommonAspect.afterThrowingAdvice() :: " + ex.getMessage());
//	}
//	
	
	@AfterReturning(pointcut="dummyImplCut()", returning="res")
	public void afterReturningAdvice(Object res) {
		System.out.println("\t 실행후정상시::CommonAspect.afterReturningAdvice() :: " + res);
	}
	
	@Around("dummyImplCut()")
	public void aroundAdvice(ProceedingJoinPoint jp) {
		try {
			System.out.println("\t 앞::CommonAspect.aroundAdvice()");
			System.out.println("\t  :: " + jp.getSignature());
			jp.proceed();    // aOPService.svcDelete();
			System.out.println("\t 뒤::CommonAspect.aroundAdvice()");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
}
