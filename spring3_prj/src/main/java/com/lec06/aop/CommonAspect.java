package com.lec06.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class CommonAspect {
	public void beforeAdvice() {
		System.out.println("\t 실행전::CommonAspect.beforeAdvice()");
	}
	public void afterAdvice() {
		System.out.println("\t 실행후무조건::CommonAspect.afterAdvice()");
	}
	public void afterThrowingAdvice(Exception ex) {
		System.out.println("\t 실행후에러시::CommonAspect.afterThrowingAdvice() :: " + ex.getMessage());
	}
	public void afterReturningAdvice(Object res) {
		System.out.println("\t 실행후정상시::CommonAspect.afterReturningAdvice() :: " + res);
	}
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
