package com.vodapally.tx.service;

import com.vodapally.tx.entity.PassengerInfo;
import com.vodapally.tx.entity.PaymentInfo;
import com.vodapally.tx.dto.FlightBookingAcknowledgement;
import com.vodapally.tx.dto.FlightBookingRequest;
import com.vodapally.tx.repository.PassengerInfoRepository;
import com.vodapally.tx.repository.PaymentInfoRepository;
import com.vodapally.tx.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class FlightBookingService {

    @Autowired
    private PassengerInfoRepository passengerInfoRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request){
        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfo = passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getpId());
        paymentInfo.setAmount(passengerInfo.getFare());

        paymentInfoRepository.save(paymentInfo);

        return new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getFare(),
                UUID.randomUUID().toString().split("-")[0],
                passengerInfo);
    }
}
