package mymall.domain;

import mymall.domain.*;
import mymall.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String orderId;
    private String status;
    private String foodId;
    private String addr;
    private String customerId;
    private List<String> option;

    public OrderPlaced(Order aggregate){
        super(aggregate);
    }
    public OrderPlaced(){
        super();
    }
}
