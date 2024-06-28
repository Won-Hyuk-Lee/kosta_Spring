package com.lec10.orm.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lec10.orm.hibernate.entity.UserEntity;

@Repository
public class UserRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
//	@PersistenceContext
//    private EntityManager entityManager;
	
	// 입력 & 수정
	@Transactional
    public void save(UserEntity user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

	//상세보기
    @Transactional
    public UserEntity getById(Long prmSeq) {
        return (UserEntity) sessionFactory.getCurrentSession().get(UserEntity.class, prmSeq);
        //JPA
//        String hql = "SELECT u FROM UserEntity u WHERE u.userSeq = :prmSeq";
//        Query query = entityManager.createQuery(hql);
//        query.setParameter("userSeq", prmSeq);
//        return (UserEntity) query.getSingleResult();
    }

    //목록
    @Transactional
    public List<UserEntity> getAll() {
    	//Hibernate Criteria API 사용 방식 - 컴파일시점에서 검사
        //return sessionFactory.getCurrentSession().createCriteria(UserEntity.class).list();
    	
    	//HQL(Hibernate Query Language) 사용 방식 - 런타임시점에서 검사
    	return sessionFactory.getCurrentSession().createQuery("from UserEntity").list();
    	
    	//JPA
//    	 String hql = "SELECT u FROM UserEntity u";
//         Query query = entityManager.createQuery(hql);
//         return query.getResultList();
         
    }

    //삭제
    @Transactional
    public void delete(Long userSeq) {
        UserEntity user = getById(userSeq);
        if (user != null) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }
    
//    //로그인
//    @Transactional  //(transactionManager = "txManager")
//    public UserEntity findUserByUserIdAndUserPw(String prmid, String prmpw) {
//    	String hql = "SELECT u FROM UserEntity u WHERE u.userId = :prmid AND u.userPw = :prmpw";
//        Query query = entityManager.createQuery(hql);
//        query.setParameter("userId", prmid);
//        query.setParameter("userPw", prmpw);
//        try {
//        	return (UserEntity) query.getSingleResult();
//        } catch (NoResultException e) {
//            return null;  // 또는 return Optional.empty()
//        }
//        
//    }
    
    
}
