package mymall.domain;

import mymall.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class OrderAcepted extends AbstractEvent {

    private Long id;
    private String orderId;
    private String status;
    private String foodId;
    private String storeId;
    private String customerId;
    private List<String> option;
}
