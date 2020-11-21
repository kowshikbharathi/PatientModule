package com.module.patient.PatientModule.entity;
import java.util.UUID;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserEntity which represent entity for User table.
 * @author Kowshik Bharathi M
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity  {

	private UUID userId;
	private String userName;
	private String password;
	private UUID roleId;
}
