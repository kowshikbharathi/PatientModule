package com.module.patient.PatientModule.repository;


import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.module.patient.PatientModule.dto.PatientDto;

/**
 * PatientRepository repository for Patient table.
 * @author Kowshik Bharathi M
 */
@Repository
@EnableJpaRepositories
public interface PatientRepository extends JpaRepository<PatientDto, UUID>{

}
