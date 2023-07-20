package com.mcb.signatureverification.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseAuditBE {
    private String createdBy;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private String updatedBy;

}
