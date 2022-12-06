package mymall.domain;

import mymall.domain.*;
import mymall.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderCanceled extends AbstractEvent {

    private Long id;
    private String orderId;
    private String foodId;
    private String addr;
    private String customerId;
    private String status;
    private List<String> option;

    public OrderCanceled(Order aggregate){
        super(aggregate);
    }
    public OrderCanceled(){
        super();
    }
}
