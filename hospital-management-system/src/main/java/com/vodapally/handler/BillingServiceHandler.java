package com.vodapally.handler;

import com.vodapally.event.PatientDischargeEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class BillingServiceHandler {

    @EventListener
    @Async
    public void processBill(PatientDischargeEvent event){ //update medical records
        System.out.println("Billing Service: Finalizing bill for patient "+
                event.getPatientId()+" : "+Thread.currentThread().getName());
    }
}
