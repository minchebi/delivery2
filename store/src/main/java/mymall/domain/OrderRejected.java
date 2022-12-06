package mymall.domain;

import mymall.domain.*;
import mymall.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderRejected extends AbstractEvent {

    private Long id;
    private String orderId;
    private String status;
    private String foodId;
    private String storeId;
    private String customerId;
    private List<String> option;

    public OrderRejected(FoodCooking aggregate){
        super(aggregate);
    }
    public OrderRejected(){
        super();
    }
}
