# Week 0 — 개발 환경 세팅 & 기본기

## 1. 학습 목표 (Learning Goals)
- Git/GitHub 기본 사용법을 익힌다.
- Java 실행 환경(JDK)과 IDE(IntelliJ)를 세팅한다.
- Docker로 PostgreSQL 컨테이너를 띄워본다.
- HTTP/REST 개념을 아주 기초 수준에서 이해한다.

---

## 2. 사전 준비 (Prerequisites)
- Git 계정 및 GitHub 계정
- JDK 21 설치
- IntelliJ 설치
- Docker Desktop 설치
- Postman 또는 Insomnia 설치

---

## 3. 과제 설명 (Assignment)

### 3-1. Hello Backend 출력
- 순수 Java 프로젝트를 생성한다(Gradle 없이 해도 됨).
- `HelloBackend` 클래스를 만들고 `main` 메서드에서 아래 내용을 출력한다.
    - `"Hello Backend Onboarding!"`

### 3-2. Git/GitHub 연습
- `week00-environment` 폴더에 `HelloBackend.java`를 생성한다.
- 변경사항을 `git add`, `git commit`, `git push` 해본다.
- GitHub에 코드가 잘 올라갔는지 확인한다.

### 3-3. Docker로 PostgreSQL 띄워보기
- Docker Desktop을 실행한다.
- 아래 예시 명령어로 Postgres 컨테이너를 띄운다. (포트/패스워드는 자유롭게 변경 가능)

  ```bash
  docker run --name week00-postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres:15
  
### 3-4. HTTP 요청 보내보기
- Postman 또는 Insomnia로 예를 들어 https://jsonplaceholder.typicode.com/posts/1 에 GET 요청을 보내본다.
- 응답의 Status Code, Header, Body를 확인하고 각각 어떤 의미인지 정리한다.

## 4. 구현 요구사항 (Requirements)
- Java 코드가 정상적으로 컴파일/실행되어야 한다.
- Git commit 메시지는 의미 있게 작성한다. (예: chore: add hello backend main class)
- README에 본인이 실습한 내용과 결과를 간단히 정리한다.

## 5. 제출 방법 (How to Submit)
- feature/week00-{이름} 브랜치 생성
- week00-environment 폴더에서 작업
- 커밋 & 푸시
- GitHub에서 Pull Request 생성
- base: develop
- compare: feature/week00-{이름}
- PR 본문에 아래 내용 포함
- 실습한 내용 간단 요약
- 실행 스크린샷(선택)

## 6. 자기 점검 체크리스트 (Self-check)
- [ ] Git clone / commit / push / PR 생성까지 해봤다.
- [ ] HelloBackend 프로그램을 실행해봤다.
- [ ] Docker로 Postgres 컨테이너를 띄워봤다.
- [ ] Postman/Insomnia로 HTTP GET 요청을 보내봤다.





