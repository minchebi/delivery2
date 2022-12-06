package mymall.domain;

import mymall.domain.*;
import mymall.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class OrderAcepted extends AbstractEvent {

    private Long id;
    private String orderId;
    private String status;
    private String foodId;
    private String storeId;
    private String customerId;
    private Object option;
}


