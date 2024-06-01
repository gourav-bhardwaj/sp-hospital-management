package com.sp.sp_hospital_management.event;

import com.sp.sp_hospital_management.dto.PatientInfoDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class PatientDischargeEvent extends ApplicationEvent {

    private Long patientId;
    private String patientName;

    public PatientDischargeEvent(Object source, PatientInfoDto patientInfoDto) {
        super(source);
        this.patientId = patientInfoDto.getPatientId();
        this.patientName = patientInfoDto.getPatientName();
    }

}
