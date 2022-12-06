package mymall.infra;

import mymall.domain.*;
import mymall.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MypageViewHandler {

    @Autowired
    private MypageRepository mypageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1 (@Payload OrderPlaced orderPlaced) {
        try {

            if (!orderPlaced.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
            mypage.setId(Long.valueOf(orderPlaced.getOrderId()));
            mypage.setStatus("주문접수됨");
            // view 레파지 토리에 save
            mypageRepository.save(mypage);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderAcepted_then_UPDATE_1(@Payload OrderAcepted orderAcepted) {
        try {
            if (!orderAcepted.validate()) return;
                // view 객체 조회
            Optional<Mypage> mypageOptional = mypageRepository.findById(Long.valueOf(orderAcepted.getOrderId()));

            if( mypageOptional.isPresent()) {
                 Mypage mypage = mypageOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                mypage.setStatus("1");    
                // view 레파지 토리에 save
                 mypageRepository.save(mypage);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaid_then_UPDATE_2(@Payload Paid paid) {
        try {
            if (!paid.validate()) return;
                // view 객체 조회
            Optional<Mypage> mypageOptional = mypageRepository.findById(Long.valueOf(paid.getOrderId()));

            if( mypageOptional.isPresent()) {
                 Mypage mypage = mypageOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                mypage.setStatus("지불됨");    
                // view 레파지 토리에 save
                 mypageRepository.save(mypage);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderAcepted_then_UPDATE_3(@Payload OrderAcepted orderAcepted) {
        try {
            if (!orderAcepted.validate()) return;
                // view 객체 조회
            Optional<Mypage> mypageOptional = mypageRepository.findById(Long.valueOf(orderAcepted.getOrderId()));

            if( mypageOptional.isPresent()) {
                 Mypage mypage = mypageOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                mypage.setStatus("오더 수락됨");    
                // view 레파지 토리에 save
                 mypageRepository.save(mypage);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderRejected_then_UPDATE_4(@Payload OrderRejected orderRejected) {
        try {
            if (!orderRejected.validate()) return;
                // view 객체 조회
            Optional<Mypage> mypageOptional = mypageRepository.findById(Long.valueOf(orderRejected.getOrderId()));

            if( mypageOptional.isPresent()) {
                 Mypage mypage = mypageOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                mypage.setStatus("오더 거절됨");    
                // view 레파지 토리에 save
                 mypageRepository.save(mypage);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookStarted_then_UPDATE_5(@Payload CookStarted cookStarted) {
        try {
            if (!cookStarted.validate()) return;
                // view 객체 조회
            Optional<Mypage> mypageOptional = mypageRepository.findById(Long.valueOf(cookStarted.getOrderId()));

            if( mypageOptional.isPresent()) {
                 Mypage mypage = mypageOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                mypage.setStatus("요리 시작");    
                // view 레파지 토리에 save
                 mypageRepository.save(mypage);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookFinished_then_UPDATE_6(@Payload CookFinished cookFinished) {
        try {
            if (!cookFinished.validate()) return;
                // view 객체 조회
            Optional<Mypage> mypageOptional = mypageRepository.findById(Long.valueOf(cookFinished.getOrderId()));

            if( mypageOptional.isPresent()) {
                 Mypage mypage = mypageOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                mypage.setStatus("요리 끝");    
                // view 레파지 토리에 save
                 mypageRepository.save(mypage);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPicked_then_UPDATE_7(@Payload Picked picked) {
        try {
            if (!picked.validate()) return;
                // view 객체 조회
            Optional<Mypage> mypageOptional = mypageRepository.findById(Long.valueOf(picked.getOrderId()));

            if( mypageOptional.isPresent()) {
                 Mypage mypage = mypageOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                mypage.setStatus("배달 시작");    
                // view 레파지 토리에 save
                 mypageRepository.save(mypage);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDelivered_then_UPDATE_8(@Payload Delivered delivered) {
        try {
            if (!delivered.validate()) return;
                // view 객체 조회
            Optional<Mypage> mypageOptional = mypageRepository.findById(Long.valueOf(delivered.getOrderId()));

            if( mypageOptional.isPresent()) {
                 Mypage mypage = mypageOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                // view 레파지 토리에 save
                 mypageRepository.save(mypage);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderRejected_then_DELETE_1(@Payload OrderRejected orderRejected) {
        try {
            if (!orderRejected.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            mypageRepository.deleteById(Long.valueOf(orderRejected.getOrderId()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

