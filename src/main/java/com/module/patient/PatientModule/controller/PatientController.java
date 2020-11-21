package com.module.patient.PatientModule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.module.patient.PatientModule.entity.PatientDetailEntity;
import com.module.patient.PatientModule.entity.PatientEntity;
import com.module.patient.PatientModule.service.PatientService;

/**
 * PatientController which is used for Patient end point.
 * @author Kowshik Bharathi M
 */
@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	public PatientController(PatientService patientService) {
	    super();	
		this.patientService=patientService;
	}
    private final PatientService patientService;
	
    /**
     * registerPatient method is used to register Patient details.
     * @param patientEnity
     * @return Boolean
     */
	@PostMapping("/register")
	public Boolean registerPatient(@RequestBody PatientEntity patientEnity) {
		return patientService.save(patientEnity);
	}
	
	/**
	 * updateVistDate method is used to update visit date.
	 * @param patientEnity
	 * @return PatientEntity
	 */
	@PostMapping("/updateVisitDate")
	public PatientEntity updateVistDate(@RequestBody PatientEntity patientEnity) {
		return patientService.updateVistDate(patientEnity);
	}
	
	/**
	 * getPatientDetail method is used to retrieve patient detail.
	 * @param userId
	 * @return PatientDetailEntity
	 */
	@GetMapping("/details/{userId}")
    public PatientDetailEntity getPatientDetail(@PathVariable String userId) {
		return patientService.getById(userId);
		
	}
}
