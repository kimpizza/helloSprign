package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest // 스프링 컨테이너와 테스트를 함께 실행함
@Transactional // 테스트 시작 전 트랜잭션을 시작하고 테스트 완료 후에 항상 롤백함 DB에 영향 X
class MemberServiceIntegrationTest {
    @Autowired MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

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