package com.mcb.signatureverification.dao;

import com.mcb.signatureverification.entity.EventSourceBE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventSourceRepo extends JpaRepository<EventSourceBE,Long> {
    List<EventSourceBE> findAll();
//    EventSourceBE findById();

}
