package com.mcb.signatureverification.services;

import com.mcb.signatureverification.Exception.DataNotFoundException;
import com.mcb.signatureverification.dao.EventSourceRepo;
import com.mcb.signatureverification.entity.EventSourceBE;
import com.mcb.signatureverification.entity.SignatureVerificationData;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventSourceImpl implements EventSourceServices{

    @Autowired
    private EventSourceRepo eventSourceRepo;
    @Override
    public List<EventSourceBE> getAllEvents() throws DataNotFoundException {
        List<EventSourceBE> eventSourceBE = eventSourceRepo.findAll();
        if(eventSourceBE.isEmpty()){
            throw new DataNotFoundException("Could not fetch data from Database");
        }
        return eventSourceBE;
    }

    @Override
    @Transactional
    public String updatedAssignee(List<EventSourceBE> eventSourceBES) throws DataNotFoundException {
        Map<Long,EventSourceBE> eventSourceBEMap = eventSourceBES.stream()
                .collect(Collectors.toMap(EventSourceBE::getId, event -> event));
        List<EventSourceBE> eventSourceBEdb = eventSourceRepo.findAllById(eventSourceBEMap.keySet());
        System.out.println(eventSourceBEdb);
        if(eventSourceBES.isEmpty()){
            throw new DataNotFoundException("Could not fetch data from Database");
        }
//        eventSourceBE.stream().map(e->e.setAssignTo(eventSourceBEMap.get(e.getId()).getAssignTo())).
        for (EventSourceBE e: eventSourceBEdb){
            e.setAssignTo(eventSourceBEMap.get(e.getId()).getAssignTo());
        }
//        Optional<EventSourceBE>eventSourceBE1 = eventSourceRepo.findById();
        return "Updated success";
    }


    @Override
    @Transactional
    public EventSourceBE updateEvent(EventSourceBE eventSourceBE) throws DataNotFoundException {
        Optional<EventSourceBE> eventSourcedb = eventSourceRepo.findById(eventSourceBE.getId());
        if(eventSourcedb.isPresent()){
//            EventSourceBE response = mapEventSourceObjecs()
//            EventSourceBE eventSourceBEdb = (EventSourceBE)eventSourcedb.get().get()1;

            eventSourcedb.get().setId(eventSourceBE.getId());
            eventSourcedb.get().setBusinessKey(eventSourceBE.getBusinessKey());
            eventSourcedb.get().setApplication(eventSourceBE.getApplication());
            eventSourcedb.get().setComments(eventSourceBE.getComments());
            eventSourcedb.get().setTransactionCurrency(eventSourceBE.getTransactionCurrency());
            eventSourcedb.get().setTransactionAmount(eventSourceBE.getTransactionAmount());
            eventSourcedb.get().setAmountInMur(eventSourceBE.getAmountInMur());
            eventSourcedb.get().setDebitAccountNumber(eventSourceBE.getDebitAccountNumber());
            eventSourcedb.get().setAccountShortName(eventSourceBE.getAccountShortName());
            eventSourcedb.get().setDebitAccountCcy(eventSourceBE.getDebitAccountCcy());
            eventSourcedb.get().setPaymentDetails1(eventSourceBE.getPaymentDetails1());
            eventSourcedb.get().setPaymentDetails2(eventSourceBE.getPaymentDetails2());
            eventSourcedb.get().setPaymentDetails3(eventSourceBE.getPaymentDetails3());
            eventSourcedb.get().setPaymentDetails4(eventSourceBE.getPaymentDetails4());
            eventSourcedb.get().setVerified(eventSourceBE.getVerified());
            eventSourcedb.get().setDiscrepancyReason(eventSourceBE.getDiscrepancyReason());
            eventSourcedb.get().setPriority(eventSourceBE.getPriority());
            eventSourcedb.get().setSourceBu(eventSourceBE.getSourceBu());
            eventSourcedb.get().setDocumentCaptureReference(eventSourceBE.getDocumentCaptureReference());
            eventSourcedb.get().setStatus(eventSourceBE.getStatus());
            eventSourcedb.get().setAssignTo(eventSourceBE.getAssignTo());

            eventSourcedb.get().setUpdatedBy(eventSourceBE.getUpdatedBy());
            eventSourcedb.get().setUpdatedOn(eventSourceBE.getUpdatedOn());

            System.out.println(eventSourcedb.get());
        }
        else{
            throw new DataNotFoundException("Could not fetch data from Database");
        }
        return eventSourcedb.get();
    }

    @Override
    public SignatureVerificationData getSignatureVerificationData() throws DataNotFoundException {
        List<EventSourceBE> eventSourceBES= eventSourceRepo.findAll();
        if(eventSourceBES.size()==0){
            throw new DataNotFoundException("Could not fetch data from Database");
        }
        SignatureVerificationData signatureVerificationData = new SignatureVerificationData();
        long notVerifiedCount = eventSourceBES.stream()
                .filter(record -> record.getVerified() == null)
                .count();

        long okCount = eventSourceBES.stream()
                .filter(record -> "Yes".equals(record.getVerified()))
                .count();

        long notOkCount = eventSourceBES.stream()
                .filter(record -> "No".equals(record.getVerified()))
                .count();
        signatureVerificationData.setNotOkCount(notOkCount);
        signatureVerificationData.setOkCount(okCount);
        signatureVerificationData.setNotVerifiedCount(notVerifiedCount);
        System.out.println(signatureVerificationData);
        return signatureVerificationData;
    }
    @Override
    public Optional<EventSourceBE> getEventSourceById(Long id){

        return eventSourceRepo.findById(id);
    }

}
