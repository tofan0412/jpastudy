package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        // 설정 파일 이름 작성하고 (persistenceUnitName) 팩토리 객체 생성하기
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 쿼리를 날리려면 어떻게 해야할까?
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 영속
            Member findMember = em.find(Member.class, 150L);
            findMember.setName("AAAAA");

            // 준영속 상태로 만들어보자.
            // 더이상 JPA에서 관리하지 않는다. 즉 위에서 업데이트한 내용이 반영되지 않는다.
            em.detach(findMember);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
