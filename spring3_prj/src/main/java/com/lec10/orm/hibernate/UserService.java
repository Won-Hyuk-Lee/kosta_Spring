package com.lec10.orm.hibernate;

import java.util.List;

import com.lec10.orm.hibernate.entity.UserEntity;

public interface UserService {
	
	public void svcInsertUser(UserEntity user);
	public UserEntity svcUserDetail(Long userSeq);
	public List<UserEntity> svcAllUsers();
	public void svcDeleteUser(Long userSeq);
}
