package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
// 만약 테이블 명과 클래스 명이 다르다면
// @Table(name = "USER") 와 같이 추가한다.
public class Member {

    @Id
    private Long id;
    private String name;


    public Member() {
    }

    // 이 생성자만 있으면 오류가 발생한다.
    // 기본 생성자가 반드시 필요하다.
    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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
