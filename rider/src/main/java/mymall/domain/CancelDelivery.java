package mymall.domain;

import mymall.domain.*;
import mymall.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class CancelDelivery extends AbstractEvent {

    private Long id;
    private String orderId;
    private String status;
    private String addr;
    private String option;

    public CancelDelivery(Delivery aggregate){
        super(aggregate);
    }
    public CancelDelivery(){
        super();
    }
}
