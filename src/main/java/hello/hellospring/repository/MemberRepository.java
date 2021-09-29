package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    //리포지토리에 4가지 기능을 만들었다

    Member save(Member member); //기능- 회원을 저장하면 저장된 회원이 반환

    Optional<Member> findById(Long id); //만든 id로 회원을 찾는다

    Optional<Member> findByName(String name); //이름으로 회원 찾기

    //Optional 은 자바 8부터 지원하는 클래스. 위의 id나 name을 찾다가 없으면 null로 반환하는데, null을 처리하는 것중 Optional로 감싸서 처리한다.
    //https://mangkyu.tistory.com/70

    List<Member> findAll(); //지금까지 저장된 모든 회원 리스트 반환

    //->구현체를 만들어라

}
