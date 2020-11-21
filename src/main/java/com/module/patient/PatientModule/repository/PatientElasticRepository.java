package com.module.patient.PatientModule.repository;

import java.util.UUID;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.module.patient.PatientModule.dto.PatientDto;

/**
 * PatientElasticRepository repository for elastic Patient table.
 * @author Kowshik Bharathi M
 */
public interface PatientElasticRepository extends ElasticsearchRepository<PatientDto, UUID>{

}
