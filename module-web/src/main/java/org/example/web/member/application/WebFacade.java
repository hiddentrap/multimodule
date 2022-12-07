package org.example.web.member.application;

import lombok.RequiredArgsConstructor;
import org.example.member.application.MemberService;
import org.example.member.domain.Member;
import org.springframework.stereotype.Service;

/**
 * 지금은 간단해서 하나씩만 있지만 복잡해지게 되면
 * 여러 domain service 모듈을 조합하여 로직 작성
 * domain core 모듈에서 domain-service를 트랜잭션 단위로 정의 했음
 * 따라서, 사용하는 최종 애플리케이션 모듈에서는 domain-service를 조합하여 service를 만들어줌
 */

@Service
@RequiredArgsConstructor
public class WebFacade {

  private final MemberService memberService;

  public void saveAnyMember() {
    memberService.saveAnyMember();
  }

  public Member findAnyMember() {
    return memberService.findAnyMember();
  }
}
