package mymall.domain;

import mymall.domain.*;
import mymall.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class PayCanceled extends AbstractEvent {

    private Long id;
    private String orderId;
    private String status;

    public PayCanceled(Payment aggregate){
        super(aggregate);
    }
    public PayCanceled(){
        super();
    }
}
