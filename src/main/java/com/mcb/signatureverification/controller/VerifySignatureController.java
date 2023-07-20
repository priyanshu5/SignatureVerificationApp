package com.mcb.signatureverification.controller;

import com.mcb.signatureverification.Exception.DataNotFoundException;
import com.mcb.signatureverification.auth.JwtHelper;
import com.mcb.signatureverification.entity.EventSourceBE;
import com.mcb.signatureverification.entity.JwtResponse;
import com.mcb.signatureverification.entity.SignatureVerificationData;
import com.mcb.signatureverification.entity.UserDetails;
import com.mcb.signatureverification.services.EventSourceServices;
import com.mcb.signatureverification.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class VerifySignatureController {
    @Autowired
    private EventSourceServices eventSourceServices;

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;


    @Autowired
    private JwtHelper helper;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody UserDetails request) {

        this.doAuthenticate(request.getUsername(), request.getPassword());


        org.springframework.security.core.userdetails.UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());

        String token = this.helper.generateToken(userDetails);

        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/update-assignee")
    public ResponseEntity<String> updatedAssignee(@RequestBody List<EventSourceBE> eventSourceBES) throws DataNotFoundException {
        String result = eventSourceServices.updatedAssignee(eventSourceBES);
        return ResponseEntity.ok(result);
    }
    @PostMapping("/update-eventsource")
    public ResponseEntity<EventSourceBE> updateEventSource(@RequestBody EventSourceBE eventSourceBE) throws DataNotFoundException {
        EventSourceBE result = eventSourceServices.updateEvent(eventSourceBE);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/signature-verification-data")
    public ResponseEntity<SignatureVerificationData> getSignatureVerificationData() throws DataNotFoundException {
        SignatureVerificationData signatureVerificationData = eventSourceServices.getSignatureVerificationData();
        return ResponseEntity.ok(signatureVerificationData);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDetails>> getAllUser(){
        List<UserDetails> userDetails = loginService.getAllUser();
        return  ResponseEntity.ok(userDetails);
    }
    @GetMapping("/events")
    public ResponseEntity<List<EventSourceBE>> getAllEventSources() throws DataNotFoundException {
        List<EventSourceBE> eventSourceBES = eventSourceServices.getAllEvents();
        return ResponseEntity.ok(eventSourceBES);
    }
    @GetMapping("/event-source/{id}")
    public ResponseEntity<EventSourceBE> getEventSourceByid(@PathVariable long id) throws DataNotFoundException {
        Optional<EventSourceBE> eventSourceBE = eventSourceServices.getEventSourceById(id);
        if(eventSourceBE.isPresent()){
            return ResponseEntity.ok(eventSourceBE.get());
        }
        else{
            throw new DataNotFoundException("Data not found in database");
        }
    }

    private void doAuthenticate(String username, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }



    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }
}
