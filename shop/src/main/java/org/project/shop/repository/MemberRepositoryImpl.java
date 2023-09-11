package org.project.shop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.project.shop.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepositoryImpl implements MemberRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Member member) {
        em.persist(member);
        em.flush();
    }

    @Override
    public Member findMember(Long id) {
        return em.find(Member.class, id);
    }

    @Override
    public List<Member> findAllMember(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }


    @Override
    public Optional<Member> findById(String user_id) {
        Optional<Member> member = Optional.empty();
        try {
             member = Optional.ofNullable(em.createQuery("select m from Member m where m.user_id = :user_id", Member.class)
                    .setParameter("user_id", user_id)
                    .getSingleResult());
        } catch (NoResultException e) {
            member = Optional.empty();
        }finally {
        }
        System.out.println("member.toString() = " + member.toString());
        return member;

    }

}
