package com.module.patient.PatientModule.entity;


import java.sql.Date;
import java.util.UUID;

import org.springframework.data.elasticsearch.annotations.Document;

import com.module.patient.PatientModule.dto.PatientDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PatientEntity which represent entity for Patient table.
 * @author Kowshik Bharathi M
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName="healthcare",type="customer")
public class PatientEntity {

	private UUID patientId;
	private String firstName;
	private String lastName;
	private Integer age;
	private String gender;
	private String address;
	private Long contactNumber;
	private String emailId;
	private String consultDoctor;
	private Date lastVisitDate;
	
	public static PatientEntity formEntity(PatientDto patientDto) {
		PatientEntity patientEntity=new PatientEntity();
		patientEntity.setPatientId(patientDto.getPatientId());
		patientEntity.setFirstName(patientDto.getFirstName());
		patientEntity.setLastName(patientDto.getLastName());
		patientEntity.setAge(patientDto.getAge());
		patientEntity.setGender(patientDto.getGender());
		patientEntity.setAddress(patientDto.getAddress());
		patientEntity.setContactNumber(patientDto.getContactNumber());
		patientEntity.setEmailId(patientDto.getEmailId());
		patientEntity.setConsultDoctor(patientDto.getConsultDoctor());
		patientEntity.setLastVisitDate(patientDto.getLastVisitDate());
		return patientEntity;
	}
	
	public static PatientDto formDto(PatientEntity patientEntity) {
		PatientDto patientDto=new PatientDto();
		patientDto.setPatientId(patientEntity.getPatientId());
		patientDto.setFirstName(patientEntity.getFirstName());
		patientDto.setLastName(patientEntity.getLastName());
		patientDto.setAge(patientEntity.getAge());
		patientDto.setGender(patientEntity.getGender());
		patientDto.setAddress(patientEntity.getAddress());
		patientDto.setContactNumber(patientEntity.getContactNumber());
		patientDto.setEmailId(patientEntity.getEmailId());
		patientDto.setConsultDoctor(patientEntity.getConsultDoctor());
		patientDto.setLastVisitDate(patientEntity.getLastVisitDate());
		return patientDto;
	}

}
