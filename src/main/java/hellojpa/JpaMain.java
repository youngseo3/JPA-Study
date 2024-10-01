package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            // CREATE
            Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");

            em.persist(member);

            // READ
            Member findMemeber = em.find(Member.class, 2L);
            System.out.println("findMember.id = " + findMemeber.getId());
            System.out.println("findMember.id = " + findMemeber.getName());

            // UPDATE
            findMemeber.setName("helloJPA");

            // DELETE
            em.remove(member);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
