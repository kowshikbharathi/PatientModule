package com.module.patient.PatientModule.entity;

import java.sql.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * VitalSignEntity which represent entity for VitalSign table.
 * @author Kowshik Bharathi M
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VitalSignEntity {

	private UUID patientId;
	private Date visitDate;
	private Integer temperatute;
	private Integer bloodPressure;
	private Integer sugerLevel;
	private String visitReason;
	
}
