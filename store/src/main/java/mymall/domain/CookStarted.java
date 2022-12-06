package mymall.domain;

import mymall.domain.*;
import mymall.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class CookStarted extends AbstractEvent {

    private Long id;
    private String orderId;
    private String foodId;
    private String status;
    private String customerId;
    private String storeId;
    private List<String> option;

    public CookStarted(FoodCooking aggregate){
        super(aggregate);
    }
    public CookStarted(){
        super();
    }
}
