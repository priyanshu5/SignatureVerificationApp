package com.mcb.signatureverification.auth;

import com.mcb.signatureverification.dao.UserRepository;
import com.mcb.signatureverification.entity.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsAuth implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = userRepository.findByUsername(username);
        if(userDetails ==null){
            throw new UsernameNotFoundException("User not Found, 404");
        }
        return new UserValidation(userDetails);
    }
}
