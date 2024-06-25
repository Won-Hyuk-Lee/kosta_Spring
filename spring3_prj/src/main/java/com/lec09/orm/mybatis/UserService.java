package com.lec09.orm.mybatis;

import java.util.ArrayList;

public interface UserService {
	public int svcUserInsert(UserVO uvo);

	public ArrayList<UserVO>  svcUserSelectAll();

	public UserVO svcUserSelectOne(UserVO uvo);

	public int svcUserUpdate(UserVO uvo);

	public int svcUserDelete(UserVO uvo);
}
