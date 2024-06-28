package com.lec09.orm.mybatis.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.lec09.orm.mybatis.UserVO;

@Repository
@Mapper
public interface UserMapper {
	public int userInsert(UserVO uvo) ;
	
	public ArrayList<UserVO>  userSelectAll() ;
		
	public UserVO userSelectOne(UserVO uvo) ;
	
	public UserVO userLogin(UserVO uvo) ;
	public int userUpdate(UserVO uvo) ;
	
	public int userDelete(UserVO uvo) ;
}
