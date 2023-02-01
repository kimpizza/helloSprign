package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    } // command+n
    // memberRepository를 외부에서 넣어주도록 변경


    // 회원가입
    public Long join(Member member){
        validateDuplicateMember(member); // 중복 회원 검증 : 같은 이름이 있는 중복 회원X
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) //Optional로 반환
                .ifPresent(m -> { //여기에 값이 있으면 동작
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
        // orElseGet도 자주씀 = 값이 있으면 꺼내고 없으면 어떤 메소드를 실행해
        // 기존에는 if !null이면 이런식으로 갔다면
        // Optional이라는 이름으로 객체를 한번 감싸서 반환
        // 감싼 덕분에 Optional안의 ifPresent것을 사용할 수 있음
        // ctrl+t 리팩토링 관련 여러 기능들 단축키
    }
    // 전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    // 아이디로 회원 조회
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
