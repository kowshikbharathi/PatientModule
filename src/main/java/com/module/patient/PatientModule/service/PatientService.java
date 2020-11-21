package com.module.patient.PatientModule.service;

import com.module.patient.PatientModule.entity.PatientDetailEntity;
import com.module.patient.PatientModule.entity.PatientEntity;

/**
 * PatientService which involves in patient module.
 * @author Kowshik Bharathi M
 */
public interface PatientService {

	/**
	 * save method is used to save patient details.
	 * @param PatientEntity
	 * @return Boolean
	 */
	public Boolean save(PatientEntity PatientEntity);
	
	/**
	 * updateVistDate method is used to update visit date.
	 * @param patientEntity
	 * @return PatientEntity
	 */
	public PatientEntity updateVistDate(PatientEntity patientEntity);
	
	/**
	 * getById method is used to get patient details by id.
	 * @param userId
	 * @return PatientDetailEntity
	 */
	public PatientDetailEntity getById(String userId); 
	
}
