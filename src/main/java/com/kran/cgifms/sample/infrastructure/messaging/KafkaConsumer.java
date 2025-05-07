package com.kran.cgifms.sample.infrastructure.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kran.cgifms.sample.application.dto.KafkaDTO;
import com.kran.cgifms.sample.application.utility.KafkaConstants;
import com.kran.cgifms.sample.domain.model.AuditLog;
import com.kran.cgifms.sample.infrastructure.repository.impl.AuditLogRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Transactional
@ConditionalOnProperty(prefix = "service.kafka", name = "enabled", matchIfMissing = false)
@Slf4j
public class KafkaConsumer {
	@Autowired
	AuditLogRepository auditLogRepository;

	@KafkaListener(topics = KafkaConstants.TOPIC_AUDIT_TRAIL, containerFactory = "kafkaListenerContainerFactoryAudit")
	public void listenKafkaMessageUser(KafkaDTO dto, Acknowledgment ack) {
		
		log.info("SERVICE NAME: {} Listening to AUDIT Event", dto.getService());
		try {
			AuditLog auditLog = new AuditLog();
			auditLog.setTraceId(dto.getTraceId());
			auditLog.setServiceName(dto.getService());
			auditLog.setUserId(dto.getUserId());
			auditLog.setClientIp(dto.getClientIp());
			auditLog.setAction(dto.getAction());
			auditLog.setEventType(dto.getEventType());
			auditLog.setBeforeActivity(dto.getBeforeActivity());
			auditLog.setAfterActivity(dto.getAfterActivity());
			auditLog.setRequestTime(dto.getRequestTime());
			auditLog.setEntryOn(dto.getEntryOn());
			
			auditLogRepository.save(auditLog);
			
		}catch (Exception e) {
			e.printStackTrace();
			log.info("Error");
		}
		ack.acknowledge();
	}
}
