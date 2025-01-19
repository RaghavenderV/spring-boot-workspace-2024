package com.vodapally.handler;

import com.vodapally.event.PatientDischargeEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MedicalRecordsServiceHandler {

    @EventListener
    @Async
    public void updatePatientHistory(PatientDischargeEvent event){ //update medical records
        System.out.println("Medical Records Service : Updating records for the patient "+
                event.getPatientId()+" : "+Thread.currentThread().getName());
    }
}
