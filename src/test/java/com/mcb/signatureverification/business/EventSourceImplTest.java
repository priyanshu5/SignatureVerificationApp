package com.mcb.signatureverification.business;


import com.mcb.signatureverification.Exception.DataNotFoundException;
import com.mcb.signatureverification.dao.EventSourceRepo;
import com.mcb.signatureverification.entity.EventSourceBE;
import com.mcb.signatureverification.entity.SignatureVerificationData;
import com.mcb.signatureverification.services.EventSourceImpl;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EventSourceImplTest {

    @Mock
    private EventSourceRepo eventSourceRepo;

    @InjectMocks
    private EventSourceImpl eventSourceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEventsSuccess() throws DataNotFoundException {
        EventSourceBE eventSourceBE = new EventSourceBE();
        eventSourceBE.setId(1L);
        eventSourceBE.setComments("dummy");
        List<EventSourceBE> mockEventSourceList = Arrays.asList(eventSourceBE);
        when(eventSourceRepo.findAll()).thenReturn(mockEventSourceList);

        List<EventSourceBE> result = eventSourceImpl.getAllEvents();

        assertEquals(1, result.size());
        assertEquals("dummy", result.get(0).getComments());

        verify(eventSourceRepo, times(1)).findAll();
    }

    @Test
    void testGetAllEventsEmptyList() {
        when(eventSourceRepo.findAll()).thenReturn(Collections.emptyList());

        assertThrows(DataNotFoundException.class, () -> eventSourceImpl.getAllEvents());

        verify(eventSourceRepo, times(1)).findAll();
    }

    @Test
    void testUpdatedAssigneeSuccess() throws DataNotFoundException {
        EventSourceBE eventSourceBE = new EventSourceBE();
        eventSourceBE.setId(1L);
        eventSourceBE.setComments("dummy");
        List<EventSourceBE> mockEventSourceList = Arrays.asList(eventSourceBE);
        when(eventSourceRepo.findAllById(any())).thenReturn(mockEventSourceList);

        String result = eventSourceImpl.updatedAssignee(mockEventSourceList);

        assertEquals("Updated success", result);

        verify(eventSourceRepo, times(1)).findAllById(any());
    }

    @Test
    void testUpdatedAssigneeEmptyList() {
        List<EventSourceBE> mockEventSourceList = Collections.emptyList();
        when(eventSourceRepo.findAllById(any())).thenReturn(mockEventSourceList);

        assertThrows(DataNotFoundException.class, () -> eventSourceImpl.updatedAssignee(mockEventSourceList));

        verify(eventSourceRepo, times(1)).findAllById(any());
    }

    @Test
    void testUpdateEventSuccess() throws DataNotFoundException {
        EventSourceBE mockEventSourceBE = new EventSourceBE();
        mockEventSourceBE.setId(1L);
        mockEventSourceBE.setComments("dummy");
        when(eventSourceRepo.findById(1L)).thenReturn(Optional.of(mockEventSourceBE));

        EventSourceBE updatedEventSourceBE = new EventSourceBE();
        updatedEventSourceBE.setId(1L);
        updatedEventSourceBE.setComments("UpdatedDummy");

//        EventSourceBE updatedEventSourceBE = new EventSourceBE();
        EventSourceBE result = eventSourceImpl.updateEvent(updatedEventSourceBE);


        assertEquals(updatedEventSourceBE.getComments(), result.getComments());


        verify(eventSourceRepo, times(1)).findById(1L);
    }

    @Test
    void testUpdateEventNotFound() {
        when(eventSourceRepo.findById(1L)).thenReturn(Optional.empty());

        EventSourceBE updatedEventSourceBE = new EventSourceBE();
        updatedEventSourceBE.setId(1L);
        updatedEventSourceBE.setComments("UpdatedComments");
        assertThrows(DataNotFoundException.class, () -> eventSourceImpl.updateEvent(updatedEventSourceBE));

        verify(eventSourceRepo, times(1)).findById(1L);
    }

    @Test
    void testGetSignatureVerificationDataSuccess() throws DataNotFoundException {
        EventSourceBE eventSourceBE1 = new EventSourceBE();
        eventSourceBE1.setId(1L);
        eventSourceBE1.setVerified(null);
        eventSourceBE1.setComments("dummy");
        EventSourceBE eventSourceBE2 = new EventSourceBE();
        eventSourceBE1.setId(1L);
        eventSourceBE1.setVerified("No");
        eventSourceBE1.setComments("dummy");
        List<EventSourceBE> mockEventSourceList = Arrays.asList(eventSourceBE1,eventSourceBE2);
        when(eventSourceRepo.findAll()).thenReturn(mockEventSourceList);

        SignatureVerificationData result = eventSourceImpl.getSignatureVerificationData();

        assertEquals(1, result.getNotVerifiedCount());
        assertEquals(1, result.getNotOkCount());
        assertEquals(0, result.getOkCount());

        verify(eventSourceRepo, times(1)).findAll();
    }

    @Test
    void testGetSignatureVerificationDataEmptyList() {
        when(eventSourceRepo.findAll()).thenReturn(Collections.emptyList());

        assertThrows(DataNotFoundException.class, () -> eventSourceImpl.getSignatureVerificationData());

        verify(eventSourceRepo, times(1)).findAll();
    }
}

