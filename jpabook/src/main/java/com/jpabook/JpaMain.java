package com.jpabook;

import jpabook.start.Board;
import jpabook.start.Member;

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

        Member member = new Member();
        member.setId("memberA");
        member.setUsername("조웅현");

        Board board = new Board();


        em.persist(member);
        em.persist(board);
        System.out.println("board.id : " + board.getId());


        tx.commit();

        em.close();

    }


}
