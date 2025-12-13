# Week 5 — QueryDSL & 고급 조회

## 1. 학습 목표
- QueryDSL 환경 구성 방법을 익힌다.
- 동적 검색 조건을 작성할 수 있다.
- 페이징 처리와 정렬을 구현한다.

---

## 2. 과제 설명: 게시글 검색 API

### 2-1. 검색 조건
다음 조건을 조합하여 게시글을 검색하는 API를 구현한다.

- 제목(title) 키워드 검색
- 작성자 이름(authorName) 검색
- 작성일(createdAt) 기간 검색 (예: from ~ to)

### 2-2. API 예시
`GET /api/v1/posts/search?title=...&authorName=...&from=...&to=...&page=0&size=10`

응답은 Page 형태로 반환한다.

---

## 3. 구현 요구사항
- QueryDSL 설정(build.gradle + QClass 생성) 완료.
- `PostRepositoryCustom`, `PostRepositoryImpl` 생성하여 검색 로직 분리.
- 동적 조건은 BooleanBuilder 또는 where 다중 파라미터 방식 사용.
- N+1 문제가 생기지 않도록 fetch join 고려.

---

## 4. 제출 방법
1. `feature/week05-{이름}` 브랜치 생성
2. QueryDSL 설정
3. 검색 API 구현
4. PR 생성

PR 본문:
- 검색 조건 설명
- QueryDSL 코드 일부
- N+1 문제 여부 및 해결 방식

---

## 5. 자기 점검 체크리스트
- [ ] QueryDSL로 동적 쿼리를 작성했다.
- [ ] BooleanBuilder 또는 Predicate를 직접 사용해봤다.
- [ ] Page<T> 기반 페이징 API를 만들었다.
- [ ] N+1 문제를 인지하고 해결해보려 시도했다.

---
