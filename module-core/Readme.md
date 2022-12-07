- 공통사용 domain, repository, domain service(트랜잭션 단위)를 작성
- domain service
    - 간단한 어플리케이션의 경우 domain service 없이 어플리케이션 패키지에서 한 개의 service에 @Transactional을 붙이고 사용
    - 하지만, 멀티 모듈로 구성한다는 자체가 이미 어플리케이션이 복잡하다는 의미이고 복잡해지게 된다면 하나의 service가 아니라 여러 개의 domain service를
      조합하여 service를 만들게 될 가능성이 큼
    - 예를들면, 하나의 요청에서 결제와 알림 로직을 동작시켜야 한다면 결제 service와 알림 service가 있을 것이고 각 서비스에 @Transactional이 붙어서
      동작하게 됨. 이게 domain service에 해당하고 이것들을 조합해서 하나의 service를 만들게 됨
- 예시로 Member를 구현한다.
- core 모듈은 실행이 필요 없기 때문에 Application.java가 존재하지 않음