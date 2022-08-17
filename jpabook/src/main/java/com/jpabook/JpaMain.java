package com.jpabook;

import jpabook.start.Board;
import jpabook.start.Member;
import jpabook.start.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member1 = new Member("memberA");
        Member member2 = new Member("memberB");

        Team team = new Team();

        List<Member> members = new ArrayList<>();
        members.add(member1);
        members.add(member2);

        team.setMembers(members);

        em.persist(member1);
        em.persist(member2);
        em.persist(team);

        tx.commit();

        em.close();

    }


}
