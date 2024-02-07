package com.ghostAPI.app.repository;

import com.ghostAPI.app.config.WireMockStubEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WiremockStubRepository extends JpaRepository<WireMockStubEntity,Long> {
}
