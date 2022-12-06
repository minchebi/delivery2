package mymall.domain;

import mymall.domain.*;
import mymall.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class PayCanceled extends AbstractEvent {

    private Long id;
    private String orderId;
    private String status;
}


