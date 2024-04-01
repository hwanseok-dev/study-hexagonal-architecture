# 헥사고날 아키텍처 시리즈 (블로그 포스팅)
- [헥사고날 아키텍처 시리즈 10. 아키텍처에 대해 고민을 해보며 얻은 것들](https://lucky-developer.tistory.com/138)
- [헥사고날 아키텍처 시리즈 9. 주의사항](https://lucky-developer.tistory.com/129)
- [헥사고날 아키텍처 시리즈 8. 영속성 계층에 ORM 적용하기](https://lucky-developer.tistory.com/128)
- [헥사고날 아키텍처 시리즈 7. 테스트](https://lucky-developer.tistory.com/127)
- [헥사고날 아키텍처 시리즈 6. 영속성 계층](https://lucky-developer.tistory.com/126)
- [헥사고날 아키텍처 시리즈 5. 애플리케이션 계층](https://lucky-developer.tistory.com/125)
- [헥사고날 아키텍처 시리즈 4. 패키지 구조](https://lucky-developer.tistory.com/124)
- [헥사고날 아키텍처 시리즈 3. 헥사고날 아키텍처 시작하기](https://lucky-developer.tistory.com/123)
- [헥사고날 아키텍처 시리즈 2. 계층형 아키텍처 극복하기](https://lucky-developer.tistory.com/122)
- [헥사고날 아키텍처 시리즈 1. 계층형 아키텍처의 문제점](https://lucky-developer.tistory.com/121)

# 요구사항

## 유저

- 계정 생성  
  - [x] 유저는 이메일, 닉네임, 비밀번호를 입력해서 회원가입을 할 수 있다
  - [x] 유저의 이메일은 유니크하다 (2023-03-23 토)
- 태그 생성
  - [x] 존재하는 유저에는 태그를 추가할 수 있다. 유저가 생성할 있는 태그의 수는 0~5개이다. 
  - [x] 태그는 각 주제 별 경력을 나타내는 키-값 쌍으로 되어 있다
  - [x] 태그 키는 Java, Javascript 중 하나를 선택해야 한다.
  - [x] 태그 값은 Iron, Bronze, Silver, Gold, Platinum, Diamond, Master, Grand Master, Challenger 중에 하나를 선택해야 한다
    - TODO
      - createdTime, updateTime
      - 애플리케이션 시작할 때 모든 태그 있는지 검증 후 생성
      - 사용자에게 태그 추가 및 삭제 기능
      - 유저를 조회할 때 태그를 함께 조회하도록 수정
