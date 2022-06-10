package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
// 만약 테이블 명과 클래스 명이 다르다면
// @Table(name = "USER") 와 같이 추가한다.
public class Member {
    @Id
    private Long id;
    @Column(name = "name", nullable = false) // DB에 들어갈 컬럼명은 name이다.
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING) // 객체에서 enum타입을 쓰려고 하는 경우, DB에는 이넘 타입이 없다. 이 경우 @Enumerated라는 걸 쓰면 된다.
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP) // DB의 경우 날짜, 시간, 날짜+시간을 구분해서 사용하기 때문에 애노테이션으로 명시
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob // VARCHAR가 허용하는 데이터 크기를 초과할 거 같은 경우에 쓴다.
    private String description;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
