package com.vodapally.projection;

import com.vodapally.model.CardDetails;
import com.vodapally.model.User;
import com.vodapally.queries.GetUserPaymentDetailsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class UserProjection {

    @QueryHandler
    public User getUserPaymentDetails(GetUserPaymentDetailsQuery query) {
        //Ideally Get the details from the DB
        CardDetails cardDetails
                = CardDetails.builder()
                .name("Raghavender Vodapally")
                .validUntilYear(2025)
                .validUntilMonth(01)
                .cardNumber("123456789")
                .cvv(111)
                .build();

        return User.builder()
                .userId(query.getUserId())
                .firstName("Raghavender")
                .lastName("Vodapally")
                .cardDetails(cardDetails)
                .build();
    }
}
