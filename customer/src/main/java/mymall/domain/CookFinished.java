package mymall.domain;

import mymall.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class CookFinished extends AbstractEvent {

    private Long id;
    private String orderId;
    private String foodId;
    private String status;
    private String customerId;
    private String storeId;
    private List<String> option;
}
