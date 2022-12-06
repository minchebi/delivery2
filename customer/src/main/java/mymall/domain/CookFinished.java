package mymall.domain;

import mymall.domain.*;
import mymall.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class CookFinished extends AbstractEvent {

    private Long id;
    private String orderId;
    private String foodId;
    private String status;
    private String customerId;
    private String storeId;
    private Object option;
}


