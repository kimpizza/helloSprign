package hello.core.member;

public interface MemberRepository {
    void sava(Member member);

    Member findById(long memberId);
}
