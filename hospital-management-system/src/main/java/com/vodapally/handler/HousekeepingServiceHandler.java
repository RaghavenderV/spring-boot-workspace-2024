package com.vodapally.handler;

import com.vodapally.event.PatientDischargeEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class HousekeepingServiceHandler {

    @EventListener
    @Async
    public void cleanAndAssign(PatientDischargeEvent event){ //update medical records
        System.out.println("Housekeeping Service: Preparing room for next patient after discharge of "+
                event.getPatientName()+" : "+Thread.currentThread().getName());
    }
}
