package hello.hellospring.domain;

public class Member {


    private Long id; //임의의 id값- 고객이 정하는 것이 아닌 데이터를 구분하기 위해서 시스템이 저장하는 id값(시스템이 저장해서 중복이 없는 유일한 기본키)
    private String name; //그냥 이름(중복 가능성 있다)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
