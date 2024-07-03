package com.kosta.semi.mappers;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.kosta.semi.vo.UserVO;

@Repository
@Mapper
public interface UserMapper {

	public int userInsert(UserVO uvo); 
	//return session.insert("userNameSpace.userInsert", uvo);
	
	public ArrayList<UserVO>  allUser();
	//return (ArrayList)session.selectList("userNameSpace.allUser");
	
	public UserVO login(UserVO uvo);
	//return session.selectOne("userNameSpace.login", uvo);
	
	public int userUpdate(UserVO uvo);
	//return session.update("userNameSpace.userUpdate", uvo);
	
	public int userDelete(int seqsss);	
}
