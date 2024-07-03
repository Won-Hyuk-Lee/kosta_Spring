package com.kosta.semi.svc;

import java.util.ArrayList;

import com.kosta.semi.vo.UserVO;

public interface UserService {
	public int svcUserInsert(UserVO uvo);
	public ArrayList<UserVO>  svcUserSelectAll();
	public UserVO svcUserSelectOne(UserVO uvo);
	public int svcUserUpdate(UserVO uvo);
	public int svcUserDelete(int seq);
	
}
