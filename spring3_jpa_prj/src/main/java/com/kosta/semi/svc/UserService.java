package com.kosta.semi.svc;

import java.util.List;

import com.kosta.semi.entity.UserEntity;

public interface UserService {	
	public UserEntity svcUserLogin(String userId, String userPw);
	public List<UserEntity> svcUserList();
	UserEntity svcUserDetail(Long userSeq);
	void svcUserUpdate(UserEntity userEntity);
	void svcUserDelete(Long userSeq);
}
