# Week 6 — 트랜잭션 / 예외 처리 / 테스트

## 1. 학습 목표
- @Transactional을 적절한 위치에 적용할 수 있다.
- 비즈니스 로직에서 예외를 정의하고 처리할 수 있다.
- 단위 테스트와 통합 테스트를 작성할 수 있다.

---

## 2. 과제 설명: 주문 + 재고 트랜잭션

### 2-1. 도메인 요구사항
- Product: id, name, stockQuantity
- Order: id, product, orderQuantity, status

주문 규칙:
- 재고가 부족하면 주문이 실패해야 한다.
- 주문이 성공하면 재고가 감소해야 한다.
- 실패 시 모든 변경 사항은 롤백되어야 한다.

---

## 3. 구현 요구사항
- `OrderService.placeOrder(productId, quantity)` 메서드 구현
    - `@Transactional` 적용
- 재고 부족 시 `BusinessException` 또는 `CustomException` 던지기
- GlobalExceptionHandler로 예외 처리하여 적절한 HTTP Status 반환
- JUnit + SpringBootTest 기반 통합 테스트 작성

---

## 4. 제출 방법
1. `feature/week06-{이름}` 브랜치 생성
2. 도메인/서비스/컨트롤러 구현
3. 최소 2개 이상의 통합 테스트 작성
4. PR 생성

PR 본문:
- 트랜잭션 경계(Service 기준) 설명
- 실패 케이스(재고 부족) 처리 방식
- 테스트 코드 예시

---

## 5. 자기 점검 체크리스트
- [ ] @Transactional의 기본 동작 방식을 이해했다.
- [ ] 재고 부족 시 예외가 발생하고 롤백되는 것을 확인했다.
- [ ] GlobalExceptionHandler를 통해 에러 응답 형식을 통일했다.
- [ ] 통합 테스트를 작성해 end-to-end로 시나리오를 검증했다.

---
