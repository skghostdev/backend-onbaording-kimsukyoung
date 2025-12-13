## Backend Onboarding Program

Spring Boot 기반 백엔드 온보딩 프로그램 (8주 과정)

본 레포지토리는 백엔드 신입 개발자가 8주 동안 실무 수준의 Spring Boot 백엔드 역량을 갖추도록 설계된 온보딩용 저장소입니다.
주차별 실습 → GitHub 기반 코드 제출 → 코드 리뷰 개선
이라는 기업 실무형 학습 방식을 따릅니다.

> 이 레포지토리는 "Template Repository"입니다.  
> 직접 clone하거나 PR을 보내지 마세요.  
> 신입 개발자는 이 템플릿을 기반으로 "본인 GitHub 계정에 새로운 레포지토리"를 생성한 뒤 작업을 진행합니다.  
> (GitHub: Use this template → Create a new repository)

## 1. 온보딩 개요
### 1.1 목적

본 온보딩 프로그램의 최종 목표는 다음과 같습니다:

1. Spring Boot 기반 REST API를 설계하고 구현할 수 있다.
2. JPA + QueryDSL 기반 데이터 모델링 및 조회 기능을 구현할 수 있다.
3. 트랜잭션/예외처리/테스트를 통해 안정적인 백엔드 로직을 만든다.
4. 실전 서비스(주문·결제)를 스스로 설계하고 구현한다.
5. GitHub Flow 기반 협업(Git + PR + 코드리뷰)을 익숙하게 수행한다.

## 2. 레포지토리 구조
  ```bash
backend-onboarding-spring/
│
├── week00-environment/          # Java/Git/Docker 기본기
├── week01-java-basic/           # Java OOP & In-Memory CRUD
├── week02-spring-core/          # Spring Boot Core & REST
├── week03-jpa-crud/             # JPA 기반 CRUD API
├── week04-jpa-relations/        # JPA 연관관계 매핑
├── week05-querydsl/             # QueryDSL 기반 검색
├── week06-transaction-test/     # 트랜잭션 & 예외 처리 & 테스트
└── project-final/               # 실전 프로젝트(주문/결제 시스템)
  ```
각 주차별 폴더에는 독립된 실습용 프로젝트가 포함되어 있으며,
각 폴더 안의 README.md에 주차별 과제 내용이 상세히 정의되어 있습니다.



## 3. 전체 커리큘럼 로드맵 (8주)
| 주차       | 주제               | 주요 학습 내용                               | 산출물                         |
|------------|--------------------|-----------------------------------------------|--------------------------------|
| Week 0     | 개발 환경 세팅     | Git, JDK, Docker, HTTP 기본기                 | Hello Backend 실행 & Docker DB |
| Week 1     | Java 기초          | OOP, Stream, 컬렉션                           | Java CRUD 프로그램             |
| Week 2     | Spring Core        | IoC/DI, REST API                              | Memo API (In-Memory)           |
| Week 3     | JPA CRUD           | Entity, Repository, JPA 기본 CRUD             | 회원 CRUD API                  |
| Week 4     | 연관관계           | 1:N, N:1 매핑, Lazy Loading                   | 회원–게시글 모델               |
| Week 5     | QueryDSL           | 동적 검색, 페이징, fetch join                 | 게시글 검색 API                |
| Week 6     | 트랜잭션/테스트     | 재고/주문 트랜잭션, 예외 처리, 테스트        | 주문/재고 트랜잭션 코드        |
| Week 7~8   | 실전 프로젝트       | 주문/결제 시스템 전체 구현                   | Final Project                  |


## 4. 개발 환경 요구사항
### 4.1 필수 설치 요소
- JDK 21
- IntelliJ IDEA Ultimate (권장)
- Docker Desktop
- Postman 또는 Insomnia
- Git CLI

### 4.2 기술 스택
- Java 21
- Spring Boot 3.x
- Spring Web / Spring Data JPA
- QueryDSL
- PostgreSQL
- Spring Test / JUnit5
- Gradle


## 5. Git Workflow (브랜치 전략)
### 5.1 브랜치 구조
  ```bash
# 템플릿 Repo는 main 하나만 존재하며 변경하지 않습니다.

# 신입 개인 Repo에서는 다음 브랜치 전략을 사용합니다:

main           # 기본 브랜치 (온보딩 결과물)
develop        # 매주 실습 코드 병합 대상
feature/*      # 각 주차별 실습 작업 브랜치
  ```

### 5.2 브랜치 네이밍 규칙
  ```bash
feature/week02-홍길동
feature/week05-search-홍길동
  ```


## 6. 과제 제출 방식 (모든 주차 공통)
### 6.1 제출 절차
1) 개인 온보딩 레포 생성  
회사 템플릿 Repo에서 **Use this template**을 눌러  
본인 GitHub 계정에 `backend-onboarding-{이름}` 레포를 생성합니다.

# 생성된 나의 개인 온보딩 레포를 클론합니다.
  ```bash
git clone git@github.com:{본인계정}/backend-onboarding-{이름}.git
  ```

2) 해당 주차 폴더 이동
  ```bash
cd week03-jpa-crud
  ```

3) 작업 브랜치 생성
```bash
git checkout -b feature/week03-홍길동
```

4) 코드 작성 후 커밋 & 푸시
```bash
git add .
git commit -m "feat: implement user CRUD for week03"
git push origin feature/week03-홍길동
```

5) GitHub에서 PR 생성
```markdown
# 반드시 "본인 개인 Repo"에서 PR을 생성해야 합니다.
# (회사 템플릿 Repo로 절대 PR을 보내지 않습니다.)

main       # 기본 브랜치 (최종 결과물)
develop    # 매주 실습 코드 병합 대상
feature/*  # 실습 작업 브랜치
```

6) 리뷰 반영 → 승인 → merge

## 7. Pull Request 템플릿
PR 본문에는 아래 항목을 포함합니다:
```bash
# 구현 내용
- (예: 회원 생성 API 구현)
- (예: email 중복 예외 처리 추가)

# 테스트 방법
- Postman 캡처 또는 curl 명령어
- 통합 테스트 실행 결과 로그

# ERD/구조 변경
- (있다면)

# 어려웠던 점
- (예: 지연 로딩 발생 시점 헷갈림)

# 비고
```

## 8. 코드 리뷰 프로세스
### 8.1 리뷰 흐름
1. 신입 → 자신의 Repo에서 PR 생성
2. 멘토/리드 → 해당 PR에 리뷰 작성
3. 신입 → 리뷰 반영 후 커밋
4. 멘토/리드 → 승인
5. (본인 Repo의) develop 브랜치로 merge

### 8.2 리뷰 기준
아키텍처
- Controller / Service / Repository 역할 분리
- 계층 간 책임 명확성

JPA
- 연관관계 주인 설정 적절성
- LAZY 우선 적용
- N+1 발생 여부

트랜잭션
- @Transactional 적용 위치
- 롤백 정책

예외 처리
- ErrorCode 정의
- GlobalExceptionHandler 일관성

QueryDSL
- 동적 조건 가독성
- fetch join 적절성

테스트
- Given-When-Then 패턴
- 성공/실패 케이스 포함


## 9. 주차별 README 안내
각 주차별 폴더에는 아래 항목이 포함된 README.md가 있습니다:
- 학습 목표
- 실습 과제 설명
- 구현 요구사항
- 제출 방법
- 체크리스트
주차별 README는 해당 주차의 필수 가이드입니다.

## 10. Final Project 안내
최종 2주 동안 수행하는 실전 프로젝트입니다.

### 10.1 구현 목표
- 회원 / 상품 / 주문 / 결제 도메인 구현
- JWT 인증/인가
- 재고 감소 트랜잭션
- QueryDSL 기반 검색
- 예외 처리 일원화
- 통합 테스트 작성

### 10.2 제출물
- 전체 코드
- ERD
- API 문서
- 테스트 로그
- 설계 문서
- 회고(1~2페이지)
