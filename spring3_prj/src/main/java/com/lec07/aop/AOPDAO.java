package com.lec07.aop;

import org.springframework.stereotype.Repository;

@Repository
public class AOPDAO {
	
	public void delete() {
		System.out.println("3.___AOPDAO.delete() 실행");
	}
}
