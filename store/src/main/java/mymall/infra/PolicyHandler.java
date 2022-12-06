package mymall.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import mymall.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import mymall.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired FoodCookingRepository foodCookingRepository;
    @Autowired OrderRepository orderRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderPlaced'")
    public void wheneverOrderPlaced_CopyOrder(@Payload OrderPlaced orderPlaced){

        OrderPlaced event = orderPlaced;
        System.out.println("\n\n##### listener CopyOrder : " + orderPlaced + "\n\n");


        

        // Sample Logic //

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Paid'")
    public void wheneverPaid_UpdateStatus(@Payload Paid paid){

        Paid event = paid;
        System.out.println("\n\n##### listener UpdateStatus : " + paid + "\n\n");


        

        // Sample Logic //
        FoodCooking.updateStatus(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CancelDelivery'")
    public void wheneverCancelDelivery_OrderCancel(@Payload CancelDelivery cancelDelivery){

        CancelDelivery event = cancelDelivery;
        System.out.println("\n\n##### listener OrderCancel : " + cancelDelivery + "\n\n");


        

        // Sample Logic //
        Order.orderCancel(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCancel'")
    public void wheneverOrderCancel_UpdateStatus(@Payload OrderCancel orderCancel){

        OrderCancel event = orderCancel;
        System.out.println("\n\n##### listener UpdateStatus : " + orderCancel + "\n\n");


        

        // Sample Logic //
        Order.updateStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CancelDelivery'")
    public void wheneverCancelDelivery_UpdateStatus(@Payload CancelDelivery cancelDelivery){

        CancelDelivery event = cancelDelivery;
        System.out.println("\n\n##### listener UpdateStatus : " + cancelDelivery + "\n\n");


        

        // Sample Logic //
        Order.updateStatus(event);
        

        

    }

}


