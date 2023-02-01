package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
    //테스트 종료시마다 저장소를 비워줌
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }
    @Test
    public void save() {
        Member member = new Member();
        member.setName("Spring");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        // 방법 1 : Assertions.assertEquals(member, result);
        // 방법 2 :
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        Member result = repository.findByName("Spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findALL() {
        Member member1 = new Member();
        member1.setName("Spring");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
