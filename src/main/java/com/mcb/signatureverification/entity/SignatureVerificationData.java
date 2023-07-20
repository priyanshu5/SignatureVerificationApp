package com.mcb.signatureverification.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.aspectj.weaver.ast.Not;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SignatureVerificationData {

    private Long notVerifiedCount;
    private Long okCount;
    private Long notOkCount;
}
