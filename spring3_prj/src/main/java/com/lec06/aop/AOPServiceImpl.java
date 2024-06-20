package com.lec06.aop;

public class AOPServiceImpl implements AOPService {

	private AOPDAO aOPDAO;
	public void setAOPDAO(AOPDAO aOPDAO) {
		this.aOPDAO = aOPDAO;
	}
	
	@Override
	public void svcDelete() {
		System.out.println("2.___AOPServiceImpl.svcDelete() 실행");
		aOPDAO.delete();
		
		//강제 에러 발생 :: after-throwing 테스트 시 열기 
		//throw new RuntimeException();
		
	}
}
