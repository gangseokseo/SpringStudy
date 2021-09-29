package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository { // MemoryMemberRepository 는 MemberRepository 인터페이스를 구현한 구현체

    //키- Long 값 -Member ,store -객체
    //save할때 메모리 저장 -> Map사용(데이터 저장위해서)
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //시퀀스란 - 0,1,2 키값을 생성하는것

    @Override
    public Member save(Member member) { //회원 save하니 저장할 곳이 필요
        member.setId(++sequence); //시퀀스 값 올려주기 //stor저장하기 전에 id값 세팅(setId) //이름 name은 넘어온상태
        store.put(member.getId(), member);//-> store에 저장 ->위의 Map에 저장
        return member; // 스펙에 따라서 저장된 결과 반환

        //관련 구조 공부 ->노션 참고 스프링입문 2(회원관리)
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //store객체 에서 꺼낸다  -> 결과가 없으면 null 반환 .
        // ->Optional.ofNullable 로 null이어도 감싸서 반환하면 클라이언트가 이용가능
    }

//람다식

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()//람다식. loop로 돌린다
                .filter(member -> member.getName().equals(name)) //member객체의 getName이 파라미터로 넘어온 findByName 매개변수로 받은 name가 같는지 확인해라 ->같으면 필터링
                .findAny(); //Map에서 1개라도 찾으면 반환해라, 없으면 Optional에 null포함되서 반환

        //filter 메서드는 컬렉션을 조건에 의한 선택을 할때 유용하다. filter 메서드는
        //boolean 결과를 리턴하는 람다표현식이 필요하다.
        //출처: https://sehoonoverflow.tistory.com/26 [세훈오버플로우]

    }

    //Map인데 List로 반환
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //store에 있는 멤버들

    }
}
