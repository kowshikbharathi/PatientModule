package com.module.patient.PatientModule.util;

import org.springframework.stereotype.Service;
import com.module.patient.PatientModule.dto.PatientDto;
import com.module.patient.PatientModule.entity.PatientDetailEntity;
import com.module.patient.PatientModule.entity.VitalSignEntity;

/**
 * PatientUtil used to patient custom operation.
 * @author Kowshik Bharathi M
 */
@Service
public class PatientUtil {

	
	
	public PatientDetailEntity buildPatientInfo(PatientDto patientDto,VitalSignEntity vitalSignEntity) {
		PatientDetailEntity patientDetailEntity=new PatientDetailEntity();
		patientDetailEntity.setPatientId(patientDto.getPatientId());
		patientDetailEntity.setFirstName(patientDto.getFirstName());
		patientDetailEntity.setLastName(patientDto.getLastName());
		patientDetailEntity.setAge(patientDto.getAge());
		patientDetailEntity.setGender(patientDto.getGender());
		patientDetailEntity.setAddress(patientDto.getAddress());
		patientDetailEntity.setContactNumber(patientDto.getContactNumber());
		patientDetailEntity.setEmailId(patientDto.getEmailId());
		patientDetailEntity.setConsultDoctor(patientDto.getConsultDoctor());
		patientDetailEntity.setLastVisitDate(patientDto.getLastVisitDate());
		patientDetailEntity.setTemperatute(vitalSignEntity.getTemperatute());
		patientDetailEntity.setBloodPressure(vitalSignEntity.getBloodPressure());
		patientDetailEntity.setSugerLevel(vitalSignEntity.getSugerLevel());
		patientDetailEntity.setVisitReason(vitalSignEntity.getVisitReason());
		return patientDetailEntity;
		
	}
}
