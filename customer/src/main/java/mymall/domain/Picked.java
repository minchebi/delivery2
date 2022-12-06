package mymall.domain;

import mymall.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class Picked extends AbstractEvent {

    private Long id;
    private String orderId;
    private String status;
    private String addr;
    private List<String> option;
}
