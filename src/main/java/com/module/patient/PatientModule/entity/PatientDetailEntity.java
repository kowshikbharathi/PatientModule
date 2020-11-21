package com.module.patient.PatientModule.entity;


import java.sql.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PatientDetailEntity which represent customize entity for patient Information.
 * @author Kowshik Bharathi M
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDetailEntity {

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
	private Integer temperatute;
	private Integer bloodPressure;
	private Integer sugerLevel;
	private String visitReason;
	
}
