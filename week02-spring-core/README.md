# Week 2 — Spring Boot Core & REST 기본기

## 1. 학습 목표
- Spring Boot 프로젝트 생성 및 실행 방법을 익힌다.
- @SpringBootApplication, Bean, DI 개념을 이해한다.
- @RestController 기반으로 간단한 REST API를 만든다.
- 아직 DB 없이 In-Memory 데이터 구조로만 API를 구현한다.

---

## 2. 사전 준비
- IntelliJ에서 Spring Boot 프로젝트 생성 가능
- Java 21 / Spring Boot 3.x

---

## 3. 과제 설명: 메모장 API (In-Memory)

### 3-1. 기능 요구사항
간단한 메모장을 관리하는 API를 구현한다.

- 메모 생성: `POST /api/v1/memos`
- 메모 단건 조회: `GET /api/v1/memos/{id}`
- 메모 전체 조회: `GET /api/v1/memos`
- 메모 삭제: `DELETE /api/v1/memos/{id}`

데이터 저장은 **HashMap 또는 ConcurrentHashMap** 사용 (DB X).

### 3-2. 계층 구조
- `MemoController`
- `MemoService`
- (선택) `MemoRepository` (In-Memory)

---

## 4. 구현 요구사항
- `@RestController`와 `@RequestMapping`을 사용한다.
- `@PostMapping`, `@GetMapping`, `@DeleteMapping` 사용.
- 간단한 요청/응답 DTO를 설계해서 사용해도 좋다.
- 예외가 발생했을 때 기본적인 에러 응답을 내려준다.
    - 예: 존재하지 않는 메모 조회 시 404

---

## 5. 제출 방법
1. `feature/week02-{이름}` 브랜치 생성
2. `week02-spring-core` 프로젝트 실행 확인
3. 메모 API 구현
4. Postman으로 API 호출 테스트 후 스크린샷 첨부
5. PR 생성

PR 본문:
- 구현한 엔드포인트 목록
- 테스트 방법 (예: Postman 스크린샷 or curl 명령어)
- 이번 주 배운 내용 한 줄 요약

---

## 6. 자기 점검 체크리스트
- [ ] Spring Boot 애플리케이션을 직접 실행해봤다.
- [ ] @RestController, @Service를 사용해봤다.
- [ ] In-Memory Map으로 데이터를 관리하는 API를 만들었다.
- [ ] Postman으로 직접 API를 호출해봤다.
- [ ] 존재하지 않는 리소스에 대한 예외 처리를 해봤다.

---
