package com.mcb.signatureverification.services;

import com.mcb.signatureverification.dao.UserRepository;
import com.mcb.signatureverification.entity.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServicesImpl implements LoginService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails login(String userName) {
        UserDetails userDetails = userRepository.findByUsername(userName);
        return userDetails;
    }

    @Override
    public List<UserDetails> getAllUser() {
        List<UserDetails> userDetails = userRepository.findAll();
        return userDetails;
    }

}
