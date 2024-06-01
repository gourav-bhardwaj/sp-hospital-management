package com.sp.sp_hospital_management.service;

import com.sp.sp_hospital_management.dto.PatientInfoDto;
import com.sp.sp_hospital_management.event.PatientDischargeEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
public class DischargeService {


    private final ApplicationEventPublisher publisher;

    public DischargeService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }


    public void process(PatientInfoDto patientInfoDto) {

        try {
            log.info("<-------------Begin patient discharge process!!--------------->");

            this.publisher.publishEvent(new PatientDischargeEvent(this, patientInfoDto));

            log.info("<------------End patient discharge process successfully!!----->");
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(500), "Failed during patient discharge process!!", ex);
        }

    }
    
}
