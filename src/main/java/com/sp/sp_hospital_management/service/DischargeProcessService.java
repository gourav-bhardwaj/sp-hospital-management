package com.sp.sp_hospital_management.service;


import com.sp.sp_hospital_management.event.PatientDischargeEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

public interface DischargeProcessService {

    @Async
    @EventListener
    void process(PatientDischargeEvent event);

}
