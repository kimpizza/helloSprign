package com.cos.security01.config.auth;

import com.cos.security01.model.User;
import com.cos.security01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// 시큐리티 설정에서 loginProcessingUrl("/login")으로 걸어놧는데 이 요청이 오면 자동으로 UserDetailsService 타입으로 IoC되어있는
// loadUserByUsername 함수가 실행된다.


@Service
public class PrincipalDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    // SecuritySession(Authentication(UserDetails))
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //이때 저 위에 username은 loginForm으로 보낸 name의 이름과 username으로 같아야한다 다르면 인식못함.
        // 만약 사용하고 싶으면 SecurityConfig에서 .usernameParameter("username2")

        User userEntity = userRepository.findByUsername(username);
        if(userEntity!=null){
            return new PrincipalDetails(userEntity);
        }

        return null;
    }
}
