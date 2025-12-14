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
<img width="1750" height="1112" alt="image" src="https://github.com/user-attachments/assets/d6ec297a-04e5-4603-96a3-c2adc2a19b4c" />

### 3-2. Git/GitHub 연습
- `week00-environment` 폴더에 `HelloBackend.java`를 생성한다.
- 변경사항을 `git add`, `git commit`, `git push` 해본다.
- GitHub에 코드가 잘 올라갔는지 확인한다.
<img width="1196" height="345" alt="image" src="https://github.com/user-attachments/assets/a3011263-57db-4175-88f2-485d182bfbef" />

### 3-3. Docker로 PostgreSQL 띄워보기
- Docker Desktop을 실행한다.
- 아래 예시 명령어로 Postgres 컨테이너를 띄운다. (포트/패스워드는 자유롭게 변경 가능)

  ```bash
  docker run --name week00-postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres:15
  <img width="1019" height="655" alt="image" src="https://github.com/user-attachments/assets/8b569487-df0d-4eb1-9e23-37653945e243" />

### 3-4. HTTP 요청 보내보기
- Postman 또는 Insomnia로 예를 들어 https://jsonplaceholder.typicode.com/posts/1 에 GET 요청을 보내본다.
- 응답의 Status Code, Header, Body를 확인하고 각각 어떤 의미인지 정리한다.
<img width="1509" height="1014" alt="image" src="https://github.com/user-attachments/assets/e2d1fc4b-3ff6-410a-ad5e-7dbe2fa85039" />

### 3-4-1. 응답

#### Status Code: 200 OK
- `HTTP Status Code` : 서버가 클라이언트의 요청을 어떻게 처리했는지 알려주는 숫자 코드
- `Status Code의 분류`
    - **2xx - 성공(Success): 요청이 정상적으로 처리됨**
        - `200 OK`: 가장 일반적인 성공 응답
        - `201 Created` : 리소스 생성 성공(POST 요청에서 자주 사용)
        - `204 No Content` : 성공했지만 응답 바디가 없음
    - **4xx - 클라이언트 오류(Client Error): 요청 자체에 문제가 있음**
        - `400 Bad Request` : 요청 형식이 잘못됨
        - `401 Unauthorized` : 인증 정보 필요
        - `403 Forbidden` : 권한 없음
        - `404 Not Found` : 요청한 리소스가 존재하지 않음
    - **5xx - 서버 오류(Server Error): 요청은 맞지만 서버 내부 문제로 처리 실패**
        - `500 Internal Server Error` : 서버 코드 에러
        - `502 Bad Gateway` : 중간 서버 문제
        - `503 Service Unavailable` : 서버가 일시적으로 사용 불가
    - 1xx: 처리 중 정보 응답
    - 3xx: 리다이렉션
#### Header
- `HTTP Header` : 요청이나 응답에 대한 부가 정보(메타데이터)를 담는 영역으로, 클라이언트가 응답 데이터를 어떻게 처리할지 결정하는 역할
- `메타데이터 종류`
    - Content-Type
        - `Content-Type: application/json; charset=utf-8` 
        : 응답 Body가 JSON 형식이며, UTF-8 인코딩임을 의미
        - 응답 Body의 데이터 타입을 명시하는 헤더(= Body를 어떤 형식으로 해석해야 하는지)
    - Cache-Control
        - `Cache-Control: max-age=43200` 
        : 이 응답을 43200초(12시간) 동안 다시 요청하지 말고 재사용해도 됨을 의미
        - 응답을 캐시해도 되는지와 캐시 유효 시간을 정의하는 헤더
    - ETag
        - `ETag: W/"124-yiKdLzqO5gfBrJFrcdJ8Yq0LGnU"` 
        : 응답 리소스의 버전을 식별하기 위한 값
        - 리소스 변경 여부를 판단하기 위한 식별자 헤더
    - **Content-Encoding**
        - `Content-Encoding: br` 
        : 응답 Body가 Brotli 방식으로 압축되어 전송되었음을 의미
        - 응답 데이터의 압축 방식을 명시하는 헤더
    - **Connection**
        - `Connection: keep-alive` 
        : 요청-응답 이후에도 TCP 연결을 유지함을 의미
        - 클라이언트와 서버 간 연결 유지 방식을 제어하는 헤더
    - **x-ratelimit-limit / x-ratelimit-remaining / x-ratelimit-reset**
        - `x-ratelimit-limit: 1000`    
            : 허용된 최대 요청 횟수
        - `x-ratelimit-remaining: 999`
            : 현재 남아 있는 요청 가능 횟수
        - `x-ratelimit-reset: 1751571733`
            : 요청 제한이 초기화되는 시각(Epoch Time)
        - API 요청 횟수 제한 정책을 전달하기 위한 헤더
#### Body
- `HTTP Response Body` : 서버가 클라이언트에게 실제로 전달하고 싶은 데이터
- 특징: `Key-Value 구조`, `타입 명확,`


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





