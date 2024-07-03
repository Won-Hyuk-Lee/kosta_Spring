package com.kosta.semi.svc;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kosta.semi.mappers.UserMapper;
import com.kosta.semi.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;
	
	@Override
	public int svcUserInsert(UserVO uvo) {
		return userMapper.userInsert(uvo);
		//return session.insert("userNameSpace.userInsert", uvo);
	}
	
	
	@Override
	public ArrayList<UserVO>  svcUserSelectAll () {
		return userMapper.allUser();
		//return userDAO.userSelectAll();	 //DAO 사용안함
		//return (ArrayList)session.selectList("userNameSpace.allUser");
	}
	@Override
	public UserVO svcUserSelectOne(UserVO uvo) {
		return userMapper.login(uvo);
		//return userDAO.userSelectOne(uvo);  //DAO 사용안함
		//return session.selectOne("userNameSpace.login", uvo);
	}
	
	@Override
	public int svcUserUpdate(UserVO uvo) {
		return userMapper.userUpdate(uvo);
		//return session.update("userNameSpace.userUpdate", uvo);
	}
	@Override
	public int svcUserDelete(int seq) {
		return userMapper.userDelete(seq) ;
		//return session.delete("userNameSpace.userDelete", uvo);
	}

}
