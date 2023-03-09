package com.cos.security01.repository;

import com.cos.security01.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//기본적인 CRUD 함수를 들고 있음
//@Repository 어노테이션이 없어도 IoC , 이유는 JpaRepository를 상속받았기 때문

public interface UserRepository extends JpaRepository <User, Integer> {

}
