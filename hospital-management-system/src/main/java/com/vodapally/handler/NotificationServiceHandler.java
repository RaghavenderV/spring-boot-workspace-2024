package com.vodapally.handler;

import com.vodapally.event.PatientDischargeEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class NotificationServiceHandler {

    @EventListener
    @Async
    public void notifyPatients(PatientDischargeEvent event){ //update medical records
        System.out.println("Notification Service: Sending discharge notification for patient "+
                event.getPatientName()+" : "+Thread.currentThread().getName());
    }
}
