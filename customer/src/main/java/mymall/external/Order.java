package mymall.external;

import lombok.Data;
import java.util.Date;
@Data
public class Order {

    private Long id;
    private String orderId;
    private String foodId;
    private String addr;
    private String customerId;
    private String status;
    private Object option;
    private String orderDetail;
}


