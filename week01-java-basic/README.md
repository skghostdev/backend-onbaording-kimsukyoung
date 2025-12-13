
---

## ✅ `week01-java-basic/README.md`

```markdown
# Week 1 — Java 기초 & 객체지향

## 1. 학습 목표
- 클래스, 객체, 메서드, 생성자 개념을 이해한다.
- 상속/다형성 등 객체지향(OOP)의 기본 개념을 이해한다.
- Java 컬렉션(List, Map)과 Stream 기본 사용법을 익힌다.

---

## 2. 사전 준비
- Week 0 완료
- IntelliJ에서 Java 프로젝트 생성 가능

---

## 3. 과제 설명 (Assignment)

### 3-1. 도메인 만들기
다음 두 도메인을 순수 Java 클래스로 구현한다.

- `User`
  - `id: Long`
  - `name: String`
- `Post`
  - `id: Long`
  - `title: String`
  - `content: String`
  - `author: User` 또는 `authorName: String`

### 3-2. In-Memory CRUD 구현
- `UserRepository`, `PostRepository` 클래스를 만들어 `Map<Long, User>` 형식으로 데이터를 관리한다.
- 최소 기능:
  - 유저 생성, 조회, 목록 조회
  - 게시글 생성, 조회, 목록 조회

### 3-3. Service 계층 추가
- `UserService`, `PostService`를 만들어 Repository를 사용한다.
- 단순한 비즈니스 로직(예: 유저가 없으면 게시글 생성 불가)을 하나 이상 넣어본다.

### 3-4. Main에서 시나리오 실행
- `Main` 클래스를 만들어 다음 흐름을 코드로 실행해 본다.
  1. 유저 생성
  2. 게시글 생성
  3. 전체 게시글 목록 출력

---

## 4. 구현 요구사항
- 모든 CRUD는 **순수 Java 메모리 기반**으로 구현한다 (DB, Spring 사용 X).
- 컬렉션(List, Map) 사용.
- Optional, Stream을 한 번 이상 사용해본다.

---

## 5. 제출 방법
1. `feature/week01-{이름}` 브랜치 생성
2. `week01-java-basic` 폴더에서 작업
3. 커밋 & 푸시
4. PR 생성 (base: develop)
5. PR 본문:
   - 구현한 기능 리스트
   - 실행 결과 또는 콘솔 출력 캡처
   - 어려웠던 점

---

## 6. 자기 점검 체크리스트
- [ ] User/Post 클래스를 직접 설계해보았다.
- [ ] Map 기반 Repository를 구현했다.
- [ ] Service 계층을 추가해보았다.
- [ ] Stream/Optional을 사용해봤다.
- [ ] main 메서드에서 end-to-end 시나리오를 실행해봤다.

---
