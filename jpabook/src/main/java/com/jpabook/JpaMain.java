package com.jpabook;

import jpabook.start.Board;
import jpabook.start.Member;
import jpabook.start.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Team team1 = new Team();
        Team team2 = new Team();
        Team team3 = new Team();

        team1.setName("team1");
        team2.setName("team2");
        team3.setName("team3");

        Member member1 = new Member("memberA");
        member1.setTeam(team1);

        Member member2 = new Member("memberB");
        member2.setTeam(team1);

        Member member3 = new Member("memberC");

        em.persist(team1);
        em.persist(team2);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);

        tx.commit();

        em.close();

    }


}
