package org.project.shop.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.project.shop.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.project.shop.domain.QMember.member;

@Repository
public class MemberRepositoryImpl implements MemberRepository{
    @PersistenceContext
    private EntityManager em;

    private final JPAQueryFactory queryFactory;

    public MemberRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public void save(Member member) {
        em.persist(member);
    }

    @Override
    public void clear() {
        queryFactory.delete(member).execute();
    }

    @Override
    public Member findMember(Long id) {
        return queryFactory.select(member)
                .from(member)
                .where(member.id.eq(id))
                .fetchOne();
    }

    @Override
    public List<Member> findAllMember(){
        return queryFactory.select(member)
                .from(member)
                .fetch();
    }

    @Override
    public void mergeMember(Member member) {
        em.merge(member);
    }

    @Override
    public Member findById(Long id) {
        return queryFactory.select(member)
                .from(member)
                .where(member.id.eq(id))
                .fetchOne();
    }

    @Override
    public Member findByName(String userName) {
        return null;
    }


    @Override
    public Member findByUserId(String userId) {
        return queryFactory.select(member)
                .from(member)
                .where(member.userId.like(userId))
                .fetchOne();
    }

    @Override
    public String findMemberIdByEmailAndPhoneNum(String email, String phoneNum) {
        return queryFactory.select(member.userId)
                .from(member)
                .where(member.email.eq(email).and(
                        member.phoneNum.eq(phoneNum)
                )).fetchOne();

    }

    public Member findById(String userId) {
        return queryFactory.select(member)
                .from(member)
                .where(member.userId.eq(userId))
                .fetchOne();
    }
}
