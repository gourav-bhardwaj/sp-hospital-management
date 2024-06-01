package com.sp.sp_hospital_management.service.impl;

import com.sp.sp_hospital_management.event.PatientDischargeEvent;
import com.sp.sp_hospital_management.service.DischargeProcessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Qualifier("houseKeepingProcess")
public class HouseKeepingProcess implements DischargeProcessService {

    @Override
    public void process(PatientDischargeEvent event) {
        log.info("Housekeeping process after discharge patient - {} - {}", event.getPatientName(), Thread.currentThread().getName());
    }

}
