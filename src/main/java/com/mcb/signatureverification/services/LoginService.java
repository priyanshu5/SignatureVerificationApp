package com.mcb.signatureverification.services;

import com.mcb.signatureverification.entity.UserDetails;

import java.util.List;

public interface LoginService {
    UserDetails login(String userName);
    List<UserDetails> getAllUser();

}
