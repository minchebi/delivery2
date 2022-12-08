# 예제 - 음식배달

본 예제는 MSA/DDD/Event Storming/EDA 를 포괄하는 분석/설계/구현/운영 전단계를 커버하도록 구성한 예제입니다.
이는 클라우드 네이티브 애플리케이션의 개발에 요구되는 체크포인트들을 통과하기 위한 예시 답안을 포함합니다.

# 서비스 시나리오

기능적 요구사항
1. 고객이 메뉴를 선택하여 주문한다.
1. 고객이 선택한 메뉴에 대해 결제한다.
1. 주문이 되면 주문 내역이 입점상점주인에게 주문정보가 전달된다
1. 상점주는 주문을 수락하거나 거절할 수 있다
1. 상점주는 요리시작때와 완료 시점에 시스템에 상태를 입력한다
1. 고객은 아직 요리가 시작되지 않은 주문은 취소할 수 있다
1. 요리가 완료되면 고객의 지역 인근의 라이더들에 의해 배송건 조회가 가능하다
1. 라이더가 해당 요리를 Pick한 후, 앱을 통해 통보한다.
1. 고객이 주문상태를 중간중간 조회한다
1. 주문상태가 바뀔 때 마다 카톡으로 알림을 보낸다
1. 고객이 요리를 배달 받으면 배송확인 버튼을 탭하여, 모든 거래가 완료된다
1. 고객이 딜리버리를 취소하여 주문이 취소된다.(추가)
1. 딜리버리가 취소되고 결제가 취소된다.(추가)


비기능적 요구사항
1. 장애격리
    1. 상점관리 기능이 수행되지 않더라도 주문은 365일 24시간 받을 수 있어야 한다  Async (event-driven), Eventual Consistency
    1. 결제시스템이 과중되면 사용자를 잠시동안 받지 않고 결제를 잠시후에 하도록 유도한다  Circuit breaker, fallback
1. 성능
    1. 고객이 자주 상점관리에서 확인할 수 있는 배달상태를 주문시스템(프론트엔드)에서 확인할 수 있어야 한다  CQRS
    1. 배달상태가 바뀔때마다 카톡 등으로 알림을 줄 수 있어야 한다  Event driven


## Model
![전체](https://user-images.githubusercontent.com/119826162/206376136-81fa3d72-c682-4216-a626-16a9971c48a4.PNG)


요구사항을 커버하는지 검증

![원본](https://user-images.githubusercontent.com/119826162/206376610-7eb6cffe-bb8c-41b9-b0ef-d7509225520c.PNG)
    
    - 고객이 메뉴를 선택하여 주문한다. (ok)
    - 고객이 선택한 메뉴에 대해 결제한다. (ok)
    - 주문이 되면 주문 내역이 입점상점주인에게 주문정보가 전달된다 (ok)
    - 상점주는 주문을 수락하거나 거절할 수 있다 (ok)
    - 상점주는 요리시작때와 완료 시점에 시스템에 상태를 입력한다 (ok)
    - 요리가 완료되면 고객의 지역 인근의 라이더들에 의해 배송건 조회가 가능하다 (ok)
    - 주문상태가 바뀔 때 마다 카톡으로 알림을 보낸다 (ok)
    - 라이더가 해당 요리를 Pick한 후, 앱을 통해 통보한다. (ok)
    - 고객은 아직 요리가 시작되지 않은 주문은 취소할 수 있다 (ok)
    - 고객이 주문상태를 중간중간 조회한다 (ok)
    - 고객이 요리를 배달 받으면 배송확인 버튼을 탭하여, 모든 거래가 완료된다 (ok)
  
  추가 요구사항
  
  ![딜리버리캔슬](https://user-images.githubusercontent.com/119826162/206377436-2a1694db-1c01-478d-90b3-60a7d1182fa2.PNG)

    - 고객이 딜리버리를 취소하여 주문이 취소된다.(ok)
    - 딜리버리가 취소되고 결제가 취소된다.(ok)

# 체크포인트
## 1. Saga(Pub/Sub)
order로 post 요청을 보내면 OrderPlaced에서 pay에 있는 pay커맨드로 요청을 전달한다.(req/res : 동기)
그 후에 pay에서 Paid이벤트를 거쳐 store에 있는 accept정책으로 이벤트를 전달한다.(Pub/Sub : 비동기)

<요청>
![saga_pub](https://user-images.githubusercontent.com/119826162/206371811-dcdb1cae-e9e5-46b5-98bd-f59a0f109799.PNG)

<결과>
![saga_sub](https://user-images.githubusercontent.com/119826162/206372826-35ba49ae-6eca-47de-950b-be5ff13d4311.PNG)

## 2. CQRS 
읽기 모델을 분리한다.
- app -> MypageViewHandler.java에서 이벤트에 따라 Real Model 저장, 업데이트, 삭제를 정의한다. 

![cqrs](https://user-images.githubusercontent.com/119826162/206373631-854af5b7-d29f-486b-8978-b1f9745ca067.PNG)

## 3. Compensation / Correlation

## 4. Request / Response

![request-response](https://user-images.githubusercontent.com/119826162/206374373-3b5c1244-b086-44ee-b48d-9c6ff01ae6c1.PNG)

## 5. Circuit Breaker

## 6. Gateway / Ingress
gateway의 라우터 설정으로 :8081/orders 요청과 :8088/orders 요청이 같은 서비스를 제공한다.


![gateway](https://user-images.githubusercontent.com/119826162/206375408-22029e12-8c53-4692-a661-378ffbb05278.PNG)
<application.yml>


![8081](https://user-images.githubusercontent.com/119826162/206375468-8c8afb4b-bf5a-4fff-8610-9db668b289e5.PNG)
<8081>

![8088](https://user-images.githubusercontent.com/119826162/206375506-ab2f4126-c219-46c5-8be6-9292fadbd74e.PNG)
<8088>



