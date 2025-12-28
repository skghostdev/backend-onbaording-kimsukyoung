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

---

- java에서의 생성자 조건: 클래스 이름과 이름이 같다. 반환 타입이 없다.
- 일반적인 자바 관례  + 외부 패키지에서의 사용을 위해 도메인 클래스는 public으로 선언
- 외부에서 직접 변경하는 것을 프로퍼티들은 private, 수정 및 조회할 수 있는 메서드 제공
- User의 id 생성은 repository의 역할
    - Domain은 객체의 상태를 표현, Repository는 저장소
    - `Domain은 Repository를 모르지만`, `Repository는 Domain을 안다.`
    - ⁉️ - Domain은 객체의 상태를 표현하는 역할만 하기 때문에 id값은 Repository가 생성 및 관리한다!
    - ⁉️ - Domain의 getId는 객체를 조회하는 것이 아니라 이미 존재하는 객체의 상태를 읽어 오는 것이고, Reposiroty의 findById(id)는 저장소에서 id를 키로 객체 자체를 가져온다.
- Package: 클래스를 묶는 논리적인 `네임스페이스(이름 충돌 방지)`이자 `접근 제어`의 기준 단위
    - package week01.domain; / package week01.repository;
    - package는 개발자가 선언하는 것, 폴더와 패키지는 같은 의미는 아니지만 관례적으로 선언을 일치시킴
    - 같은 패키지는 default 접근이 가능하다.


### 3-2. In-Memory CRUD 구현

- `UserRepository`, `PostRepository` 클래스를 만들어 `Map<Long, User>` 형식으로 데이터를 관리한다.
- 최소 기능:
    - 유저 생성, 조회, 목록 조회
    - 게시글 생성, 조회, 목록 조회


### 3-3. Service 계층 추가

- `UserService`, `PostService`를 만들어 Repository를 사용한다.
- 단순한 비즈니스 로직(예: 유저가 없으면 게시글 생성 불가)을 하나 이상 넣어본다.

---

- UserService
    - 이름 유효성 금지
    - 중복 이름 금지
    - 위의 케이스에 해당되는 경우 `throw new IllegalArgumentException();`
        - 생성자에서도 throw를 할 수 있고, 시그니처에 throw를 명시하지 않아도 됨(Unchecked Exception)
            - Unchecked Exception: IllegalArgumentException, NullPointerException, IllegalStateException
            - Checked Exception: IOExcetion, SQLException
- PostService
    - title, content 공백 불가
    - 유저 없으면 게시글 생성 불가
- `Stream`: 컬렉션(List, Set 등)의 데이터를 하나씩 흘려보내면서 처리하기 위한 데이터 파이프라인
    - 데이터를 저장하지 않고, 가공/판단만 한다. 반복문을 대체하는 도구
    - `데이터를 흐름(stream)`으로 만들어 연속적인 연산을 적용하기 위한 API
    - swift에서 가장 가까운 개념으로는 lazy: 지금 당장 실행하지 말고 뒤에 붙는 연산이 있을 때만 실행
        - stream().anyMatch == contain { 조건 }
    
    ```java
    // 반복문
    boolean exists = false;
    for (User u : users) {
        if (u.getName().equalsIgnoreCase(name)) {
            exists = true;
            break;
        }
    }
    
    // Stream 방식
    boolean exists = users.stream()
            .anyMatch(u -> u.getName().equals(name));
    ```
    

### 3-4. Main에서 시나리오 실행

- `Main` 클래스를 만들어 다음 흐름을 코드로 실행해 본다.
    1. 유저 생성
    2. 게시글 생성
    3. 전체 게시글 목록 출력

<img width="853" height="795" alt="image" src="https://github.com/user-attachments/assets/5ac89b49-2cad-4edb-9add-c7c08e13d3bb" />
<img width="854" height="372" alt="image" src="https://github.com/user-attachments/assets/f4989491-1af2-4683-b31f-7983231d98a7" />


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

- [x]  User/Post 클래스를 직접 설계해보았다.
- [x]  Map 기반 Repository를 구현했다.
- [x]  Service 계층을 추가해보았다.
- [x]  Stream/Optional을 사용해봤다.
- [x]  main 메서드에서 end-to-end 시나리오를 실행해봤다.

---
