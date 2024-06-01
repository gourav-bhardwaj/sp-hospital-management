package com.sp.sp_hospital_management.controller;

import com.sp.sp_hospital_management.dto.PatientInfoDto;
import com.sp.sp_hospital_management.service.DischargeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PatientProcessController {

    private final DischargeService dischargeService;

    public PatientProcessController(DischargeService dischargeService) {
        this.dischargeService = dischargeService;
    }

    @PostMapping("/discharge-process")
    public ResponseEntity<String> patientDischargeProcess(@RequestBody PatientInfoDto patientInfoDto) {
        log.info("Invoked the patient process from controller endpoint!! ----");
        dischargeService.process(patientInfoDto);
        return ResponseEntity.ok("Patient discharge process done successfully");
    }

}
