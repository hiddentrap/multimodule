package org.example.web.member.presentation;

import lombok.RequiredArgsConstructor;
import org.example.member.domain.Member;
import org.example.web.member.application.WebFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WebController {

  private final WebFacade webFacade;

  @PostMapping("/")
  public void saveAnyMember() {
    webFacade.saveAnyMember();
  }

  @GetMapping("/")
  public Member getNewMember() {
    return webFacade.findAnyMember();
  }
}