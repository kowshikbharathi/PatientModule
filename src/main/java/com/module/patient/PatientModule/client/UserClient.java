package com.module.patient.PatientModule.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.module.patient.PatientModule.entity.UserQueryEntity;

/**
 * UserClient is act as User end point client
 * @author Kowshik Bharathi M
 */

@FeignClient(url="${healthcare.management.user.uri}" ,name="${healthcare.management.user.name}")
public interface UserClient {

	@GetMapping("/{userName}")
	public UserQueryEntity getUser(@PathVariable String userName);
}
