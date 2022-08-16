package com.jpabook;

import jpabook.start.Member;
import jpabook.start.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaRelationMapping {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Team team = new Team();
        team.setName("team1");
        em.persist(team);

        Member member1 = new Member();
//        member1.setId("member1"); // 이미 기본키를 직접 할당이 아닌 DB에 의해 할당하기로 약속했으므로, 이와 같이 설정하면 오류가 발생한다.
        // 위와 같이 Member 클래스의 Id 타입을 String으로 하면 오류가 발생한다.
        member1.setUsername("회원1");
        member1.setTeam(team);

        Member member2 = new Member();
//        member2.setId("member2");
        member2.setUsername("회원2");
        member2.setTeam(team);

        em.persist(member1);
        em.persist(member2);

        tx.commit();

        em.close();
    }
}
