package com.lec10.orm.hibernate.entity;

import javax.persistence.*;


import lombok.Data;

import java.util.Date;


/*<class name="UserVO" table="users3">
	<id name="userSeq" column="user_seq" />
	<property name="userId" column="user_id" />
	<property name="userPw" column="user_pw" />
	<property name="userName" column="user_name" />
	<property name="userGubun" column="user_gubun" />
	<property name="regdate" column="regdate" />
</class>*/

@Data
@Entity  //(name = "UserEntityJPA")
@Table(name = "users3")
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users3_seq_gen")
    @SequenceGenerator(name = "users3_seq_gen", sequenceName = "users3_seq", allocationSize = 1)
    @Column(name = "user_seq")
    private Long id;
    
    @Column(name = "user_id", nullable = false, length = 20)
    private String userId;
    
    @Column(name = "user_pw", nullable = false, length = 20)
    private String userPw;
    
    @Column(name = "user_name", length = 20)
    private String userName;
    
    @Column(name = "user_gubun", nullable = false, length = 1)
    private char userGubun = 'u';
    
    @Column(name = "regdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regdate = new Date();

    // lombok : getters and setters
}