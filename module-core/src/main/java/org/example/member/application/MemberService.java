package org.example.member.application;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.member.domain.Member;
import org.example.member.domain.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  @Transactional
  public void saveAnyMember() {
    memberRepository.save(Member.builder().name("web").build());
  }

  @Transactional
  public Member findAnyMember() {
    return memberRepository.findById(1L).get();
  }
}
