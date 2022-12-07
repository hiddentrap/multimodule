package org.example.batch.member.presentation;

import lombok.RequiredArgsConstructor;
import org.example.batch.member.application.BatchFacade;
import org.example.member.domain.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BatchController {

  private final BatchFacade batchFacade;

  @PostMapping("/")
  public void saveAnyMember() {
    batchFacade.saveAnyMember();
  }

  @GetMapping("/")
  public Member getNewMember() {
    return batchFacade.findAnyMember();
  }
}
