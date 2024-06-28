package com.lec09.orm.mybatis;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lec09.orm.mybatis.mapper.UserMapper;

@Service
//@Transactional   //DataSourceTXManager를 통한 트랜잭션 관리 대상 : 문제발생 시 롤백
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMap;

	@Transactional
	public int userInsert(UserVO uvo) {
		System.out.println(userMap);
		return userMap.userInsert(uvo);
	}

	public ArrayList<UserVO>  userSelectAll() {
		return userMap.userSelectAll();
	}

	public UserVO userSelectOne(UserVO uvo) {
		return userMap.userSelectOne(uvo);
	}

	public int userUpdate(UserVO uvo) {
		return userMap.userUpdate(uvo);
	}

	public int userDelete(UserVO uvo) {
		return userMap.userDelete(uvo);
	}


	//TX rollback test용

		//3건의 insert 중 에러 발생 시 TX에 의해 모두 rollback 처리됨

		public void svcDeleteRuntimeErrorFunc(UserVO vo) throws RuntimeException {

			userMap.userInsert(vo);

			userMap.userInsert(vo);

			System.err.println("----------------- 모두 롤백처리 됨 ----------------");

			throw new RuntimeException("RuntimeException(Unchecked Exception) -- UserServiceImpl.svcDeleteErrorFunc() 강제 에러 발생");

		}

		

		public void svcDeleteSQLErrorFunc(UserVO vo) throws SQLException {

			userMap.userInsert(vo);

			userMap.userInsert(vo);

			System.err.println("----------------- 모두 롤백처리 됨 ----------------");

			throw new SQLException("SQLException(Checked Exception) -- UserServiceImpl.svcDeleteErrorFunc22() 강제 에러 발생");

			

		}




	
	
}
