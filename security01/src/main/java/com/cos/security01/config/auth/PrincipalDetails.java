package com.cos.security01.config.auth;

// 시큐리티가 /login 이라는 요청을 낚아 채 로그인을 진행시킨다.
// 이때 로그인이 완료되면 세션을 만들어줄것인데
// 시큐리티는 자신만의 세션 공간을 가지고 있다.
// (Security ContextHolder라는 Key값에 세션 정보를 저장시킨다)
// 이때 여기에 들어갈 수 있는 정보는 시큐리티가 가지고있는 세션에 들어갈 수 있는 오브젝트가 정해져있다 > Authentication 타입의 객체
// 이 Authentication 안에는 User정보가 있어야 된다.
// 이 유저 오브젝트의 타입은 UserDetails 타입 객체

// 시큐리티가 가지고있는 세션 영역이 있고 여기에 회원의 세션정보를 저장해주는데 그 객체가 Authentication 여야한다.
// 그리고 이 객체안에 유저정보를 저장할때 유저 정보는 UserDetails 타입이어야한다.

import com.cos.security01.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetails implements UserDetails {

    private User user; //콤포지션

    public PrincipalDetails(User user){
        this.user = user;
    }

    // 해당 유저의 권한을 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });
        //user.getRole(); //String 타입이기때문에 이대로 지정할 수 없음

        return collect;
    }


    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {

        //이 계정이 만약 우리 사이트에서 1년동안 회원이 로그인을 안하면 휴전 계정으로 하기로했다면?
        //현재시간 - 최종로그인 시간 해서 이게 일년을 초과하면 리턴을 false

        return true;
    }
}
