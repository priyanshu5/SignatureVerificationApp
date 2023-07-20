package com.mcb.signatureverification.services;

import com.mcb.signatureverification.Exception.DataNotFoundException;
import com.mcb.signatureverification.entity.EventSourceBE;
import com.mcb.signatureverification.entity.SignatureVerificationData;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public interface EventSourceServices {
    List<EventSourceBE> getAllEvents() throws DataNotFoundException;
    String updatedAssignee(List<EventSourceBE> eventSourceBES) throws DataNotFoundException;
    EventSourceBE updateEvent(EventSourceBE eventSourceBE) throws DataNotFoundException;
    SignatureVerificationData getSignatureVerificationData() throws DataNotFoundException;
    Optional<EventSourceBE> getEventSourceById(Long id);

}
