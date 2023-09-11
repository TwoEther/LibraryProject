package org.project.shop.service;

import org.project.shop.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    public Long join(Member member);

    public List<Member> findAllMember();
    public Member findOneMember(Long memberId);

    public Optional<Member> findById(String id);

    public int checkDuplicateMember(String id);

    public boolean checkReqexId(String id);

}
