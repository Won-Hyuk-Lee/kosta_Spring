package com.lec08.dao;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component    //--------------Spring <bean>  JPA:@Entity
@Data         //--------------lombok
//@ToString
//@Getter
//@Setter
//@RequiredArgsConstructor
//@EqualsAndHashCode

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class UserVO {
	private int user_seq;
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_gubun;
	private String regdate;
	
}
