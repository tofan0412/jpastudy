package jpabook.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        // 설정 파일 이름 작성하고 (persistenceUnitName) 팩토리 객체 생성하기
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashop");

        // 쿼리를 날리려면 어떻게 해야할까?
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
