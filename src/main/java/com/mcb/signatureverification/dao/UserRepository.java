package com.mcb.signatureverification.dao;

import com.mcb.signatureverification.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {
    UserDetails findByUsername(String userName);
    List<UserDetails> findAll();

}
