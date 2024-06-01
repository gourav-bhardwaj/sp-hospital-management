package com.sp.sp_hospital_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class SpHospitalManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpHospitalManagementApplication.class, args);
	}

}
