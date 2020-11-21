package com.module.patient.PatientModule.service;

import java.sql.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.module.patient.PatientModule.client.UserClient;
import com.module.patient.PatientModule.client.VitalSignClient;
import com.module.patient.PatientModule.dto.PatientDto;
import com.module.patient.PatientModule.entity.PatientDetailEntity;
import com.module.patient.PatientModule.entity.PatientEntity;
import com.module.patient.PatientModule.entity.UserQueryEntity;
import com.module.patient.PatientModule.entity.VitalSignEntity;
import com.module.patient.PatientModule.repository.PatientRepository;
import com.module.patient.PatientModule.repository.PatientElasticRepository;
import com.module.patient.PatientModule.util.PatientUtil;

/**
 * PatientService which implement PatientService.
 * @author Kowshik Bharathi M
 */
@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	public PatientServiceImpl(PatientRepository patientRepository,PatientElasticRepository patientElasticRepository,PatientUtil patientUtil,VitalSignClient vitalSignClient,UserClient userClient) {
	    super();	
		this.patientRepository=patientRepository;
		this.patientElasticRepository=patientElasticRepository;
		this.patientUtil=patientUtil;
		this.vitalSignClient=vitalSignClient;
		this.userClient=userClient;
	}
	private final PatientRepository patientRepository;
	private final PatientElasticRepository patientElasticRepository;
	private final PatientUtil patientUtil;
	private final VitalSignClient vitalSignClient;
	private final UserClient userClient;
	
	
	@Override
	public Boolean save(PatientEntity patientEntity) {
	    if(Objects.nonNull(patientEntity)) {
	    	patientEntity.setConsultDoctor(getDocterId(patientEntity.getConsultDoctor()).toString());
		}
		PatientDto patientDto=patientRepository.save(PatientEntity.formDto(patientEntity));
		if(Objects.nonNull(patientDto)){
			patientElasticRepository.save(patientDto);
			return true;
		}
		return false;
	}

	/**
	 * getDocterId method is used to get userId from user client.
	 * @param doctorName
	 * @return UUID
	 */
	private UUID getDocterId(String doctorName) {
		UserQueryEntity userQueryEntity=userClient.getUser(doctorName);
		if(Objects.nonNull(userQueryEntity)) {
			return userQueryEntity.getUserId();
		}
		return null;
	}
	
	@Override
	public PatientEntity updateVistDate(PatientEntity patientEntity) {
		Optional<PatientDto> patientOpt=patientRepository.findById(patientEntity.getPatientId());
		if(patientOpt.isPresent()) {
			patientOpt.get().setLastVisitDate(patientEntity.getLastVisitDate());
		}
		PatientDto patientDto=patientRepository.save(patientOpt.get());
		patientElasticRepository.save(patientDto);
		return PatientEntity.formEntity(patientDto);
	}

	@Override
	public PatientDetailEntity getById(String userId) {
		Optional<PatientDto> patientOptional=patientRepository.findById(UUID.fromString(userId));
		Date lastVisitDate = null;
		if(patientOptional.isPresent()) {
		  lastVisitDate=patientOptional.get().getLastVisitDate();
		}
		VitalSignEntity vitalSignEntity=vitalSignClient.getVitalSign(userId,lastVisitDate );
		return patientUtil.buildPatientInfo(patientOptional.get(),vitalSignEntity);
	}

}
