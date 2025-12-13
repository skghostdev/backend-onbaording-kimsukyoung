# Week 3 — JPA 기반 회원 CRUD API

## 1. 학습 목표
- Spring Boot + JPA + PostgreSQL 연동 방법을 익힌다.
- @Entity, @Id, @GeneratedValue 등 기본 매핑을 이해한다.
- JpaRepository를 사용해 CRUD API를 구현한다.

---

## 2. 사전 준비
- Postgres Docker 컨테이너 실행
- `application.yml`에 DB 정보 설정

---

## 3. 과제 설명: 회원 CRUD API

### 3-1. 엔티티 설계
`User` 엔티티를 설계한다.

예시 필드:
- `id: Long`
- `email: String`
- `name: String`

제약사항:
- email은 중복되면 안 된다.

### 3-2. API 요구사항
- 회원 생성: `POST /api/v1/users`
- 회원 단건 조회: `GET /api/v1/users/{id}`
- 회원 목록 조회: `GET /api/v1/users`
- 회원 수정: `PUT /api/v1/users/{id}`
- 회원 삭제: `DELETE /api/v1/users/{id}`

---

## 4. 구현 요구사항
- JpaRepository를 활용하여 CRUD 구현.
- email 중복 시 적절한 예외 처리 및 409 응답.
- DTO를 사용해 엔티티를 직접 노출하지 않도록 한다.
- `@Transactional`의 위치를 고민해 본다 (Service 계층).

---

## 5. 제출 방법
1. `feature/week03-{이름}` 브랜치 생성
2. DB 연결 후 애플리케이션 실행
3. CRUD API 구현 및 테스트
4. PR 생성

PR 본문:
- ERD (간단히 표나 그림)
- 구현 API 목록
- 예외 처리 방식 설명
- 테스트 방법

---

## 6. 자기 점검 체크리스트
- [ ] JPA 엔티티를 직접 작성해봤다.
- [ ] JpaRepository를 사용해 CRUD를 구현했다.
- [ ] email 중복 체크 로직을 구현했다.
- [ ] DTO를 사용해 응답 모델을 분리했다.
- [ ] Postman으로 CRUD 전체 흐름을 테스트했다.

---
