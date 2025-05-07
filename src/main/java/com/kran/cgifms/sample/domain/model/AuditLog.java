package com.kran.cgifms.sample.domain.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(schema = "auditdb", catalog = "auditdb", name = "log_user_activity")
@Data
public class AuditLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "client_ip")
	private Long clientIp;
	@Column(name = "trace_id")
	private String traceId;
	@Column(name = "service_name")
	private String serviceName;
	@Column(name = "action")
	private String action;
	@Column(name = "event_type")
	private String eventType;
	@Column(name = "before_activity")
	private String beforeActivity;
	@Column(name = "after_activity")
	private String afterActivity;
	@Column(name = "request_time")
	private Date requestTime;
	@Column(name = "entry_on")
	private Date entryOn;
	
}
