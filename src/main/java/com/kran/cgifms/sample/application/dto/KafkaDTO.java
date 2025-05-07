package com.kran.cgifms.sample.application.dto;

import java.util.Date;

import lombok.Data;

@Data
public class KafkaDTO {
	
	private String service;
	private String eventType;
	private Long userId;
	private Long clientIp;
	private String traceId;
	private String action;
	private String beforeActivity;
	private String afterActivity;
	private Date requestTime;
	private Date entryOn;
}
