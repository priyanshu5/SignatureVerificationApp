package com.mcb.signatureverification.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtResponse {
    private String username;
    private String jwtToken;
}
