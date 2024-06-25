package com.lec09.orm.mybatis;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
//@Transactional   //DataSourceTXManager를 통한 트랜잭션 관리 대상 : 문제발생 시 롤백
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO userDAO;

	@Override
	public int svcUserInsert(UserVO uvo) {
		return userDAO.userInsert(uvo);
		//return session.insert("userNameSpace.userInsert", uvo);
	}
	@Override
	public ArrayList<UserVO>  svcUserSelectAll () {
		return userDAO.userSelectAll();
		//return (ArrayList)session.selectList("userNameSpace.allUser");
	}
	@Override
	public UserVO svcUserSelectOne(UserVO uvo) {
		return userDAO.userSelectOne(uvo);
		//return session.selectOne("userNameSpace.login", uvo);
	}
	@Override
	public int svcUserUpdate(UserVO uvo) {
		return userDAO.userUpdate(uvo);
		//return session.update("userNameSpace.userUpdate", uvo);
	}
	@Override
	public int svcUserDelete(UserVO uvo) {
		return userDAO.userDelete(uvo) ;
		//return session.delete("userNameSpace.userDelete", uvo);
	}




}
