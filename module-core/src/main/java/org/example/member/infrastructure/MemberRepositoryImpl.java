package org.example.member.infrastructure;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.member.domain.Member;
import org.example.member.domain.MemberRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

  private final MemberJpaRepository memberJpaRepository;


  @Override
  public Member save(Member member) {
    return memberJpaRepository.save(member);
  }

  @Override
  public Optional<Member> findById(Long id) {
    return memberJpaRepository.findById(id);
  }
}
