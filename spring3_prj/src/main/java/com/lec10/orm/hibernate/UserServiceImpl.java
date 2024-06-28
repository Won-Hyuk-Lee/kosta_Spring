package com.lec10.orm.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec10.orm.hibernate.entity.UserEntity;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;  //DAO

	@Transactional
	public void svcInsertUser(UserEntity user) {
		userRepository.save(user);
	}

	@Transactional
	public UserEntity svcUserDetail(Long userSeq) {
		return userRepository.getById(userSeq);
	}

	@Transactional
	public List<UserEntity> svcAllUsers() {
		return userRepository.getAll();
	}

	@Transactional
	public void svcDeleteUser(Long userSeq) {
		userRepository.delete(userSeq);
	}



}
