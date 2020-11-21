package com.module.patient.PatientModule.dto;


import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PatientDto represent patient table.
 * @author Kowshik Bharathi M
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="patient_tb")
public class PatientDto {

	@Id
	@Type(type="uuid-char")
	@Column(name="patient_id")
	private UUID patientId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="age")
	private Integer age;
	@Column(name="gender")
	private String gender;
	@Column(name="address")
	private String address;
	@Column(name="contact_number")
	private Long contactNumber;
	@Column(name="email_id")
	private String emailId;
	@Column(name="consult_doctor")
	private String consultDoctor;
	@Column(name="last_visit_date")
	private Date lastVisitDate;
	@Column(name="last_update_user_id")
	private String lastUpdateUserId;
	@Column(name="last_update_date_time")
	private Date lastUpdateDateTime;
	
	public PatientDto build() {
		return new PatientDto();
	}
}
