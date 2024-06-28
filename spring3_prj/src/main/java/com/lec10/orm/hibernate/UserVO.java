package com.lec10.orm.hibernate;

import lombok.Data;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

//@Entity
//@Table(name = "users3")
@Data
public class UserVO {
    
    private Long userSeq;
    private String userId;
    private String userPw;
    private String userName;
    private char userGubun = 'u';
    private Date regdate = new Date();

    // lombok : getters and setters
}