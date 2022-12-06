package mymall.domain;

import mymall.domain.*;
import mymall.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderCancel extends AbstractEvent {

    private Long id;
    private String orderId;
    private String status;

    public OrderCancel(Order aggregate){
        super(aggregate);
    }
    public OrderCancel(){
        super();
    }
}
