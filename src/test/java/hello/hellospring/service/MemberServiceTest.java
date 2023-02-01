package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;
    // MemoryMemberRepository를 가져오면 문제가 생길 수 있음
    // 이미 MemberService에서 memoryMemberRepository를 선언하여 사용중이기때문(?)


    // 테스트를 실행하면 각 테스트마다 같은 MemmoryMemberRepository에 넣어줌
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given : 이게 주어지고
        Member member = new Member();
        member.setName("spring");

        //when : 이걸 실행하면
        Long saveId = memberService.join(member);

        //then : 이게 나와야해
        Member findMember = memberService.findOne(saveId).get();
        // Assertions.assertThat(member.getName()).isEqualTo(findMember.getName()); > static import : option + enter
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    // 중복 회원 예외 처리가 잘 되는지 확인이 필요하다
    @Test
    public void 중복_회원_예외(){
        //given
            //1번 회원 이름도 spring
        Member member1 = new Member();
        member1.setName("spring");
            //2번 회원 이름도 spring
        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        /* 방법 1
        try {
            memberService.join(member2);
            // 위 코드가 실행되고 이 다음줄로 내려오면 실패인거임
            fail();
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
        }
        */
        // 방법 2 : 권장
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}