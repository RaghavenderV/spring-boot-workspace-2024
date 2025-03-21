package com.vodapally.events;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderCompletedEvent {
    private String orderId;
    private String orderStatus;
}
