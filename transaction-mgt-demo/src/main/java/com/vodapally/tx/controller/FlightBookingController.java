package com.vodapally.tx.controller;

import com.vodapally.tx.dto.FlightBookingAcknowledgement;
import com.vodapally.tx.dto.FlightBookingRequest;
import com.vodapally.tx.exception.InsufficientFundsException;
import com.vodapally.tx.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightBookingController {
    @Autowired
    private FlightBookingService service;

    @PostMapping("/bookFlightTicket")
    public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request){
        return service.bookFlightTicket(request);
    }

}
