package com.ghostAPI.app.repository;

import com.ghostAPI.app.config.StubMapping;
import com.ghostAPI.app.config.StubMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MappingRespository extends JpaRepository<StubMappingEntity,Long> {
}
