package com.kran.cgifms.sample.infrastructure.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kran.cgifms.sample.domain.model.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long>{

}
