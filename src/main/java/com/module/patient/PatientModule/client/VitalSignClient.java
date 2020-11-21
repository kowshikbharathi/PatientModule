package com.module.patient.PatientModule.client;

import java.sql.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.module.patient.PatientModule.entity.VitalSignEntity;

/**
 * VitalSignClient is act as Vital Sign end point client
 * @author Kowshik Bharathi M
 */
@FeignClient(url="${healthcare.management.vitalsign.uri}" ,name="${healthcare.management.vitalsign.name}")
public interface VitalSignClient {

	@GetMapping("getVitalSign/{userId}/{visitDate}")
	public VitalSignEntity getVitalSign(@PathVariable String userId,@PathVariable Date visitDate );
}
